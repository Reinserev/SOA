package com.ubb.pcis2083.soa.labels;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Int64Value;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.google.protobuf.Empty;

import java.util.List;

public class TestClient {
    private static void showAll(LabelServiceGrpc.LabelServiceBlockingStub stub) {
        LabelResponse labelResponse = stub.getAll(Empty.getDefaultInstance());
        List<Label> labelList = labelResponse.getLabelsList();

        System.out.println("Response received from server:");
        for (Label label : labelList) {
            System.out.println(label.getName());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 55836)
                .usePlaintext()
                .build();

        LabelServiceGrpc.LabelServiceBlockingStub stub = LabelServiceGrpc.newBlockingStub(channel);

        showAll(stub);

        Label label = Label.newBuilder().setName("cars").build();
        Int64Value result = stub.save(label);
        System.out.println("Save result: " + result.getValue());
        Long savedID = result.getValue();

        showAll(stub);

        label = Label.newBuilder().setId(savedID).setName("trucks").build();
        BoolValue response = stub.update(label);
        System.out.println("Update result: " + response.getValue());

        showAll(stub);

        response = stub.deleteById(Int64Value.of(savedID));
        System.out.println("Remove result: " + response.getValue());

        showAll(stub);

        channel.shutdown();
    }
}
