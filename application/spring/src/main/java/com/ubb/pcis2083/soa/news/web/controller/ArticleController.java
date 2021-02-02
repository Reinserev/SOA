package com.ubb.pcis2083.soa.news.web.controller;

import com.ubb.pcis2083.soa.articles.Article;
import com.ubb.pcis2083.soa.labels.Label;
import com.ubb.pcis2083.soa.news.core.dto.ArticleDto;
import com.ubb.pcis2083.soa.news.core.dto.converter.ArticleConverter;
import com.ubb.pcis2083.soa.news.core.service.ArticleService;
import com.ubb.pcis2083.soa.news.core.service.LabelService;
import com.ubb.pcis2083.soa.news.web.websocket.GreetingHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/articles")
@PropertySource({
        "/WEB-INF/application.properties"
})
public class ArticleController implements InitializingBean {
    private final Logger log = LogManager.getLogger(this.getClass());

    private final ArticleService articleService;
    private final ArticleConverter articleConverter;
    private final LabelService labelService;
    private final GreetingHandler greetingHandler;

    private final Integer numberOfRows = 3;
    private final Integer numberfOfColumns = 3;
    private final Integer pageSize = numberOfRows * numberfOfColumns;

    @Value("${api.keys}")
    private String apiKeysProperty;

    private List<String> apiKeys = new ArrayList<>();

