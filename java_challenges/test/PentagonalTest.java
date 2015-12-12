import org.junit.Test;

import static org.junit.Assert.*;

public class PentagonalTest {

    @Test
    public void testReset() throws Exception {
        Pentagonal p = new Pentagonal();
        p.reset();
        assertEquals(0, p.current());
        p.next();
        p.next();
        assertEquals(5, p.current());
        p.reset();
        assertEquals(0, p.current());
    }

    @Test
    public void testCurrent() throws Exception {
        Pentagonal p = new Pentagonal();
        p.reset();
        assertEquals(0, p.current());
        p.next();
        assertEquals(1, p.current());
        p.next();
        assertEquals(5, p.current());
    }

    @Test
    public void testNext() throws Exception {
        Pentagonal p = new Pentagonal();
        p.reset();
        assertEquals(1, p.next());
        assertEquals(5, p.next());
        assertEquals(12, p.next());
        assertEquals(22, p.next());
        assertEquals(35, p.next());
    }
}