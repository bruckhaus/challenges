import static org.apache.commons.math3.util.CombinatoricsUtils.binomialCoefficient;

public class P53_CombinatoricSelections {
    // Project Euler - Problem 53 - Combinatoric selections
    // There are exactly ten ways of selecting three from five, 12345:
    //        123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
    // In combinatorics, we use the notation, 5C3 = 10.
    // In general, nCr = n! / r!(n−r)!, where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
    // It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
    // How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are greater than one-million?

    public static void main(String[] args) {
        int solution = P53_CombinatoricSelections.getCountGreater(MAX, LIMIT);
        String message = "The count of not necessarily distinct " +
                "values of nCr, for 1 ≤ n ≤ 100, which are greater than one-million, is %,d.\n";
        System.out.printf(message, solution);
    }

    private static final int MAX = 100;
    private static final int LIMIT = 1000000;

    static int getCountGreater(int max, int limit) {
        int count = 0;
        for (int n = 1; n <= max; n++) {
            count += getCountGreaterForN(n, limit);
        }
        return count;
    }

    static int getCountGreaterForN(int n, int limit) {
        int count = 0;
        for (int j = 0; j <= n / 2; j++) {
            if (choose(n, j) > limit) {
                count += n + 1 - 2 * (j);
                break;
            }
        }
        return count;
    }

    static long choose(int i, int j) {
        return binomialCoefficient(i, j);
    }
}
