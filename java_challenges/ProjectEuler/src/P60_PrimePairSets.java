import java.util.*;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    private static final int PRIME_ARRAY_SIZE = 5;
    private static List<Integer> tracers;

    public static void main(String[] args) {
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        long[] solution = P60_PrimePairSets.findPrimeArray(PRIME_ARRAY_SIZE);
        showSolutionPrimeArray(solution);
        long primeSum = P60_PrimePairSets.getSum(solution);
        System.out.printf(message, primeSum);
    }

    static {
        tracers = new ArrayList<>();
        tracers.add(6);
        tracers.add(692);
        tracers.add(751);
        tracers.add(868);
        tracers.add(1051);
    }

    static long[] findPrimeArray(int size) {
        return PrimePairs.getPrimeArray(findIndexArray(size));
    }

    static List<Integer> findIndexArray(int size) {
        System.out.println("\nsize = " + size);
        int seed = 1;
        int offset = 0;
        List<Integer> solution = new ArrayList<>();
        List<Integer> pairs = PrimePairs.get(seed);
        List<Integer> partial;
        while (true) {
            System.out.println("seed = " + seed);
            System.out.println("offset = " + offset);
            System.out.println("solution = " + (solution != null ? solution.toString() : null));
            if (offset <= pairs.size() - 1) {
                partial = findIndexArray(size - 1);
                solution = checkPartial(seed, partial);
                if (solution != null) {
                    Collections.sort(solution);
                    System.out.println("solution = " + solution.toString());
                    return solution;
                }
            }
            if (offset < pairs.size() - 1) {
                offset++;
            } else {
                seed++;
                offset = 0;
                pairs = PrimePairs.get(seed);
            }
        }
    }

    private static List<Integer> checkPartial(int seed, List<Integer> partial) {
        if (partial == null) return null;
        partial.add(seed);
        if (PrimePairs.isConcatenable(partial)) return partial;
        return null;
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
