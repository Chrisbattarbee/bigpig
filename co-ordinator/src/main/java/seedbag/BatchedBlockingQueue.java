package seedbag;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public interface BatchedBlockingQueue<T> extends BlockingQueue<T> {
    List<T> takeN(int n);
    List<T> pollN(int n, long timeout, TimeUnit unit);
}
