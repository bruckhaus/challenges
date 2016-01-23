import java.math.BigInteger;

public class P57_SquareRootConvergents {
    // Project Euler - Problem 57 - Square root convergents
    // It is possible to show that the square root of two can be expressed as an infinite continued fraction.
    // √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
    // By expanding this for the first four iterations, we get:
    //        1 + 1/2 = 3/2 = 1.5
    //        1 + 1/(2 + 1/2) = 7/5 = 1.4
    //        1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
    //        1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
    // The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985,
    // is the first example where the number of digits in the numerator exceeds the number of digits in
    // the denominator. In the first one-thousand expansions, how many fractions contain a numerator
    // with more digits than denominator?

    private static final int LIMIT = 1000;

    public static void main(String[] args) {
        String message = "";
        int count = P57_SquareRootConvergents.getCount(LIMIT);
        System.out.printf("The number of fractions containing a numerator " +
                "having more digits than the denominator has is %,d.\n", count);
    }

    static int getCount(int limit) {
        int count = 0;
        BigInteger numerator = new BigInteger("3");
        BigInteger bitInteger_2 = new BigInteger("2");
        BigInteger denominator = bitInteger_2;
        for (int i = 1; i <= limit; i++) {
            BigInteger temp = denominator.multiply(bitInteger_2);
            BigInteger nextNumerator = numerator.add(temp);
            denominator = numerator.add(denominator);
            numerator = nextNumerator;
            if (hasMoreDigits(numerator, denominator)) count++;
        }
        return count;
    }

    static boolean hasMoreDigits(BigInteger number1, BigInteger number2) {
        return ("" + number1).length() > ("" + number2).length();
    }
}
