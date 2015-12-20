import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Prime {
    private static long current = 2;
    private static long last = 2;
    public static HashSet<Long> primes = new HashSet<>(Collections.singletonList(2L));

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
        current++;
        while (!isPrime(current)) current++;
        return current;
    }

    public static void reset() {
        current = 2;
        last = 2;
        primes.clear();
        primes.add(2L);
    }

    public static Set<Long> getFactorSet(long l) {
        Set<Long> factorSet = new TreeSet<>();
        long candidate = 2;
        while (l > 1) {
            if (l % candidate == 0) {
                factorSet.add(candidate);
                l /= candidate;
            } else {
                candidate++;
            }
        }
        return factorSet;
    }

    public static Boolean checkPrime(long p) {
        p = Math.abs(p);
        if (p < 2) return false;
        if (p == 2) return true;
        if (p == 3) return true;
        if ((p & 1) == 0) return false;
        if (isDivisibleByThree(p)) return false;
        for (long l = 5; l <= Math.sqrt(p); l += 2) if (p % l == 0) return false;
        return true;
    }

    private static boolean isDivisibleByThree(long p) {
        while (p > 9) p = threesDigitSum(p);
        return (p == 0 | p == 3 || p == 6 || p == 9);
    }

    private static int threesDigitSum(long p) {
        int digitSum = 0;
        String s = "" + p;
        for (int i = 0; i < s.length(); i++) {
            Integer digit = Integer.valueOf(s.substring(i, i + 1));
            if (digit != 0 && digit != 3 && digit != 6 && digit != 9) digitSum += digit;
        }
        return digitSum;
    }

}
