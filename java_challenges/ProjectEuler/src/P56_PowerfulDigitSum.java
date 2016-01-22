import java.math.BigInteger;

public class P56_PowerfulDigitSum {
    // Project Euler - Problem 56 - Powerful digit sum
    // A googol (10^100) is a massive number: one followed by one-hundred zeros;
    // 100^100 is almost unimaginably large: one followed by two-hundred zeros.
    // Despite their size, the sum of the digits in each number is only 1.
    // Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?

    public static final int LIMIT = 100;

    public static void main(String[] args) {
        String message = "The maximum digit sum of a^b, where a, b < 100, is %,d.\n";
        int solution = P56_PowerfulDigitSum.getPowerfulDigitSum(LIMIT);
        System.out.printf(message, solution);
    }

    static int getPowerfulDigitSum(int limit) {
        int maxDigitSum = 0;
        for (int i = 1; i < limit; i++) {
            for (int j = 1; j < limit; j++) {
                BigInteger pow = new BigInteger("" + i).pow(j);
                int digitSum = DigitNumber.getDigitSum(pow);
                if (digitSum > maxDigitSum) {
                    maxDigitSum = digitSum;
                }
            }
        }
        return maxDigitSum;
    }
}
