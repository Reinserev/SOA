package com.ubb.pcis2083.soa.articles.server;

import com.ubb.pcis2083.soa.articles.dao.ArticleDao;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ArticleServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArticleDao articleDao = new ArticleDao(true);
        Server server = ServerBuilder.forPort(56499)
          .addService(new ArticleServiceImpl(articleDao)).build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
