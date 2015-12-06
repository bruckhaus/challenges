import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_41_PandigitalPrimeTest {

    @Test
    public void testFindLargestPandigital() throws Exception {
        Pandigital.setLength(7);
        assertEquals(7652413, Euler_41_PandigitalPrime.findLargestPandigital());
    }
}