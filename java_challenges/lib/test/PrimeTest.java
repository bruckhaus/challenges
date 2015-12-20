import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PrimeTest {

    @Test
    public void testNext() throws Exception {
        assertEquals(3, Prime.next());
        assertEquals(5, Prime.next());
        assertEquals(7, Prime.next());
        assertEquals(11, Prime.next());
        assertEquals(13, Prime.next());
        assertEquals(17, Prime.next());
        assertEquals(19, Prime.next());
        assertEquals(23, Prime.next());
        assertEquals(29, Prime.next());
        assertEquals(31, Prime.next());
    }

    @Test
    public void testIsPrime() throws Exception {
        int[] positiveTests = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 29, 71, 113, 173, 4657}; //, 7652413};
        int[] negativeTests = new int[]{4, 6, 8, 12, 14, 15, 21, 35, 1431, 3327, 4653};
        for (int i : positiveTests) {
            assertEquals(String.format("%d is prime but method returns false", i), true, Prime.isPrime(i));
        }
        for (int i : negativeTests) {
            assertEquals(String.format("%d is not prime but method returns true", i), false, Prime.isPrime(i));
        }
    }

    @Test
    public void testGetFactorSet() throws Exception {
        checkPrimeFactorSet(new Long[]{2L, 7L}, 14);
        checkPrimeFactorSet(new Long[]{3L, 5L}, 15);
        checkPrimeFactorSet(new Long[]{2L, 7L, 23L}, 644);
        checkPrimeFactorSet(new Long[]{3L, 5L, 43L}, 645);
        checkPrimeFactorSet(new Long[]{2L, 17L, 19L}, 646);
        checkPrimeFactorSet(new Long[]{3L, 7L, 13L, 491L}, 134043);
        checkPrimeFactorSet(new Long[]{2L, 23L, 31L, 47L}, 134044);
        checkPrimeFactorSet(new Long[]{5L, 17L, 19L, 83L}, 134045);
        checkPrimeFactorSet(new Long[]{2L, 3L, 11L, 677L}, 134046);
    }

    private void checkPrimeFactorSet(Long[] factors, int number) {
        assertArrayEquals(factors, Prime.getFactorSet(number).toArray());
    }
}