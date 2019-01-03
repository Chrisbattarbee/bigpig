package Numbers;

import ctrie.CoordinatorCTrie;
import jwp.fuzz.BranchHit;
import jwp.fuzz.ExecutionResult;
import jwp.fuzz.ParamGenerator;
import jwp.fuzz.ParamProvider;
import seedbag.CoordinatorSeedBag;

import java.io.ObjectStreamClass;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ParamProviderSuggested extends ParamProvider.Suggested {

    public ParamProviderSuggested(Set<Integer> seenPathHashes, CoordinatorCTrie<String, Integer> cTrie, CoordinatorSeedBag<Object[]> seedBag, ParamGenerator... paramGenerators) {
        super(paramGenerators);
        this.seedBag = seedBag;
        this.seenPathHashes = seenPathHashes;
        this.cTrie = cTrie;

        Thread thread = new Thread(() -> {
            while (true) {
                if (next == null) {
                    next = seedBag.poll();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private Set<Integer> seenPathHashes;
    private CoordinatorSeedBag seedBag;
    private CoordinatorCTrie<String, Integer> cTrie;
    private Object[] next = null;

    @Override
    public void onResult(ExecutionResult res) {
        super.onResult(res);
        int hash = BranchHit.Hasher.WITHOUT_HIT_COUNTS.hash(res.branchHits);
        if (res.params[0] == null) {
            return;
        }

        cTrie.putAsync(res.pathString, cTrie.getOrDefault(res.pathString, 0) + 1);

        if (seenPathHashes.add(hash)) {
            System.out.printf("Unique path for param '%s': %s\n", res.params[0],
                    res.exception == null ? res.result : res.exception);
        }
    }

    @Override
    public Iterator<Object[]> iterator() {

        Iterator<Object[]> superIterator = super.iterator();

        return new Iterator<Object[]>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Object[] next() {
                while (true) {
                    if (next != null) {
                        Object[] obj = next;
                        next = null;
                        return obj;
                    }
                    if (superIterator.hasNext()) {
                        Object[] obj = superIterator.next();
                        return obj;
                    }
                }
            }
        };
    }
}
