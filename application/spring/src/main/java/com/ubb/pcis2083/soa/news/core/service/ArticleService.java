package com.ubb.pcis2083.soa.news.core.service;



import com.ubb.pcis2083.soa.articles.Article;
import com.ubb.pcis2083.soa.labels.Label;

import java.util.List;

public interface ArticleService {
    Article createArticle(String title, String text, Label label);
    Article updateArticle(Long articleId, String title, String text, Label label);
    Article deleteArticle(Long articleId);
    List<Article> getArticlesWithLabel (Long labelID);
    List<Article> getArticlesWithLabelPaged (Long labelID, Integer pageSize, Integer pageNumber);
    List<Article> getRecentArticlesPaged(Integer pageSize, Integer pageNumber);
    Article findByID(Long articleID);
}
