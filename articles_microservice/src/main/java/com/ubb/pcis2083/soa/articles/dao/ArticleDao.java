package com.ubb.pcis2083.soa.articles.dao;

import com.ubb.pcis2083.soa.articles.external.NewsAPI;
import com.ubb.pcis2083.soa.common.dao.Dao;
import com.ubb.pcis2083.soa.common.misc.SOAException;
import com.ubb.pcis2083.soa.articles.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleDao implements Dao<Long, Article> {
    private Map<Long, Article> articles = new HashMap<>();
    private Long seed = 0L;

    public ArticleDao(Boolean addInitialData) {
        if (addInitialData == true) {
            populate();
        }

        try {
            List<Article> externalArticles = NewsAPI.getExternalArticles();
            for(Article article : externalArticles) {
                save(article);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populate() {
        Article first = Article.newBuilder()
                .setTitle("US Open 2021")
                .setText("Likely cancelled")
                .setLabelId(1L)
                .build();

        Article second = Article.newBuilder()
                .setTitle("US-China trade war")
                .setText("Will escalate")
                .setLabelId(2L)
                .build();

        Article third = Article.newBuilder()
                .setTitle("New over-the-air charger")
                .setText("Was released by a Chinese manufacturer")
                .setLabelId(3L)
                .build();

        Article fourth = Article.newBuilder()
                .setTitle("FIFA statement")
                .setText("Something")
                .setLabelId(1L)
                .build();

        Article fifth = Article.newBuilder()
                .setTitle("Brexit")
                .setText("Dutch officials seize ham sandwiches")
                .setLabelId(2L)
                .build();

        Article sixth = Article.newBuilder()
                .setTitle("Chevrolet Volt")
                .setText("Is a four-wheeled geek gadget")
                .setLabelId(3L)
                .build();

        List<Article> articlesToAdd = List.of(first, second, third, fourth, fifth, sixth);
        for (Article article : articlesToAdd) {
            save(article);
        }
    }

    @Override
    public List<Article> getAll() {
        return new ArrayList<>(articles.values());
    }

    @Override
    public Long save(Article entity) {
        Article article = Article.newBuilder().setId(++seed)
                .setTitle(entity.getTitle())
                .setText(entity.getText())
                .setLabelId(entity.getLabelId())
                .build();
        articles.put(article.getId(),article);
        return article.getId();
    }

    @Override
    public void delete(Article entity) {
        if (articles.containsKey(entity.getId())) {
            articles.remove(entity.getId());
        } else {
            System.out.println("Noting to delete.");
        }
    }

    @Override
    public void update(Article entity) {
        if (articles.containsKey(entity.getId())) {
            articles.put(entity.getId(), entity);
        } else {
            throw new SOAException("Article with ID: " + entity.getId() + " does not exist");
        }
    }

    @Override
    public Article findById(Long id) {
        if (articles.containsKey(id)) {
            return articles.get(id);
        } else {
            throw new SOAException("No entity with id " + id + " exists.");
        }
    }

    @Override
    public void deleteById(Long id) {
        if (articles.containsKey(id)) {
            articles.remove(id);
        } else {
            System.out.println("Noting to delete.");
        }
    }
}
