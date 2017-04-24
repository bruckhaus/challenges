import java.util.ArrayList;
import java.util.List;

public class PrimeSequence {

    private static boolean diagnosticsToStdOut = false;
    private static int maxSeedShown = 0;

    List<Integer> findList(int size) {
        for (int seed = 0; true; seed++) {
            List<Integer> result = find(size, seed, 0);
            if (result != null) return result;
        }
    }

    public List<Integer> find(int size, Integer seed, Integer seedOffset) {
        if (size == 1) return makeList(seed);
        List<Integer> seedPairs = PrimePairs.get(seed);
        int partialOffset = 0;
        while (true) {
            if (seedOffset > seedPairs.size() - 1) return null;
            List<Integer> partial = find(size - 1, seedPairs.get(seedOffset), partialOffset);
            if (partial == null) {
                seedOffset++;
                partialOffset = 0;
            } else {
                List<Integer> solution = checkPartial(partial, seed);
                if (solution == null) {
                    partialOffset++;
                } else {
                    return solution;
                }
            }
        }
    }

    static List<Integer> checkPartial(List<Integer> partial, int index) {
        partial.add(index);
        if (PrimePairs.isConcatenable(partial)) return partial;
        return null;
    }

    static List<Integer> makeList(int seed) {
        List<Integer> solution = new ArrayList<>();
        solution.add(seed);
        return solution;
    }

    // --- Debug helpers: ---

    private static void showStep(int size, int seed, int offsetForSolution, int offsetForPartial,
                                 List<Integer> partial, List<Integer> pairs) {
        if (!diagnosticsToStdOut) return;
        if (seed <= maxSeedShown) return;
        maxSeedShown = seed;
        long prime = PrimePairs.getPrime(seed);
        String partialStr = partial == null ? "null" : partial.toString();
        System.out.printf("Size: %d, prime[%5d]: %,5d, " +
                        "offset for solution: %2d, offset for partial: %2d, " +
                        "partial solution: %20s, pairs: %s\n",
                size, seed, prime, offsetForSolution, offsetForPartial, partialStr, pairs);
    }

    private static void showCall(int size) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("Find index array for size: %d\n", size);
    }

    private static void showSolution(List<Integer> solution) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("Solution: %s\n", solution.toString());
    }
}
