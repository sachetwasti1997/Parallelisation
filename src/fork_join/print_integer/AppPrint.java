package fork_join.print_integer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppPrint {
    public static void main(String[] args) {
        var rand = new Random();
        List<Integer> p = new ArrayList<>(1000);
        createList(p, rand.nextInt(20, 100));
        System.out.println(p.size());
        System.out.println(p);
        PrintIntegerFork printIntegerFork = new PrintIntegerFork(p);
        printIntegerFork.invoke();
    }

    static void createList(List<Integer> p, int limit) {
        var rand = new Random();
        for (int i=0; i<limit; i++) {
            p.add(rand.nextInt(21, limit+21));
        }
    }
}
