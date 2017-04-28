import java.util.*;

public class CyclicalFigurate {

    private final int MIN_ORDER = 3;
    private final int MAX_ORDER = 8;
    private final int LENGTH = 4;
    private int HALF_LENGTH = 2;
    private int MIN_VALUE = 1000;
    private int MAX_VALUE = 9999;

    private static boolean diagnosticsToStdOut = false;
    private TreeMap<Integer, List<PolygonalNumber>> polygonals = buildPolygonals();


    List<Long> find(int size) {
        return find(size, size, 0, 0);
    }

    private List<Long> find(int solutionSize, int size, int head, int offset) {
//        if (size == 1) return makeList(head, offset);
        List<Long> solution;
        int nextSeed = 0;
        int nextOffset = 0;
        while (true) {
            List<Long> partial = find(solutionSize, size - 1, nextSeed, nextOffset);
            solution = checkSolution(size, partial, nextSeed, nextOffset);
            return solution;
        }
    }

    TreeMap<Integer, List<PolygonalNumber>> buildPolygonals() {
        polygonals = new TreeMap<>();
        int base = MIN_ORDER;
        int exponent = 0;
        int count = 0;
        while (true) {
            PolygonalNumber p = new PolygonalNumber(base, exponent);
            if (base > MAX_ORDER) break;
            else if (p.getValue() < MIN_VALUE) exponent++;
            else if (p.getValue() > MAX_VALUE) {
                base++;
                exponent = 0;
            } else {
                count++;
                addPolygonal(p);
                exponent++;
            }
        }
        showListCheck(count);
        return polygonals;
    }

//    private List<Long> makeList(int seed, int offset) {
//        List<Integer> list = new ArrayList<>();
//        Integer head = polygonals.firstKey();
//        for (int i = 0; i < seed; i++) head = polygonals.higherKey(head);
//        Long tail = polygonals.get(head).get(offset);
//        list.add(head);
//        list.add(tail);
//        return list;
//    }

    private void addPolygonal(PolygonalNumber p) {
        Integer base = p.getBase();
        List<PolygonalNumber> list = polygonals.get(base);
        if (list == null) {
            list = new ArrayList<>();
            polygonals.put(base, list);
        }
        list.add(p);
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
//        List<Long> solution = append(partial, key, value);
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
        return false;
//                PolygonalNumber.hasRequiredDigitCounts(list, LENGTH) &&
//                PolygonalNumber.hasUniqueOrders(list) &&
//                PolygonalNumber.isCyclicAndWraps(size, list);
    }

    // Diagnostics:

    private void showCall(int size, int[] seed) {
        if (!diagnosticsToStdOut) return;
//        System.out.printf("size: %d, seed: %s, %d\n", size, Arrays.toString(seed), PolygonalNumber.calculate(seed));
    }

    private void showStep(int size, int[] seed, int[] anchor, List<int[]> partial) {
        if (!diagnosticsToStdOut) return;
        System.out.printf("size: %d, seed: %s, %,d, anchor: %s, %d\n", size
//                Arrays.toString(seed), PolygonalNumber.calculate(seed),
//                Arrays.toString(anchor), PolygonalNumber.calculate(anchor)
        );
        showList(partial);
    }

    private void showListCheck(int steps) {
        System.out.println("polygonals = " + polygonals);
        System.out.println("step count = " + steps);
        int polygonalCount = 0;
        for (Integer key : polygonals.keySet()) {
            List<PolygonalNumber> value = polygonals.get(key);
            System.out.printf("%s: %s\n", key, value);
            polygonalCount += value.size();
        }
        System.out.println("polygonals = " + polygonalCount);
    }

    private void showList(List<int[]> partial) {
        if (!diagnosticsToStdOut) return;
        if (partial != null) {
            for (int i = 0; i < partial.size(); i++) {
//                System.out.printf("partial[%d]: %,d\n", i, PolygonalNumber.calculate(partial.get(i)));
            }
        } else {
            System.out.println("partial: null");
        }
    }

//public class CyclicPolygonalSequence {

    long getSum() {
//        if (list == null) return 0;
        long sum = 0;
//        for (PolygonalNumber item : list) sum += (long) item.getValue();
        return sum;
    }

    boolean hasUniqueOrders() {
        Set<Integer> orders = new HashSet<>();
//        for (PolygonalNumber polygonal : list) {
//            int base = polygonal.getBase();
//            if (orders.contains(base)) return false;
//            orders.add(base);
//        }
        return true;
    }

    boolean hasRequiredDigitCounts() {
//        for (PolygonalNumber item : list) if (!item.hasValidLength()) return false;
        return true;
    }

    boolean isCyclicAndWraps(int maxSize) {
        return hasCyclicItems() && isPartialOrWraps(maxSize);
    }

    boolean hasCyclicItems() {
//        for (int i = 1; i < list.size(); i++) if (!isCyclicWithPrevious(i)) return false;
        return true;
    }

    boolean isPartialOrWraps(int maxSize) {
//        return list.size() != maxSize || hasCyclicListMembers(list.size() - 1, 0);
        return false;
    }

    boolean isCyclicWithPrevious(int i) {
        return hasCyclicListMembers(i - 1, i);
    }

    boolean hasCyclicListMembers(int index1, int index2) {
        try {
//            return isCyclic(list.get(index1), list.get(index2));
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    boolean isCyclic(PolygonalNumber polygonal1, PolygonalNumber polygonal2) {
//        return polygonal1.getTail().equals(polygonal2.getHead());
        return false;
    }
}
