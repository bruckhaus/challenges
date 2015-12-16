import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class Euler_46_GoldbachTest {

    @Test
    public void testFindSmallest() throws Exception {
        Euler_46_Goldbach.reset();
        assertEquals(5777, Euler_46_Goldbach.findSmallest());
    }

    @Test
    public void testGenerateAndAddAll() throws Exception {
        Euler_46_Goldbach.reset();
        TreeSet<Long> g = Euler_46_Goldbach.generated;
        assertEquals(0, g.size());
        Euler_46_Goldbach.generateAndAddAll(3);
        assertEquals(6, g.size());
        assert(g.contains(4L));
        assert(g.contains(5L));
        assert(g.contains(10L));
        assert(g.contains(11L));
        assert(g.contains(20L));
        assert(g.contains(21L));
    }

    @Test
    public void testGenerateAndAddWithPrime() throws Exception {
        Euler_46_Goldbach.reset();
        TreeSet<Long> g = Euler_46_Goldbach.generated;
        assertEquals(0, g.size());
        Euler_46_Goldbach.generateAndAddWithPrime(3);
        assertEquals(3, g.size());
        assert(g.contains(5L));  // 3 + 2 * 1^2 = 3 + 2 * 1 = 3 + 2 = 5
        assert(g.contains(11L)); // 3 + 2 * 2^2 = 3 + 2 * 4 = 3 + 8 = 11
        assert(g.contains(21L)); // 3 + 2 * 3^2 = 3 + 2 * 9 = 3 + 18 = 21
    }

    @Test
    public void testGenerateAndAddWithSquare() throws Exception {
        Euler_46_Goldbach.reset();
        TreeSet<Long> g = Euler_46_Goldbach.generated;
        assertEquals(0, g.size());
        Euler_46_Goldbach.generateAndAddWithSquare(5, 3);
        assertEquals(3, g.size());
        assert(g.contains(20L)); // 2 + 2 * 3^2 = 2 + 2 * 9 = 2 + 18
        assert(g.contains(34L)); // 2 + 2 * 4^2 = 2 + 2 * 16 = 2 + 32 = 34
        assert(g.contains(52L)); // 2 + 2 * 5^2 = 2 + 2 * 25 = 2 + 50 = 52
    }

    @Test
    public void testGenerateAndAdd() throws Exception {
        Euler_46_Goldbach.reset();
        Euler_46_Goldbach.generateAndAdd(13, 5);
        assertEquals(1, Euler_46_Goldbach.generated.size());
        assert(Euler_46_Goldbach.generated.contains(63L));
    }
}