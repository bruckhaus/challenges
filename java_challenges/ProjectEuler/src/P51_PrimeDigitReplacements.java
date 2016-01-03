import java.io.IOException;

public class P51_PrimeDigitReplacements {
    // Project Euler - Problem 51 - Prime digit replacements
    // By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible
    // values: 13, 23, 43, 53, 73, and 83, are all prime.
    // By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the
    // first example having seven primes among the ten generated numbers, yielding the family:
    // 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
    // Consequently 56003, being the first member of this family, is the smallest prime with this property.
    // Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
    // with the same digit, is part of an eight prime value family.

    public static void main(String[] args) throws IOException {
        flagShowDiagnosticOutput = true;
        long solution = P51_PrimeDigitReplacements.findReplaceablePrime(8);
        String message = "The smallest prime which, by replacing part of the number " +
                "with the same digit, is part of an eight prime value family is: %,d\n";
        System.out.printf(message, solution);
    }

    private static boolean flagShowDiagnosticOutput = false;
    private static Prime primes;
    private static long smallestPrime = -1;
    private static long solutionPrime = -1;
    private static int solutionCount = 0;
    private static int solutionPositionCode = 0;

    static {
        try {
            primes = new Prime1stMillion();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }

    static long findReplaceablePrime(int count) throws IOException {
        solutionCount = 0;
        for (int i = 1; i < 1000000; i++) {
            long prime = primes.get(i);
            if (getPrimeCount(prime) == count) return solutionPrime;
        }
        return -1;
    }

    static int getPrimeCount(long prime) {
        int result = -1;
        int positionCode = 1;
        while (DigitNumber.isValidPositionCode(prime, positionCode)) {
            int count = getPrimeCount(prime, positionCode);
            if (count > result) result = count;
            if (count > solutionCount) {
                solutionCount = count;
                solutionPrime = smallestPrime;
                solutionPositionCode = positionCode;
                showSolution();
            }
            positionCode++;
        }
        return result;
    }

    static int getPrimeCount(long prime, int positionCode) {
        int count = 0;
        smallestPrime = -1;
        for (int newValue = 0; newValue <= 9; newValue++) {
            long replacement = DigitNumber.replacePositions(prime, positionCode, newValue);
            if (isInPrimeFamily(prime, replacement)) {
                count++;
                if (smallestPrime == -1) smallestPrime = replacement;
            }
        }
        return count;
    }

    static boolean isInPrimeFamily(long prime, long replacement) {
        return isSameLength(prime, replacement) &&
                primes.isPrime(replacement);
    }

    static boolean isSameLength(long prime, long replacement) {
        return ("" + replacement).length() ==
                ("" + prime).length();
    }

    private static void showSolution() {
        if (!flagShowDiagnosticOutput) return;
        System.out.printf(
                "Solution prime: %,d, replacement prime count: %d, position code: %d\nReplacements:\n",
                solutionPrime, solutionCount, solutionPositionCode);
        for (int newValue = 0; newValue <= 9; newValue++) {
            long replacement = DigitNumber.replacePositions(solutionPrime, solutionPositionCode, newValue);
            String primeMarker = isInPrimeFamily(solutionPrime, replacement) ? "*" : "";
            System.out.printf("  new value: %d, %,d %s\n", newValue, replacement, primeMarker);
        }
    }
}
