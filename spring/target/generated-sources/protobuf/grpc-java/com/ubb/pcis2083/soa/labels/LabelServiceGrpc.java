package com.ubb.pcis2083.soa.labels;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: Labels.proto")
public final class LabelServiceGrpc {

  private LabelServiceGrpc() {}

  public static final String SERVICE_NAME = "com.ubb.pcis2083.soa.labels.LabelService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ubb.pcis2083.soa.labels.LabelResponse> METHOD_GET_ALL =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.ubb.pcis2083.soa.labels.LabelResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.labels.LabelService", "getAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.labels.LabelResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.ubb.pcis2083.soa.labels.Label> METHOD_GET_BY_ID =
      io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.ubb.pcis2083.soa.labels.Label>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.labels.LabelService", "getById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Int64Value.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.labels.Label.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.pcis2083.soa.labels.Label,
      com.google.protobuf.Int64Value> METHOD_SAVE =
      io.grpc.MethodDescriptor.<com.ubb.pcis2083.soa.labels.Label, com.google.protobuf.Int64Value>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.labels.LabelService", "save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.labels.Label.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Int64Value.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.pcis2083.soa.labels.Label,
      com.google.protobuf.BoolValue> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<com.ubb.pcis2083.soa.labels.Label, com.google.protobuf.BoolValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.labels.LabelService", "update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.labels.Label.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.BoolValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.google.protobuf.BoolValue> METHOD_DELETE_BY_ID =
      io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.google.protobuf.BoolValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.labels.LabelService", "deleteById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Int64Value.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.BoolValue.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LabelServiceStub newStub(io.grpc.Channel channel) {
    return new LabelServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LabelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LabelServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LabelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LabelServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LabelServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.labels.LabelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL, responseObserver);
    }

    /**
     */
    public void getById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.labels.Label> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BY_ID, responseObserver);
    }

    /**
     */
    public void save(com.ubb.pcis2083.soa.labels.Label request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void update(com.ubb.pcis2083.soa.labels.Label request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void deleteById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_BY_ID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ALL,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.ubb.pcis2083.soa.labels.LabelResponse>(
                  this, METHODID_GET_ALL)))
          .addMethod(
            METHOD_GET_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                com.ubb.pcis2083.soa.labels.Label>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                com.ubb.pcis2083.soa.labels.Label,
                com.google.protobuf.Int64Value>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.ubb.pcis2083.soa.labels.Label,
                com.google.protobuf.BoolValue>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                com.google.protobuf.BoolValue>(
                  this, METHODID_DELETE_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class LabelServiceStub extends io.grpc.stub.AbstractStub<LabelServiceStub> {
    private LabelServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LabelServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LabelServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LabelServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.labels.LabelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.labels.Label> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(com.ubb.pcis2083.soa.labels.Label request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.ubb.pcis2083.soa.labels.Label request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_BY_ID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LabelServiceBlockingStub extends io.grpc.stub.AbstractStub<LabelServiceBlockingStub> {
    private LabelServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LabelServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LabelServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LabelServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ubb.pcis2083.soa.labels.LabelResponse getAll(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL, getCallOptions(), request);
    }

    /**
     */
    public com.ubb.pcis2083.soa.labels.Label getById(com.google.protobuf.Int64Value request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Int64Value save(com.ubb.pcis2083.soa.labels.Label request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue update(com.ubb.pcis2083.soa.labels.Label request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue deleteById(com.google.protobuf.Int64Value request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_BY_ID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LabelServiceFutureStub extends io.grpc.stub.AbstractStub<LabelServiceFutureStub> {
    private LabelServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LabelServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LabelServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LabelServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ubb.pcis2083.soa.labels.LabelResponse> getAll(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ubb.pcis2083.soa.labels.Label> getById(
        com.google.protobuf.Int64Value request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int64Value> save(
        com.ubb.pcis2083.soa.labels.Label request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> update(
        com.ubb.pcis2083.soa.labels.Label request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> deleteById(
        com.google.protobuf.Int64Value request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_BY_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL = 0;
  private static final int METHODID_GET_BY_ID = 1;
  private static final int METHODID_SAVE = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_DELETE_BY_ID = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LabelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LabelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL:
          serviceImpl.getAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.labels.LabelResponse>) responseObserver);
          break;
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.labels.Label>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((com.ubb.pcis2083.soa.labels.Label) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.ubb.pcis2083.soa.labels.Label) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_DELETE_BY_ID:
          serviceImpl.deleteById((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class LabelServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ubb.pcis2083.soa.labels.Labels.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LabelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LabelServiceDescriptorSupplier())
              .addMethod(METHOD_GET_ALL)
              .addMethod(METHOD_GET_BY_ID)
              .addMethod(METHOD_SAVE)
              .addMethod(METHOD_UPDATE)
              .addMethod(METHOD_DELETE_BY_ID)
              .build();
        }
      }
    }
    return result;
  }
}
