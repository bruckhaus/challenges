import org.junit.Test;

public class PanDigitalTest {

    @Test
    public void testPanDigital() throws Exception {
        assert new PanDigital(9).maxPrime() == 7652413;
    }

    @Test
    public void testPrime() {
        assert !Prime.isPrime(0);
        assert !Prime.isPrime(1);
        assert Prime.isPrime(2);
        assert Prime.isPrime(3);
        assert !Prime.isPrime(4);
        assert Prime.isPrime(5);
        assert !Prime.isPrime(6);
        assert Prime.isPrime(7);
        assert !Prime.isPrime(8);
        assert !Prime.isPrime(9);
        assert !Prime.isPrime(10);
        assert Prime.isPrime(11);
        assert !Prime.isPrime(12);
        assert Prime.isPrime(13);
        assert !Prime.isPrime(14);
        assert !Prime.isPrime(15);
        assert !Prime.isPrime(16);
        assert Prime.isPrime(17);
        assert !Prime.isPrime(18);
        assert Prime.isPrime(19);
        assert !Prime.isPrime(20);
        assert !Prime.isPrime(21);
        assert !Prime.isPrime(22);
        assert Prime.isPrime(23);
        assert !Prime.isPrime(24);
        assert !Prime.isPrime(25);
        assert !Prime.isPrime(26);
        assert !Prime.isPrime(27);
        assert !Prime.isPrime(28);
        assert Prime.isPrime(29);
        assert !Prime.isPrime(30);
        assert !Prime.isPrime(255);
        assert !Prime.isPrime(256);
        assert !Prime.isPrime(369);
        assert !Prime.isPrime(290);
        assert !Prime.isPrime(492);
        assert !Prime.isPrime(876);
        assert !Prime.isPrime(2092);
        assert !Prime.isPrime(2877);
        assert !Prime.isPrime(2991);
        assert Prime.isPrime(7652413);
        assert !Prime.isPrime(76654321);
        assert !Prime.isPrime(200000000);
        assert !Prime.isPrime(200000001);
        assert !Prime.isPrime(222299876);
        assert !Prime.isPrime(222299877);

    }
}