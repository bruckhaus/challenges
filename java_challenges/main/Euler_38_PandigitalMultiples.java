/**
 * Euler Pandigital multiples
 * Problem 38
 * Take the number 192 and multiply it by each of 1, 2, and 3: 192 × 1 = 192, 192 × 2 = 384, 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576.
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
 * giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed
 * as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */

public class Euler_38_PandigitalMultiples {

    public static final int MAX_PANDIGITAL = 987654321;
    private static final int MAX_CANDIDATE = MAX_PANDIGITAL / 3; // c * 1 + c * 2 <= max pandigital

    public static void main(String[] arg) {
        int candidate = 1;
        int sequence = 2;
        int product = 0;
        int solution_candidate = 0;
        int solution_sequence = 0;
        int solution_pandigital = 0;
        for (candidate = 1; candidate <= MAX_CANDIDATE; candidate++) {
            while (product < MAX_PANDIGITAL) {
                int result = getMultiple(candidate, sequence);
                if (isPandigital(result)) {
                    solution_candidate = candidate;
                    solution_sequence = sequence;
                    solution_pandigital = result;
                }
                sequence++;
            }
        }
        printSolution(solution_candidate, solution_sequence, solution_pandigital);
    }

    private static int getMultiple(int candidate, int sequence) {
        return 0;
    }

    private static boolean isPandigital(int result) {
        return false;
    }

    private static void printSolution(int solution_candidate, int solution_sequence, int solution_pandigital) {
        System.out.printf("The largest pandigital multiple is:\n");
        System.out.printf("%d * 1\n", solution_candidate);
        for (int i = 1; i <= solution_sequence; i++) {
            System.out.printf("+ %d * i:\n", solution_candidate);
        }
        System.out.printf("= %d", solution_pandigital);
    }
}
