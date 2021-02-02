package com.ubb.pcis2083.soa.news.core.service;

import com.ubb.pcis2083.soa.articles.Article;
import com.ubb.pcis2083.soa.labels.Label;
import com.ubb.pcis2083.soa.news.core.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public Article createArticle(String title, String text, Label label) {
        Article article = Article.newBuilder()
                .setTitle(title)
                .setText(text)
                .setLabelId(label.getId())
                .build();
        Long assignedId = articleDao.save(article);
        return articleDao.findById(assignedId);
    }

    @Override
    public Article updateArticle(Long articleId, String title, String text, Label label) {
        Article article = Article.newBuilder()
                .setId(articleId)
                .setTitle(title)
                .setText(text)
                .setLabelId(label.getId())
                .build();
        articleDao.update(article);
        return articleDao.findById(articleId);
    }

    @Override
    public Article deleteArticle(Long articleId) {
        Article article = articleDao.findById(articleId);
        articleDao.deleteById(articleId);
        return article;
    }

    @Override
    public List<Article> getArticlesWithLabel(Long labelID) {
        return  articleDao.findArticlesWithLabel(labelID);
    }

    @Override
    public List<Article> getArticlesWithLabelPaged(Long labelID, Integer pageSize, Integer pageNumber) {
        return articleDao.findArticlesWithLabelPaged(labelID,pageSize,pageNumber);
    }

    @Override
    public List<Article> getRecentArticlesPaged(Integer pageSize, Integer pageNumber) {
        return articleDao.findRecentArticlesPaged(pageSize,pageNumber);
    }

    @Override
    public Article findByID(Long articleID) {
        return articleDao.findById(articleID);
    }
}
