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
    private static boolean FORWARD = true;
    private static boolean BACKWARD = !FORWARD;
    private static Prime1stMillion primes;
    private static long[] primeArray;
    private static List<List<Integer>> pairsList;

    public static void main(String[] args) {
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        long primeSum = P60_PrimePairSets.findPrimeSum(PRIME_ARRAY_SIZE);
        showSolutionPrimeArray();
        System.out.printf(message, primeSum);
    }

    static {
        pairsList = new ArrayList<>();
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
        for (int maxPrimeIndex = 1; true; maxPrimeIndex++) {
            System.out.printf("Checking for last prime %,d\n", primes.get(maxPrimeIndex));
            buildHashSet(maxPrimeIndex);
            ArrayList<Integer> array = new ArrayList<>();
            array.add(maxPrimeIndex);
            ArrayList<Integer> indexArray = searchPrimeArray(arraySize, array);
            primeArray = getPrimeArray(indexArray);
            if (primeArray != null) return primeArray;
        }
    }

    private static ArrayList<Integer> searchPrimeArray(int arraySize, ArrayList<Integer> solution) {
        // get n: set max(n-1) to (p in pairs of max(n)), get n-1, check n, iterate or return
        if (solution.size() == arraySize) return solution;
        Integer lastIndex = solution.get(solution.size() - 1);
        int hashSetSize = pairsList.get(lastIndex).size();
        for (int i = 0; i < hashSetSize - 1; i++) {
            solution.add(pairsList.get(lastIndex).get(i));
            long[] primeArray = getPrimeArray(solution);
            if (isConcatenable(arraySize, primeArray)) {
                searchPrimeArray(arraySize - 1, solution);
            }
        }
        return null;
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

    private static void buildHashSet(int index) {
        ArrayList<Integer> newPairs = new ArrayList<>();
        pairsList.add(newPairs);
        List<Integer> pairs = pairsList.get(index - 1);
        for (int i = 0; i < index; i++) {
            if (isConcatenablePair(primes.get(i), primes.get(index))) {
                pairs.add(i);
            }
        }
    }

    private static boolean isConcatenablePair(long left, long right) {
        return primes.isPrime(concatenate(right, left)) &&
                primes.isPrime(concatenate(left, right));
    }

    static long concatenate(long prime1, long prime2) {
        return Long.parseLong("" + prime1 + prime2);
    }

    private static long[] getPrimeArray(ArrayList<Integer> indexArray) {
        long[] longs = new long[indexArray.size()];
        for (int i = 0; i < indexArray.size(); i++) longs[i] = primes.get(i);
        return longs;
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
