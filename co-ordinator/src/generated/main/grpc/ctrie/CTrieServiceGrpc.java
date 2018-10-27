package ctrie;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: c_trie.proto")
public final class CTrieServiceGrpc {

  private CTrieServiceGrpc() {}

  public static final String SERVICE_NAME = "ctrie.CTrieService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSizeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.SizeRequest,
      ctrie.SizeResponse> METHOD_SIZE = getSizeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.SizeRequest,
      ctrie.SizeResponse> getSizeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.SizeRequest,
      ctrie.SizeResponse> getSizeMethod() {
    return getSizeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.SizeRequest,
      ctrie.SizeResponse> getSizeMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.SizeRequest, ctrie.SizeResponse> getSizeMethod;
    if ((getSizeMethod = CTrieServiceGrpc.getSizeMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getSizeMethod = CTrieServiceGrpc.getSizeMethod) == null) {
          CTrieServiceGrpc.getSizeMethod = getSizeMethod = 
              io.grpc.MethodDescriptor.<ctrie.SizeRequest, ctrie.SizeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "Size"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.SizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.SizeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("Size"))
                  .build();
          }
        }
     }
     return getSizeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsEmptyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.IsEmptyRequest,
      ctrie.IsEmptyResponse> METHOD_IS_EMPTY = getIsEmptyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.IsEmptyRequest,
      ctrie.IsEmptyResponse> getIsEmptyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.IsEmptyRequest,
      ctrie.IsEmptyResponse> getIsEmptyMethod() {
    return getIsEmptyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.IsEmptyRequest,
      ctrie.IsEmptyResponse> getIsEmptyMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.IsEmptyRequest, ctrie.IsEmptyResponse> getIsEmptyMethod;
    if ((getIsEmptyMethod = CTrieServiceGrpc.getIsEmptyMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getIsEmptyMethod = CTrieServiceGrpc.getIsEmptyMethod) == null) {
          CTrieServiceGrpc.getIsEmptyMethod = getIsEmptyMethod = 
              io.grpc.MethodDescriptor.<ctrie.IsEmptyRequest, ctrie.IsEmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "IsEmpty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.IsEmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.IsEmptyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("IsEmpty"))
                  .build();
          }
        }
     }
     return getIsEmptyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getContainsKeyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.ContainsKeyRequest,
      ctrie.ContainsKeyResponse> METHOD_CONTAINS_KEY = getContainsKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.ContainsKeyRequest,
      ctrie.ContainsKeyResponse> getContainsKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.ContainsKeyRequest,
      ctrie.ContainsKeyResponse> getContainsKeyMethod() {
    return getContainsKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.ContainsKeyRequest,
      ctrie.ContainsKeyResponse> getContainsKeyMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.ContainsKeyRequest, ctrie.ContainsKeyResponse> getContainsKeyMethod;
    if ((getContainsKeyMethod = CTrieServiceGrpc.getContainsKeyMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getContainsKeyMethod = CTrieServiceGrpc.getContainsKeyMethod) == null) {
          CTrieServiceGrpc.getContainsKeyMethod = getContainsKeyMethod = 
              io.grpc.MethodDescriptor.<ctrie.ContainsKeyRequest, ctrie.ContainsKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "ContainsKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ContainsKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ContainsKeyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("ContainsKey"))
                  .build();
          }
        }
     }
     return getContainsKeyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getContainsValueMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.ContainsValueRequest,
      ctrie.ContainsValueResponse> METHOD_CONTAINS_VALUE = getContainsValueMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.ContainsValueRequest,
      ctrie.ContainsValueResponse> getContainsValueMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.ContainsValueRequest,
      ctrie.ContainsValueResponse> getContainsValueMethod() {
    return getContainsValueMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.ContainsValueRequest,
      ctrie.ContainsValueResponse> getContainsValueMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.ContainsValueRequest, ctrie.ContainsValueResponse> getContainsValueMethod;
    if ((getContainsValueMethod = CTrieServiceGrpc.getContainsValueMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getContainsValueMethod = CTrieServiceGrpc.getContainsValueMethod) == null) {
          CTrieServiceGrpc.getContainsValueMethod = getContainsValueMethod = 
              io.grpc.MethodDescriptor.<ctrie.ContainsValueRequest, ctrie.ContainsValueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "ContainsValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ContainsValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ContainsValueResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("ContainsValue"))
                  .build();
          }
        }
     }
     return getContainsValueMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.GetRequest,
      ctrie.GetResponse> METHOD_GET = getGetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.GetRequest,
      ctrie.GetResponse> getGetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.GetRequest,
      ctrie.GetResponse> getGetMethod() {
    return getGetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.GetRequest,
      ctrie.GetResponse> getGetMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.GetRequest, ctrie.GetResponse> getGetMethod;
    if ((getGetMethod = CTrieServiceGrpc.getGetMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getGetMethod = CTrieServiceGrpc.getGetMethod) == null) {
          CTrieServiceGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<ctrie.GetRequest, ctrie.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.GetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPutMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.PutRequest,
      ctrie.PutResponse> METHOD_PUT = getPutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.PutRequest,
      ctrie.PutResponse> getPutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.PutRequest,
      ctrie.PutResponse> getPutMethod() {
    return getPutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.PutRequest,
      ctrie.PutResponse> getPutMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.PutRequest, ctrie.PutResponse> getPutMethod;
    if ((getPutMethod = CTrieServiceGrpc.getPutMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getPutMethod = CTrieServiceGrpc.getPutMethod) == null) {
          CTrieServiceGrpc.getPutMethod = getPutMethod = 
              io.grpc.MethodDescriptor.<ctrie.PutRequest, ctrie.PutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "Put"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.PutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.PutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("Put"))
                  .build();
          }
        }
     }
     return getPutMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.RemoveRequest,
      ctrie.RemoveResponse> METHOD_REMOVE = getRemoveMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.RemoveRequest,
      ctrie.RemoveResponse> getRemoveMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.RemoveRequest,
      ctrie.RemoveResponse> getRemoveMethod() {
    return getRemoveMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.RemoveRequest,
      ctrie.RemoveResponse> getRemoveMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.RemoveRequest, ctrie.RemoveResponse> getRemoveMethod;
    if ((getRemoveMethod = CTrieServiceGrpc.getRemoveMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getRemoveMethod = CTrieServiceGrpc.getRemoveMethod) == null) {
          CTrieServiceGrpc.getRemoveMethod = getRemoveMethod = 
              io.grpc.MethodDescriptor.<ctrie.RemoveRequest, ctrie.RemoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "Remove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.RemoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.RemoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("Remove"))
                  .build();
          }
        }
     }
     return getRemoveMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPutAllMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.PutAllRequest,
      ctrie.PutAllResponse> METHOD_PUT_ALL = getPutAllMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.PutAllRequest,
      ctrie.PutAllResponse> getPutAllMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.PutAllRequest,
      ctrie.PutAllResponse> getPutAllMethod() {
    return getPutAllMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.PutAllRequest,
      ctrie.PutAllResponse> getPutAllMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.PutAllRequest, ctrie.PutAllResponse> getPutAllMethod;
    if ((getPutAllMethod = CTrieServiceGrpc.getPutAllMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getPutAllMethod = CTrieServiceGrpc.getPutAllMethod) == null) {
          CTrieServiceGrpc.getPutAllMethod = getPutAllMethod = 
              io.grpc.MethodDescriptor.<ctrie.PutAllRequest, ctrie.PutAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "PutAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.PutAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.PutAllResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("PutAll"))
                  .build();
          }
        }
     }
     return getPutAllMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getClearMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.ClearRequest,
      ctrie.ClearResponse> METHOD_CLEAR = getClearMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.ClearRequest,
      ctrie.ClearResponse> getClearMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.ClearRequest,
      ctrie.ClearResponse> getClearMethod() {
    return getClearMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.ClearRequest,
      ctrie.ClearResponse> getClearMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.ClearRequest, ctrie.ClearResponse> getClearMethod;
    if ((getClearMethod = CTrieServiceGrpc.getClearMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getClearMethod = CTrieServiceGrpc.getClearMethod) == null) {
          CTrieServiceGrpc.getClearMethod = getClearMethod = 
              io.grpc.MethodDescriptor.<ctrie.ClearRequest, ctrie.ClearResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "Clear"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ClearRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ClearResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("Clear"))
                  .build();
          }
        }
     }
     return getClearMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getKeySetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.KeySetRequest,
      ctrie.KeySetResponse> METHOD_KEY_SET = getKeySetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.KeySetRequest,
      ctrie.KeySetResponse> getKeySetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.KeySetRequest,
      ctrie.KeySetResponse> getKeySetMethod() {
    return getKeySetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.KeySetRequest,
      ctrie.KeySetResponse> getKeySetMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.KeySetRequest, ctrie.KeySetResponse> getKeySetMethod;
    if ((getKeySetMethod = CTrieServiceGrpc.getKeySetMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getKeySetMethod = CTrieServiceGrpc.getKeySetMethod) == null) {
          CTrieServiceGrpc.getKeySetMethod = getKeySetMethod = 
              io.grpc.MethodDescriptor.<ctrie.KeySetRequest, ctrie.KeySetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "KeySet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.KeySetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.KeySetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("KeySet"))
                  .build();
          }
        }
     }
     return getKeySetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getValuesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.ValuesRequest,
      ctrie.ValuesResponse> METHOD_VALUES = getValuesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.ValuesRequest,
      ctrie.ValuesResponse> getValuesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.ValuesRequest,
      ctrie.ValuesResponse> getValuesMethod() {
    return getValuesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.ValuesRequest,
      ctrie.ValuesResponse> getValuesMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.ValuesRequest, ctrie.ValuesResponse> getValuesMethod;
    if ((getValuesMethod = CTrieServiceGrpc.getValuesMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getValuesMethod = CTrieServiceGrpc.getValuesMethod) == null) {
          CTrieServiceGrpc.getValuesMethod = getValuesMethod = 
              io.grpc.MethodDescriptor.<ctrie.ValuesRequest, ctrie.ValuesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "Values"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.ValuesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("Values"))
                  .build();
          }
        }
     }
     return getValuesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getEntrySetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ctrie.EntrySetRequest,
      ctrie.EntrySetResponse> METHOD_ENTRY_SET = getEntrySetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ctrie.EntrySetRequest,
      ctrie.EntrySetResponse> getEntrySetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ctrie.EntrySetRequest,
      ctrie.EntrySetResponse> getEntrySetMethod() {
    return getEntrySetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ctrie.EntrySetRequest,
      ctrie.EntrySetResponse> getEntrySetMethodHelper() {
    io.grpc.MethodDescriptor<ctrie.EntrySetRequest, ctrie.EntrySetResponse> getEntrySetMethod;
    if ((getEntrySetMethod = CTrieServiceGrpc.getEntrySetMethod) == null) {
      synchronized (CTrieServiceGrpc.class) {
        if ((getEntrySetMethod = CTrieServiceGrpc.getEntrySetMethod) == null) {
          CTrieServiceGrpc.getEntrySetMethod = getEntrySetMethod = 
              io.grpc.MethodDescriptor.<ctrie.EntrySetRequest, ctrie.EntrySetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ctrie.CTrieService", "EntrySet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.EntrySetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ctrie.EntrySetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CTrieServiceMethodDescriptorSupplier("EntrySet"))
                  .build();
          }
        }
     }
     return getEntrySetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CTrieServiceStub newStub(io.grpc.Channel channel) {
    return new CTrieServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CTrieServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CTrieServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CTrieServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CTrieServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CTrieServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void size(ctrie.SizeRequest request,
        io.grpc.stub.StreamObserver<ctrie.SizeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSizeMethodHelper(), responseObserver);
    }

    /**
     */
    public void isEmpty(ctrie.IsEmptyRequest request,
        io.grpc.stub.StreamObserver<ctrie.IsEmptyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIsEmptyMethodHelper(), responseObserver);
    }

    /**
     */
    public void containsKey(ctrie.ContainsKeyRequest request,
        io.grpc.stub.StreamObserver<ctrie.ContainsKeyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContainsKeyMethodHelper(), responseObserver);
    }

    /**
     */
    public void containsValue(ctrie.ContainsValueRequest request,
        io.grpc.stub.StreamObserver<ctrie.ContainsValueResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContainsValueMethodHelper(), responseObserver);
    }

    /**
     */
    public void get(ctrie.GetRequest request,
        io.grpc.stub.StreamObserver<ctrie.GetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethodHelper(), responseObserver);
    }

    /**
     */
    public void put(ctrie.PutRequest request,
        io.grpc.stub.StreamObserver<ctrie.PutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutMethodHelper(), responseObserver);
    }

    /**
     */
    public void remove(ctrie.RemoveRequest request,
        io.grpc.stub.StreamObserver<ctrie.RemoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveMethodHelper(), responseObserver);
    }

    /**
     */
    public void putAll(ctrie.PutAllRequest request,
        io.grpc.stub.StreamObserver<ctrie.PutAllResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutAllMethodHelper(), responseObserver);
    }

    /**
     */
    public void clear(ctrie.ClearRequest request,
        io.grpc.stub.StreamObserver<ctrie.ClearResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getClearMethodHelper(), responseObserver);
    }

    /**
     */
    public void keySet(ctrie.KeySetRequest request,
        io.grpc.stub.StreamObserver<ctrie.KeySetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getKeySetMethodHelper(), responseObserver);
    }

    /**
     */
    public void values(ctrie.ValuesRequest request,
        io.grpc.stub.StreamObserver<ctrie.ValuesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getValuesMethodHelper(), responseObserver);
    }

    /**
     */
    public void entrySet(ctrie.EntrySetRequest request,
        io.grpc.stub.StreamObserver<ctrie.EntrySetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEntrySetMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSizeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.SizeRequest,
                ctrie.SizeResponse>(
                  this, METHODID_SIZE)))
          .addMethod(
            getIsEmptyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.IsEmptyRequest,
                ctrie.IsEmptyResponse>(
                  this, METHODID_IS_EMPTY)))
          .addMethod(
            getContainsKeyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.ContainsKeyRequest,
                ctrie.ContainsKeyResponse>(
                  this, METHODID_CONTAINS_KEY)))
          .addMethod(
            getContainsValueMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.ContainsValueRequest,
                ctrie.ContainsValueResponse>(
                  this, METHODID_CONTAINS_VALUE)))
          .addMethod(
            getGetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.GetRequest,
                ctrie.GetResponse>(
                  this, METHODID_GET)))
          .addMethod(
            getPutMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.PutRequest,
                ctrie.PutResponse>(
                  this, METHODID_PUT)))
          .addMethod(
            getRemoveMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.RemoveRequest,
                ctrie.RemoveResponse>(
                  this, METHODID_REMOVE)))
          .addMethod(
            getPutAllMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.PutAllRequest,
                ctrie.PutAllResponse>(
                  this, METHODID_PUT_ALL)))
          .addMethod(
            getClearMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.ClearRequest,
                ctrie.ClearResponse>(
                  this, METHODID_CLEAR)))
          .addMethod(
            getKeySetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.KeySetRequest,
                ctrie.KeySetResponse>(
                  this, METHODID_KEY_SET)))
          .addMethod(
            getValuesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.ValuesRequest,
                ctrie.ValuesResponse>(
                  this, METHODID_VALUES)))
          .addMethod(
            getEntrySetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ctrie.EntrySetRequest,
                ctrie.EntrySetResponse>(
                  this, METHODID_ENTRY_SET)))
          .build();
    }
  }

  /**
   */
  public static final class CTrieServiceStub extends io.grpc.stub.AbstractStub<CTrieServiceStub> {
    private CTrieServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CTrieServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CTrieServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CTrieServiceStub(channel, callOptions);
    }

    /**
     */
    public void size(ctrie.SizeRequest request,
        io.grpc.stub.StreamObserver<ctrie.SizeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSizeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isEmpty(ctrie.IsEmptyRequest request,
        io.grpc.stub.StreamObserver<ctrie.IsEmptyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsEmptyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void containsKey(ctrie.ContainsKeyRequest request,
        io.grpc.stub.StreamObserver<ctrie.ContainsKeyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContainsKeyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void containsValue(ctrie.ContainsValueRequest request,
        io.grpc.stub.StreamObserver<ctrie.ContainsValueResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContainsValueMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(ctrie.GetRequest request,
        io.grpc.stub.StreamObserver<ctrie.GetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void put(ctrie.PutRequest request,
        io.grpc.stub.StreamObserver<ctrie.PutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void remove(ctrie.RemoveRequest request,
        io.grpc.stub.StreamObserver<ctrie.RemoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putAll(ctrie.PutAllRequest request,
        io.grpc.stub.StreamObserver<ctrie.PutAllResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutAllMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clear(ctrie.ClearRequest request,
        io.grpc.stub.StreamObserver<ctrie.ClearResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClearMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void keySet(ctrie.KeySetRequest request,
        io.grpc.stub.StreamObserver<ctrie.KeySetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getKeySetMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void values(ctrie.ValuesRequest request,
        io.grpc.stub.StreamObserver<ctrie.ValuesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValuesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void entrySet(ctrie.EntrySetRequest request,
        io.grpc.stub.StreamObserver<ctrie.EntrySetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEntrySetMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CTrieServiceBlockingStub extends io.grpc.stub.AbstractStub<CTrieServiceBlockingStub> {
    private CTrieServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CTrieServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CTrieServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CTrieServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ctrie.SizeResponse size(ctrie.SizeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSizeMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.IsEmptyResponse isEmpty(ctrie.IsEmptyRequest request) {
      return blockingUnaryCall(
          getChannel(), getIsEmptyMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.ContainsKeyResponse containsKey(ctrie.ContainsKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getContainsKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.ContainsValueResponse containsValue(ctrie.ContainsValueRequest request) {
      return blockingUnaryCall(
          getChannel(), getContainsValueMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.GetResponse get(ctrie.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.PutResponse put(ctrie.PutRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.RemoveResponse remove(ctrie.RemoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.PutAllResponse putAll(ctrie.PutAllRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutAllMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.ClearResponse clear(ctrie.ClearRequest request) {
      return blockingUnaryCall(
          getChannel(), getClearMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.KeySetResponse keySet(ctrie.KeySetRequest request) {
      return blockingUnaryCall(
          getChannel(), getKeySetMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.ValuesResponse values(ctrie.ValuesRequest request) {
      return blockingUnaryCall(
          getChannel(), getValuesMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public ctrie.EntrySetResponse entrySet(ctrie.EntrySetRequest request) {
      return blockingUnaryCall(
          getChannel(), getEntrySetMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CTrieServiceFutureStub extends io.grpc.stub.AbstractStub<CTrieServiceFutureStub> {
    private CTrieServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CTrieServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CTrieServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CTrieServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.SizeResponse> size(
        ctrie.SizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSizeMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.IsEmptyResponse> isEmpty(
        ctrie.IsEmptyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIsEmptyMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.ContainsKeyResponse> containsKey(
        ctrie.ContainsKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getContainsKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.ContainsValueResponse> containsValue(
        ctrie.ContainsValueRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getContainsValueMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.GetResponse> get(
        ctrie.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.PutResponse> put(
        ctrie.PutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.RemoveResponse> remove(
        ctrie.RemoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.PutAllResponse> putAll(
        ctrie.PutAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutAllMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.ClearResponse> clear(
        ctrie.ClearRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClearMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.KeySetResponse> keySet(
        ctrie.KeySetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getKeySetMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.ValuesResponse> values(
        ctrie.ValuesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getValuesMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ctrie.EntrySetResponse> entrySet(
        ctrie.EntrySetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEntrySetMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIZE = 0;
  private static final int METHODID_IS_EMPTY = 1;
  private static final int METHODID_CONTAINS_KEY = 2;
  private static final int METHODID_CONTAINS_VALUE = 3;
  private static final int METHODID_GET = 4;
  private static final int METHODID_PUT = 5;
  private static final int METHODID_REMOVE = 6;
  private static final int METHODID_PUT_ALL = 7;
  private static final int METHODID_CLEAR = 8;
  private static final int METHODID_KEY_SET = 9;
  private static final int METHODID_VALUES = 10;
  private static final int METHODID_ENTRY_SET = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CTrieServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CTrieServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIZE:
          serviceImpl.size((ctrie.SizeRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.SizeResponse>) responseObserver);
          break;
        case METHODID_IS_EMPTY:
          serviceImpl.isEmpty((ctrie.IsEmptyRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.IsEmptyResponse>) responseObserver);
          break;
        case METHODID_CONTAINS_KEY:
          serviceImpl.containsKey((ctrie.ContainsKeyRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.ContainsKeyResponse>) responseObserver);
          break;
        case METHODID_CONTAINS_VALUE:
          serviceImpl.containsValue((ctrie.ContainsValueRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.ContainsValueResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((ctrie.GetRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.GetResponse>) responseObserver);
          break;
        case METHODID_PUT:
          serviceImpl.put((ctrie.PutRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.PutResponse>) responseObserver);
          break;
        case METHODID_REMOVE:
          serviceImpl.remove((ctrie.RemoveRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.RemoveResponse>) responseObserver);
          break;
        case METHODID_PUT_ALL:
          serviceImpl.putAll((ctrie.PutAllRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.PutAllResponse>) responseObserver);
          break;
        case METHODID_CLEAR:
          serviceImpl.clear((ctrie.ClearRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.ClearResponse>) responseObserver);
          break;
        case METHODID_KEY_SET:
          serviceImpl.keySet((ctrie.KeySetRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.KeySetResponse>) responseObserver);
          break;
        case METHODID_VALUES:
          serviceImpl.values((ctrie.ValuesRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.ValuesResponse>) responseObserver);
          break;
        case METHODID_ENTRY_SET:
          serviceImpl.entrySet((ctrie.EntrySetRequest) request,
              (io.grpc.stub.StreamObserver<ctrie.EntrySetResponse>) responseObserver);
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

  private static abstract class CTrieServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CTrieServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ctrie.CTrieProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CTrieService");
    }
  }

  private static final class CTrieServiceFileDescriptorSupplier
      extends CTrieServiceBaseDescriptorSupplier {
    CTrieServiceFileDescriptorSupplier() {}
  }

  private static final class CTrieServiceMethodDescriptorSupplier
      extends CTrieServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CTrieServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CTrieServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CTrieServiceFileDescriptorSupplier())
              .addMethod(getSizeMethodHelper())
              .addMethod(getIsEmptyMethodHelper())
              .addMethod(getContainsKeyMethodHelper())
              .addMethod(getContainsValueMethodHelper())
              .addMethod(getGetMethodHelper())
              .addMethod(getPutMethodHelper())
              .addMethod(getRemoveMethodHelper())
              .addMethod(getPutAllMethodHelper())
              .addMethod(getClearMethodHelper())
              .addMethod(getKeySetMethodHelper())
              .addMethod(getValuesMethodHelper())
              .addMethod(getEntrySetMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
