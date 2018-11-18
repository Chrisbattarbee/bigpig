package Numbers;

import jwp.fuzz.ExecutionResult;
import jwp.fuzz.ParamGenerator;
import jwp.fuzz.ParamProvider;
import seedbag.CoordinatorSeedBag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class SeedbagParamProvider extends ParamProvider {

    CoordinatorSeedBag<HashMap<String,Integer>> seedBag;
    ParamProvider suggested;

    public SeedbagParamProvider(CoordinatorSeedBag<HashMap<String, Integer>> seedBag, ParamProvider suggested, ParamGenerator... paramGenerators) {
        super(paramGenerators);
        this.seedBag = seedBag;
        this.suggested = suggested;
    }

    @Override
    public Iterator<Object[]> iterator() {
        return new Iterator<Object[]>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Object[] next() {
                Object[] ret = new Integer[1];
                HashMap<String, Integer> hashMap = seedBag.poll();
                if (hashMap == null) {
                    ret[0] = new Random().nextInt();
                } else {
                    ret[0] = hashMap.get("s");
//                    System.out.println("Value: " + ret[0]);
                }

                if ((Integer) ret[0] == 153) {
                    System.out.println("here");
                }
                return ret;
            }
        };
    }

    @Override
    public void onResult(ExecutionResult result) {
        suggested.onResult(result);
    }
}
