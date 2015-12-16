public class PrimeChecker {

    public static boolean isPrime(long p) {
        p = Math.abs(p);
        if (p < 2) return false;
        if (p == 2) return true;
        if (p == 3) return true;
        if ((p & 1) == 0) return false;
        if (isDivisibleByThree(p)) return false;
        for (long l = 5; l <= Math.sqrt(p); l += 2) if (p % l == 0) return false;
        return true;
    }

    private static boolean isDivisibleByThree(long p) {
        while (p > 9) p = threesDigitSum(p);
        return (p == 0 | p == 3 || p == 6 || p == 9);
    }

    private static int threesDigitSum(long p) {
        int digitSum = 0;
        String s = "" + p;
        for (int i = 0; i < s.length(); i++) {
            Integer digit = Integer.valueOf(s.substring(i, i + 1));
            if (digit != 0 && digit != 3 && digit != 6 && digit != 9) digitSum += digit;
        }
        return digitSum;
    }
}