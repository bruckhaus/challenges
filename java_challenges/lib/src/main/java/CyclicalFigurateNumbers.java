import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class CyclicalFigurateNumbers {

    private final int MIN_ORDER = 3;
    private final int MAX_ORDER = 8;
    private final int LENGTH = 4;
    private int HALF_LENGTH = 2;
    private int MIN_VALUE = 1000;
    private int MAX_VALUE = 9999;

    private static boolean diagnosticsToStdOut = false;
    private TreeMap<Integer, List<Long>> polygonals = buildPolygonals();

    List<Long> find(int size) {
        return find(size, size, 0, 0);
    }

    private List<Long> find(int solutionSize, int size, int seed, int offset) {
        if (size == 1) return makeList(seed, offset);
        List<Long> solution;
        int nextSeed = 0;
        int nextOffset = 0;
        while (true) {
            List<Long> partial = find(solutionSize, size - 1, nextSeed, nextOffset);
            solution = checkSolution(size, partial, nextSeed, nextOffset);
            return solution;
        }
    }

    private List<Long> append(List<Long> partial, int key, int value) {
        int[] array = new int[]{key, value};
        Long polygonal = new PolygonalNumber(key, value).calculate();
        partial.add(polygonal);
        return partial;
    }

    private List<Long> makeList(int seed, int offset) {
        List<Integer> list = new ArrayList<>();
        Integer head = polygonals.firstKey();
        for (int i = 0; i < seed; i++) head = polygonals.higherKey(head);
        Long tail = polygonals.get(head).get(offset);
        list.add(head);
        list.add(tail);
        return list;
    }

    private TreeMap<Integer, List<Long>> buildPolygonals() {
        polygonals = new TreeMap<>();
        int[] polygonal = getStart();
        int count = 0;
        while (true) {
            if (isUnderflow(polygonal)) break;
            if (!isWrongSize(polygonal)) {
                System.out.println("polygonal = " + Arrays.toString(polygonal));
                count++;
                addPolygonal(polygonal);
            }
            polygonal = getNext(polygonal);
        }
        showListCheck(count);
        return polygonals;
    }

    private void addPolygonal(PolygonalNumber p) {
        Integer base = p.getBase();
        List<Long> list = polygonals.get(base);
        if (list == null) {
            list = new ArrayList<>();
            polygonals.put(base, list);
        }
        list.add(value);
    }

    // checkers:
    // TODO: refactor this section

    boolean hasValidLength(PolygonalNumber p) {
        return p.getLength() == LENGTH;
    }

    Long getHead(PolygonalNumber p) {
        String s = "" + p.getValue();
        if (s.length() < HALF_LENGTH) return Long.parseLong(s);
        return Long.parseLong(s.substring(0, HALF_LENGTH));
    }

    Long getTail(PolygonalNumber p) {
        String s = "" + p.getValue();
        if (s.length() < HALF_LENGTH) return Long.parseLong(s);
        return Long.parseLong(s.substring(s.length() - HALF_LENGTH));
    }

    // Solution evaluation:

    List<Long> checkSolution(int size, List<Long> partial, int key, int value) {
        List<Long> solution = append(partial, key, value);
        if (isSolution(size, partial)) return partial;
        return null;
    }

    boolean isSolution(int size, List<Long> list) {
        switch (list.size()) {
            case 0:
                return true;
            case 1:
                return false; // PolygonalForEuler61.getDigitCount(list.get(0)) == LENGTH;
            default:
                return isCyclicSolution(size, list);
        }
    }

    private boolean isCyclicSolution(int size, List<Long> list) {
        return PolygonalNumber.hasRequiredDigitCounts(list, LENGTH) &&
                PolygonalNumber.hasUniqueOrders(list) &&
                PolygonalNumber.isCyclicAndWraps(size, list);
    }

    // Diagnostics:

    private void showCall(int size, int[] seed) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("size: %d, seed: %s, %d\n", size, Arrays.toString(seed), PolygonalNumber.calculate(seed));
    }

    private void showStep(int size, int[] seed, int[] anchor, List<int[]> partial) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("size: %d, seed: %s, %,d, anchor: %s, %d\n", size,
                Arrays.toString(seed), PolygonalNumber.calculate(seed),
                Arrays.toString(anchor), PolygonalNumber.calculate(anchor));
        showList(partial);
    }

    private void showListCheck(int count) {
        System.out.println("count = " + count);
        int count2 = 0;
        for (Long key : polygonals.keySet()) {
            List<Long> value = polygonals.get(key);
            System.out.printf("%s: %s\n", key, value);
            count2 += value.size();
        }
        System.out.println("count2 = " + count2);
    }

    private void showList(List<int[]> partial) {
        if (!diagnosticsToStdOut) return;
        if (partial != null) {
            for (int i = 0; i < partial.size(); i++) {
                System.out.printf("partial[%d]: %,d\n", i, PolygonalNumber.calculate(partial.get(i)));
            }
        } else {
            System.out.println("partial: null");
        }
    }

    // CyclicPolygonal wrappers:

    private Long getHead(int[] polygonal) {
        return PolygonalNumber.getHead(polygonal, LENGTH / 2);
    }

    private Long getTail(int[] polygonal) {
        return PolygonalNumber.getTail(polygonal, LENGTH / 2);
    }

    private int[] getStart() {
        return PolygonalNumber.getStart(MAX_ORDER);
    }

    private boolean isUnderflow(int[] polygonal) {
        return PolygonalNumber.isUnderflow(polygonal, MIN_ORDER);
    }

    private boolean isWrongSize(int[] polygonal) {
        return PolygonalNumber.isWrongSize(polygonal, LENGTH);
    }

    private boolean isTooSmall(int[] polygonal) {
        return PolygonalNumber.isTooSmall(polygonal, LENGTH);
    }

    private boolean isTooLarge(int[] polygonal) {
        return PolygonalNumber.isTooLarge(polygonal, LENGTH);
    }

    private int[] getNext(int[] polygonal) {
        return PolygonalNumber.getNext(polygonal, LENGTH);
    }

}
