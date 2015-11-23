import java.util.HashSet;

public class Prime {
    private static Integer last = 2;
    private static HashSet<Integer> primes = new HashSet<>();

    public Prime() {
        primes.add(2);
    }

    public static void main(String[] args) {
//        Prime p = new Prime();
//        System.out.println("primes = " + primes);
//        isPrime(3);
//        System.out.println("primes = " + primes);
    }

    public static Boolean isPrime(Integer tested) {
        if (primes.contains(tested)) return true;
        if (tested <= last) return false;
        while (last < tested) {
            last++;
            if (lastIsPrime()) {
//                System.out.println("last = " + last);
                primes.add((int)last);
            }
        }
        return primes.contains(tested);
    }

    private static boolean lastIsPrime() {
        for (Integer i = 2; i <= Math.sqrt(last); i++) {
            if (primes.contains(i)) {
                if (last % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
