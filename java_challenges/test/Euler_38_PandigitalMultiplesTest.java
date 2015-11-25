import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_38_PandigitalMultiplesTest {

    @Test
    public void testGetMultiple() throws Exception {
        assertEquals(9, Euler_38_PandigitalMultiples.getMultiple(9, 1));
        assertEquals(123456789, Euler_38_PandigitalMultiples.getMultiple(1, 9));
        assertEquals(918273645, Euler_38_PandigitalMultiples.getMultiple(9, 5));
        assertEquals(926718534, Euler_38_PandigitalMultiples.getMultiple(9267, 2));
        assertEquals(927318546, Euler_38_PandigitalMultiples.getMultiple(9273, 2));
        assertEquals(932718654, Euler_38_PandigitalMultiples.getMultiple(9327, 2));
        assertEquals(123246369492615738L, Euler_38_PandigitalMultiples.getMultiple(123, 6));
        assertEquals(9182736455463728190L, Euler_38_PandigitalMultiples.getMultiple(9, 10));
    }

    @Test
    public void testIsPandigital() throws Exception {
        assertEquals(false, Euler_38_PandigitalMultiples.isPandigital(4));
        assertEquals(true, Euler_38_PandigitalMultiples.isPandigital(123456789));
        assertEquals(true, Euler_38_PandigitalMultiples.isPandigital(214365798));
        assertEquals(true, Euler_38_PandigitalMultiples.isPandigital(918273645));
        assertEquals(true, Euler_38_PandigitalMultiples.isPandigital(926718534));
        assertEquals(true, Euler_38_PandigitalMultiples.isPandigital(932718654));
        assertEquals(true, Euler_38_PandigitalMultiples.isPandigital(987654321));
        assertEquals(false, Euler_38_PandigitalMultiples.isPandigital(12345678));
        assertEquals(false, Euler_38_PandigitalMultiples.isPandigital(123456788));
        assertEquals(false, Euler_38_PandigitalMultiples.isPandigital(1234567890));
    }

    @Test
    public void testFindLargestPandigitalMultiple() throws Exception {
        assertEquals(932718654, Euler_38_PandigitalMultiples.findLargestPandigitalMultiple());
    }
}