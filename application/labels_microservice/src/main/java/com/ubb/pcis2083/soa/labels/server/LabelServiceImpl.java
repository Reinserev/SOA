package com.ubb.pcis2083.soa.labels.server;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.ubb.pcis2083.soa.common.misc.SOAException;
import com.ubb.pcis2083.soa.labels.Label;
import com.ubb.pcis2083.soa.labels.LabelResponse;
import com.ubb.pcis2083.soa.labels.LabelServiceGrpc;
import com.ubb.pcis2083.soa.labels.dao.LabelDao;
import io.grpc.stub.StreamObserver;

public class LabelServiceImpl extends LabelServiceGrpc.LabelServiceImplBase {
    private LabelDao labelDao;

    public LabelServiceImpl(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    @Override
    public void getAll(Empty request,
                       StreamObserver<LabelResponse> responseObserver) {
        LabelResponse response = LabelResponse.newBuilder()
                .addAllLabels(labelDao.getAll())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void getById(Int64Value request,
                        StreamObserver<Label> responseObserver) {
        Label label = labelDao.findById(request.getValue());

        responseObserver.onNext(label);
        responseObserver.onCompleted();
    }

    @Override
    public void save(Label request,
                     StreamObserver<com.google.protobuf.Int64Value> responseObserver) {

        Long newID = labelDao.save(request);

        responseObserver.onNext(Int64Value.of(newID));
        responseObserver.onCompleted();
    }

    @Override
    public void update(Label request,
                       StreamObserver<com.google.protobuf.BoolValue> responseObserver) {

        Boolean success = true;

        try {
            labelDao.update(request);
        }
        catch (SOAException soaException) {
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
            labelDao.deleteById(request.getValue());
        }
        catch (SOAException soaException) {
            success = false;
        }

        responseObserver.onNext(BoolValue.of(success));
        responseObserver.onCompleted();
    }
}
