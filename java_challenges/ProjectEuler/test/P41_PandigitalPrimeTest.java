import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P41_PandigitalPrimeTest {

    @Test
    public void testFindLargestPandigital() throws Exception {
        Pandigital.setLength(7);
        assertEquals(7652413, P41_PandigitalPrime.findLargestPandigitalPrime());
    }
}