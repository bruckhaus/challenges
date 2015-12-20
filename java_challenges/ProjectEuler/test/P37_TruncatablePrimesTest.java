import org.junit.Test;

import static org.junit.Assert.*;

public class P37_TruncatablePrimesTest {

    @Test
    public void testIsTruncatable() throws Exception {
        assertFalse(P37_TruncatablePrimes.isTruncatable(14));
        assertTrue(P37_TruncatablePrimes.isTruncatable(3797));
    }

    @Test
    public void testSumTruncatables() throws Exception {
        P37_TruncatablePrimes t = new P37_TruncatablePrimes();
        assertEquals(748317, t.sumTruncatables());
    }

    @Test
    public void testChopFirstDigit() throws Exception {
        P37_TruncatablePrimes.leftRight left = P37_TruncatablePrimes.leftRight.LEFT;
        assertEquals(23456789, P37_TruncatablePrimes.chopDigit(left, 123456789));
        assertEquals(3456789, P37_TruncatablePrimes.chopDigit(left, 23456789));
        assertEquals(456789, P37_TruncatablePrimes.chopDigit(left, 3456789));
        assertEquals(56789, P37_TruncatablePrimes.chopDigit(left, 456789));
        assertEquals(6789, P37_TruncatablePrimes.chopDigit(left, 56789));
        assertEquals(789, P37_TruncatablePrimes.chopDigit(left, 6789));
        assertEquals(89, P37_TruncatablePrimes.chopDigit(left, 789));
        assertEquals(9, P37_TruncatablePrimes.chopDigit(left, 89));
        assertEquals(0, P37_TruncatablePrimes.chopDigit(left, 9));
        assertEquals(0, P37_TruncatablePrimes.chopDigit(left, -1));
    }
}