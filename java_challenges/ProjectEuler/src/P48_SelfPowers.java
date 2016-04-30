import java.math.BigInteger;

public class P48_SelfPowers {
    // Project Euler - Problem 48 - Self powers
    // The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
    // Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

    private static final int LIMIT = 1000;
    private static final int DIGITS = 10;

    public static void main(String[] args) {
        long solution = P48_SelfPowers.getSelfPowerSumLast(LIMIT, DIGITS);
        String message = "The last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000 is ";
        System.out.printf(message + "%,d\n", solution);
    }

    public static long getSelfPowerSumLast(int limit, int digits) {
        BigInteger selfPowerSum = getSelfPowerSum(limit);
        return getLast(selfPowerSum, digits);
    }

    public static BigInteger getSelfPowerSum(int limit) {
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= limit; i++) sum = sum.add(getSelfPower(i));
        return sum;
    }

    public static BigInteger getSelfPower(int i) {
        BigInteger iAsBigInteger = new BigInteger(i + "");
        return iAsBigInteger.pow(i);
    }

    public static long getLast(BigInteger bigInteger, int digits) {
        String stringInteger = "" + bigInteger;
        int length = stringInteger.length();
        String lastDigits = stringInteger.substring(length - digits);
        return Long.parseLong(lastDigits);
    }
}
