public class P50_ConsecutivePrimeSum {
    // Project Euler - Problem 50 - Consecutive prime sum
    // The prime 41, can be written as the sum of six consecutive primes:
    //         41 = 2 + 3 + 5 + 7 + 11 + 13
    // This is the longest sum of consecutive primes that adds to a prime below one-hundred.
    // The longest sum of consecutive primes below one-thousand that adds to a prime,
    // contains 21 terms, and is equal to 953.
    // Which prime, below one-million, can be written as the sum of the most consecutive primes?

    public static void main(String[] args) {
        long solution = findMost();
        String message = "The prime, below one-million, " +
                "that can be written as the sum of the most consecutive primes is %d.\n";
        System.out.printf(message, solution);
    }

    private static final int LIMIT = 1000000;
    private static Prime prime = new Prime();
    private static int mostTerms = 0;
    private static int terms = 1;

    private static long findMost() {
        int startIndex = 1;
        long solution = 2;
        while (true) {
            long sum = getSum(startIndex);
            if (terms > mostTerms && sum < LIMIT) {
                mostTerms = terms;
                solution = sum;
                System.out.print("startIndex = " + startIndex);
                System.out.print(", terms = " + terms);
                System.out.println(", sum = " + sum);
            }
            if (prime.get(startIndex) > LIMIT) return solution;
            startIndex++;
        }
    }

    private static long getSum(int index) {
        long sum = prime.get(index);
        index++;
        int run = 2;
        long nextSum = sum + prime.get(index);
        while (prime.isPrime(nextSum)) {
            sum = nextSum;
            index++;
            run++;
            nextSum = sum + prime.get(index);
        }
        terms = run - 1;
        System.out.printf("index = %,d, prime = %,d, terms = %,d, sum = %,d\n",
                index, prime.get(index), terms, sum);
        return sum;
    }
}
