package com.ubb.pcis2083.soa.news.web.controller;

import com.ubb.pcis2083.soa.news.core.dto.LabelDto;
import com.ubb.pcis2083.soa.news.core.dto.converter.LabelConverter;
import com.ubb.pcis2083.soa.news.core.service.LabelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/labels")
@PropertySource({
        "/WEB-INF/application.properties"
})
public class LabelController implements InitializingBean {
    private final Logger log = LogManager.getLogger(this.getClass());

    private final LabelService labelService;
    private final LabelConverter labelConverter;

    @Value("${api.keys}")
    private String apiKeysProperty;

    private List<String> apiKeys = new ArrayList<>();

    @Autowired
    public LabelController(LabelService labelService, LabelConverter labelConverter) {
        this.labelService = labelService;
        this.labelConverter = labelConverter;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity getAll(@RequestParam String apiKey) {
        log.info("getAll");

        ResponseEntity responseEntity;

        if (apiKeys.contains(apiKey)) {
            List<LabelDto> labelDtos = new ArrayList<>(labelConverter.convertModelsToDtos(labelService.getAllLabels()));
            responseEntity = new ResponseEntity<>(labelDtos, HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/new")
    public ResponseEntity<Long> add(@RequestBody LabelDto labelDto) {
        log.info("CREATE");

        ResponseEntity<Long> responseEntity;
        try {
            Long labelID = labelService.createLabel(labelDto.getName()).getId();

            responseEntity = new ResponseEntity<>(labelID, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(-1L, HttpStatus.PARTIAL_CONTENT);
        }
        return responseEntity;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("LabelController started !!");
        apiKeys.addAll(Arrays.asList(apiKeysProperty.split(",")));
    }
}
