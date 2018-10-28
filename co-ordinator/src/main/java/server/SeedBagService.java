package server;

import io.grpc.stub.StreamObserver;
import seedbag.*;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static utils.ByteStringManipulation.*;

public class SeedBagService extends SeedBagServiceGrpc.SeedBagServiceImplBase {

    private Queue<Object> queue;

    public SeedBagService() {
        queue = new ArrayDeque<>();
    }

    @Override
    public void size(SizeRequest request, StreamObserver<SizeResponse> responseObserver) {
        System.out.println(queue.size());
        responseObserver.onNext(SizeResponse.newBuilder().setSize(queue.size()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void isEmpty(IsEmptyRequest request, StreamObserver<IsEmptyResponse> responseObserver) {
        responseObserver.onNext(IsEmptyResponse.newBuilder().setIsEmpty(queue.isEmpty()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void contains(ContainsRequest request, StreamObserver<ContainsResponse> responseObserver) {
        responseObserver.onNext(ContainsResponse.newBuilder().setDoesContain(queue.contains(byteStringToObject(request.getSerializedObject()))).build());
        responseObserver.onCompleted();
    }

    @Override
    // TODO Implement this whenever I have the energy to think of an optimal solution
    public void iterator(IteratorRequest request, StreamObserver<IteratorResponse> responseObserver) {
        super.iterator(request, responseObserver);
    }

    @Override
    public void toArray(ToArrayRequest request, StreamObserver<ToArrayResponse> responseObserver) {
        responseObserver.onNext(ToArrayResponse.newBuilder().setSerializedArrayObject(objectToByteString(queue.toArray())).build());
        responseObserver.onCompleted();
    }

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        boolean result = queue.add(byteStringToObject(request.getSerializedObject()));

        responseObserver.onNext(AddResponse.newBuilder().setAdded(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void remove(RemoveRequest request, StreamObserver<RemoveResponse> responseObserver) {
        boolean result = queue.remove(byteStringToObject(request.getSerializedObject()));

        responseObserver.onNext(RemoveResponse.newBuilder().setRemoved(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void containsAll(ContainsAllRequest request, StreamObserver<ContainsAllResponse> responseObserver) {
        boolean result = queue.containsAll((Collection<?>) byteStringToObject(request.getSerializedCollection()));

        responseObserver.onNext(ContainsAllResponse.newBuilder().setContainsAll(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void addAll(AddAllRequest request, StreamObserver<AddAllResponse> responseObserver) {
        boolean result = queue.addAll((Collection<?>) byteStringToObject(request.getSerializedCollection()));

        responseObserver.onNext(AddAllResponse.newBuilder().setAllAdded(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void retainAll(RetainAllRequest request, StreamObserver<RetainAllResponse> responseObserver) {
        boolean result = queue.retainAll((Collection<?>) byteStringToObject(request.getSerializedCollection()));

        responseObserver.onNext(RetainAllResponse.newBuilder().setAllRetained(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeAll(RemoveAllRequest request, StreamObserver<RemoveAllResponse> responseObserver) {
        boolean result = queue.removeAll((Collection<?>) byteStringToObject(request.getSerializedCollection()));

        responseObserver.onNext(RemoveAllResponse.newBuilder().setAllRemoved(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void clear(ClearRequest request, StreamObserver<ClearResponse> responseObserver) {
        queue.clear();

        responseObserver.onNext(ClearResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void offer(OfferRequest request, StreamObserver<OfferResponse> responseObserver) {
        boolean result = queue.offer(byteStringToObject(request.getSerializedObject()));

        responseObserver.onNext(OfferResponse.newBuilder().setOffered(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeNoArgs(RemoveNoArgsRequest request, StreamObserver<RemoveNoArgsResponse> responseObserver) {
        Object o = queue.remove();

        responseObserver.onNext(RemoveNoArgsResponse.newBuilder().setSerializedObject(objectToByteString(o)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void poll(PollRequest request, StreamObserver<PollResponse> responseObserver) {
        Object o = queue.poll();

        responseObserver.onNext(PollResponse.newBuilder().setSerializedObject(objectToByteString(o)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void element(ElementRequest request, StreamObserver<ElementResponse> responseObserver) {
        Object o = queue.element();

        responseObserver.onNext(ElementResponse.newBuilder().setSerializedObject(objectToByteString(o)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void peek(PeekRequest request, StreamObserver<PeekResponse> responseObserver) {
        Object o = queue.peek();
        responseObserver.onNext(PeekResponse.newBuilder().setSerializedObject(objectToByteString(o)).build());
        responseObserver.onCompleted();
    }
}
