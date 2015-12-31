import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Prime1stMillionTest {

    @Test
    public void testGet() throws Exception {
        Prime prime = new Prime1stMillion();
        assertEquals(2, prime.get(1));
        assertEquals(3, prime.get(2));
        assertEquals(5, prime.get(3));
        assertEquals(7, prime.get(4));
        assertEquals(11, prime.get(5));
        assertEquals(13, prime.get(6));
        assertEquals(17, prime.get(7));
        assertEquals(29, prime.get(10));
        assertEquals(541, prime.get(100));
        assertEquals(7919, prime.get(1000));
        assertEquals(104729, prime.get(10000));
        assertEquals(1299709, prime.get(100000));
    }


    @Test
    public void testIsPrime() throws Exception {
        Prime prime = new Prime1stMillion();
        String message;
        for (Long l : getPrimes()) {
            message = String.format("%d is prime but method returns false", l);
            assertEquals(message, true, prime.isPrime(l));
        }
        for (Long l : getNonPrimes(getPrimes())) {
            message = String.format("%d is not prime but method returns true", l);
            assertEquals(message, false, prime.isPrime(l));
        }
    }


    // Test helper:
    private List<Long> getPrimes() {
        List<Long> primes = new ArrayList<>(Arrays.asList(SAMPLE_PRIMES));
        primes.addAll(Arrays.asList(LARGE_PRIMES));
        return primes;
    }

    // Test helper:
    private List<Long> getNonPrimes(List<Long> primes) {
        List<Long> nonPrimes = new ArrayList<>(Arrays.asList(SAMPLE_NON_PRIMES));
        primes.addAll(Arrays.asList(LARGE_NON_PRIMES));
        return nonPrimes;
    }

    private static final Long[] SAMPLE_PRIMES = new Long[]
            {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 71L, 113L, 173L, 4657L};
    private static final Long[] LARGE_PRIMES = new Long[]{7652413L};
    private static final Long[] SAMPLE_NON_PRIMES = new Long[]
            {0L, 1L, 4L, 6L, 8L, 9L, 10L, 12L, 14L, 15L, 16L, 18L, 20L, 21L, 22L, 24L, 25L, 26L, 27L, 28L, 30L, 35L,
                    255L, 256L, 290L, 369L, 492L, 876L, 1431L, 2092L, 2877L, 2991L, 3327L, 4653L};
    private static final Long[] LARGE_NON_PRIMES = new Long[]
            {76654321L, 200000000L, 200000001L, 222299876L, 222299877L};
}