import java.io.IOException;


public class P50_ConsecutivePrimeSum {
    // Project Euler - Problem 50 - Consecutive prime sum
    // The prime 41, can be written as the sum of six consecutive primes:
    //         41 = 2 + 3 + 5 + 7 + 11 + 13
    // This is the longest sum of consecutive primes that adds to a prime below one-hundred.
    // The longest sum of consecutive primes below one-thousand that adds to a prime,
    // contains 21 terms, and is equal to 953.
    // Which prime, below one-million, can be written as the sum of the most consecutive primes?

    public static void main(String[] args) throws IOException {
        P50_ConsecutivePrimeSum p50 = new P50_ConsecutivePrimeSum();
        p50.flagShowSolution = true;
        long solution = p50.findMost();
        String message = "The prime, below one-million, " +
                "that can be written as the sum of the most consecutive primes is %d.\n";
        System.out.printf(message, solution);
    }

    private final int LIMIT = 1000000;

    @SuppressWarnings("FieldCanBeLocal")
    private boolean flagShowDetails = false;
    private boolean flagShowSolution = false;

    private int solutionFirst = 1;
    private int solutionTerms = 1;
    private long solutionPrime = 2;

    private Prime primes;
    private long[] primeSums = new long[LIMIT];

    P50_ConsecutivePrimeSum() throws IOException {
        primes = new Prime1stMillion();
        setPrimeSums();
    }

    long findMost() {
        int first = 1;
        while (!doneFindMost(first)) {
            checkFirst(first);
            first++;
        }
        return solutionPrime;
    }

    long checkFirst(int first) {
        int last = first;
        int terms = 1;
        long primeSum = 0;
        while (!doneCheckFirst(last, primeSum)) {
            primeSum = getPrimeSum(first, last);
            if (isBetterSolution(primeSum, terms)) updateSolution(first, last, primeSum);
            terms++;
            last++;
        }
        return solutionPrime;
    }

    private boolean isBetterSolution(long primeSum, int terms) {
        return terms > solutionTerms &&
                primeSum <= LIMIT &&
                primes.isPrime(primeSum);
    }

    private void updateSolution(int first, int last, long primeSum) {
        solutionFirst = first;
        solutionPrime = primeSum;
        solutionTerms = last - first + 1;
        showSolution();
    }

    private boolean doneFindMost(int first) {
        return first > LIMIT ||
                primes.get(first) > LIMIT;
    }

    private boolean doneCheckFirst(int last, long primeSum) {
        return primeSum > LIMIT ||
                primes.get(last) > LIMIT ||
                last > LIMIT;
    }

    public long getPrimeSum(int first, int last) {
        return primeSums[last] - primeSums[first - 1];
    }

    private void setPrimeSums() {
        primeSums[1] = primes.get(1);
        for (int i = 2; i < LIMIT; i++) {
            primeSums[i] = primeSums[i - 1] + primes.get(i);
        }
    }

    private void showSolution() {
        if (!flagShowSolution) return;
        System.out.printf("startIndex = %d, terms = %d, sum = %d\n",
                solutionFirst, solutionTerms, solutionPrime);
        if (!flagShowDetails) return;
        for (int i = solutionFirst; i < solutionFirst + solutionTerms; i++) {
            System.out.printf("  prime(%d) = %d\n", i, primes.get(i));
        }
    }
}
