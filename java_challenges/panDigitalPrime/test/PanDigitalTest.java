import org.junit.Test;

public class PanDigitalTest {

    @Test
    public void testPanDigitalPrime() throws Exception {
        assert new PanDigitalPrime(9).maxPrime() == 7652413;
    }

    @Test
    public void testPandigital() {
        assert new PanDigital(1).list().equals("1");
        assert new PanDigital(2).list().equals("1, 12, 21");
        assert new PanDigital(3).list().equals("1, 12, 21, 123, 132, 213, 231, 312, 321");
        assert new PanDigital(4).list().equals("1, 12, 21, 123, 132, 213, 231, 312, 321, " +
                "1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, " +
                "3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321");
    }

    @Test
    public void testPrime() {
        assert !PrimeChecker.isPrime(0);
        assert !PrimeChecker.isPrime(1);
        assert PrimeChecker.isPrime(2);
        assert PrimeChecker.isPrime(3);
        assert !PrimeChecker.isPrime(4);
        assert PrimeChecker.isPrime(5);
        assert !PrimeChecker.isPrime(6);
        assert PrimeChecker.isPrime(7);
        assert !PrimeChecker.isPrime(8);
        assert !PrimeChecker.isPrime(9);
        assert !PrimeChecker.isPrime(10);
        assert PrimeChecker.isPrime(11);
        assert !PrimeChecker.isPrime(12);
        assert PrimeChecker.isPrime(13);
        assert !PrimeChecker.isPrime(14);
        assert !PrimeChecker.isPrime(15);
        assert !PrimeChecker.isPrime(16);
        assert PrimeChecker.isPrime(17);
        assert !PrimeChecker.isPrime(18);
        assert PrimeChecker.isPrime(19);
        assert !PrimeChecker.isPrime(20);
        assert !PrimeChecker.isPrime(21);
        assert !PrimeChecker.isPrime(22);
        assert PrimeChecker.isPrime(23);
        assert !PrimeChecker.isPrime(24);
        assert !PrimeChecker.isPrime(25);
        assert !PrimeChecker.isPrime(26);
        assert !PrimeChecker.isPrime(27);
        assert !PrimeChecker.isPrime(28);
        assert PrimeChecker.isPrime(29);
        assert !PrimeChecker.isPrime(30);
        assert !PrimeChecker.isPrime(255);
        assert !PrimeChecker.isPrime(256);
        assert !PrimeChecker.isPrime(369);
        assert !PrimeChecker.isPrime(290);
        assert !PrimeChecker.isPrime(492);
        assert !PrimeChecker.isPrime(876);
        assert !PrimeChecker.isPrime(2092);
        assert !PrimeChecker.isPrime(2877);
        assert !PrimeChecker.isPrime(2991);
        assert PrimeChecker.isPrime(7652413);
        assert !PrimeChecker.isPrime(76654321);
        assert !PrimeChecker.isPrime(200000000);
        assert !PrimeChecker.isPrime(200000001);
        assert !PrimeChecker.isPrime(222299876);
        assert !PrimeChecker.isPrime(222299877);

    }
}