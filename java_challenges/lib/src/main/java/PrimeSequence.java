import java.util.ArrayList;
import java.util.List;

public class PrimeSequence {

    private static boolean diagnosticsToStdOut = false;
    private static int maxSeedShown = 0;

    List<Integer> findList(int size) {
        return find(size, 0, 0);
    }

    public List<Integer> find(int length, Integer index, Integer offset) {
        List<Integer> solution = new ArrayList<>();
        showCall(length);
        if (length == 1) return makeList(index);
        // todo: add initializer for new 'pairs' field, use local getter:
        List<Integer> seedPairs = PrimePairs.get(index);
        if (offset >= seedPairs.size()) return null;
        while (length < 1) {
            showStep(length, index, offset, 0, solution, solution);
            offset++;
            // todo: extract checkPartial() to Sequence class
        }
        showSolution(solution);
        return solution;
    }

    static List<Integer> checkPartial(List<Integer> partial, int seed) {
        partial.add(seed);
        if (PrimePairs.isConcatenable(partial)) return partial;
        return null;
    }

    static List<Integer> makeList(int seed) {
        List<Integer> solution = new ArrayList<>();
        solution.add(seed);
        return solution;
    }

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
