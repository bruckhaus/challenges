import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P45_TriangularTest {

    @Test
    public void testNext() throws Exception {
        P45_Triangular.reset();
        assertEquals(1533776805L, P45_Triangular.next(P45_Triangular.GIVEN));
    }

    @Test
    public void testDone() throws Exception {
        P45_Triangular.reset();
        assert(!P45_Triangular.done(0));
        P45_Triangular.next(0);
        assert(P45_Triangular.done(0));
        assert(!P45_Triangular.done(1));
        assertEquals(1, P45_Triangular.triangular.current());
        assertEquals(1, P45_Triangular.pentagonal.current());
        assertEquals(1, P45_Triangular.hexagonal.current());
        P45_Triangular.next(1);
        assert(P45_Triangular.done(1));
        assert(P45_Triangular.done(40754));
        assert(!P45_Triangular.done(40755));
        assertEquals(40755, P45_Triangular.triangular.current());
        assertEquals(40755, P45_Triangular.pentagonal.current());
        assertEquals(40755, P45_Triangular.hexagonal.current());
    }
}
