package seedbag;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public interface BatchedBlockingQueue<T> extends BlockingQueue<T> {
    T[] takeN(int n);
    T[] pollN(int n, long timeout, TimeUnit unit);
    void add(T[] items);
}