    @Autowired
    public ArticleController(ArticleService articleService, ArticleConverter articleConverter, LabelService labelService, GreetingHandler greetingHandler) {
        this.articleService = articleService;
        this.articleConverter = articleConverter;
        this.labelService = labelService;
        this.greetingHandler = greetingHandler;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{labelName}/{page}")
    public String getArticlesWithLabel(@PathVariable final String labelName, @PathVariable final Integer page, Model model, HttpServletRequest httpRequest) {
        log.info("Articles with label");

        List<Article> articles = articleService.getArticlesWithLabelPaged(labelService.findLabelByName(labelName).getId(), pageSize, page);
        List<ArticleDto> articleDtos = new ArrayList<>(articleConverter.convertModelsToDtosModded(articles)); // AICI e baiu' ; ca noi avem nevoie de o colectie ordonata, NU neordonata

        List<Article> nextArticles = articleService.getArticlesWithLabelPaged(labelService.findLabelByName(labelName).getId(), pageSize, page + 1);
        Boolean flag = !nextArticles.isEmpty();

        List<String> labels = labelService.getAllLabels().stream().map(Label::getName).collect(Collectors.toList());
        model.addAttribute("labels",labels);

        model.addAttribute("pageTitle", labelName);
        model.addAttribute("link", labelName);
        model.addAttribute("articles", articleDtos);
        model.addAttribute("page", page);
        model.addAttribute("flag", flag);
        model.addAttribute("noOfRows",numberOfRows);
        model.addAttribute("noOfCols",numberfOfColumns);

        addLoggedIn(model,httpRequest);

        return "articleList";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/recent/{page}")
    public String getRecentArticlesPage(@PathVariable final Integer page, Model model, HttpServletRequest httpRequest) {
        List<ArticleDto> articleDtos = new ArrayList<>(articleConverter.convertModelsToDtosModded(articleService.getRecentArticlesPaged(pageSize, page)));

        List<Article> nextArticles = articleService.getRecentArticlesPaged(pageSize, page + 1);
        Boolean flag = !nextArticles.isEmpty();

        List<String> labels = labelService.getAllLabels().stream().map(Label::getName).collect(Collectors.toList());
        model.addAttribute("labels",labels);

        model.addAttribute("pageTitle", "Recent Articles");
        model.addAttribute("link", "recent");
        model.addAttribute("articles", articleDtos);
        model.addAttribute("page", page);
        model.addAttribute("flag", flag);
        model.addAttribute("noOfRows",numberOfRows);
        model.addAttribute("noOfCols",numberfOfColumns);

        addLoggedIn(model,httpRequest);

        return "articleList";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete/{articleId}")
    public ResponseEntity deleteArticle(final @PathVariable Long articleId) {
        log.info("Delete article : " + articleId.toString());
        ResponseEntity<String> responseEntity;
        try {
            articleService.deleteArticle(articleId);

            greetingHandler.sendMessage("Article successfully deleted !!");

            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>( HttpStatus.PARTIAL_CONTENT);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    public ResponseEntity uploadArticle(@RequestBody HashMap<String, String> arguments) {
        log.info("Upload article ");

        String title = arguments.get("fileName");
        String text = arguments.get("file");
        String label = arguments.get("label");

        ResponseEntity<String> responseEntity;
        try {
            articleService.createArticle(title, text, labelService.findLabelByName(label));

            greetingHandler.sendMessage("Article successfully created !!");

            responseEntity = new ResponseEntity<>(label, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();

            greetingHandler.sendMessage("Could not create article.");

            responseEntity = new ResponseEntity<>("error", HttpStatus.PARTIAL_CONTENT);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/upload")
    public String uploadPage(Model model) {
        List<String> labels = labelService.getAllLabels().stream().map(Label::getName).collect(Collectors.toList());
        model.addAttribute("labels",labels);

        return "upload";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/view/{id}")
    public String viewArticleWithID(@PathVariable final Long id, Model model, HttpServletRequest httpRequest) {
        List<String> labels = labelService.getAllLabels().stream().map(Label::getName).collect(Collectors.toList());

        addLoggedIn(model,httpRequest);

        model.addAttribute("labels",labels);
        model.addAttribute("article", articleConverter.convertModelToDto(articleService.findByID(id)));
        return "article";
    }

    private void addLoggedIn(Model model, HttpServletRequest httpRequest) {
        try {
            Boolean value = (Boolean) httpRequest.getSession().getAttribute("loggedIn");
            if (value.equals(true)) {
                model.addAttribute("loggedIn",true);
            }
        }
        catch (Exception e) {
            model.addAttribute("loggedIn",false);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getArticleWithID(@PathVariable final Long id) {
        Article article = articleService.findByID(id);
        return new ResponseEntity<>(articleConverter.convertModelToDto(article), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/exec")
    public ResponseEntity exec() throws Exception {
        // add here some FileWalker reference ;)

        log.info("Code executed sucessfully!");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/label/{labelID}")
    public ResponseEntity getAllWithLabel(@PathVariable final Long labelID, @RequestParam String apiKey) {
        log.info("get all with label");

        ResponseEntity responseEntity;
        if (apiKeys.contains(apiKey)) {
            List<ArticleDto> articleDtos = new ArrayList<>(articleConverter.convertModelsToDtos(articleService.getArticlesWithLabel(labelID)));
            responseEntity = new ResponseEntity<>(articleDtos, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/label")
    public ResponseEntity getAllWithLabelPaged(@RequestBody HashMap<String, String> params) {
        log.info("get all with label paged");

        Long labelID = Long.parseLong(params.get("labelID"));
        Integer pageSize = Integer.parseInt(params.get("pageSize"));
        Integer pageNumber = Integer.parseInt(params.get("pageNumber"));

        List<ArticleDto> articleDtos = new ArrayList<>(articleConverter.convertModelsToDtos(articleService.getArticlesWithLabelPaged(labelID, pageSize, pageNumber)));
        ResponseEntity responseEntity = new ResponseEntity<>(articleDtos, HttpStatus.OK);

        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/recent")
    public ResponseEntity getRecentArticlesPaged(@RequestBody HashMap<String, String> params) {
        log.info("get recent paged");

        Integer pageSize = Integer.parseInt(params.get("pageSize"));
        Integer pageNumber = Integer.parseInt(params.get("pageNumber"));

        List<ArticleDto> articleDtos = new ArrayList<>(articleConverter.convertModelsToDtos(articleService.getRecentArticlesPaged(pageSize, pageNumber)));
        ResponseEntity responseEntity = new ResponseEntity<>(articleDtos, HttpStatus.OK);

        return responseEntity;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Article Controller started !");
        apiKeys.addAll(Arrays.asList(apiKeysProperty.split(",")));
    }
}
