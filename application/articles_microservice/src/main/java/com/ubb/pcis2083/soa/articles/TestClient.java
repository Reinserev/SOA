package com.ubb.pcis2083.soa.articles;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Int64Value;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.google.protobuf.Empty;

import java.util.List;

public class TestClient {
    private static void showAll(ArticleServiceGrpc.ArticleServiceBlockingStub stub) {
        ArticleResponse articleResponse = stub.getAll(Empty.getDefaultInstance());
        List<Long> articleIDList = articleResponse.getArticlesList();

        System.out.println("Response received from server:");
        for (Long articleID : articleIDList) {
            Article article = stub.getById(Int64Value.of(articleID));
            System.out.print("\n" + article.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 56499)
                .usePlaintext()
                .build();

        ArticleServiceGrpc.ArticleServiceBlockingStub stub = ArticleServiceGrpc.newBlockingStub(channel);

        showAll(stub);

        Article article = Article.newBuilder().setTitle("BMW X7").build();
        Int64Value result = stub.save(article);
        System.out.println("Save result: " + result.getValue());
        Long savedID = result.getValue();

        showAll(stub);

        article = Article.newBuilder().setId(savedID).setTitle("Ford F150").build();
        BoolValue response = stub.update(article);
        System.out.println("Update result: " + response.getValue());

        showAll(stub);

        response = stub.deleteById(Int64Value.of(savedID));
        System.out.println("Remove result: " + response.getValue());

        showAll(stub);

        channel.shutdown();
    }
}
