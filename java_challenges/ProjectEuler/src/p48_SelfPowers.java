import java.math.BigInteger;

public class P48_SelfPowers {
    // Project Euler - Problem 48 - Self powers
    // The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
    // Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.

    public static void main(String[] args) {
        long last10 = P48_SelfPowers.findLast10();
        System.out.printf("The last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000 = %,d\n", last10);
    }

    private static long findLast10() {
        BigInteger result = new BigInteger("0");
        for (int i = 1; i <= 1000; i++) {
            BigInteger power = new BigInteger(i + "");
            power = power.pow(i);
            result = result.add(power);
        }
        String stringResult = "" + result;
        int len = stringResult.length();
        String last10 = stringResult.substring(len - 10);
        return Long.parseLong(last10);
    }
}
