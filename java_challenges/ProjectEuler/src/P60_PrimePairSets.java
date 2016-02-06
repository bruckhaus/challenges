import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    public static void main(String[] args) {
        String message = "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        int primeSum = P60_PrimePairSets.findPrimeSun(5);
        System.out.printf(message, primeSum);
    }

    private static int findPrimeSun(int i) {
        while (true) {
            Set primeSet = getNextPrimeSet(i);
            if (isConcatenatable(primeSet)) return getSum(primeSet);
        }
    }

    private static int getSum(Set primeSet) {
        return 0;
    }

    private static boolean isConcatenatable(Set primeSet) {
        return false;
    }

    private static Set getNextPrimeSet(int i) {
        return null;
    }

    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
