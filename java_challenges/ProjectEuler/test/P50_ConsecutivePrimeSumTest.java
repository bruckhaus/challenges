import org.junit.Test;

import static org.junit.Assert.*;

public class P50_ConsecutivePrimeSumTest {

    @Test
    public void findMost() throws Exception {
        P50_ConsecutivePrimeSum p50 = new P50_ConsecutivePrimeSum();
        assertEquals(997651, p50.findMost());
    }

    @Test
    public void checkFirst() throws Exception {
        P50_ConsecutivePrimeSum p50;
        p50 = new P50_ConsecutivePrimeSum();
        assertEquals(997651, p50.checkFirst(4));
        p50 = new P50_ConsecutivePrimeSum();
        assertEquals(779827, p50.checkFirst(555));
    }

    @Test
    public void getPrimeSum() throws Exception {
        P50_ConsecutivePrimeSum p50 = new P50_ConsecutivePrimeSum();
        assertEquals(41, p50.getPrimeSum(1, 6));
        assertEquals(997651, p50.getPrimeSum(4, 4 + 543 - 1));
        assertEquals(539, p50.getPrimeSum(10, 20));
        assertEquals(1003653, p50.getPrimeSum(111, 555));
        assertEquals(1761144, p50.getPrimeSum(890, 1111));
    }
}