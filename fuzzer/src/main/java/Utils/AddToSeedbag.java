package Utils;

import seedbag.CoordinatorSeedBag;

public class AddToSeedbag {
    public static void main(String[] args) throws InterruptedException {
        CoordinatorSeedBag<Object[]> seedBag = new CoordinatorSeedBag<>("localhost", 8080);
        //seedBag.add(new Object[]{12, 13, 14, -6});
        for(int i = 0; i < 10; i++)
            seedBag.add(new Object[]{4, 1, 3, -6});
    }
}
