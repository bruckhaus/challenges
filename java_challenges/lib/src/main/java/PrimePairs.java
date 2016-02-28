import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimePairs {
    // Two primes p and q are a prime pair if the concatenations of p and q, as well as q and p are prime.

    private static Prime1stMillion primes;
    private static List<List<Integer>> pairsList;
    private static int lastIndex = -1;

    static {
        pairsList = new ArrayList<>();
        try {
            primes = new Prime1stMillion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Integer> get(int index) {
        buildPairs(index);
        return pairsList.get(index);
    }

    static List<Integer> buildPairs(int index) {
        while (lastIndex < index) {
            lastIndex++;
            pairsList.add(lastIndex, getPairs(lastIndex));
        }
        return pairsList.get(index);
    }

    static List<Integer> getPairs(int index) {
        List<Integer> pairs = new ArrayList<>();
        for (int i = 1; i < index; i++) {
            if (isConcatenable(i, index)) {
                pairs.add(i);
            }
        }
        return pairs;
    }

    static List<Integer> getPrimePair(int prime1, int prime2) {
        if (PrimePairs.isConcatenable(prime1, prime2)) return getListFromPair(prime1, prime2);
        return null;
    }

    static boolean isConcatenable(long left, long right) {
        return primes.isPrime(concatenate(left, right)) &&
                primes.isPrime(concatenate(right, left));
    }

    static boolean isConcatenable(int first, int second) {
        return isConcatenable(primes.get(first), primes.get(second));
    }

    static boolean isConcatenable(List<Integer> list) {
        if (list.size() < 2) return true;
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        int head = temp.remove(0);
        for (int other : temp) if (!isPair(head, other)) return false;
        return isConcatenable(temp);
    }

    static boolean isPair(Integer index1, Integer index2) {
        Integer larger = Math.max(index1, index2);
        Integer smaller = Math.min(index1, index2);
        buildPairs(larger);
        return get(larger).contains(smaller);
    }

    static long[] getPrimeArray(List<Integer> list) {
        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) array[i] = primes.get(list.get(i));
        Arrays.sort(array);
        return array;
    }

    static long concatenate(long prime1, long prime2) {
        return Long.parseLong("" + prime1 + prime2);
    }

    static long getPrime(int index) {
        return primes.get(index);
    }

    static List<Integer> getListFromPair(int index1, int index2) {
        List<Integer> list = new ArrayList<>();
        int first = Math.min(index1, index2);
        int second = Math.max(index1, index2);
        list.add(first);
        list.add(second);
        return list;
    }
}
