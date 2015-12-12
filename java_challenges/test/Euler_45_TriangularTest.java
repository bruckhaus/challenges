import org.junit.Test;
import sun.nio.cs.ext.EUC_CN;

import static org.junit.Assert.*;

public class Euler_45_TriangularTest {

    @Test
    public void testNext() throws Exception {
        Euler_45_Triangular.reset();
        assertEquals(1533776805L, Euler_45_Triangular.next(Euler_45_Triangular.GIVEN));
    }

    @Test
    public void testNextTriangular() throws Exception {
        Euler_45_Triangular.reset();
        assertEquals(1, Euler_45_Triangular.nextTriangular());
        assertEquals(3, Euler_45_Triangular.nextTriangular());
        assertEquals(6, Euler_45_Triangular.nextTriangular());
        assertEquals(10, Euler_45_Triangular.nextTriangular());
        assertEquals(15, Euler_45_Triangular.nextTriangular());
    }

    @Test
    public void testNext_hexagonal() throws Exception {
        Euler_45_Triangular.reset();
        assertEquals(1, Euler_45_Triangular.next_hexagonal());
        assertEquals(6, Euler_45_Triangular.next_hexagonal());
        assertEquals(15, Euler_45_Triangular.next_hexagonal());
        assertEquals(28, Euler_45_Triangular.next_hexagonal());
        assertEquals(45, Euler_45_Triangular.next_hexagonal());
    }

    @Test
    public void testDone() throws Exception {
        Euler_45_Triangular.reset();
        assert(!Euler_45_Triangular.done(0));
        Euler_45_Triangular.next(0);
        assert(Euler_45_Triangular.done(0));
        assert(!Euler_45_Triangular.done(1));
        assertEquals(1, Euler_45_Triangular.triangular);
        assertEquals(1, Euler_45_Triangular.pentagonal.current());
        assertEquals(1, Euler_45_Triangular.hexagonal);
        Euler_45_Triangular.next(1);
        assert(Euler_45_Triangular.done(1));
        assert(Euler_45_Triangular.done(40754));
        assert(!Euler_45_Triangular.done(40755));
        assertEquals(40755, Euler_45_Triangular.triangular);
        assertEquals(40755, Euler_45_Triangular.pentagonal.current());
        assertEquals(40755, Euler_45_Triangular.hexagonal);
    }
}
