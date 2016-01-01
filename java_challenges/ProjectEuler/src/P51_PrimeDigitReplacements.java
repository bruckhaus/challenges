import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P51_PrimeDigitReplacements {
    // Project Euler - Problem 51 - Prime digit replacements
    // By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible
    // values: 13, 23, 43, 53, 73, and 83, are all prime.
    // By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the
    // first example having seven primes among the ten generated numbers, yielding the family:
    // 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
    // Consequently 56003, being the first member of this family, is the smallest prime with this property.
    // Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
    // with the same digit, is part of an eight prime value family.

    public static void main(String[] args) throws IOException {
        long solution = P51_PrimeDigitReplacements.findReplaceablePrime(8);
        String message = "The smallest prime which, by replacing part of the number " +
                "with the same digit, is part of an eight prime value family is: %,d\n";
        System.out.printf(message, solution);
    }

    private static long findReplaceablePrime(int count) throws IOException {
        Prime primes = new Prime1stMillion();
        for (int i = 1; i < 1000000; i++) {
            long prime = primes.get(i);
            if (getReplaceableCount(prime) == count) return prime;
        }
        return -1;
    }

    private static int getReplaceableCount(long prime) {
        List<int[]> replacements = new ArrayList<>();
        int maxCount = 0;
        while (DigitNumber.hasNextCombination(prime, replacements)) {
            replacements = DigitNumber.getNextCombination(prime, replacements);
            int count = getReplaceableCount(prime, replacements);
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }

    private static int getReplaceableCount(long prime, List<int[]> replacements) {
        return 0;
    }
}
