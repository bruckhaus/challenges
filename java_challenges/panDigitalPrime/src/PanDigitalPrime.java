public class PanDigitalPrime {

    private int maxLength;
    private PanDigital panDigital;
    private long maxPrime = -1;

    public PanDigitalPrime(int length) {
        maxLength = length;
        panDigital = new PanDigital(maxLength);
        maxPrime();
    }

    public static void main(String[] args) {
        new PanDigitalPrime(4).maxPrime();
    }

    public long maxPrime() {
        long p = panDigital.get();
        while (p != -1) {
            System.out.println(p + checkPrime(p));
            p = panDigital.next();
        }
        System.out.println("The maximum pandigital prime of length up to " + maxLength + " is " + maxPrime + ".");
        return maxPrime;
    }

    private String checkPrime(long p) {
        if (PrimeChecker.isPrime(p)) {
            if (p > maxPrime) maxPrime = p;
            return " *";
        } else return "";
    }

}
