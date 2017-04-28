import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonalNumberTest {
    @Test
    public void testToString() throws Exception {
        PolygonalNumber p = new PolygonalNumber(3, 18);
        assertEquals("p(3,18)=171", p.toString());
    }

    @Test
    public void testGetValue() throws Exception {
        PolygonalNumber p = new PolygonalNumber(3, 18);
        assertEquals(new Long(171), p.getValue());
    }

    @Test
    public void testGetBase() throws Exception {
        PolygonalNumber p = new PolygonalNumber(3, 18);
        assertEquals(new Integer((3)), p.getBase());
    }

    @Test
    public void testGetLength() throws Exception {
        PolygonalNumber p = new PolygonalNumber(3, 88);
        assertEquals(4, p.getLength()); // p(3,88)=7744, a four-digit number
    }

    @Test
    public void testCalculate() throws Exception {
        assertEquals(new Long(-1), new PolygonalNumber(2, 18).calculate());
        assertEquals(new Long(-1), new PolygonalNumber(9, 18).calculate());
        assertEquals(new Long(153), new PolygonalNumber(3, -18).calculate());
        assertEquals(new Long(171), new PolygonalNumber(3, 18).calculate());
        assertEquals(new Long(7_744), new PolygonalNumber(4, 88).calculate());
        assertEquals(new Long(30_135), new PolygonalNumber(6, 123).calculate());
        assertEquals(new Long(622_896), new PolygonalNumber(8, 456).calculate());
        assertEquals(new Long(299_980_000), new PolygonalNumber(8, 10_000).calculate());
        assertEquals(new Long(2_926_383_171_394_604_481L), // 2 quintillion
                new PolygonalNumber(8, 987_654_321).calculate());
    }
}
