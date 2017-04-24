import java.util.ArrayList;
import java.util.List;

public class PrimeSequence {

    List<Long> findPrimes(int size) {
        List<Integer> indexList = findList(size);
        List<Long> primeList = new ArrayList<>();
        for (Integer i : indexList) primeList.add(PrimePairs.getPrime(i));
        return primeList;
    }

    List<Integer> findList(int size) {
        for (int head = 1; true; head++) {
            List<Integer> result = find(size, head, 0);
            if (result != null) return result;
        }
    }

    public List<Integer> find(int length, Integer head, Integer offset) {
        if (length == 1) return makeList(head);
        List<Integer> headList = PrimePairs.get(head);
        int nextOffset = 0;
        while (true) {
            if (offset >= headList.size()) return null;
            Integer nextHead = headList.get(offset);
            List<Integer> partial = find(length - 1, nextHead, nextOffset);
            if (partial == null) {
                offset++;
                nextOffset = 0;
            } else {
                List<Integer> solution = checkPartial(partial, head);
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

    static List<Integer> makeList(int head) {
        List<Integer> solution = new ArrayList<>();
        solution.add(head);
        return solution;
    }
}
