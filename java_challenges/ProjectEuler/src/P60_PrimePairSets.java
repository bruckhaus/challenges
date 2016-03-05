import java.util.*;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    private static final int PRIME_ARRAY_SIZE = 5;
    private static boolean printToStdOut = true;
    private static int maxSeedShown = 0;

    public static void main(String[] args) {
        printToStdOut = true;
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        long[] solution = P60_PrimePairSets.findPrimeArray(PRIME_ARRAY_SIZE);
        showSolutionPrimeArray(solution);
        long primeSum = P60_PrimePairSets.getSum(solution);
        System.out.printf(message, primeSum);
    }

    static long[] findPrimeArray(int size) {
        return PrimePairs.getPrimeArray(findIndexArray(size));
    }

    static List<Integer> findIndexArray(int size) {
        for (int seed = 1; true; seed++) {
            List<Integer> result = findIndexArray(size, seed, 0);
            if (result != null) return result;
        }
    }

    static List<Integer> findIndexArray(int size, int seed, int start) {
        showCall(size);
        if (size == 1) return makeList(seed);
        List<Integer> pairs = PrimePairs.get(seed);
        int offset = 0;
        while (true) {
            if (start > pairs.size() - 1) return null;
            List<Integer> partial = findIndexArray(size - 1, pairs.get(start), offset);
            showStep(size, seed, start, offset, partial, pairs);
            if (partial == null) {
                start++;
                offset = 0;
            } else {
                List<Integer> solution = checkPartial(partial, seed);
                if (solution == null) {
                    offset++;
                } else {
                    showSolution(solution);
                    return solution;
                }
            }
        }
    }

    static List<Integer> makeList(int seed) {
        List<Integer> solution = new ArrayList<>();
        solution.add(seed);
        return solution;
    }

    static List<Integer> checkPartial(List<Integer> partial, int seed) {
        partial.add(seed);
        if (PrimePairs.isConcatenable(partial)) return partial;
        return null;
    }

    static long getSum(long[] longs) {
        long sum = 0;
        for (long l : longs) sum += l;
        return sum;
    }

    private static void showCall(int size) {
//        if (!printToStdOut) return;
//        System.out.printf("Find index array for size: %d\n", size);
    }

    private static void showStep(int size, int seed, int start, int offset, List<Integer> partial, List<Integer> pairs) {
        if (!printToStdOut) return;
        if (seed <= maxSeedShown) return;
        maxSeedShown = seed;
        long prime = PrimePairs.getPrime(seed);
        String partialStr = partial == null ? "null" : partial.toString();
        System.out.printf("Size: %d, prime[%5d]: %,5d, start: %2d, offset: %2d, partial solution: %20s, pairs: %s\n",
                size, seed, prime, start, offset, partialStr, pairs);
    }

    private static void showSolution(List<Integer> solution) {
//        if (!printToStdOut) return;
//        System.out.printf("Solution: %s\n", solution.toString());
    }

    private static void showSolutionPrimeArray(long[] solution) {
        System.out.printf("Solution prime set = %s\n", Arrays.toString(solution));
    }
}
