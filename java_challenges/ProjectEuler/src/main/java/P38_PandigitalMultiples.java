public class P38_PandigitalMultiples {
    // Project Euler - Problem 38 - Pandigital Multiples
    // Take the number 192 and multiply it by each of 1, 2, and 3: 192 × 1 = 192, 192 × 2 = 384, 192 × 3 = 576
    // By concatenating each product we get the 1 to 9 pandigital, 192384576.
    // We will call 192384576 the concatenated product of 192 and (1,2,3)
    // The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
    // giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
    // What is the largest 1 to 9 pandigital 9-digit number that can be formed
    // as the concatenated product of an integer with (1,2, ... , n) where n > 1?
    // Correct: 932718654 = 9327 * 1 || 9327 * 2
    // See: http://www.mathblog.dk/project-euler-38-pandigital-multiplying-fixed-number/

    private static boolean printToStdOut = false;

    private static final long MAX_PANDIGITAL = 987654321;

    // see: http://www.mathblog.dk/project-euler-38-pandigital-multiplying-fixed-number/
    private static final long MIN_CANDIDATE = 9234;
    private static final long MAX_CANDIDATE = 9487;

    private static long solution_candidate = 0;
    private static long solution_sequence = 0;
    private static long solution_multiple = 0;

    public static void main(String[] args) {
        printToStdOut = true;
        findLargestPandigitalMultiple();
    }

    public static long findLargestPandigitalMultiple() {
        for (long candidate = MIN_CANDIDATE; candidate <= MAX_CANDIDATE; candidate++) {
            long sequence = 2;
            long multiple = 0;
            while (multiple < MAX_PANDIGITAL) {
                multiple = getMultiple(candidate, sequence);
                if (multiple > solution_multiple && isPandigital(multiple)) {
                    solution_candidate = candidate;
                    solution_sequence = sequence;
                    solution_multiple = multiple;
                    printSolution();
                }
                sequence++;
            }
        }
        return solution_multiple;
    }

    public static long getMultiple(long candidate, long sequence) {
        long multiple;
        String concatenatedMultiple = "";
        for (int i = 1; i <= sequence; i++) {
            concatenatedMultiple += (candidate * i);
        }
        multiple = Long.parseLong(concatenatedMultiple);
        return multiple;
    }

    public static boolean isPandigital(long number) {
        String numberAsString = number + "";
        if (numberAsString.length() != 9) return false;
        for (int i = 1; i <= 9; i++) {
            String digit = i + "";
            if (!numberAsString.contains(digit)) return false;
        }
        return true;
    }

    private static void printSolution() {
        if (!printToStdOut) return;
        System.out.printf("\nFound pandigital:\n");
        System.out.printf("   %d * 1\n", solution_candidate);
        for (int i = 2; i <= solution_sequence; i++) {
            System.out.printf("|| %d * %d\n", solution_candidate, i);
        }
        System.out.printf("= %d\n", solution_multiple);
    }
}
