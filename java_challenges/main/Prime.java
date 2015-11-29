import java.util.Collections;
import java.util.HashSet;

public class Prime {
    private static Integer last = 2;
    private static HashSet<Integer> primes = new HashSet<>(Collections.singletonList(2));

    public static Boolean isPrime(long tested) {
        if (primes.contains(tested)) return true;
        if (tested <= last) return false;
        while (last < tested) {
            last++;
            if (lastIsPrime()) primes.add(last);
        }
        return primes.contains(tested);
    }

    private static boolean lastIsPrime() {
        for (Integer i = 2; i <= Math.sqrt(last); i++) {
            if (primes.contains(i) && last % i == 0) return false;
        }
        return true;
    }
}
