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
    private int maxLength = -1;
    private int[] position;
    private static ArrayList<String> Digits =
            new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    public PanDigital(int length) {
        maxLength = length;
        resetPosition();
    }

    public long get() {
        String result = "";
        ArrayList<String> digits = new ArrayList<>(Digits);
        for (int i = 0; i < length; i++) result += digits.remove(position[i]);
        return Integer.valueOf(result);
    }

    public long next() {
        for (int i = length - 2; i >= 0; i--) {
            if (position[i] + i < length - 1) {
                position[i]++;
                return get();
            } else position[i] = 0;
        }
        if (length < maxLength) {
            length++;
            resetPosition();
            return get();
        } else return -1;
    }

    public String list() {
        String result = "" + get();
        Long p = next();
        while (p != -1) {
            result += ", " + p;
            p = next();
        }
        System.out.println(result);
        return result;
    }

    private void resetPosition() {
        position = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}