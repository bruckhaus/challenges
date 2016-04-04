import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CyclicPolygonal {

    private static Polygonal triangular = new Triangular();
    private static Polygonal square = new Square();
    private static Polygonal pentagonal = new Pentagonal();
    private static Polygonal hexagonal = new Hexagonal();
    private static Polygonal heptagonal = new Heptagonal();
    private static Polygonal octagonal = new Octagonal();

    static long getValue(int[] item) {
        switch (item[0]) {
            case 3:
                return triangular.function(item[1]);
            case 4:
                return square.function(item[1]);
            case 5:
                return pentagonal.function(item[1]);
            case 6:
                return hexagonal.function(item[1]);
            case 7:
                return heptagonal.function(item[1]);
            case 8:
                return octagonal.function(item[1]);
            default:
                return -1;
        }
    }

    static int[] getStart(int maxOrder) {
        return new int[]{maxOrder, 1};
    }

    static List<int[]> makeList(int[] seed) {
        List<int[]> list = new ArrayList<>();
        list.add(seed);
        return list;
    }

    static List<int[]> makeList(int order, Integer n) {
        return makeList(makePolygonal(order, n));
    }

    static int[] makePolygonal(int order, Integer n) {
        return new int[]{order, n};
    }

    static long getSum(List<int[]> list) {
        if (list == null) return 0;
        long sum = 0;
        long value;
        for (int[] item : list) {
            value = CyclicPolygonal.getValue(item);
            sum += value;
        }
        return sum;
    }

    static int[] getNext(int[] polygonal, int length) {
        int[] result = polygonal.clone();
        if (getDigitCount(polygonal) <= length) result[1] = result[1] + 1;
        else {
            result[0] = result[0] - 1;
            result[1] = 1;
        }
        return result;
    }

    static int getDigitCount(int[] polygonal) {
        long value = CyclicPolygonal.getValue(polygonal);
        if (value < 0) return 0;
        return ("" + value).length();
    }

    static boolean isUnderflow(int[] polygonal, int minOrder) {
        return polygonal[0] < minOrder;
    }

    static boolean isWrongSize(int[] polygonal, int length) {
        return getDigitCount(polygonal) != length;
    }

    static boolean isTooLarge(int[] polygonal, int length) {
        return getDigitCount(polygonal) > length;
    }

    static boolean isTooSmall(int[] polygonal, int length) {
        return getDigitCount(polygonal) < length;
    }

    static boolean hasUniqueOrders(List<int[]> list) {
        Set<Integer> orders = new HashSet<>();
        for (int[] polygonal : list) {
            int order = polygonal[0];
            if (orders.contains(order)) return false;
            orders.add(order);
        }
        return true;
    }

    static boolean hasRequiredDigitCounts(List<int[]> list, int length) {
        for (int[] item : list) if (isWrongSize(item, length)) return false;
        return true;
    }

    static boolean isCyclicAndWraps(int size, List<int[]> list) {
        return CyclicPolygonal.isCyclicList(list) &&
                CyclicPolygonal.isPartialOrWraps(size, list);
    }

    static boolean isCyclicList(List<int[]> list) {
        for (int i = 1; i < list.size(); i++) if (!isCyclicWithPrevious(list, i)) return false;
        return true;
    }

    static boolean isPartialOrWraps(int size, List<int[]> list) {
        return list.size() != size ||
                isCyclicListMembers(list, list.size() - 1, 0);
    }

    static boolean isCyclicWithPrevious(List<int[]> list, int i) {
        return isCyclicListMembers(list, i - 1, i);
    }

    static boolean isCyclicListMembers(List<int[]> list, int index1, int index2) {
        try {
            return isCyclic(list.get(index1), list.get(index2));
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    static boolean isCyclic(int[] polygonal1, int[] polygonal2) {
        return getLastDigits(polygonal1, 2).equals(getFirstDigits(polygonal2, 2));
    }

    static String getFirstDigits(int[] polygonal, int count) {
        String s = "" + getValue(polygonal);
        if (s.length() < count) return s;
        return s.substring(0, count);
    }

    static String getLastDigits(int[] polygonal1, int count) {
        String s = "" + getValue(polygonal1);
        if (s.length() < count) return s;
        return s.substring(s.length() - count);
    }
}
