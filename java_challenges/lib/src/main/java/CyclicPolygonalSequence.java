import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CyclicPolygonalSequence {

    private List<PolygonalNumber> list;

    CyclicPolygonalSequence() {
        list = new ArrayList<>();
    }

    long getSum() {
        if (list == null) return 0;
        long sum = 0;
        for (PolygonalNumber item : list) sum += (long) item.getValue();
        return sum;
    }

    boolean hasUniqueOrders() {
        Set<Integer> orders = new HashSet<>();
        for (PolygonalNumber polygonal : list) {
            int base = polygonal.getBase();
            if (orders.contains(base)) return false;
            orders.add(base);
        }
        return true;
    }

    boolean hasRequiredDigitCounts() {
        for (PolygonalNumber item : list) if (!item.hasValidLength()) return false;
        return true;
    }

    boolean isCyclicAndWraps(int maxSize) {
        return hasCyclicItems() && isPartialOrWraps(maxSize);
    }

    boolean hasCyclicItems() {
        for (int i = 1; i < list.size(); i++) if (!isCyclicWithPrevious(i)) return false;
        return true;
    }

    boolean isPartialOrWraps(int maxSize) {
        return list.size() != maxSize || hasCyclicListMembers(list.size() - 1, 0);
    }

    boolean isCyclicWithPrevious(int i) {
        return hasCyclicListMembers(i - 1, i);
    }

    boolean hasCyclicListMembers(int index1, int index2) {
        try {
            return isCyclic(list.get(index1), list.get(index2));
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    boolean isCyclic(PolygonalNumber polygonal1, PolygonalNumber polygonal2) {
        return polygonal1.getTail().equals(polygonal2.getHead());
    }
}
