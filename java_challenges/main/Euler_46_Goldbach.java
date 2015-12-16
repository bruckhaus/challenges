public class Euler_46_Goldbach {
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
        int smallest = Euler_46_Goldbach.findSmallest();
        String message = "The smallest odd composite that cannot be written " +
                "as the sum of a prime and twice a square is %d.\n";
        System.out.printf(message, smallest);
    }

    private static int findSmallest() {
//        loop over primes
        while (true) {
            long p = Prime.next();
        }
//        generate numbers
        
//        check if any missing
//        track largest checked
        return -1;
    }
}
