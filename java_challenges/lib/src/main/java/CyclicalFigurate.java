import java.util.*;

class CyclicalFigurate {

    private static final int LENGTH = 4;

    final int MIN_ORDER = 3;
    final int MAX_ORDER = 8;
    final int MIN_VALUE = 1000;
    final int MAX_VALUE = 9999;

    private TreeMap<Long, List<PolygonalNumber>> polygonals = buildPolygonals();

    TreeMap<Long, List<PolygonalNumber>> buildPolygonals() {
        polygonals = new TreeMap<>();
        int base = MIN_ORDER;
        int exponent = 0;
        while (true) {
            PolygonalNumber p = new PolygonalNumber(base, exponent);
            if (base > MAX_ORDER) break;
            else if (p.getValue() < MIN_VALUE) exponent++;
            else if (p.getPostfix() < 10) exponent++;
            else if (p.getValue() > MAX_VALUE) {
                base++;
                exponent = 0;
            } else {
                polygonals = addPolygonal(polygonals, p);
                exponent++;
            }
        }
        return polygonals;
    }

    TreeMap<Long, List<PolygonalNumber>> addPolygonal(TreeMap<Long, List<PolygonalNumber>> map, PolygonalNumber p) {
        Long prefix = p.getPrefix();
        List<PolygonalNumber> list = map.get(prefix);
        if (list == null) {
            list = new ArrayList<>();
            map.put(prefix, list);
        }
        list.add(p);
        return map;
    }

    List<Long> find(int size) {
        List<Long> longs = new ArrayList<>();
        List<PolygonalNumber> polygonals = findPolygonals(size);
        for (PolygonalNumber p : polygonals) {
            longs.add(p.getValue());
        }
        return longs;
    }

    List<PolygonalNumber> findPolygonals(int size) {
        List<PolygonalNumber> result;
        Long head = polygonals.firstKey();
        while (head != null) {
            result = find(size, size, head, 0);
            if (result != null) return result;
            head = polygonals.higherKey(head);
        }
        return null;
    }

    List<PolygonalNumber> find(int solutionSize, int size, Long head, Integer offset) {
        if (size == 1) return makeList(head, offset);
        List<PolygonalNumber> headList = polygonals.get(head);
        int nextOffset = 0;
        while (true) {
            if (offset >= headList.size()) return null;
            PolygonalNumber p = headList.get(offset);
            Long nextHead = p.getPostfix();
            List<PolygonalNumber> partial = find(solutionSize, size - 1, nextHead, nextOffset);
            if (partial == null) {
                offset++;
                nextOffset = 0;
            } else {
                List<PolygonalNumber> solution = checkSolution(solutionSize, partial, p);
                if (solution == null) {
                    nextOffset++;
                } else {
                    return solution;
                }
            }
        }
    }

    List<PolygonalNumber> makeList(Long head, int offset) {
        if (offset >= polygonals.get(head).size()) return null;
        List<PolygonalNumber> list = new ArrayList<>();
        list.add(polygonals.get(head).get(offset));
        return list;
    }

    // Solution evaluation:

    static List<PolygonalNumber> checkSolution(int size, List<PolygonalNumber> partial, PolygonalNumber p) {
        partial.add(0, p);
        if (isSolution(size, partial)) return partial;
        return null;
    }

    static boolean isSolution(int size, List<PolygonalNumber> list) {
        return hasRequiredDigitCounts(list) &&
                isCyclicAndWraps(size, list) &&
                eachOrderHasDifferentPolygonal(list);
    }

    static boolean hasRequiredDigitCounts(List<PolygonalNumber> list) {
        for (PolygonalNumber p : list) if (p.getLength() != LENGTH) return false;
        return true;
    }

    static boolean isCyclicAndWraps(int size, List<PolygonalNumber> list) {
        return isCyclic(list) && (isWrapping(list) || !isFullSize(size, list));
    }

    static boolean isCyclic(List<PolygonalNumber> list) {
        if (list.size() < 1) return true;
        Long lastPostfix = list.get(0).getPrefix();
        for (PolygonalNumber p : list) {
            if (!p.getPrefix().equals(lastPostfix)) return false;
            lastPostfix = p.getPostfix();
        }
        return true;
    }

    static boolean isWrapping(List<PolygonalNumber> list) {
        if (list.size() < 1) return true;
        Long firstPrefix = list.get(0).getPrefix();
        Long lastPostfix = list.get(list.size() - 1).getPostfix();
        return firstPrefix.equals(lastPostfix);
    }

    static boolean isFullSize(int size, List<PolygonalNumber> list) {
        return list.size() == size;
    }

    static boolean eachOrderHasDifferentPolygonal(List<PolygonalNumber> list) {
        Set<Integer> bases = new HashSet<>();
        Set<Long> numbers = new HashSet<>();
        for (PolygonalNumber p : list) {
            bases.add(p.getBase());
            numbers.add(p.getValue());
        }
        return (bases.size() == list.size()) &&
                (numbers.size() == list.size());
    }
}
