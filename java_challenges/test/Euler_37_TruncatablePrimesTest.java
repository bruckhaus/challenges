import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_37_TruncatablePrimesTest {

    @Test
    public void testIsTruncatable() throws Exception {
        assertFalse(Euler_37_TruncatablePrimes.isTruncatable(14));
        assertTrue(Euler_37_TruncatablePrimes.isTruncatable(3797));
    }

    @Test
    public void testSumTruncatables() throws Exception {
        Euler_37_TruncatablePrimes t = new Euler_37_TruncatablePrimes();
        assertEquals(748317, t.sumTruncatables());
    }

    @Test
    public void testChopFirstDigit() throws Exception {
        assertEquals(23456789, Euler_37_TruncatablePrimes.chopFirstDigit(123456789));
        assertEquals(3456789, Euler_37_TruncatablePrimes.chopFirstDigit(23456789));
        assertEquals(456789, Euler_37_TruncatablePrimes.chopFirstDigit(3456789));
        assertEquals(56789, Euler_37_TruncatablePrimes.chopFirstDigit(456789));
        assertEquals(6789, Euler_37_TruncatablePrimes.chopFirstDigit(56789));
        assertEquals(789, Euler_37_TruncatablePrimes.chopFirstDigit(6789));
        assertEquals(89, Euler_37_TruncatablePrimes.chopFirstDigit(789));
        assertEquals(9, Euler_37_TruncatablePrimes.chopFirstDigit(89));
        assertEquals(0, Euler_37_TruncatablePrimes.chopFirstDigit(9));
        assertEquals(0, Euler_37_TruncatablePrimes.chopFirstDigit(-1));
    }
}