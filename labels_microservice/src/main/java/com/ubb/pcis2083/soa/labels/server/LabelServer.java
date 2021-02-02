package com.ubb.pcis2083.soa.labels.server;

import com.ubb.pcis2083.soa.labels.dao.LabelDao;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class LabelServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        LabelDao labelDao = new LabelDao(true);
        Server server = ServerBuilder.forPort(55836)
          .addService(new LabelServiceImpl(labelDao)).build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
