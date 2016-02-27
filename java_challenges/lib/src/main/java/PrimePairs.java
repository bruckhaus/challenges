import java.io.IOException;
import java.util.ArrayList;
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

    static List addPairs(int index) {
        List<Integer> newPairs = new ArrayList<>();
        pairsList.add(newPairs);
        for (int i = 1; i < index; i++) {
            if (isConcatenable(i, index)) {
                newPairs.add(i);
            }
        }
        return newPairs;
    }

    static List<Integer> get(int index) {
        buildPairs(index);
        return pairsList.get(index);
    }

    private static void buildPairs(int index) {
        while (index > lastIndex) {
            lastIndex++;
            addPairs(lastIndex);
        }
    }

    static boolean isConcatenable(List<Integer> list) {
        System.out.println("checking list = " + list);
        if (list.size() < 2) {
            System.out.println("  list has less than 2 elements");
            return true;
        }
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        int head = temp.remove(0);
        System.out.println("  removed head = " + head);
        for (int other : temp) {
            System.out.printf("  checking %d and %d\n", head, other);
            if (!isPair(head, other)) {
                System.out.println("  not pair");
                return false;
            }
        }
        return isConcatenable(temp);
    }

    private static boolean isPair(int index1, int index2) {
        buildPairs(Math.max(index1, index2));
        return PrimePairs.get(index2).contains(index1) ||
                PrimePairs.get(index1).contains(index2);
    }

    static boolean isConcatenable(int first, int second) {
        return isConcatenable(primes.get(first), primes.get(second));
    }

    static boolean isConcatenable(long left, long right) {
        return primes.isPrime(concatenate(left, right)) &&
                primes.isPrime(concatenate(right, left));
    }

    static long[] getPrimeArray(List<Integer> list) {
        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) array[i] = primes.get(list.get(i));
        return array;
    }

    static long getPrime(int index) {
        return primes.get(index);
    }

    static long concatenate(long prime1, long prime2) {
        return Long.parseLong("" + prime1 + prime2);
    }
}
