/*
Project Euler
Truncatable primes
Problem 37
The number 3797 has an interesting property. Being prime itself,
it is possible to continuously remove digits from left to right,
and remain prime at each stage: 3797, 797, 97, and 7.
Similarly we can work from right to left: 3797, 379, 37, and 3.
Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/

public class Euler_37_TruncatablePrimes {
    public static final int NUMBER_OF_TRUNCATABLES = 11;
    public static final int FIRST_ELIGIBLE_NUMBER = 11;

    private static int current = FIRST_ELIGIBLE_NUMBER;
    private static int count = 0;
    private static int sum = 0;

    public static void main(String[] args) {
        Euler_37_TruncatablePrimes t = new Euler_37_TruncatablePrimes();
        System.out.printf("\nThe sum of truncatable primes is %d.", t.sumTruncatables());
    }

    public int sumTruncatables() {
        while (count < NUMBER_OF_TRUNCATABLES) {
            if (isTruncatable(current)) {
                count++;
                sum += current;
            }
            current++;
        }
        return sum;
    }

    public static boolean isTruncatable(int i) {
        return isLeftTruncatable(i) && isRightTruncatable(i);
    }

    private static boolean isLeftTruncatable(int number) {
        while (number > 0) {
            if (!Prime.isPrime(number)) return false;
            number = chopFirstDigit(number);
        }
        return true;
    }

    private static boolean isRightTruncatable(int number) {
        while (number > 0) {
            if (!Prime.isPrime(number)) return false;
            number = number / 10;
        }
        return true;
    }

    public static int chopFirstDigit(int number) {
        if (number < 10) return 0;
        return Integer.parseInt((number + "").substring(1));
    }
}
