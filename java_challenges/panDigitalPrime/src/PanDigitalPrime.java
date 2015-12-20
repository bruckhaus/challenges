public class PanDigitalPrime {

    private PanDigital panDigital;
    private long maxPrime = -1;
    public static boolean outputToStdout = false;

    public static void main(String[] args) {
        PanDigitalPrime.outputToStdout();
        int length = 4;
        long solution = new PanDigitalPrime(length).maxPrime();
        System.out.printf("The maximum pandigital prime of length up to %d is %,d.\n", length, solution);
    }

    public PanDigitalPrime(int length) {
        panDigital = new PanDigital(length);
    }

    public long maxPrime() {
        long p = panDigital.get();
        while (p != -1) {
            Boolean isPrime = Prime.checkPrime(p);
            if (isPrime && p > maxPrime) maxPrime = p;
            if (outputToStdout) System.out.println(p + markPrime(isPrime));
            p = panDigital.next();
        }
        return maxPrime;
    }

    private String markPrime(boolean prime) {
        return prime ? " *" : "";
    }

    private static void outputToStdout() {
        outputToStdout = true;
    }
}
