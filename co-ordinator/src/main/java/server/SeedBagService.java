package server;

import io.grpc.stub.StreamObserver;
import seedbag.*;

public class SeedBagService extends SeedBagServiceGrpc.SeedBagServiceImplBase {
    @Override
    public void size(SizeRequest request, StreamObserver<SizeResponse> responseObserver) {
        super.size(request, responseObserver);
    }

    @Override
    public void isEmpty(IsEmptyRequest request, StreamObserver<IsEmptyResponse> responseObserver) {
        super.isEmpty(request, responseObserver);
    }

    @Override
    public void contains(ContainsRequest request, StreamObserver<ContainsResponse> responseObserver) {
        super.contains(request, responseObserver);
    }

    @Override
    public void iterator(IteratorRequest request, StreamObserver<IteratorResponse> responseObserver) {
        super.iterator(request, responseObserver);
    }

    @Override
    public void toArray(ToArrayRequest request, StreamObserver<ToArrayResponse> responseObserver) {
        super.toArray(request, responseObserver);
    }

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        super.add(request, responseObserver);
    }

    @Override
    public void remove(RemoveRequest request, StreamObserver<RemoveResponse> responseObserver) {
        super.remove(request, responseObserver);
    }

    @Override
    public void containsAll(ContainsAllRequest request, StreamObserver<ContainsAllResponse> responseObserver) {
        super.containsAll(request, responseObserver);
    }

    @Override
    public void addAll(AddAllRequest request, StreamObserver<AddAllResponse> responseObserver) {
        super.addAll(request, responseObserver);
    }

    @Override
    public void retainAll(RetainAllRequest request, StreamObserver<RetainAllResponse> responseObserver) {
        super.retainAll(request, responseObserver);
    }

    @Override
    public void removeAll(RemoveAllRequest request, StreamObserver<RemoveAllResponse> responseObserver) {
        super.removeAll(request, responseObserver);
    }

    @Override
    public void clear(ClearRequest request, StreamObserver<ClearResponse> responseObserver) {
        super.clear(request, responseObserver);
    }

    @Override
    public void offer(OfferRequest request, StreamObserver<OfferResponse> responseObserver) {
        super.offer(request, responseObserver);
    }

    @Override
    public void removeNoArgs(RemoveNoArgsRequest request, StreamObserver<RemoveNoArgsResponse> responseObserver) {
        super.removeNoArgs(request, responseObserver);
    }

    @Override
    public void poll(PollRequest request, StreamObserver<PollResponse> responseObserver) {
        super.poll(request, responseObserver);
    }

    @Override
    public void element(ElementRequest request, StreamObserver<ElementResponse> responseObserver) {
        super.element(request, responseObserver);
    }

    @Override
    public void peek(PeekRequest request, StreamObserver<PeekResponse> responseObserver) {
        super.peek(request, responseObserver);
    }
}
