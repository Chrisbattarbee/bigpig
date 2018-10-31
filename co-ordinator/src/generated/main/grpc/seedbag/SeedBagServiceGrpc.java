package seedbag;

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
    comments = "Source: seed_bag.proto")
public final class SeedBagServiceGrpc {

  private SeedBagServiceGrpc() {}

  public static final String SERVICE_NAME = "seedbag.SeedBagService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSizeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.SizeRequest,
      seedbag.SizeResponse> METHOD_SIZE = getSizeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.SizeRequest,
      seedbag.SizeResponse> getSizeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.SizeRequest,
      seedbag.SizeResponse> getSizeMethod() {
    return getSizeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.SizeRequest,
      seedbag.SizeResponse> getSizeMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.SizeRequest, seedbag.SizeResponse> getSizeMethod;
    if ((getSizeMethod = SeedBagServiceGrpc.getSizeMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getSizeMethod = SeedBagServiceGrpc.getSizeMethod) == null) {
          SeedBagServiceGrpc.getSizeMethod = getSizeMethod = 
              io.grpc.MethodDescriptor.<seedbag.SizeRequest, seedbag.SizeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Size"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.SizeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.SizeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Size"))
                  .build();
          }
        }
     }
     return getSizeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsEmptyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.IsEmptyRequest,
      seedbag.IsEmptyResponse> METHOD_IS_EMPTY = getIsEmptyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.IsEmptyRequest,
      seedbag.IsEmptyResponse> getIsEmptyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.IsEmptyRequest,
      seedbag.IsEmptyResponse> getIsEmptyMethod() {
    return getIsEmptyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.IsEmptyRequest,
      seedbag.IsEmptyResponse> getIsEmptyMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.IsEmptyRequest, seedbag.IsEmptyResponse> getIsEmptyMethod;
    if ((getIsEmptyMethod = SeedBagServiceGrpc.getIsEmptyMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getIsEmptyMethod = SeedBagServiceGrpc.getIsEmptyMethod) == null) {
          SeedBagServiceGrpc.getIsEmptyMethod = getIsEmptyMethod = 
              io.grpc.MethodDescriptor.<seedbag.IsEmptyRequest, seedbag.IsEmptyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "IsEmpty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.IsEmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.IsEmptyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("IsEmpty"))
                  .build();
          }
        }
     }
     return getIsEmptyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getContainsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.ContainsRequest,
      seedbag.ContainsResponse> METHOD_CONTAINS = getContainsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.ContainsRequest,
      seedbag.ContainsResponse> getContainsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.ContainsRequest,
      seedbag.ContainsResponse> getContainsMethod() {
    return getContainsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.ContainsRequest,
      seedbag.ContainsResponse> getContainsMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.ContainsRequest, seedbag.ContainsResponse> getContainsMethod;
    if ((getContainsMethod = SeedBagServiceGrpc.getContainsMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getContainsMethod = SeedBagServiceGrpc.getContainsMethod) == null) {
          SeedBagServiceGrpc.getContainsMethod = getContainsMethod = 
              io.grpc.MethodDescriptor.<seedbag.ContainsRequest, seedbag.ContainsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Contains"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ContainsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ContainsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Contains"))
                  .build();
          }
        }
     }
     return getContainsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIteratorMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.IteratorRequest,
      seedbag.IteratorResponse> METHOD_ITERATOR = getIteratorMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.IteratorRequest,
      seedbag.IteratorResponse> getIteratorMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.IteratorRequest,
      seedbag.IteratorResponse> getIteratorMethod() {
    return getIteratorMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.IteratorRequest,
      seedbag.IteratorResponse> getIteratorMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.IteratorRequest, seedbag.IteratorResponse> getIteratorMethod;
    if ((getIteratorMethod = SeedBagServiceGrpc.getIteratorMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getIteratorMethod = SeedBagServiceGrpc.getIteratorMethod) == null) {
          SeedBagServiceGrpc.getIteratorMethod = getIteratorMethod = 
              io.grpc.MethodDescriptor.<seedbag.IteratorRequest, seedbag.IteratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Iterator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.IteratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.IteratorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Iterator"))
                  .build();
          }
        }
     }
     return getIteratorMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getToArrayMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.ToArrayRequest,
      seedbag.ToArrayResponse> METHOD_TO_ARRAY = getToArrayMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.ToArrayRequest,
      seedbag.ToArrayResponse> getToArrayMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.ToArrayRequest,
      seedbag.ToArrayResponse> getToArrayMethod() {
    return getToArrayMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.ToArrayRequest,
      seedbag.ToArrayResponse> getToArrayMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.ToArrayRequest, seedbag.ToArrayResponse> getToArrayMethod;
    if ((getToArrayMethod = SeedBagServiceGrpc.getToArrayMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getToArrayMethod = SeedBagServiceGrpc.getToArrayMethod) == null) {
          SeedBagServiceGrpc.getToArrayMethod = getToArrayMethod = 
              io.grpc.MethodDescriptor.<seedbag.ToArrayRequest, seedbag.ToArrayResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "ToArray"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ToArrayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ToArrayResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("ToArray"))
                  .build();
          }
        }
     }
     return getToArrayMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.AddRequest,
      seedbag.AddResponse> METHOD_ADD = getAddMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.AddRequest,
      seedbag.AddResponse> getAddMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.AddRequest,
      seedbag.AddResponse> getAddMethod() {
    return getAddMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.AddRequest,
      seedbag.AddResponse> getAddMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.AddRequest, seedbag.AddResponse> getAddMethod;
    if ((getAddMethod = SeedBagServiceGrpc.getAddMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getAddMethod = SeedBagServiceGrpc.getAddMethod) == null) {
          SeedBagServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<seedbag.AddRequest, seedbag.AddResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.AddResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.RemoveRequest,
      seedbag.RemoveResponse> METHOD_REMOVE = getRemoveMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.RemoveRequest,
      seedbag.RemoveResponse> getRemoveMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.RemoveRequest,
      seedbag.RemoveResponse> getRemoveMethod() {
    return getRemoveMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.RemoveRequest,
      seedbag.RemoveResponse> getRemoveMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.RemoveRequest, seedbag.RemoveResponse> getRemoveMethod;
    if ((getRemoveMethod = SeedBagServiceGrpc.getRemoveMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getRemoveMethod = SeedBagServiceGrpc.getRemoveMethod) == null) {
          SeedBagServiceGrpc.getRemoveMethod = getRemoveMethod = 
              io.grpc.MethodDescriptor.<seedbag.RemoveRequest, seedbag.RemoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Remove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RemoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RemoveResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Remove"))
                  .build();
          }
        }
     }
     return getRemoveMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getContainsAllMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.ContainsAllRequest,
      seedbag.ContainsAllResponse> METHOD_CONTAINS_ALL = getContainsAllMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.ContainsAllRequest,
      seedbag.ContainsAllResponse> getContainsAllMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.ContainsAllRequest,
      seedbag.ContainsAllResponse> getContainsAllMethod() {
    return getContainsAllMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.ContainsAllRequest,
      seedbag.ContainsAllResponse> getContainsAllMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.ContainsAllRequest, seedbag.ContainsAllResponse> getContainsAllMethod;
    if ((getContainsAllMethod = SeedBagServiceGrpc.getContainsAllMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getContainsAllMethod = SeedBagServiceGrpc.getContainsAllMethod) == null) {
          SeedBagServiceGrpc.getContainsAllMethod = getContainsAllMethod = 
              io.grpc.MethodDescriptor.<seedbag.ContainsAllRequest, seedbag.ContainsAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "ContainsAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ContainsAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ContainsAllResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("ContainsAll"))
                  .build();
          }
        }
     }
     return getContainsAllMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddAllMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.AddAllRequest,
      seedbag.AddAllResponse> METHOD_ADD_ALL = getAddAllMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.AddAllRequest,
      seedbag.AddAllResponse> getAddAllMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.AddAllRequest,
      seedbag.AddAllResponse> getAddAllMethod() {
    return getAddAllMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.AddAllRequest,
      seedbag.AddAllResponse> getAddAllMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.AddAllRequest, seedbag.AddAllResponse> getAddAllMethod;
    if ((getAddAllMethod = SeedBagServiceGrpc.getAddAllMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getAddAllMethod = SeedBagServiceGrpc.getAddAllMethod) == null) {
          SeedBagServiceGrpc.getAddAllMethod = getAddAllMethod = 
              io.grpc.MethodDescriptor.<seedbag.AddAllRequest, seedbag.AddAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "AddAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.AddAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.AddAllResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("AddAll"))
                  .build();
          }
        }
     }
     return getAddAllMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRetainAllMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.RetainAllRequest,
      seedbag.RetainAllResponse> METHOD_RETAIN_ALL = getRetainAllMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.RetainAllRequest,
      seedbag.RetainAllResponse> getRetainAllMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.RetainAllRequest,
      seedbag.RetainAllResponse> getRetainAllMethod() {
    return getRetainAllMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.RetainAllRequest,
      seedbag.RetainAllResponse> getRetainAllMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.RetainAllRequest, seedbag.RetainAllResponse> getRetainAllMethod;
    if ((getRetainAllMethod = SeedBagServiceGrpc.getRetainAllMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getRetainAllMethod = SeedBagServiceGrpc.getRetainAllMethod) == null) {
          SeedBagServiceGrpc.getRetainAllMethod = getRetainAllMethod = 
              io.grpc.MethodDescriptor.<seedbag.RetainAllRequest, seedbag.RetainAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "RetainAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RetainAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RetainAllResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("RetainAll"))
                  .build();
          }
        }
     }
     return getRetainAllMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveAllMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.RemoveAllRequest,
      seedbag.RemoveAllResponse> METHOD_REMOVE_ALL = getRemoveAllMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.RemoveAllRequest,
      seedbag.RemoveAllResponse> getRemoveAllMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.RemoveAllRequest,
      seedbag.RemoveAllResponse> getRemoveAllMethod() {
    return getRemoveAllMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.RemoveAllRequest,
      seedbag.RemoveAllResponse> getRemoveAllMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.RemoveAllRequest, seedbag.RemoveAllResponse> getRemoveAllMethod;
    if ((getRemoveAllMethod = SeedBagServiceGrpc.getRemoveAllMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getRemoveAllMethod = SeedBagServiceGrpc.getRemoveAllMethod) == null) {
          SeedBagServiceGrpc.getRemoveAllMethod = getRemoveAllMethod = 
              io.grpc.MethodDescriptor.<seedbag.RemoveAllRequest, seedbag.RemoveAllResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "RemoveAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RemoveAllRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RemoveAllResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("RemoveAll"))
                  .build();
          }
        }
     }
     return getRemoveAllMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getClearMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.ClearRequest,
      seedbag.ClearResponse> METHOD_CLEAR = getClearMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.ClearRequest,
      seedbag.ClearResponse> getClearMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.ClearRequest,
      seedbag.ClearResponse> getClearMethod() {
    return getClearMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.ClearRequest,
      seedbag.ClearResponse> getClearMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.ClearRequest, seedbag.ClearResponse> getClearMethod;
    if ((getClearMethod = SeedBagServiceGrpc.getClearMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getClearMethod = SeedBagServiceGrpc.getClearMethod) == null) {
          SeedBagServiceGrpc.getClearMethod = getClearMethod = 
              io.grpc.MethodDescriptor.<seedbag.ClearRequest, seedbag.ClearResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Clear"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ClearRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ClearResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Clear"))
                  .build();
          }
        }
     }
     return getClearMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOfferMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.OfferRequest,
      seedbag.OfferResponse> METHOD_OFFER = getOfferMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.OfferRequest,
      seedbag.OfferResponse> getOfferMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.OfferRequest,
      seedbag.OfferResponse> getOfferMethod() {
    return getOfferMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.OfferRequest,
      seedbag.OfferResponse> getOfferMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.OfferRequest, seedbag.OfferResponse> getOfferMethod;
    if ((getOfferMethod = SeedBagServiceGrpc.getOfferMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getOfferMethod = SeedBagServiceGrpc.getOfferMethod) == null) {
          SeedBagServiceGrpc.getOfferMethod = getOfferMethod = 
              io.grpc.MethodDescriptor.<seedbag.OfferRequest, seedbag.OfferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Offer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.OfferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.OfferResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Offer"))
                  .build();
          }
        }
     }
     return getOfferMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveNoArgsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.RemoveNoArgsRequest,
      seedbag.RemoveNoArgsResponse> METHOD_REMOVE_NO_ARGS = getRemoveNoArgsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.RemoveNoArgsRequest,
      seedbag.RemoveNoArgsResponse> getRemoveNoArgsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.RemoveNoArgsRequest,
      seedbag.RemoveNoArgsResponse> getRemoveNoArgsMethod() {
    return getRemoveNoArgsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.RemoveNoArgsRequest,
      seedbag.RemoveNoArgsResponse> getRemoveNoArgsMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.RemoveNoArgsRequest, seedbag.RemoveNoArgsResponse> getRemoveNoArgsMethod;
    if ((getRemoveNoArgsMethod = SeedBagServiceGrpc.getRemoveNoArgsMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getRemoveNoArgsMethod = SeedBagServiceGrpc.getRemoveNoArgsMethod) == null) {
          SeedBagServiceGrpc.getRemoveNoArgsMethod = getRemoveNoArgsMethod = 
              io.grpc.MethodDescriptor.<seedbag.RemoveNoArgsRequest, seedbag.RemoveNoArgsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "RemoveNoArgs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RemoveNoArgsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.RemoveNoArgsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("RemoveNoArgs"))
                  .build();
          }
        }
     }
     return getRemoveNoArgsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPollMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.PollRequest,
      seedbag.PollResponse> METHOD_POLL = getPollMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.PollRequest,
      seedbag.PollResponse> getPollMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.PollRequest,
      seedbag.PollResponse> getPollMethod() {
    return getPollMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.PollRequest,
      seedbag.PollResponse> getPollMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.PollRequest, seedbag.PollResponse> getPollMethod;
    if ((getPollMethod = SeedBagServiceGrpc.getPollMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getPollMethod = SeedBagServiceGrpc.getPollMethod) == null) {
          SeedBagServiceGrpc.getPollMethod = getPollMethod = 
              io.grpc.MethodDescriptor.<seedbag.PollRequest, seedbag.PollResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Poll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.PollRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.PollResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Poll"))
                  .build();
          }
        }
     }
     return getPollMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getElementMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.ElementRequest,
      seedbag.ElementResponse> METHOD_ELEMENT = getElementMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.ElementRequest,
      seedbag.ElementResponse> getElementMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.ElementRequest,
      seedbag.ElementResponse> getElementMethod() {
    return getElementMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.ElementRequest,
      seedbag.ElementResponse> getElementMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.ElementRequest, seedbag.ElementResponse> getElementMethod;
    if ((getElementMethod = SeedBagServiceGrpc.getElementMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getElementMethod = SeedBagServiceGrpc.getElementMethod) == null) {
          SeedBagServiceGrpc.getElementMethod = getElementMethod = 
              io.grpc.MethodDescriptor.<seedbag.ElementRequest, seedbag.ElementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Element"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ElementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.ElementResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Element"))
                  .build();
          }
        }
     }
     return getElementMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPeekMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.PeekRequest,
      seedbag.PeekResponse> METHOD_PEEK = getPeekMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.PeekRequest,
      seedbag.PeekResponse> getPeekMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.PeekRequest,
      seedbag.PeekResponse> getPeekMethod() {
    return getPeekMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.PeekRequest,
      seedbag.PeekResponse> getPeekMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.PeekRequest, seedbag.PeekResponse> getPeekMethod;
    if ((getPeekMethod = SeedBagServiceGrpc.getPeekMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getPeekMethod = SeedBagServiceGrpc.getPeekMethod) == null) {
          SeedBagServiceGrpc.getPeekMethod = getPeekMethod = 
              io.grpc.MethodDescriptor.<seedbag.PeekRequest, seedbag.PeekResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "Peek"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.PeekRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.PeekResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("Peek"))
                  .build();
          }
        }
     }
     return getPeekMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTakeNMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.TakeNRequest,
      seedbag.TakeNResponse> METHOD_TAKE_N = getTakeNMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.TakeNRequest,
      seedbag.TakeNResponse> getTakeNMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.TakeNRequest,
      seedbag.TakeNResponse> getTakeNMethod() {
    return getTakeNMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.TakeNRequest,
      seedbag.TakeNResponse> getTakeNMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.TakeNRequest, seedbag.TakeNResponse> getTakeNMethod;
    if ((getTakeNMethod = SeedBagServiceGrpc.getTakeNMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getTakeNMethod = SeedBagServiceGrpc.getTakeNMethod) == null) {
          SeedBagServiceGrpc.getTakeNMethod = getTakeNMethod = 
              io.grpc.MethodDescriptor.<seedbag.TakeNRequest, seedbag.TakeNResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "TakeN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.TakeNRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.TakeNResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("TakeN"))
                  .build();
          }
        }
     }
     return getTakeNMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPollNMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.PollNRequest,
      seedbag.PollNResponse> METHOD_POLL_N = getPollNMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.PollNRequest,
      seedbag.PollNResponse> getPollNMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.PollNRequest,
      seedbag.PollNResponse> getPollNMethod() {
    return getPollNMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.PollNRequest,
      seedbag.PollNResponse> getPollNMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.PollNRequest, seedbag.PollNResponse> getPollNMethod;
    if ((getPollNMethod = SeedBagServiceGrpc.getPollNMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getPollNMethod = SeedBagServiceGrpc.getPollNMethod) == null) {
          SeedBagServiceGrpc.getPollNMethod = getPollNMethod = 
              io.grpc.MethodDescriptor.<seedbag.PollNRequest, seedbag.PollNResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "PollN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.PollNRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.PollNResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("PollN"))
                  .build();
          }
        }
     }
     return getPollNMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddNMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.AddNRequest,
      seedbag.AddNResponse> METHOD_ADD_N = getAddNMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.AddNRequest,
      seedbag.AddNResponse> getAddNMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.AddNRequest,
      seedbag.AddNResponse> getAddNMethod() {
    return getAddNMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.AddNRequest,
      seedbag.AddNResponse> getAddNMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.AddNRequest, seedbag.AddNResponse> getAddNMethod;
    if ((getAddNMethod = SeedBagServiceGrpc.getAddNMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getAddNMethod = SeedBagServiceGrpc.getAddNMethod) == null) {
          SeedBagServiceGrpc.getAddNMethod = getAddNMethod = 
              io.grpc.MethodDescriptor.<seedbag.AddNRequest, seedbag.AddNResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "AddN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.AddNRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.AddNResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("AddN"))
                  .build();
          }
        }
     }
     return getAddNMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOfferOrPutBlockingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<seedbag.OfferOrPutBlockingRequest,
      seedbag.OfferOrPutBlockingResponse> METHOD_OFFER_OR_PUT_BLOCKING = getOfferOrPutBlockingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<seedbag.OfferOrPutBlockingRequest,
      seedbag.OfferOrPutBlockingResponse> getOfferOrPutBlockingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<seedbag.OfferOrPutBlockingRequest,
      seedbag.OfferOrPutBlockingResponse> getOfferOrPutBlockingMethod() {
    return getOfferOrPutBlockingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<seedbag.OfferOrPutBlockingRequest,
      seedbag.OfferOrPutBlockingResponse> getOfferOrPutBlockingMethodHelper() {
    io.grpc.MethodDescriptor<seedbag.OfferOrPutBlockingRequest, seedbag.OfferOrPutBlockingResponse> getOfferOrPutBlockingMethod;
    if ((getOfferOrPutBlockingMethod = SeedBagServiceGrpc.getOfferOrPutBlockingMethod) == null) {
      synchronized (SeedBagServiceGrpc.class) {
        if ((getOfferOrPutBlockingMethod = SeedBagServiceGrpc.getOfferOrPutBlockingMethod) == null) {
          SeedBagServiceGrpc.getOfferOrPutBlockingMethod = getOfferOrPutBlockingMethod = 
              io.grpc.MethodDescriptor.<seedbag.OfferOrPutBlockingRequest, seedbag.OfferOrPutBlockingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "seedbag.SeedBagService", "OfferOrPutBlocking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.OfferOrPutBlockingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  seedbag.OfferOrPutBlockingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SeedBagServiceMethodDescriptorSupplier("OfferOrPutBlocking"))
                  .build();
          }
        }
     }
     return getOfferOrPutBlockingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeedBagServiceStub newStub(io.grpc.Channel channel) {
    return new SeedBagServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeedBagServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SeedBagServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeedBagServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SeedBagServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SeedBagServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void size(seedbag.SizeRequest request,
        io.grpc.stub.StreamObserver<seedbag.SizeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSizeMethodHelper(), responseObserver);
    }

    /**
     */
    public void isEmpty(seedbag.IsEmptyRequest request,
        io.grpc.stub.StreamObserver<seedbag.IsEmptyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIsEmptyMethodHelper(), responseObserver);
    }

    /**
     */
    public void contains(seedbag.ContainsRequest request,
        io.grpc.stub.StreamObserver<seedbag.ContainsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContainsMethodHelper(), responseObserver);
    }

    /**
     */
    public void iterator(seedbag.IteratorRequest request,
        io.grpc.stub.StreamObserver<seedbag.IteratorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIteratorMethodHelper(), responseObserver);
    }

    /**
     */
    public void toArray(seedbag.ToArrayRequest request,
        io.grpc.stub.StreamObserver<seedbag.ToArrayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getToArrayMethodHelper(), responseObserver);
    }

    /**
     */
    public void add(seedbag.AddRequest request,
        io.grpc.stub.StreamObserver<seedbag.AddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethodHelper(), responseObserver);
    }

    /**
     */
    public void remove(seedbag.RemoveRequest request,
        io.grpc.stub.StreamObserver<seedbag.RemoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveMethodHelper(), responseObserver);
    }

    /**
     */
    public void containsAll(seedbag.ContainsAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.ContainsAllResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContainsAllMethodHelper(), responseObserver);
    }

    /**
     */
    public void addAll(seedbag.AddAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.AddAllResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddAllMethodHelper(), responseObserver);
    }

    /**
     */
    public void retainAll(seedbag.RetainAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.RetainAllResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRetainAllMethodHelper(), responseObserver);
    }

    /**
     */
    public void removeAll(seedbag.RemoveAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.RemoveAllResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveAllMethodHelper(), responseObserver);
    }

    /**
     */
    public void clear(seedbag.ClearRequest request,
        io.grpc.stub.StreamObserver<seedbag.ClearResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getClearMethodHelper(), responseObserver);
    }

    /**
     */
    public void offer(seedbag.OfferRequest request,
        io.grpc.stub.StreamObserver<seedbag.OfferResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOfferMethodHelper(), responseObserver);
    }

    /**
     */
    public void removeNoArgs(seedbag.RemoveNoArgsRequest request,
        io.grpc.stub.StreamObserver<seedbag.RemoveNoArgsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveNoArgsMethodHelper(), responseObserver);
    }

    /**
     */
    public void poll(seedbag.PollRequest request,
        io.grpc.stub.StreamObserver<seedbag.PollResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPollMethodHelper(), responseObserver);
    }

    /**
     */
    public void element(seedbag.ElementRequest request,
        io.grpc.stub.StreamObserver<seedbag.ElementResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getElementMethodHelper(), responseObserver);
    }

    /**
     */
    public void peek(seedbag.PeekRequest request,
        io.grpc.stub.StreamObserver<seedbag.PeekResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPeekMethodHelper(), responseObserver);
    }

    /**
     */
    public void takeN(seedbag.TakeNRequest request,
        io.grpc.stub.StreamObserver<seedbag.TakeNResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTakeNMethodHelper(), responseObserver);
    }

    /**
     */
    public void pollN(seedbag.PollNRequest request,
        io.grpc.stub.StreamObserver<seedbag.PollNResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPollNMethodHelper(), responseObserver);
    }

    /**
     */
    public void addN(seedbag.AddNRequest request,
        io.grpc.stub.StreamObserver<seedbag.AddNResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddNMethodHelper(), responseObserver);
    }

    /**
     */
    public void offerOrPutBlocking(seedbag.OfferOrPutBlockingRequest request,
        io.grpc.stub.StreamObserver<seedbag.OfferOrPutBlockingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOfferOrPutBlockingMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSizeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.SizeRequest,
                seedbag.SizeResponse>(
                  this, METHODID_SIZE)))
          .addMethod(
            getIsEmptyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.IsEmptyRequest,
                seedbag.IsEmptyResponse>(
                  this, METHODID_IS_EMPTY)))
          .addMethod(
            getContainsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.ContainsRequest,
                seedbag.ContainsResponse>(
                  this, METHODID_CONTAINS)))
          .addMethod(
            getIteratorMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.IteratorRequest,
                seedbag.IteratorResponse>(
                  this, METHODID_ITERATOR)))
          .addMethod(
            getToArrayMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.ToArrayRequest,
                seedbag.ToArrayResponse>(
                  this, METHODID_TO_ARRAY)))
          .addMethod(
            getAddMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.AddRequest,
                seedbag.AddResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getRemoveMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.RemoveRequest,
                seedbag.RemoveResponse>(
                  this, METHODID_REMOVE)))
          .addMethod(
            getContainsAllMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.ContainsAllRequest,
                seedbag.ContainsAllResponse>(
                  this, METHODID_CONTAINS_ALL)))
          .addMethod(
            getAddAllMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.AddAllRequest,
                seedbag.AddAllResponse>(
                  this, METHODID_ADD_ALL)))
          .addMethod(
            getRetainAllMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.RetainAllRequest,
                seedbag.RetainAllResponse>(
                  this, METHODID_RETAIN_ALL)))
          .addMethod(
            getRemoveAllMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.RemoveAllRequest,
                seedbag.RemoveAllResponse>(
                  this, METHODID_REMOVE_ALL)))
          .addMethod(
            getClearMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.ClearRequest,
                seedbag.ClearResponse>(
                  this, METHODID_CLEAR)))
          .addMethod(
            getOfferMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.OfferRequest,
                seedbag.OfferResponse>(
                  this, METHODID_OFFER)))
          .addMethod(
            getRemoveNoArgsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.RemoveNoArgsRequest,
                seedbag.RemoveNoArgsResponse>(
                  this, METHODID_REMOVE_NO_ARGS)))
          .addMethod(
            getPollMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.PollRequest,
                seedbag.PollResponse>(
                  this, METHODID_POLL)))
          .addMethod(
            getElementMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.ElementRequest,
                seedbag.ElementResponse>(
                  this, METHODID_ELEMENT)))
          .addMethod(
            getPeekMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.PeekRequest,
                seedbag.PeekResponse>(
                  this, METHODID_PEEK)))
          .addMethod(
            getTakeNMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.TakeNRequest,
                seedbag.TakeNResponse>(
                  this, METHODID_TAKE_N)))
          .addMethod(
            getPollNMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.PollNRequest,
                seedbag.PollNResponse>(
                  this, METHODID_POLL_N)))
          .addMethod(
            getAddNMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.AddNRequest,
                seedbag.AddNResponse>(
                  this, METHODID_ADD_N)))
          .addMethod(
            getOfferOrPutBlockingMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                seedbag.OfferOrPutBlockingRequest,
                seedbag.OfferOrPutBlockingResponse>(
                  this, METHODID_OFFER_OR_PUT_BLOCKING)))
          .build();
    }
  }

  /**
   */
  public static final class SeedBagServiceStub extends io.grpc.stub.AbstractStub<SeedBagServiceStub> {
    private SeedBagServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SeedBagServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeedBagServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SeedBagServiceStub(channel, callOptions);
    }

    /**
     */
    public void size(seedbag.SizeRequest request,
        io.grpc.stub.StreamObserver<seedbag.SizeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSizeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isEmpty(seedbag.IsEmptyRequest request,
        io.grpc.stub.StreamObserver<seedbag.IsEmptyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsEmptyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void contains(seedbag.ContainsRequest request,
        io.grpc.stub.StreamObserver<seedbag.ContainsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContainsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void iterator(seedbag.IteratorRequest request,
        io.grpc.stub.StreamObserver<seedbag.IteratorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIteratorMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void toArray(seedbag.ToArrayRequest request,
        io.grpc.stub.StreamObserver<seedbag.ToArrayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToArrayMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void add(seedbag.AddRequest request,
        io.grpc.stub.StreamObserver<seedbag.AddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void remove(seedbag.RemoveRequest request,
        io.grpc.stub.StreamObserver<seedbag.RemoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void containsAll(seedbag.ContainsAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.ContainsAllResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContainsAllMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addAll(seedbag.AddAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.AddAllResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddAllMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void retainAll(seedbag.RetainAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.RetainAllResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRetainAllMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeAll(seedbag.RemoveAllRequest request,
        io.grpc.stub.StreamObserver<seedbag.RemoveAllResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveAllMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clear(seedbag.ClearRequest request,
        io.grpc.stub.StreamObserver<seedbag.ClearResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClearMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void offer(seedbag.OfferRequest request,
        io.grpc.stub.StreamObserver<seedbag.OfferResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOfferMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeNoArgs(seedbag.RemoveNoArgsRequest request,
        io.grpc.stub.StreamObserver<seedbag.RemoveNoArgsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveNoArgsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void poll(seedbag.PollRequest request,
        io.grpc.stub.StreamObserver<seedbag.PollResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPollMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void element(seedbag.ElementRequest request,
        io.grpc.stub.StreamObserver<seedbag.ElementResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getElementMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void peek(seedbag.PeekRequest request,
        io.grpc.stub.StreamObserver<seedbag.PeekResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPeekMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void takeN(seedbag.TakeNRequest request,
        io.grpc.stub.StreamObserver<seedbag.TakeNResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTakeNMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pollN(seedbag.PollNRequest request,
        io.grpc.stub.StreamObserver<seedbag.PollNResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPollNMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addN(seedbag.AddNRequest request,
        io.grpc.stub.StreamObserver<seedbag.AddNResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddNMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void offerOrPutBlocking(seedbag.OfferOrPutBlockingRequest request,
        io.grpc.stub.StreamObserver<seedbag.OfferOrPutBlockingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOfferOrPutBlockingMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SeedBagServiceBlockingStub extends io.grpc.stub.AbstractStub<SeedBagServiceBlockingStub> {
    private SeedBagServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SeedBagServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeedBagServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SeedBagServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public seedbag.SizeResponse size(seedbag.SizeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSizeMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.IsEmptyResponse isEmpty(seedbag.IsEmptyRequest request) {
      return blockingUnaryCall(
          getChannel(), getIsEmptyMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.ContainsResponse contains(seedbag.ContainsRequest request) {
      return blockingUnaryCall(
          getChannel(), getContainsMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.IteratorResponse iterator(seedbag.IteratorRequest request) {
      return blockingUnaryCall(
          getChannel(), getIteratorMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.ToArrayResponse toArray(seedbag.ToArrayRequest request) {
      return blockingUnaryCall(
          getChannel(), getToArrayMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.AddResponse add(seedbag.AddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.RemoveResponse remove(seedbag.RemoveRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.ContainsAllResponse containsAll(seedbag.ContainsAllRequest request) {
      return blockingUnaryCall(
          getChannel(), getContainsAllMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.AddAllResponse addAll(seedbag.AddAllRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddAllMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.RetainAllResponse retainAll(seedbag.RetainAllRequest request) {
      return blockingUnaryCall(
          getChannel(), getRetainAllMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.RemoveAllResponse removeAll(seedbag.RemoveAllRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveAllMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.ClearResponse clear(seedbag.ClearRequest request) {
      return blockingUnaryCall(
          getChannel(), getClearMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.OfferResponse offer(seedbag.OfferRequest request) {
      return blockingUnaryCall(
          getChannel(), getOfferMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.RemoveNoArgsResponse removeNoArgs(seedbag.RemoveNoArgsRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveNoArgsMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.PollResponse poll(seedbag.PollRequest request) {
      return blockingUnaryCall(
          getChannel(), getPollMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.ElementResponse element(seedbag.ElementRequest request) {
      return blockingUnaryCall(
          getChannel(), getElementMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.PeekResponse peek(seedbag.PeekRequest request) {
      return blockingUnaryCall(
          getChannel(), getPeekMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.TakeNResponse takeN(seedbag.TakeNRequest request) {
      return blockingUnaryCall(
          getChannel(), getTakeNMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.PollNResponse pollN(seedbag.PollNRequest request) {
      return blockingUnaryCall(
          getChannel(), getPollNMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.AddNResponse addN(seedbag.AddNRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddNMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public seedbag.OfferOrPutBlockingResponse offerOrPutBlocking(seedbag.OfferOrPutBlockingRequest request) {
      return blockingUnaryCall(
          getChannel(), getOfferOrPutBlockingMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SeedBagServiceFutureStub extends io.grpc.stub.AbstractStub<SeedBagServiceFutureStub> {
    private SeedBagServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SeedBagServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeedBagServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SeedBagServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.SizeResponse> size(
        seedbag.SizeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSizeMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.IsEmptyResponse> isEmpty(
        seedbag.IsEmptyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIsEmptyMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.ContainsResponse> contains(
        seedbag.ContainsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getContainsMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.IteratorResponse> iterator(
        seedbag.IteratorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIteratorMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.ToArrayResponse> toArray(
        seedbag.ToArrayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getToArrayMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.AddResponse> add(
        seedbag.AddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.RemoveResponse> remove(
        seedbag.RemoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.ContainsAllResponse> containsAll(
        seedbag.ContainsAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getContainsAllMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.AddAllResponse> addAll(
        seedbag.AddAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddAllMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.RetainAllResponse> retainAll(
        seedbag.RetainAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRetainAllMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.RemoveAllResponse> removeAll(
        seedbag.RemoveAllRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveAllMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.ClearResponse> clear(
        seedbag.ClearRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClearMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.OfferResponse> offer(
        seedbag.OfferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOfferMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.RemoveNoArgsResponse> removeNoArgs(
        seedbag.RemoveNoArgsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveNoArgsMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.PollResponse> poll(
        seedbag.PollRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPollMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.ElementResponse> element(
        seedbag.ElementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getElementMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.PeekResponse> peek(
        seedbag.PeekRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPeekMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.TakeNResponse> takeN(
        seedbag.TakeNRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTakeNMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.PollNResponse> pollN(
        seedbag.PollNRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPollNMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.AddNResponse> addN(
        seedbag.AddNRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddNMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<seedbag.OfferOrPutBlockingResponse> offerOrPutBlocking(
        seedbag.OfferOrPutBlockingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOfferOrPutBlockingMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIZE = 0;
  private static final int METHODID_IS_EMPTY = 1;
  private static final int METHODID_CONTAINS = 2;
  private static final int METHODID_ITERATOR = 3;
  private static final int METHODID_TO_ARRAY = 4;
  private static final int METHODID_ADD = 5;
  private static final int METHODID_REMOVE = 6;
  private static final int METHODID_CONTAINS_ALL = 7;
  private static final int METHODID_ADD_ALL = 8;
  private static final int METHODID_RETAIN_ALL = 9;
  private static final int METHODID_REMOVE_ALL = 10;
  private static final int METHODID_CLEAR = 11;
  private static final int METHODID_OFFER = 12;
  private static final int METHODID_REMOVE_NO_ARGS = 13;
  private static final int METHODID_POLL = 14;
  private static final int METHODID_ELEMENT = 15;
  private static final int METHODID_PEEK = 16;
  private static final int METHODID_TAKE_N = 17;
  private static final int METHODID_POLL_N = 18;
  private static final int METHODID_ADD_N = 19;
  private static final int METHODID_OFFER_OR_PUT_BLOCKING = 20;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SeedBagServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SeedBagServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIZE:
          serviceImpl.size((seedbag.SizeRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.SizeResponse>) responseObserver);
          break;
        case METHODID_IS_EMPTY:
          serviceImpl.isEmpty((seedbag.IsEmptyRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.IsEmptyResponse>) responseObserver);
          break;
        case METHODID_CONTAINS:
          serviceImpl.contains((seedbag.ContainsRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.ContainsResponse>) responseObserver);
          break;
        case METHODID_ITERATOR:
          serviceImpl.iterator((seedbag.IteratorRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.IteratorResponse>) responseObserver);
          break;
        case METHODID_TO_ARRAY:
          serviceImpl.toArray((seedbag.ToArrayRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.ToArrayResponse>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((seedbag.AddRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.AddResponse>) responseObserver);
          break;
        case METHODID_REMOVE:
          serviceImpl.remove((seedbag.RemoveRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.RemoveResponse>) responseObserver);
          break;
        case METHODID_CONTAINS_ALL:
          serviceImpl.containsAll((seedbag.ContainsAllRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.ContainsAllResponse>) responseObserver);
          break;
        case METHODID_ADD_ALL:
          serviceImpl.addAll((seedbag.AddAllRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.AddAllResponse>) responseObserver);
          break;
        case METHODID_RETAIN_ALL:
          serviceImpl.retainAll((seedbag.RetainAllRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.RetainAllResponse>) responseObserver);
          break;
        case METHODID_REMOVE_ALL:
          serviceImpl.removeAll((seedbag.RemoveAllRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.RemoveAllResponse>) responseObserver);
          break;
        case METHODID_CLEAR:
          serviceImpl.clear((seedbag.ClearRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.ClearResponse>) responseObserver);
          break;
        case METHODID_OFFER:
          serviceImpl.offer((seedbag.OfferRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.OfferResponse>) responseObserver);
          break;
        case METHODID_REMOVE_NO_ARGS:
          serviceImpl.removeNoArgs((seedbag.RemoveNoArgsRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.RemoveNoArgsResponse>) responseObserver);
          break;
        case METHODID_POLL:
          serviceImpl.poll((seedbag.PollRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.PollResponse>) responseObserver);
          break;
        case METHODID_ELEMENT:
          serviceImpl.element((seedbag.ElementRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.ElementResponse>) responseObserver);
          break;
        case METHODID_PEEK:
          serviceImpl.peek((seedbag.PeekRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.PeekResponse>) responseObserver);
          break;
        case METHODID_TAKE_N:
          serviceImpl.takeN((seedbag.TakeNRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.TakeNResponse>) responseObserver);
          break;
        case METHODID_POLL_N:
          serviceImpl.pollN((seedbag.PollNRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.PollNResponse>) responseObserver);
          break;
        case METHODID_ADD_N:
          serviceImpl.addN((seedbag.AddNRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.AddNResponse>) responseObserver);
          break;
        case METHODID_OFFER_OR_PUT_BLOCKING:
          serviceImpl.offerOrPutBlocking((seedbag.OfferOrPutBlockingRequest) request,
              (io.grpc.stub.StreamObserver<seedbag.OfferOrPutBlockingResponse>) responseObserver);
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

  private static abstract class SeedBagServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeedBagServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return seedbag.CTrieProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeedBagService");
    }
  }

  private static final class SeedBagServiceFileDescriptorSupplier
      extends SeedBagServiceBaseDescriptorSupplier {
    SeedBagServiceFileDescriptorSupplier() {}
  }

  private static final class SeedBagServiceMethodDescriptorSupplier
      extends SeedBagServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeedBagServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeedBagServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeedBagServiceFileDescriptorSupplier())
              .addMethod(getSizeMethodHelper())
              .addMethod(getIsEmptyMethodHelper())
              .addMethod(getContainsMethodHelper())
              .addMethod(getIteratorMethodHelper())
              .addMethod(getToArrayMethodHelper())
              .addMethod(getAddMethodHelper())
              .addMethod(getRemoveMethodHelper())
              .addMethod(getContainsAllMethodHelper())
              .addMethod(getAddAllMethodHelper())
              .addMethod(getRetainAllMethodHelper())
              .addMethod(getRemoveAllMethodHelper())
              .addMethod(getClearMethodHelper())
              .addMethod(getOfferMethodHelper())
              .addMethod(getRemoveNoArgsMethodHelper())
              .addMethod(getPollMethodHelper())
              .addMethod(getElementMethodHelper())
              .addMethod(getPeekMethodHelper())
              .addMethod(getTakeNMethodHelper())
              .addMethod(getPollNMethodHelper())
              .addMethod(getAddNMethodHelper())
              .addMethod(getOfferOrPutBlockingMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
