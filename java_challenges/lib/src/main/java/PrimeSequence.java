import java.util.ArrayList;
import java.util.List;

public class PrimeSequence {

    private static boolean diagnosticsToStdOut = false;
    private static int maxSeedShown = 0;

    List<Integer> findList(int size) {
        for (int index = 0; true; index++) {
            List<Integer> result = find(size, index, 0);
            if (result != null) return result;
        }
    }

    public List<Integer> find(int length, Integer index, Integer offset) {
        if (length == 1) return makeList(index);
        List<Integer> headList = PrimePairs.get(index);
        if (offset >= headList.size()) return null;
        Integer nextHead = headList.get(offset);
        List<Integer> solution;
        List<Integer> partial;
        int nextOffset = 0;
        while (true) {
            List<Integer> nextHeadList = PrimePairs.get(nextHead);
            if (nextOffset >= nextHeadList.size()) return null;
            partial = find(length - 1, nextHead, nextOffset);
            if (partial == null) {
                nextOffset++;
            } else {
                solution = checkPartial(partial, index);
                if (solution == null) {
                    nextOffset++;
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
