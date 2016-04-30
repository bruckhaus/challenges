import java.util.Arrays;

public class P52_PermutedMultiples {
// Project Euler - Problem 52 -Permuted multiples
// It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits,
// but in a different order.
// Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

    public static void main(String[] args) {
        int solution = P52_PermutedMultiples.findSmallestPermutedMultiple(6);
        String message = "The smallest positive integer, x, " +
                "such that 2x, 3x, 4x, 5x, and 6x, contain the same digits, is %,d.\n";
        System.out.printf(message, solution);
    }

    static int findSmallestPermutedMultiple(int limit) {
        for (int i = 1; true; i++) if (hasSameDigitMultiples(i, limit)) return i;
    }

    static boolean hasSameDigitMultiples(int i, int limit) {
        char[] digits = DigitNumber.getSortedDigits(i);
        for (int factor = 2; factor <= limit; factor++) {
            char[] multipleDigits = DigitNumber.getSortedDigits(i * factor);
            if (!Arrays.equals(digits, multipleDigits)) return false;
        }
        return true;
    }
}
