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
 *
 * The largest pandigital multiple is:
 6,455,257 * 1
 + 6,455,257 * 1:
 + 6,455,257 * 2:
 + 6,455,257 * 3:
 + 6,455,257 * 4:
 + 6,455,257 * 5:
 + 6,455,257 * 6:
 + 6,455,257 * 7:
 + 6,455,257 * 8:
 + 6,455,257 * 9:
 + 6,455,257 * 10:
 + 6,455,257 * 11:
 + 6,455,257 * 12:
 + 6,455,257 * 13:
 + 6,455,257 * 14:
 + 6,455,257 * 15:
 + 6,455,257 * 16:
 + 6,455,257 * 17:
 = 987,654,321

 Correct:
 932718654
 http://www.mathblog.dk/project-euler-38-pandigital-multiplying-fixed-number/
 */

public class Euler_38_PandigitalMultiples {

    private static final long MAX_PANDIGITAL = 987654321;
    private static final long MAX_CANDIDATE = MAX_PANDIGITAL / 3; // c * 1 + c * 2 <= max pandigital

    private static long solution_candidate = 0;
    private static long solution_sequence = 0;
    private static long solution_multiple = 0;

    public static void main(String[] args) {
        for (long candidate = 1; candidate <= MAX_CANDIDATE; candidate++) {
            long sequence = 2;
            long multiple = 0;
            while (multiple < MAX_PANDIGITAL) {
                multiple = getMultiple(candidate, sequence);
                if (multiple > solution_multiple && isPandigital(multiple)) {
                    solution_candidate = candidate;
                    solution_sequence = sequence;
                    solution_multiple = multiple;
                }
                sequence++;
            }
        }
        printSolution();
    }

    private static int getMultiple(long candidate, long sequence) {
        int multiple = 0;
        for (int i = 1; i <= sequence; i++) {
            multiple += candidate * i;
        }
        return multiple;
    }

    private static boolean isPandigital(long result) {
        String s = result + "";
        if (s.length() != 9) return false;
        for (int i = 1; i <= 9; i++) {
            String digit = i + "";
            if (!s.contains(digit)) return false;
        }
        System.out.printf("Found pandigital: %d\n", result);
        return true;
    }

    private static void printSolution() {
        System.out.printf("The largest pandigital multiple is:\n");
        System.out.printf("%d * 1\n", solution_candidate);
        for (int i = 1; i <= solution_sequence; i++) {
            System.out.printf("+ %d * %d:\n", solution_candidate, i);
        }
        System.out.printf("= %d\n", solution_multiple);
    }
}
