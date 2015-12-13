import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_45_TriangularTest {

    @Test
    public void testNext() throws Exception {
        Euler_45_Triangular.reset();
        assertEquals(1533776805L, Euler_45_Triangular.next(Euler_45_Triangular.GIVEN));
    }

    @Test
    public void testDone() throws Exception {
        Euler_45_Triangular.reset();
        assert(!Euler_45_Triangular.done(0));
        Euler_45_Triangular.next(0);
        assert(Euler_45_Triangular.done(0));
        assert(!Euler_45_Triangular.done(1));
        assertEquals(1, Euler_45_Triangular.triangular.current());
        assertEquals(1, Euler_45_Triangular.pentagonal.current());
        assertEquals(1, Euler_45_Triangular.hexagonal.current());
        Euler_45_Triangular.next(1);
        assert(Euler_45_Triangular.done(1));
        assert(Euler_45_Triangular.done(40754));
        assert(!Euler_45_Triangular.done(40755));
        assertEquals(40755, Euler_45_Triangular.triangular.current());
        assertEquals(40755, Euler_45_Triangular.pentagonal.current());
        assertEquals(40755, Euler_45_Triangular.hexagonal.current());
    }
}
