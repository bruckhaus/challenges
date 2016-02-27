import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    private static final int PRIME_ARRAY_SIZE = 5;

    public static void main(String[] args) {
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        long[] solution = P60_PrimePairSets.findPrimeArray(PRIME_ARRAY_SIZE);
        showSolutionPrimeArray(solution);
        long primeSum = P60_PrimePairSets.getSum(solution);
        System.out.printf(message, primeSum);
    }

    static long[] findPrimeArray(int size) {
        List<Integer> solution;
        for (int i = 1; true; i++) {
            showStep(i);
            solution = searchPrimeArray(size, i);
            if (solution != null) return PrimePairs.getPrimeArray(solution);
        }
    }

    static List<Integer> searchPrimeArray(int size, int seed) {
        List<Integer> solution;
        for (int nextSeed : PrimePairs.get(seed)) {
            solution = searchPrimeArray(size, seed, nextSeed);
            if (solution != null) return solution;
        }
        return null;
    }

    static List<Integer> searchPrimeArray(int size, int seed, int newSeed) {
        if (size == 2) return checkPair(seed, newSeed);
        List<Integer> solution;
        solution = searchPrimeArray(size - 1, newSeed);
        if (solution != null) {
            solution.add(seed);
            if (PrimePairs.isConcatenable(solution)) return solution;
        }
        return null;
    }

    static List<Integer> checkPair(int seed, int newSeed) {
        if (PrimePairs.isConcatenable(seed, newSeed)) {
            return makeList(seed, newSeed);
        }
        return null;
    }

    static List<Integer> makeList(int seed, int newSeed) {
        List<Integer> solution = new ArrayList<>();
        solution.add(seed);
        solution.add(newSeed);
        return solution;
    }

    static long getSum(long[] longs) {
        long sum = 0;
        for (long l : longs) sum += l;
        return sum;
    }

    private static void showStep(int index) {
        long prime = PrimePairs.getPrime(index);
        System.out.printf("Checking for prime[%d] = %,d\n", index, prime);
    }

    private static void showSolutionPrimeArray(long[] solution) {
        System.out.printf("Solution prime set = %s\n", Arrays.toString(solution));
    }
}
