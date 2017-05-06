import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.Set;

public class P47_DistinctPrimeFactors {
    // Project Euler 47 - Distinct primes factors
    // The first two consecutive numbers to have two distinct prime factors are:
    //        14 = 2 × 7
    //        15 = 3 × 5
    // The first three consecutive numbers to have three distinct prime factors are:
    //        644 = 2² × 7 × 23
    //        645 = 3 × 5 × 43
    //        646 = 2 × 17 × 19.
    // Find the first four consecutive integers to have four distinct prime factors.
    // What is the first of these numbers?

    public static void main(String[] args) {
        StopWatch timer = new StopWatch();
        timer.start();
        long solution = P47_DistinctPrimeFactors.findFirst();
        double seconds = timer.getTime() / 1000.0;
        String message = "The first of the first four consecutive integers " +
                "to have four distinct prime factors is %,d.\n" +
                "Execution took %.1f seconds.\n";
        System.out.printf(message, solution, seconds);
    }

    private static Prime prime;

    static {
        try {
            prime = new Prime1stMillion();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getLocalizedMessage());
        }
    }

    public static long findFirst() {
        long candidate = 1;
        while (true) {
            if (isSolution(candidate)) return candidate;
            candidate++;
        }
    }

    public static boolean isSolution(long number) {
        for (long l = number; l <= number + 3; l++) {
            if (!hasFourDistinctPrimeFactors(l)) return false;
        }
        return true;
    }

    public static boolean hasFourDistinctPrimeFactors(long l) {
        Set<Long> factors = prime.getPrimeFactorSet(l);
        return factors.size() == 4;
    }
}
