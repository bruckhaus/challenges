import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSum {
    // PowerSum - Coding - Simple maths maths medium - QUESTION DESCRIPTION
    // Complete the function below.
    // You are given two integers, l and r. Find the number of integers x such that l <= x <= r,
    // and x is a Power Number.
    // A Power Number is defined as an integer that can be represented as sum of two powers, i.e.
    //    x = ap + bq,
    //    a, b, p and q are all integers,
    //    a, b ≥ 0, and
    //    p, q > 1.
    // You have to complete function int countPowerNumbers(int l, int r), which takes the arguments l and r
    // and returns the result as described above. The code to process input and output is already provided.
    // Constraints
    // 1 ≤ l ≤ r ≤ 5,000,000
    // Sample Input #1
    // l = 0
    // r = 1
    // Sample Output #1:
    // 2
    // Explanation #1:
    // 0 and 1 both are Power Numbers. 0 = 0^2 + 0^2. 1 = 1^2 + 0^2.
    // Sample Input #2:
    // l = 25
    // r = 30
    // Sample Output #2:
    // 5
    // Explanation #2:
    // Except 30, all are Power Numbers.
    //    25 = 5^2 + 0^2,
    //    26 = 5^2 + 1^2,
    //    27 = 3^3 + 0^2,
    //    28 = 3^3 + 1^2,
    //    29 = 5^2 + 2^2.

    private static List<Long> powerNumbers = new ArrayList<>();
    private static Set<Long> powerSums = new HashSet<>();

    public static void main(String[] args) {
        int i = 25;
        int j = 30;
        int sum = countPowerNumbers(i, j);
        System.out.printf("The count of power numbers between %d and %d is %d.\n", i, j, sum);
    }

    static int countPowerNumbers(int l, int r) {
        powerSums.clear();
        initializePowerNumbers(r);
        for (Long p1 : powerNumbers) {
            for (Long p2 : powerNumbers) {
                if (p1 + p2 >= l && p1 + p2 <= r) powerSums.add(p1 + p2);
            }
        }
        return powerSums.size();
    }

    private static void initializePowerNumbers(int limit) {
        powerNumbers.clear();
        powerNumbers.add(0L);
        powerNumbers.add(1L);
        for (int i = 2; i <= limit; i++) {
            Long powerNumber = (long) i * i;
            while (true) {
                if (powerNumber > limit) break;
                powerNumbers.add(powerNumber);
                powerNumber *= i;
            }
        }
    }
}
