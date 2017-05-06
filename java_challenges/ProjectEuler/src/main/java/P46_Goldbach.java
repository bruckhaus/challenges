import java.io.IOException;
import java.util.TreeSet;

public class P46_Goldbach {
    // Project Euler - Problem 46 - Goldbach's other conjecture
    // It was proposed by Christian Goldbach that every odd composite number
    // can be written as the sum of a prime and twice a square.
    //            9 = 7 + 2 × 1^2
    //            15 = 7 + 2 × 2^2
    //            21 = 3 + 2 × 3^2
    //            25 = 7 + 2 × 3^2
    //            27 = 19 + 2 × 2^2
    //            33 = 31 + 2 × 1^2
    // It turns out that the conjecture was false.
    // What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

    public static void main(String[] args) throws IOException {
        long smallest = new P46_Goldbach().findSmallest();
        String message = "The smallest odd composite that cannot be written " +
                "as the sum of a prime and twice a square is %d.\n";
        System.out.printf(message, smallest);
    }

    private static Prime primes;

    public TreeSet<Long> generated = new TreeSet<>();

    private final long NOT_FOUND = Long.MIN_VALUE;
    private long lastPrime = 0;
    private int primeIndex = 1;

    static {
        try {
            primes = new Prime1stMillion();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error:" + e.getMessage());
        }
    }

    P46_Goldbach() throws IOException {
        generated.clear();
        primes = new Prime1stMillion();
        lastPrime = 0;
        primeIndex = 1;
    }

    public long findSmallest() {
        long prime;
        long missing;
        while (true) {
            prime = primes.get(primeIndex);
            generateAndAddAll(prime);
            missing = searchMissing(prime);
            if (missing != NOT_FOUND) return missing;
            lastPrime = prime;
            primeIndex++;
        }
    }

    public void generateAndAddAll(long prime) {
        generateAndAddWithPrime(prime);
        generateAndAddWithSquare(prime);
    }

    public void generateAndAddWithPrime(long prime) {
        for (long l = 1; l <= prime; l++) {
            generateAndAdd(prime, l);
        }
    }

    public void generateAndAddWithSquare(long prime) {
        generateAndAddWithSquare(prime, lastPrime + 1);
    }

    public void generateAndAddWithSquare(long prime, long start) {
        for (int i = 1; i <= primeIndex; i++) {
            long previousPrime = primes.get(i);
            for (long j = start; j <= prime; j++) {
                generateAndAdd(previousPrime, j);
            }
        }
    }

    public void generateAndAdd(long prime, long l) {
        long newNumber = (long) (prime + 2 * Math.pow(l, 2));
        generated.add(newNumber);
    }

    private long searchMissing(long number) {
        for (long i = getLastChecked(); i <= number + 2; i += 2) {
            if (isMissing(i)) return i;
        }
        return NOT_FOUND;
    }

    private boolean isMissing(long i) {
        return !primes.isPrime(i) && !generated.contains(i);
    }

    private long getLastChecked() {
        return Math.max(9, lastPrime);
    }
}
