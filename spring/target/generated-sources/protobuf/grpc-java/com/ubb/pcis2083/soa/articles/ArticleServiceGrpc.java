package com.ubb.pcis2083.soa.articles;

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
    comments = "Source: Articles.proto")
public final class ArticleServiceGrpc {

  private ArticleServiceGrpc() {}

  public static final String SERVICE_NAME = "com.ubb.pcis2083.soa.articles.ArticleService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.ubb.pcis2083.soa.articles.ArticleResponse> METHOD_GET_ALL =
      io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.ubb.pcis2083.soa.articles.ArticleResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.articles.ArticleService", "getAll"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.articles.ArticleResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.ubb.pcis2083.soa.articles.Article> METHOD_GET_BY_ID =
      io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.ubb.pcis2083.soa.articles.Article>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.articles.ArticleService", "getById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Int64Value.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.articles.Article.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.pcis2083.soa.articles.Article,
      com.google.protobuf.Int64Value> METHOD_SAVE =
      io.grpc.MethodDescriptor.<com.ubb.pcis2083.soa.articles.Article, com.google.protobuf.Int64Value>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.articles.ArticleService", "save"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.articles.Article.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Int64Value.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.ubb.pcis2083.soa.articles.Article,
      com.google.protobuf.BoolValue> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<com.ubb.pcis2083.soa.articles.Article, com.google.protobuf.BoolValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.articles.ArticleService", "update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.ubb.pcis2083.soa.articles.Article.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.BoolValue.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.google.protobuf.BoolValue> METHOD_DELETE_BY_ID =
      io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.google.protobuf.BoolValue>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.ubb.pcis2083.soa.articles.ArticleService", "deleteById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Int64Value.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.BoolValue.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArticleServiceStub newStub(io.grpc.Channel channel) {
    return new ArticleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArticleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ArticleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArticleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ArticleServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ArticleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.articles.ArticleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL, responseObserver);
    }

    /**
     */
    public void getById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.articles.Article> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BY_ID, responseObserver);
    }

    /**
     */
    public void save(com.ubb.pcis2083.soa.articles.Article request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAVE, responseObserver);
    }

    /**
     */
    public void update(com.ubb.pcis2083.soa.articles.Article request,
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
                com.ubb.pcis2083.soa.articles.ArticleResponse>(
                  this, METHODID_GET_ALL)))
          .addMethod(
            METHOD_GET_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int64Value,
                com.ubb.pcis2083.soa.articles.Article>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            METHOD_SAVE,
            asyncUnaryCall(
              new MethodHandlers<
                com.ubb.pcis2083.soa.articles.Article,
                com.google.protobuf.Int64Value>(
                  this, METHODID_SAVE)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.ubb.pcis2083.soa.articles.Article,
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
  public static final class ArticleServiceStub extends io.grpc.stub.AbstractStub<ArticleServiceStub> {
    private ArticleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArticleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArticleServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.articles.ArticleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getById(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.articles.Article> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void save(com.ubb.pcis2083.soa.articles.Article request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.ubb.pcis2083.soa.articles.Article request,
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
  public static final class ArticleServiceBlockingStub extends io.grpc.stub.AbstractStub<ArticleServiceBlockingStub> {
    private ArticleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArticleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArticleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ubb.pcis2083.soa.articles.ArticleResponse getAll(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL, getCallOptions(), request);
    }

    /**
     */
    public com.ubb.pcis2083.soa.articles.Article getById(com.google.protobuf.Int64Value request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BY_ID, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Int64Value save(com.ubb.pcis2083.soa.articles.Article request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAVE, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue update(com.ubb.pcis2083.soa.articles.Article request) {
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
  public static final class ArticleServiceFutureStub extends io.grpc.stub.AbstractStub<ArticleServiceFutureStub> {
    private ArticleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArticleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArticleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ubb.pcis2083.soa.articles.ArticleResponse> getAll(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ubb.pcis2083.soa.articles.Article> getById(
        com.google.protobuf.Int64Value request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int64Value> save(
        com.ubb.pcis2083.soa.articles.Article request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAVE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> update(
        com.ubb.pcis2083.soa.articles.Article request) {
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
    private final ArticleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArticleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL:
          serviceImpl.getAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.articles.ArticleResponse>) responseObserver);
          break;
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.ubb.pcis2083.soa.articles.Article>) responseObserver);
          break;
        case METHODID_SAVE:
          serviceImpl.save((com.ubb.pcis2083.soa.articles.Article) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.ubb.pcis2083.soa.articles.Article) request,
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

  private static final class ArticleServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ubb.pcis2083.soa.articles.Articles.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ArticleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArticleServiceDescriptorSupplier())
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
