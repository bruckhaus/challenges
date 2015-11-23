/*
Truncatable primes
Problem 37
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem_37_TruncatablePrimes {
    private static int count = 0;
    private static int current = 11;
    private static int sum = 0;
    private static int chunk = 0;
//    private static Prime prime = new Prime();

    int max = 2;
    Set<Integer> primes = new HashSet<>();


    public static void main(String[] args) {
        Problem_37_TruncatablePrimes t = new Problem_37_TruncatablePrimes();
        t.sumTruncatables();
        System.out.printf("The sum of truncatables is %d", sum);
    }

    private void sumTruncatables() {
        int checkPoint = 100000;
        while (count < 11) {
            if (isTruncatable(current)) {
                count++;
                sum += current;
                System.out.printf("\nFound truncatable %d, sum: %d",current, sum);
            }
//            System.out.printf(".");
            if (current % checkPoint == 0) {
                System.out.printf("%d\n", current);
            }
            current++;
        }
    }

    private boolean isTruncatable(int current) {
        return isLeftTruncatable(current) && isRightTruncatable(current);
    }

    private boolean isLeftTruncatable(int current) {
        int length = (int) Math.log10(current);
        int chunk = current;
        while (chunk > 0) {
            if (!isPrime(chunk))
                return false;
            chunk = (int) (chunk - Math.pow(10, length));
            length--;
        }
        return true;
    }

    private boolean isRightTruncatable(int current) {
        while (chunk > 0) {
            if (!isPrime(chunk)) {
                return false;
            }
            chunk = chunk / 10;
        }
        return true;
    }

    public Boolean isPrime(int tested) {
        if (primes.contains(tested)) return true;
        if (tested <= max) return false;
        while (max < tested) {
            if (maxIsPrime()) {
                primes.add(max);
            }
            max++;
        }
        return primes.contains(tested);
    }

    private boolean maxIsPrime() {
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (primes.contains(i)) {
                if (max % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
