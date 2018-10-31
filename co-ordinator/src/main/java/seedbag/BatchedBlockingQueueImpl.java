package seedbag;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

//TODO[gg]: Technically T should implement Serializable. Currently this is not the case because we are using Object as T
public class BatchedBlockingQueueImpl<T, U extends BlockingQueue<T>> implements BatchedBlockingQueue<T> {

    private U blockingQueue;

    public BatchedBlockingQueueImpl(U blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public U getUnderlyingStructure() {
        return blockingQueue;
    }

    @Override
    public List<T> takeN(int n) {
        List<T> results = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            try {
            results.add(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
                //TODO[gg]: log maybe
            }
        }
        return results;
    }

    @Override
    //Last returned element might be null if poll fails.
    public List<T> pollN(int n, long timeout, TimeUnit unit) {
        List<T> results = new ArrayList<>();
        long totalTime = 0;
        long nanoTimeout = TimeUnit.NANOSECONDS.convert(timeout, unit);
        for(int i = 0; i < n; i++) {
            long statTime = System.nanoTime();
            try {
                results.add(blockingQueue.poll(nanoTimeout - totalTime, TimeUnit.NANOSECONDS));
            } catch (InterruptedException e) {
               e.printStackTrace();
                //TODO[gg]: log maybe
            }
            totalTime += System.nanoTime() - statTime;
            if(totalTime > TimeUnit.NANOSECONDS.convert(timeout, unit)) {
                break;
            }
        }
        return results;
    }

    @Override
    public boolean add(T t) {
        return blockingQueue.add(t);
    }

    @Override
    public boolean offer(T t) {
        return blockingQueue.offer(t);
    }

    @Override
    public void put(T t) throws InterruptedException {
        blockingQueue.put(t);
    }

    @Override
    public boolean offer(T t, long l, TimeUnit timeUnit) throws InterruptedException {
        return blockingQueue.offer(t, l, timeUnit);
    }

    @Override
    public T take() throws InterruptedException {
        return blockingQueue.take();
    }

    @Override
    public T poll(long l, TimeUnit timeUnit) throws InterruptedException {
        return blockingQueue.poll(l, timeUnit);
    }

    //TODO[gg]: Implement
    @Override
    public int remainingCapacity() {
        return blockingQueue.remainingCapacity();
    }

    @Override
    public boolean remove(Object o) {
        return blockingQueue.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return blockingQueue.contains(o);
    }

    //TODO[gg]: Implement
    @Override
    public int drainTo(Collection<? super T> collection) {
        return blockingQueue.drainTo(collection);
    }

    //TODO[gg]: Implement
    @Override
    public int drainTo(Collection<? super T> collection, int i) {
        return blockingQueue.drainTo(collection, i);
    }

    @Override
    public T remove() {
        return blockingQueue.remove();
    }

    @Override
    public T poll() {
        return blockingQueue.poll();
    }

    @Override
    public T element() {
        return blockingQueue.element();
    }

    @Override
    public T peek() {
        return blockingQueue.peek();
    }

    @Override
    public int size() {
        return blockingQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return blockingQueue.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return blockingQueue.iterator();
    }

    @Override
    public Object[] toArray() {
        return blockingQueue.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return blockingQueue.toArray(t1s);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return blockingQueue.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return blockingQueue.addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return blockingQueue.removeAll(collection);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return blockingQueue.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return blockingQueue.retainAll(collection);
    }

    @Override
    public void clear() {
        blockingQueue.clear();
    }

    @Override
    public boolean equals(Object o) {
        return blockingQueue.equals(o);
    }

    @Override
    public int hashCode() {
        return blockingQueue.hashCode();
    }

    @Override
    public Spliterator<T> spliterator() {
        return blockingQueue.spliterator();
    }

    @Override
    public Stream<T> stream() {
        return blockingQueue.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return blockingQueue.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        blockingQueue.forEach(action);
    }


}
