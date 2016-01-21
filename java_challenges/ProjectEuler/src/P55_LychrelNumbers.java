public class P55_LychrelNumbers {
    // Project Euler - Problem 55 - Lychrel numbers
    // If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
    // Not all numbers produce palindromes so quickly. For example,
    // 349 + 943 = 1292, 1292 + 2921 = 4213, 4213 + 3124 = 7337
    // That is, 349 took three iterations to arrive at a palindrome.
    // Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
    // A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
    // Due to the theoretical nature of these numbers, and for the purpose of this problem,
    // we shall assume that a number is Lychrel until proven otherwise.
    // In addition you are given that for every number below ten-thousand,
    // it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one,
    // with all the computing power that exists, has managed so far to map it to a palindrome.
    // In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome:
    // 4668731596684224866951378664 (53 iterations, 28-digits).
    // Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
    // How many Lychrel numbers are there below ten-thousand?
    // NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.

    public static void main(String[] args) {
        String message = "The number of Lychrel numbers that exist below ten-thousand is %,d.\n";
        int solution = P55_LychrelNumbers.getLychrelCount(LIMIT);
        System.out.printf(message, solution);
    }

    private static final int LIMIT = 10000;
    private static final int ITERATION_LIMIT = 50;

    static int getLychrelCount(int limit) {
        int count = 0;
        for (int candidate = 1; candidate <= limit; candidate++) {
            if (!isLychrelNumber(candidate)) {
                System.out.println("candidate = " + candidate);
                count++;
            }
        }
        return count;
    }

    static boolean isLychrelNumber(int number) {
        for (int iteration = 1; iteration <= ITERATION_LIMIT; iteration++) {
            number = getLychrelTransform(number);
            if (isPalindrome(number)) return true;
        }
        return false;
    }

    static boolean isPalindrome(int number) {
        String numberString = "" + number;
        int rightPointer = numberString.length() - 1;
        for (int leftPointer = 0; true; leftPointer++) {
            if (leftPointer >= rightPointer) return true;
            if (numberString.charAt(leftPointer) != numberString.charAt(rightPointer)) return false;
            rightPointer--;
        }
    }

    static int getLychrelTransform(int number) {
        String reverse = new StringBuffer("" + number).reverse().toString();
        return Integer.parseInt("" + number + reverse);
    }
}
