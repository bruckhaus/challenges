import java.util.*;

public class Prime {
    public long current = 2;
    private long last = 3;
    public List<Long> primes = new ArrayList<>();

    public Boolean isPrime(long tested) {
        if (primes.contains(tested)) return true;
        if (tested <= last) return false;
        while (last < tested) {
            last++;
            if (lastIsPrime()) {
                primes.add(last);
            }
        }
        return primes.contains(tested);
    }

    private boolean lastIsPrime() {
        long num = Math.abs(last);
        if (num < 2) return false;
        if (num == 2) return true;
        if (num == 3) return true;
        if ((num & 1) == 0) return false;
        if (isDivisibleByThree(num)) return false;
        int index = 1;
        while (true) {
            Long prime = primes.get(index);
            if (num % prime == 0) return false;
            if (prime > Math.sqrt(num)) return true;
            index++;
        }
    }

    public long get(int index) {
        while (primes.size() < index) next();
        return primes.get(index - 1);
    }

    public long next() {
        current++;
        while (!isPrime(current)) current++;
        return current;
    }

    public Prime() {
        current = 2;
        last = 2;
        primes.clear();
        primes.add(2L);
    }

    public Set<Long> getPrimeFactorSet(long l) {
        throw new UnsupportedOperationException();
    }

    static Set<Long> getFactorSet(long l) {
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

    static Boolean checkPrime(long p) {
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
