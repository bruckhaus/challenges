import org.junit.Test;

import static org.junit.Assert.*;

public class PandigitalOfVariableLengthTest {

    @Test
    public void testNext() throws Exception {
        PandigitalOfVariableLength p3 = new PandigitalOfVariableLength(3);
        assertEquals(12, p3.next());
        assertEquals(21, p3.next());
        assertEquals(123, p3.next());
        assertEquals(132, p3.next());
        assertEquals(213, p3.next());
        assertEquals(231, p3.next());
        assertEquals(312, p3.next());
        assertEquals(321, p3.next());
        assertEquals(-1, p3.next());
        PandigitalOfVariableLength p9 = new PandigitalOfVariableLength(9);
        assertEquals(12, p9.next());
        assertEquals(21, p9.next());
        assertEquals(123, p9.next());
        for (int i = 1; i <= 100; i++) p9.next();
        assertEquals(35421, p9.next());
        for (int i = 1; i <= 1000; i++) p9.next();
        assertEquals(1375624, p9.next());
        for (int i = 1; i <= 10000; i++) p9.next();
        assertEquals(21456783, p9.next());
        for (int i = 1; i <= 100000; i++) p9.next();
        assertEquals(269173548, p9.next());
    }

    @Test
    public void testList() throws Exception {
        assert new PandigitalOfVariableLength(1).list().equals("1");
        assert new PandigitalOfVariableLength(2).list().equals("1, 12, 21");
        assert new PandigitalOfVariableLength(3).list().equals("1, 12, 21, 123, 132, 213, 231, 312, 321");
        assert new PandigitalOfVariableLength(4).list().equals("1, 12, 21, 123, 132, 213, 231, 312, 321, " +
                "1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, " +
                "3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321");
    }
}
