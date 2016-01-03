import org.junit.Test;

import static org.junit.Assert.*;

public class P51_PrimeDigitReplacementsTest {

    @Test
    public void findReplaceablePrime() throws Exception {
        assertEquals(121313, P51_PrimeDigitReplacements.findReplaceablePrime(8));
        assertEquals(2, P51_PrimeDigitReplacements.findReplaceablePrime(4));
        assertEquals(11, P51_PrimeDigitReplacements.findReplaceablePrime(5));
        assertEquals(13, P51_PrimeDigitReplacements.findReplaceablePrime(6));
        assertEquals(56003, P51_PrimeDigitReplacements.findReplaceablePrime(7));
    }

    @Test
    public void getPrimeCount() throws Exception {
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(2));
        assertEquals(5, P51_PrimeDigitReplacements.getPrimeCount(11));
        assertEquals(6, P51_PrimeDigitReplacements.getPrimeCount(13));
        assertEquals(5, P51_PrimeDigitReplacements.getPrimeCount(1001));
        assertEquals(2, P51_PrimeDigitReplacements.getPrimeCount(3083));
        assertEquals(7, P51_PrimeDigitReplacements.getPrimeCount(56003));
        assertEquals(8, P51_PrimeDigitReplacements.getPrimeCount(121313));
    }

    @Test
    public void getPrimeCount1() throws Exception {
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(2, 1));
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(11, 1));
        assertEquals(5, P51_PrimeDigitReplacements.getPrimeCount(11, 2));
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(13, 1));
        assertEquals(6, P51_PrimeDigitReplacements.getPrimeCount(13, 2));
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(101, 1));
        assertEquals(5, P51_PrimeDigitReplacements.getPrimeCount(101, 2));
        assertEquals(1, P51_PrimeDigitReplacements.getPrimeCount(101, 3));
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(101, 4));
        assertEquals(1, P51_PrimeDigitReplacements.getPrimeCount(101, 5));
        assertEquals(4, P51_PrimeDigitReplacements.getPrimeCount(101, 6));
        assertEquals(0, P51_PrimeDigitReplacements.getPrimeCount(101, 7));
        assertEquals(3, P51_PrimeDigitReplacements.getPrimeCount(229, 1));
        assertEquals(0, P51_PrimeDigitReplacements.getPrimeCount(1001, 9));
        assertEquals(0, P51_PrimeDigitReplacements.getPrimeCount(1001, 15));
        assertEquals(2, P51_PrimeDigitReplacements.getPrimeCount(3083, 1));
        assertEquals(7, P51_PrimeDigitReplacements.getPrimeCount(56003, 6));
        assertEquals(1, P51_PrimeDigitReplacements.getPrimeCount(56003, 15));
        assertEquals(0, P51_PrimeDigitReplacements.getPrimeCount(56003, 31));
        assertEquals(8, P51_PrimeDigitReplacements.getPrimeCount(121313, 42));
    }

    @Test
    public void isInPrimeFamily() throws Exception {
        assert (P51_PrimeDigitReplacements.isInPrimeFamily(11, 17));
        assert (!P51_PrimeDigitReplacements.isInPrimeFamily(11, 1));
    }

    @Test
    public void isSameLength() throws Exception {
        assert (P51_PrimeDigitReplacements.isSameLength(11, 17));
        assert (!P51_PrimeDigitReplacements.isSameLength(11, 7));
    }
}