import java.util.Arrays;

public class P49_PrimePermutations {
    // Project Euler - Problem 49 - Prime permutations
    // The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
    // is unusual in two ways:
    //   (i) each of the three terms are prime, and,
    //   (ii) each of the 4-digit numbers are permutations of one another.
    // There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
    // exhibiting this property, but there is one other 4-digit increasing sequence.
    // What 12-digit number do you form by concatenating the three terms in this sequence?

    public static final int NOT_FOUND = -1;
    public static final int NUM_ITEMS = 3;
    public static final int STEP_SIZE = 3330;
    public static final int RANGE_MIN = 1000;
    public static final int RANGE_MAX = 9999;
    public static final int GIVEN_EXAMPLE = 1487;

    public static void main(String[] args) {
        long solution = findPrimePermutation();
        String message = "The concatenation of other three four-digit terms in a sequence " +
                "of primes that are permutations of each other is %d.\n";
        System.out.printf(message, solution);
    }

    public static long findPrimePermutation() {
        for (int candidate = RANGE_MIN; candidate <= RANGE_MAX; candidate++) {
            if (isSolution(candidate)) return getConcatenatedSequence(candidate);
        }
        return NOT_FOUND;
    }

    public static boolean isSolution(int candidate) {
        return isPrimeSequence(candidate) &&
                isPermutationSequence(candidate) &&
                candidate != GIVEN_EXAMPLE;
    }

    public static boolean isPrimeSequence(int candidate) {
        for (int step = 0; step < NUM_ITEMS; step++) {
            int number = candidate + step * STEP_SIZE;
            if (!Prime.checkPrime(number)) return false;
        }
        return true;
    }

    public static boolean isPermutationSequence(int candidate) {
        char[] sortedChars = getSortedChars(candidate);
        for (int step = 1; step < NUM_ITEMS; step++) {
            char[] sortedChars2 = getSortedChars(candidate + STEP_SIZE * step);
            if (!Arrays.equals(sortedChars, sortedChars2)) return false;
        }
        return true;
    }

    public static char[] getSortedChars(int candidate) {
        char[] chars = ("" + candidate).toCharArray();
        java.util.Arrays.sort(chars);
        return chars;
    }

    public static long getConcatenatedSequence(int candidate) {
        String sequence = "";
        for (int step = 0; step < NUM_ITEMS; step++) sequence += candidate + step * STEP_SIZE;
        return Long.parseLong(sequence);
    }
}
