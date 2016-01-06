import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P38_PandigitalMultiplesTest {

    @Test
    public void testGetMultiple() throws Exception {
        assertEquals(9, P38_PandigitalMultiples.getMultiple(9, 1));
        assertEquals(123456789, P38_PandigitalMultiples.getMultiple(1, 9));
        assertEquals(918273645, P38_PandigitalMultiples.getMultiple(9, 5));
        assertEquals(926718534, P38_PandigitalMultiples.getMultiple(9267, 2));
        assertEquals(927318546, P38_PandigitalMultiples.getMultiple(9273, 2));
        assertEquals(932718654, P38_PandigitalMultiples.getMultiple(9327, 2));
        assertEquals(123246369492615738L, P38_PandigitalMultiples.getMultiple(123, 6));
        assertEquals(9182736455463728190L, P38_PandigitalMultiples.getMultiple(9, 10));
    }

    @Test
    public void testIsPandigital() throws Exception {
        assertEquals(false, P38_PandigitalMultiples.isPandigital(4));
        assertEquals(true, P38_PandigitalMultiples.isPandigital(123456789));
        assertEquals(true, P38_PandigitalMultiples.isPandigital(214365798));
        assertEquals(true, P38_PandigitalMultiples.isPandigital(918273645));
        assertEquals(true, P38_PandigitalMultiples.isPandigital(926718534));
        assertEquals(true, P38_PandigitalMultiples.isPandigital(932718654));
        assertEquals(true, P38_PandigitalMultiples.isPandigital(987654321));
        assertEquals(false, P38_PandigitalMultiples.isPandigital(12345678));
        assertEquals(false, P38_PandigitalMultiples.isPandigital(123456788));
        assertEquals(false, P38_PandigitalMultiples.isPandigital(1234567890));
    }

    @Test
    public void testFindLargestPandigitalMultiple() throws Exception {
        assertEquals(932718654, P38_PandigitalMultiples.findLargestPandigitalMultiple());
    }
}