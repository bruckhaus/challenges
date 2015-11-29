public class Euler_41_PandigitalPrime {

    // Project Euler - Problem 41 - Pandigital prime
    // Problem 41
    // We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
    // For example, 2143 is a 4-digit pandigital and is also prime.
    // What is the largest n-digit pandigital prime that exists?
    // Solution: The largest pandigital prime is 7652413

    public static void main(String[] args) {
        long largest = Euler_41_PandigitalPrime.findLargestPandigital();
        System.out.printf("\nThe largest pandigital prime is %d\n", largest);
    }

    private static long findLargestPandigital() {
        long last = 0;
        while (Pandigital.hasNext()) {
            Pandigital.next();
//            System.out.printf(".");
            if (Prime.isPrime(Pandigital.current)) {
//                System.out.printf("\nFound prime pandigital: %d\n", Pandigital.current);
                last = Pandigital.current;
            }
        }
        return last;
    }
}
