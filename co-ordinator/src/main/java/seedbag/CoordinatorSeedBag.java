package seedbag;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


import static utils.ByteStringManipulation.*;

public class CoordinatorSeedBag<E extends Serializable> implements Queue<E> {

    private final ManagedChannel channel;
    private final SeedBagServiceGrpc.SeedBagServiceBlockingStub blockingStub;

    public CoordinatorSeedBag() {
        this(ManagedChannelBuilder.forAddress(HOST_NAME, PORT_NUMBER).usePlaintext());
    }

    public CoordinatorSeedBag(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public CoordinatorSeedBag(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();

        blockingStub = SeedBagServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public int size() {
        SizeRequest sizeRequest = SizeRequest.newBuilder().build();
        return blockingStub.size(sizeRequest).getSerializedSize();
    }

    @Override
    public boolean isEmpty() {
        IsEmptyRequest isEmptyRequest = IsEmptyRequest.newBuilder().build();
        return blockingStub.isEmpty(isEmptyRequest).getIsEmpty();
    }

    @Override
    public boolean contains(Object o) {
        ContainsRequest containsRequest = ContainsRequest.newBuilder().setSerializedObject(objectToByteString(o)).build();
        return blockingStub.contains(containsRequest).getDoesContain();
    }

    @Override
    public Iterator<E> iterator() {
        IteratorRequest iteratorRequest = IteratorRequest.newBuilder().build();
        return (Iterator<E>) byteStringToObject(blockingStub.iterator(iteratorRequest).getSerializedIterator());
    }

    @Override
    public Object[] toArray() {
        ToArrayRequest toArrayRequest = ToArrayRequest.newBuilder().build();
        return (Object[]) byteStringToObject(blockingStub.toArray(toArrayRequest).getSerializedArrayObject());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) toArray();
    }

    @Override
    public boolean add(E e) {
        AddRequest addRequest = AddRequest.newBuilder().setSerializedObject(objectToByteString(e)).build();
        return blockingStub.add(addRequest).getAdded();
    }

    @Override
    public boolean remove(Object o) {
        RemoveRequest removeRequest = RemoveRequest.newBuilder().setSerializedObject(objectToByteString(o)).build();
        return blockingStub.remove(removeRequest).getRemoved();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        ContainsAllRequest containsAllRequest = ContainsAllRequest.newBuilder().setSerializedCollection(objectToByteString(c)).build();
        return blockingStub.containsAll(containsAllRequest).getContainsAll();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        AddAllRequest addAllRequest = AddAllRequest.newBuilder().setSerializedCollection(objectToByteString(c)).build();
        return blockingStub.addAll(addAllRequest).getAllAdded();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        RemoveAllRequest removeAllRequest = RemoveAllRequest.newBuilder().setSerializedCollection(objectToByteString(c)).build();
        return blockingStub.removeAll(removeAllRequest).getAllRemoved();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        RetainAllRequest retainAllRequest = RetainAllRequest.newBuilder().setSerializedCollection(objectToByteString(c)).build();
        return blockingStub.retainAll(retainAllRequest).getAllRetained();
    }

    @Override
    public void clear() {
        ClearRequest clearRequest = ClearRequest.newBuilder().build();
        blockingStub.clear(clearRequest);
    }

    @Override
    public boolean offer(E e) {
        OfferRequest offerRequest = OfferRequest.newBuilder().setSerializedObject(objectToByteString(e)).build();
        return blockingStub.offer(offerRequest).getOffered();
    }

    @Override
    public E remove() {
        RemoveNoArgsRequest removeRequest = RemoveNoArgsRequest.newBuilder().build();
        return (E) byteStringToObject(blockingStub.removeNoArgs(removeRequest).getSerializedObject());
    }

    @Override
    public E poll() {
        PollRequest pollRequest = PollRequest.newBuilder().build();
        return (E) byteStringToObject(blockingStub.poll(pollRequest).getSerializedObject());
    }

    @Override
    public E element() {
        ElementRequest elementRequest = ElementRequest.newBuilder().build();
        return (E) byteStringToObject(blockingStub.element(elementRequest).getSerializedObject());
    }

    @Override
    public E peek() {
        PeekRequest peekRequest = PeekRequest.newBuilder().build();
        return (E) byteStringToObject(blockingStub.peek(peekRequest).getSerializedObject());
    }
}
