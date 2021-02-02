package com.ubb.pcis2083.soa.news.core.dao;


import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.ubb.pcis2083.soa.articles.Article;
import com.ubb.pcis2083.soa.articles.ArticleServiceGrpc;
import com.ubb.pcis2083.soa.news.core.utils.Utils;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ArticleDaoImpl implements ArticleDao {
    private ArticleServiceGrpc.ArticleServiceBlockingStub stub;

    public ArticleDaoImpl() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 56499)
                .usePlaintext()
                .build();

        stub = ArticleServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public List<Article> findArticlesWithLabel(Long labelID) {
        List<Article> articles = getAll();

        Collections.sort(articles, Comparator.comparingLong(Article::getLabelId));

        Collections.reverse(articles);

        return articles.stream().filter(a -> a.getLabelId() == labelID).collect(Collectors.toList());
    }

    @Override
    public List<Article> findArticlesWithLabelPaged(Long labelID, Integer pageSize, Integer pageNumber) {
        List<Article> articles = getAll();

        Collections.sort(articles, Comparator.comparingLong(Article::getLabelId));

        Collections.reverse(articles);

        articles = articles.stream().filter(a -> a.getLabelId() == labelID).collect(Collectors.toList());

        return Utils.getPage(articles, pageSize, pageNumber);
    }

    @Override
    public List<Article> findRecentArticlesPaged(Integer pageSize, Integer pageNumber) {
        List<Article> articles = getAll();

        Collections.sort(articles, Comparator.comparingLong(Article::getLabelId));

        Collections.reverse(articles);

        return Utils.getPage(articles, pageSize, pageNumber);
    }

    @Override
    public List<Article> getAll() {
        List<Long> articleIDs = stub.getAll(Empty.getDefaultInstance()).getArticlesList();
        List<Article> articles = new ArrayList<>();
        for (Long articleID : articleIDs) {
            articles.add(stub.getById(Int64Value.of(articleID)));
        }
        return articles;
    }

    @Override
    public Long save(Article entity) {
        return stub.save(entity).getValue();
    }

    @Override
    public boolean delete(Article entity) {
        return stub.deleteById(Int64Value.of(entity.getId())).getValue();
    }

    @Override
    public boolean update(Article entity) {
        return stub.update(entity).getValue();
    }

    @Override
    public Article findById(Long aLong) {
        return stub.getById(Int64Value.of(aLong));
    }

    @Override
    public boolean deleteById(Long aLong) {
        return stub.deleteById(Int64Value.of(aLong)).getValue();
    }
}
