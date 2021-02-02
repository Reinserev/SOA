package com.ubb.pcis2083.soa.news.core.dao;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.google.type.LatLng;
import com.ubb.pcis2083.soa.labels.Label;
import com.ubb.pcis2083.soa.labels.LabelResponse;
import com.ubb.pcis2083.soa.labels.LabelServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabelDaoImpl implements LabelDao {
    private LabelServiceGrpc.LabelServiceBlockingStub stub;

    public LabelDaoImpl() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 55836)
                .usePlaintext()
                .build();

        this.stub = LabelServiceGrpc.newBlockingStub(channel);
    }


    @Override
    public List<Label> getAll() {
        LabelResponse labelResponse = stub.getAll(Empty.getDefaultInstance());
        return labelResponse.getLabelsList();
    }

    @Override
    public Long save(Label entity) {
        Int64Value result = stub.save(entity);
        Long savedID = result.getValue();
        return savedID;
    }

    @Override
    public boolean delete(Label entity) {
        return stub.deleteById(Int64Value.of(entity.getId())).getValue();
    }

    @Override
    public boolean update(Label entity) {
        BoolValue response = stub.update(entity);
        return response.getValue();
    }

    @Override
    public Label findById(Long aLong) {
        return stub.getById(Int64Value.of(aLong));
    }

    @Override
    public boolean deleteById(Long aLong) {
        return stub.deleteById(Int64Value.of(aLong)).getValue();
    }

    @Override
    public Label findLabelByName(String name) {
        List<Label> labels = getAll();
        for (Label label : labels) {
            if (label.getName().equals(name)) {
                return label;
            }
        }
        return null;
    }
}
