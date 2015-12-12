import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonalTest {

    @Test
    public void testReset() throws Exception {
        Pentagonal pentagonal = new Pentagonal();
        pentagonal.reset();
        assertEquals(0, pentagonal.current());
        pentagonal.next();
        pentagonal.next();
        assertEquals(5, pentagonal.current());
        pentagonal.reset();
        assertEquals(0, pentagonal.current());
    }

    @Test
    public void testCurrent() throws Exception {
        Pentagonal pentagonal = new Pentagonal();
        pentagonal.reset();
        assertEquals(0, pentagonal.current());
        pentagonal.next();
        assertEquals(1, pentagonal.current());
        pentagonal.next();
        assertEquals(5, pentagonal.current());
    }

    @Test
    public void testTriangular() throws Exception {
        Triangular triangular = new Triangular();
        triangular.reset();
        assertEquals(1, triangular.next());
        assertEquals(3, triangular.next());
        assertEquals(6, triangular.next());
        assertEquals(10, triangular.next());
        assertEquals(15, triangular.next());
    }

    @Test
    public void testPentagonal() throws Exception {
        Pentagonal pentagonal = new Pentagonal();
        pentagonal.reset();
        assertEquals(1, pentagonal.next());
        assertEquals(5, pentagonal.next());
        assertEquals(12, pentagonal.next());
        assertEquals(22, pentagonal.next());
        assertEquals(35, pentagonal.next());
    }
    @Test
    public void testHexagonal() throws Exception {
        Hexagonal hexagonal = new Hexagonal();
        hexagonal.reset();
        assertEquals(1, hexagonal.next());
        assertEquals(6, hexagonal.next());
        assertEquals(15, hexagonal.next());
        assertEquals(28, hexagonal.next());
        assertEquals(45, hexagonal.next());
    }
}