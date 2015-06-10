import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class PowerSum {

    /*
     * Complete the function below.
     *  PowerSum   Coding
        Simple maths maths medium
        QUESTION DESCRIPTION
        You are given two integers, l and r. Find the number of integers x such that l <= x <= r,
        and x is a Power Number.
        A Power Number is defined as an integer that can be represented as sum of two powers, i.e.

            x = ap + bq,
            a, b, p and q are all integers,
            a, b ≥ 0, and
            p, q > 1.

        You have to complete function int countPowerNumbers(int l, int r), which takes the arguments l and r
        and returns the result as described above. The code to process input and output is already provided.

        Constraints
        1 ≤ l ≤ r ≤ 5,000,000

        Sample Input #1
        l = 0
        r = 1
        Sample Output #1:
        2
        Explanation #1:
        0 and 1 both are Power Numbers. 0 = 02+02. 1 = 12+02.

        Sample Input #2:
        l = 25
        r = 30
        Sample Output #2:
        5
        Explanation #2:
        Except 30, all are Power Numbers.
            25 = 52 + 02,
            26 = 52 + 12,
            27 = 33 + 02,
            28 = 33 + 12,
            29 = 55 + 22.
     */

    private static Set<Integer> powerSums = newHashSet();

    static int countPowerNumbers(int l, int r) {
        initializePowerSums(r);
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (powerSums.contains(i)) {
//                System.out.println("counting: " + i);
                count ++;
            }
        }
        return count;
    }

    private static void initializePowerSums(int limit) {
        for (int a = 0; a <= limit; a++){
            for (int b = a; a + b <= limit; b++) {
                for (int p = 2; Math.pow(a, p) <= limit; p++) {
                    for (int q = 2; Math.pow(a, p) + Math.pow(b, q) <= limit; q++) {
                        int powerNumber = (int) (Math.pow(a, p) + Math.pow(b, q));
//                        System.out.println("adding: " + powerNumber +
//                                " (a:" + a + ", b:" + b + ", p: " + p + ", q: " + q +")");
                        powerSums.add(powerNumber);
                        if (b <= 1) break;
                    }
                    if (a <= 1) break;
                }
            }
        }
    }
}
