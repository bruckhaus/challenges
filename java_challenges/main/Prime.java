import java.util.Collections;
import java.util.HashSet;

public class Prime {
    private static long last = 2L;
    private static HashSet<Long> primes = new HashSet<>(Collections.singletonList(2L));

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
        for (long i = 2; i <= Math.sqrt(last); i++) {
            if (primes.contains(i) && last % i == 0) return false;
        }
        return true;
    }

    public static long next() {
        long result = last;
        while (true) {
            last++;
            if (isPrime(last)) {
                primes.add(last);
                return result;
            }
        }
    }
}
