import java.util.*;

public class P60_PrimePairSets {
    // Project Euler - Problem 60 - Prime pair sets
    // The primes 3, 7, 109, and 673, are quite remarkable.
    // By taking any two primes and concatenating them in any order the result will always be prime.
    // For example, taking 7 and 109, both 7109 and 1097 are prime.
    // The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
    // Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

    private static final int PRIME_ARRAY_SIZE = 5;

    public static void main(String[] args) {
        PrimeSequence primeSequence = new PrimeSequence();
        List<Long> solutionList = primeSequence.findPrimes(PRIME_ARRAY_SIZE);

        String message = "Solution prime set = %s.\n" +
                "The lowest sum for a set of five primes " +
                "for which any two primes concatenate to produce another prime is %d.\n";
        String solutionArrayString = solutionList.toString();
        Long solutionSum = getSum(solutionList);
        System.out.printf(message, solutionArrayString, solutionSum);
    }

    static Long getSum(List<Long> ints) {
        Long sum = 0l;
        for (Long l : ints) sum += l;
        return sum;
    }
}
