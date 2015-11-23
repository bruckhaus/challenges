import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PrimeTest {

    @Test
    public void testIsPrime() throws Exception {
        Prime prime = new Prime();
        int[] positiveTests = new int[]{2, 3, 5, 7, 11, 13, 17, 29, 71, 113, 173, 4657};
        int[] negativeTests = new int[]{4, 6, 8, 12, 14, 15, 21, 35, 1431, 3327, 4653};
        for (int i : positiveTests) {
            assertEquals(String.format("%d is prime but method returns false", i), true, prime.isPrime(i));
        }
        for (int i : negativeTests) {
            assertEquals(String.format("%d is not prime but method returns true", i), false, prime.isPrime(i));
        }
    }
}