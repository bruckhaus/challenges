import org.junit.Test;

import static org.junit.Assert.*;

public class PentagonalTest {

    @Test
    public void testReset() throws Exception {
        Pentagonal.reset();
        assertEquals(0, Pentagonal.current());
        Pentagonal.next();
        Pentagonal.next();
        assertEquals(5, Pentagonal.current());
        Pentagonal.reset();
        assertEquals(0, Pentagonal.current());
    }

    @Test
    public void testCurrent() throws Exception {
        Pentagonal.reset();
        assertEquals(0, Pentagonal.current());
        Pentagonal.next();
        assertEquals(1, Pentagonal.current());
        Pentagonal.next();
        assertEquals(5, Pentagonal.current());
    }

    @Test
    public void testNext() throws Exception {
        Pentagonal.reset();
        assertEquals(1, Pentagonal.next());
        assertEquals(5, Pentagonal.next());
        assertEquals(12, Pentagonal.next());
        assertEquals(22, Pentagonal.next());
        assertEquals(35, Pentagonal.next());
    }
}