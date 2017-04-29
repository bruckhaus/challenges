import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolygonalTest {

    @Test
    public void testReset() throws Exception {
        Polygonal pentagonal = new Pentagonal();
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
        Polygonal pentagonal = new Pentagonal();
        pentagonal.reset();
        assertEquals(0, pentagonal.current());
        pentagonal.next();
        assertEquals(1, pentagonal.current());
        pentagonal.next();
        assertEquals(5, pentagonal.current());
    }

    @Test
    public void testFunction() throws Exception {
        Polygonal triangular = new Triangular();
        Polygonal pentagonal = new Pentagonal();
        Polygonal hexagonal = new Hexagonal();
        assertEquals(7626, triangular.function(123));
        assertEquals(82017, pentagonal.function(234));
        assertEquals(1560090, pentagonal.function(1020));
        assertEquals(7042750, pentagonal.function(2167));
        assertEquals(415416, hexagonal.function(456));
    }

    @Test
    public void testIsPolygonal() throws Exception {
        Polygonal triangular = new Triangular();
        Polygonal pentagonal = new Pentagonal();
        Polygonal hexagonal = new Hexagonal();
        assert(triangular.isPolygonal(7626));
        assert(pentagonal.isPolygonal(82017));
        assert(hexagonal.isPolygonal(415416));
    }

    @Test
    public void testTriangular() throws Exception {
        // Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
        Polygonal triangular = new Triangular();
        triangular.reset();
        assertEquals(1, triangular.next());
        assertEquals(3, triangular.next());
        assertEquals(6, triangular.next());
        assertEquals(10, triangular.next());
        assertEquals(15, triangular.next());
    }

    @Test
    public void testSquare() throws Exception {
        // Square	 	P4,n=n2	 	1, 4, 9, 16, 25, ...
        Polygonal square = new Square();
        square.reset();
        assertEquals(1, square.next());
        assertEquals(4, square.next());
        assertEquals(9, square.next());
        assertEquals(16, square.next());
        assertEquals(25, square.next());
    }

    @Test
    public void testPentagonal() throws Exception {
        // Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
        Polygonal pentagonal = new Pentagonal();
        pentagonal.reset();
        assertEquals(1, pentagonal.next());
        assertEquals(5, pentagonal.next());
        assertEquals(12, pentagonal.next());
        assertEquals(22, pentagonal.next());
        assertEquals(35, pentagonal.next());
    }

    @Test
    public void testHexagonal() throws Exception {
        // Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
        Polygonal hexagonal = new Hexagonal();
        hexagonal.reset();
        assertEquals(1, hexagonal.next());
        assertEquals(6, hexagonal.next());
        assertEquals(15, hexagonal.next());
        assertEquals(28, hexagonal.next());
        assertEquals(45, hexagonal.next());
    }

    @Test
    public void testHeptagonal() throws Exception {
        // Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
        Polygonal heptagonal = new Heptagonal();
        heptagonal.reset();
        assertEquals(1, heptagonal.next());
        assertEquals(7, heptagonal.next());
        assertEquals(18, heptagonal.next());
        assertEquals(34, heptagonal.next());
        assertEquals(55, heptagonal.next());
    }

    @Test
    public void testOctagonal() throws Exception {
        // Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
        Polygonal octagonal = new Octagonal();
        octagonal.reset();
        assertEquals(1, octagonal.next());
        assertEquals(8, octagonal.next());
        assertEquals(21, octagonal.next());
        assertEquals(40, octagonal.next());
        assertEquals(65, octagonal.next());
    }
}
