package com.ubb.pcis2083.soa.news.core.dao;

import com.ubb.pcis2083.soa.articles.Article;

import java.util.List;

public interface ArticleDao extends Dao<Long, Article> {
    List<Article> findArticlesWithLabel(Long labelID);

    List<Article> findArticlesWithLabelPaged(Long labelID, Integer pageSize, Integer pageNumber);

    List<Article> findRecentArticlesPaged(Integer pageSize, Integer pageNumber);
}
