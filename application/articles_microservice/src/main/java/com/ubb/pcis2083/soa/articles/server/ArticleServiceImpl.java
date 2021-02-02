package com.ubb.pcis2083.soa.articles.server;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.ubb.pcis2083.soa.common.misc.SOAException;
import com.ubb.pcis2083.soa.articles.Article;
import com.ubb.pcis2083.soa.articles.ArticleResponse;
import com.ubb.pcis2083.soa.articles.ArticleServiceGrpc;
import com.ubb.pcis2083.soa.articles.dao.ArticleDao;
import io.grpc.stub.StreamObserver;

import java.util.stream.Collectors;

public class ArticleServiceImpl extends ArticleServiceGrpc.ArticleServiceImplBase {
    private ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void getAll(Empty request,
                       StreamObserver<ArticleResponse> responseObserver) {
        ArticleResponse response = ArticleResponse.newBuilder()
                .addAllArticles(articleDao.getAll().stream().map(Article::getId)
                        .collect(Collectors.toList()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getById(Int64Value request,
                        StreamObserver<Article> responseObserver) {
        Article article = articleDao.findById(request.getValue());

        responseObserver.onNext(article);
        responseObserver.onCompleted();
    }

    @Override
    public void save(Article request,
                     StreamObserver<com.google.protobuf.Int64Value> responseObserver) {

        Long newID = articleDao.save(request);

        responseObserver.onNext(Int64Value.of(newID));
        responseObserver.onCompleted();
    }

    @Override
    public void update(Article request,
                       StreamObserver<com.google.protobuf.BoolValue> responseObserver) {

        Boolean success = true;

        try {
            articleDao.update(request);
        } catch (SOAException soaException) {
            success = false;
        }

        responseObserver.onNext(BoolValue.of(success));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(Int64Value request,
                           StreamObserver<com.google.protobuf.BoolValue> responseObserver) {

        Boolean success = true;

        try {
            articleDao.deleteById(request.getValue());
        } catch (SOAException soaException) {
            success = false;
        }

        responseObserver.onNext(BoolValue.of(success));
        responseObserver.onCompleted();
    }
}
