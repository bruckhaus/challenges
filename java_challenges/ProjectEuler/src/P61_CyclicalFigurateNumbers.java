import java.util.*;

public class P61_CyclicalFigurateNumbers {
    // Project Euler - Problem 61 - Cyclical figurate numbers
    // Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are all figurate (polygonal)
    // numbers and are generated by the following formulae:
    // Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
    // Square	 	P4,n=n2	 	        1, 4, 9, 16, 25, ...
    // Pentagonal	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
    // Hexagonal	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
    // Heptagonal	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
    // Octagonal	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
    // The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.
    // The set is cyclic, in that the last two digits of each number is the first two digits of the next number
    // (including the last number with the first).
    // Each polygonal type: triangle P(3,127)=8128, square P(4,91)=8281, and pentagonal P(5,44)=2882, is
    // represented by a different number in the set.
    // This is the only set of 4-digit numbers with this property.
    // Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type:
    // triangle, square, pentagonal, hexagonal, heptagonal, and octagonal,
    // is represented by a different number in the set.

    public static void main(String[] args) {
        diagnosticsToStdOut = false;
        String message = "The sum of the only ordered set of six cyclic 4-digit numbers " +
                "for which each polygonal type: " +
                "triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, " +
                "is represented by a different number in the set is %,d\n" +
                "The set is: %s\n";
        List<int[]> solution = P61_CyclicalFigurateNumbers.find(6);
        long sum = CyclicPolygonal.getSum(solution);
        System.out.printf(message, sum, solution.toString());
    }

    public static final int MIN_ORDER = 3;
    public static final int LENGTH = 4;
    private static boolean diagnosticsToStdOut = false;

    static List<int[]> find(int size) {
        return P61_CyclicalFigurateNumbers.find(size, size, getStart());
    }

    static List<int[]> find(int solutionSize, int size, int[] seed) {
        showCall(size, seed);
        List<int[]> partial;
        List<int[]> solution;
        int[] anchor = getStart();
        while (true) {
            if (isUnderflow(seed)) return null;
            else if (isTooSmall(seed)) seed = getNext(seed);
            else if (isTooLarge(seed)) {
                seed = getNext(seed);
                anchor = getStart();
            } else if (size == 1) return makeList(seed);
            else if (isUnderflow(anchor)) {
                seed = getNext(seed);
                anchor = getStart();
            } else if (isWrongSize(anchor)) anchor = getNext(anchor);
            else {
                partial = find(solutionSize, size - 1, anchor);
                showStep(size, seed, anchor, partial);
                if (partial == null) {
                    seed = getNext(seed);
                    anchor = getStart();
                } else {
                    solution = checkSolution(solutionSize, partial, seed);
                    if (solution == null) anchor = getNext(anchor);
                    else return solution;
                }
            }
        }
    }

    static List<int[]> checkSolution(int size, List<int[]> partial, int[] polygonal) {
        partial.add(polygonal);
        if (isSolution(size, partial)) return partial;
        return null;
    }

    static boolean isSolution(int size, List<int[]> list) {
        switch (list.size()) {
            case 0:
                return true;
            case 1:
                return CyclicPolygonal.getDigitCount(list.get(0)) == LENGTH;
            default:
                return isCyclicSolution(size, list);
        }
    }

    private static boolean isCyclicSolution(int size, List<int[]> list) {
        return CyclicPolygonal.hasRequiredDigitCounts(list, LENGTH) &&
                CyclicPolygonal.hasUniqueOrders(list) &&
                CyclicPolygonal.isCyclicAndWraps(size, list);
    }

    private static void showCall(int size, int[] seed) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("size: %d, seed: %s, %d\n", size, Arrays.toString(seed), CyclicPolygonal.getValue(seed));
    }

    private static void showStep(int size, int[] seed, int[] anchor, List<int[]> partial) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("size: %d, seed: %s, %,d, anchor: %s, %d\n", size,
                Arrays.toString(seed), CyclicPolygonal.getValue(seed),
                Arrays.toString(anchor), CyclicPolygonal.getValue(anchor));
        showList(partial);
    }

    private static void showList(List<int[]> partial) {
        if (!diagnosticsToStdOut) return;
        if (partial != null) {
            for (int i = 0; i < partial.size(); i++) {
                System.out.printf("partial[%d]: %,d\n", i, CyclicPolygonal.getValue(partial.get(i)));
            }
        } else {
            System.out.println("partial: null");
        }
    }

    private static List<int[]> makeList(int[] polygonal) {
        return CyclicPolygonal.makeList(polygonal);
    }

    private static int[] getStart() {
        return CyclicPolygonal.getStart(8);
    }

    private static boolean isUnderflow(int[] polygonal) {
        return CyclicPolygonal.isUnderflow(polygonal, MIN_ORDER);
    }

    private static boolean isWrongSize(int[] polygonal) {
        return CyclicPolygonal.isWrongSize(polygonal, LENGTH);
    }

    private static boolean isTooSmall(int[] polygonal) {
        return CyclicPolygonal.isTooSmall(polygonal, LENGTH);
    }

    private static boolean isTooLarge(int[] polygonal) {
        return CyclicPolygonal.isTooLarge(polygonal, LENGTH);
    }

    private static int[] getNext(int[] polygonal) {
        return CyclicPolygonal.getNext(polygonal, LENGTH);
    }
}
