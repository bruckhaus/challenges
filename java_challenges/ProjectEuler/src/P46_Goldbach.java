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

    public static void main(String[] args) {
        long smallest = P46_Goldbach.findSmallest();
        String message = "The smallest odd composite that cannot be written " +
                "as the sum of a prime and twice a square is %d.\n";
        System.out.printf(message, smallest);
    }

    private static final long NOT_FOUND = Long.MIN_VALUE;
    public static TreeSet<Long> generated = new TreeSet<>();
    private static long lastPrime = 0;

    public static long findSmallest() {
        long prime = 2;
        long missing;
        while (true) {
            generateAndAddAll(prime);
            missing = searchMissing(prime);
            if (missing != NOT_FOUND) return missing;
            lastPrime = prime;
            prime = Prime.next();
        }
    }

    public static void generateAndAddAll(long prime) {
        generateAndAddWithPrime(prime);
        generateAndAddWithSquare(prime);
    }

    public static void generateAndAddWithPrime(long prime) {
        for (long i = 1; i <= prime; i++) {
            generateAndAdd(prime, i);
        }
    }

    public static void generateAndAddWithSquare(long prime) {
        generateAndAddWithSquare(prime, lastPrime + 1);
    }

    public static void generateAndAddWithSquare(long prime, long last) {
        for (long previousPrime : Prime.primes) {
            for (long i = last; i <= prime; i++) {
                generateAndAdd(previousPrime, i);
            }
        }
    }

    public static void generateAndAdd(long prime, long i) {
        long newNumber = (long) (prime + 2 * Math.pow(i, 2));
        generated.add(newNumber);
    }

    private static long searchMissing(long number) {
        for (long i = getLastChecked(); i <= number + 2; i += 2) {
            if (isMissing(i)) return i;
        }
        return NOT_FOUND;
    }

    private static boolean isMissing(long i) {
        return !Prime.isPrime(i) && !generated.contains(i);
    }

    private static long getLastChecked() {
        return Math.max(9, lastPrime);
    }

    public static void reset() {
        generated.clear();
        lastPrime = 0;
        Prime.reset();
    }
}
