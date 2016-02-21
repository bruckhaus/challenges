import org.apache.commons.math3.util.Combinations;

import java.io.IOException;
import java.util.*;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    private static final int PRIME_ARRAY_SIZE = 5;
    private static final int HASH_SET_SIZE = 30000;
    private static boolean FORWARD = true;
    private static boolean BACKWARD = !FORWARD;
    private static Prime1stMillion primes;
    private static long[] primeArray;
    private static List<Set<Integer>> hashSets;

    public static void main(String[] args) {
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        long primeSum = P60_PrimePairSets.findPrimeSum(PRIME_ARRAY_SIZE);
        showSolutionPrimeArray();
        System.out.printf(message, primeSum);
    }

    static {
        hashSets = new ArrayList<Set<Integer>>();
        try {
            primes = new Prime1stMillion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static long findPrimeSum(int arraySize) {
        return getSum(findPrimeArray(arraySize));
    }

    static long[] findPrimeArray(int arraySize) {
        for (int maxPrimeIndex = 0; true; maxPrimeIndex++) {
            System.out.printf("Checking for last prime %,d\n", primes.get(maxPrimeIndex));
            updateHashSets(maxPrimeIndex);
            primeArray = searchPrimeArray(arraySize, maxPrimeIndex);
            if (primeArray != null) return primeArray;
        }
    }

    private static long[] searchPrimeArray(int arraySize, int maxPrimeIndex) {
        return new long[0];
    }

    private static void updateHashSets(int index) {
        hashSets.set(index, new HashSet<Integer>());
        for (int i = 0; i < index; i++) {
            if (isConcatenablePair(primes.get(i), primes.get(index))) hashSets.get(i).add(index);
        }
    }

    private static boolean isConcatenablePair(long left, long right) {
        return primes.isPrime(concatenate(right, left)) &&
                primes.isPrime(concatenate(left, right));
    }

    static long concatenate(long prime1, long prime2) {
        return Long.parseLong("" + prime1 + prime2);
    }

    static long getSum(long[] primeArray) {
        long sum = 0;
        for (long aPrimeArray : primeArray) sum += aPrimeArray;
        return sum;
    }

    private static void showSolutionPrimeArray() {
        System.out.printf("Solution prime set = %s\n", Arrays.toString(primeArray));
    }
}
