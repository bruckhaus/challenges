public class P64_OddPeriodSquareRoots {

    private static final int UPPER_BOUND = 10_000;

    public static void main(String[] args) {
        String message = "There are %,d continued fractions for N ≤ 10,000 that have an odd period.\n";
        int fractions = countFractions();
        System.out.printf(message, fractions);
    }

    static int countFractions() {
        int fractions = 0;
        for (int n = 2; n < UPPER_BOUND; n++) {
            if (hasNaturalRoot(n)) continue;
            int period = getPeriod(n);
            if (period % 2 == 1) fractions++;
        }
        return fractions;
    }

    static boolean hasNaturalRoot(int n) {
        return (int) Math.sqrt(n) == Math.sqrt(n);
    }

    static int getPeriod(int n) {
        int lowerBound = (int) Math.sqrt(n);
        int period = 0;
        int remainder = 1;
        int approximation = 0;
        int upperBound = lowerBound;
        do {
            approximation = remainder * upperBound - approximation;
            remainder = (n - approximation * approximation) / remainder;
            if (remainder == 0) break;
            upperBound = (lowerBound + approximation) / remainder;
            period++;
        } while (upperBound != 2 * lowerBound);
        return period;
    }
}
