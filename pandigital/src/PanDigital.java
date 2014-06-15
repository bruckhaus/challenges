/*  http://projecteuler.net/problem=41
    Pandigital prime
    Problem 41
    We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
    For example, 2143 is a 4-digit pandigital and is also prime.
    What is the largest n-digit pandigital prime that exists?
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PanDigital {

    private int length = 1;
    private int maxLength = 9;
    private long maxPrime = -1;
    private int[] position = resetPosition();
    private static ArrayList<String> Digits =
            new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    public static void main(String[] args) {
        new PanDigital().panDigital();
    }

    public long panDigital() {
        long p = get();
        while (p != -1) {
            System.out.println(p + checkPrime(p));
            p = next();
        }
        System.out.println("maxPrime = " + maxPrime);
        return maxPrime;
    }

    private String checkPrime(long p) {
        if (isPrime(p)) {
            if (p > maxPrime) {
                maxPrime = p;
            }
            return " *";
        } else {
            return "";
        }
    }

    private static boolean isPrime(long p) {
        for (long l = 2; l <= p / 2; l++) {
            if (p % l == 0) {
                return false;
            }
        }
        return true;
    }

    public long get() {
        String result = "";
        ArrayList<String> digits = new ArrayList<String>(Digits);
        for (int i = 0; i < length; i++) {
            result += digits.get(position[i]);
            digits.remove(position[i]);
        }
        return Integer.valueOf(result);
    }

    public long next() {
        for (int i = 0; i < length; i++) {
            if (i + position[i] < length - 1) {
                position[i]++;
                return get();
            } else {
                position[i] = 0;
            }
        }
        if (length < maxLength) {
            length++;
            position = resetPosition();
            return get();
        } else {
            return -1;
        }
    }

    private int[] resetPosition() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

}