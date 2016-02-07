import org.apache.commons.math3.util.Combinations;

import java.io.IOException;
import java.util.Arrays;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    private static final int SET_SIZE = 5;
    private static boolean FORWARD = true;
    private static boolean BACKWARD = !FORWARD;
    private static Prime1stMillion primes;
    private static long[] primeArray;

    public static void main(String[] args) {
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        long primeSum = P60_PrimePairSets.findPrimeSum(SET_SIZE);
        showSolutionPrimeArray();
        System.out.printf(message, primeSum);
    }

    static {
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
        for (int lastPrimeIndex = arraySize; true; lastPrimeIndex++) {
            System.out.printf("Checking for last prime %,d\n", primes.get(lastPrimeIndex));
            primeArray = searchPrimeArray(arraySize, lastPrimeIndex);
            if (primeArray != null) return primeArray;
        }
    }

    static long[] searchPrimeArray(int setSize, int lastPrimeIndex) {
        for (int[] combo : new Combinations(lastPrimeIndex, setSize - 1)) {
            primeArray = getPrimeArray(setSize, lastPrimeIndex, combo);
            if (isConcatenable(setSize, primeArray)) return primeArray;
        }
        return null;
    }

    static long[] getPrimeArray(int arraySize, int lastPrimeIndex, int[] combo) {
        primeArray = new long[arraySize];
        primeArray[arraySize - 1] = primes.get(lastPrimeIndex);
        for (int j = 0; j <= arraySize - 2; j++) primeArray[j] = primes.get(combo[j] + 1);
        return primeArray;
    }

    static boolean isConcatenable(int setSize, long[] primeArray) {
        for (int[] pair : new Combinations(setSize, 2)) {
            if (!isConcatenable(primeArray, pair, FORWARD)) return false;
            if (!isConcatenable(primeArray, pair, BACKWARD)) return false;
        }
        return true;
    }

    static boolean isConcatenable(long[] primeArray, int[] pair, boolean forward) {
        int first = forward ? 0 : 1;
        int second = forward ? 1 : 0;
        return primes.isPrime(concatenate(primeArray[pair[first]], primeArray[pair[second]]));
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
