import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class P46_GoldbachTest {

// TODO: Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//    @Test
//    public void testFindSmallest() throws Exception {
//        P46_Goldbach.reset();
//        assertEquals(5777, P46_Goldbach.findSmallest());
//    }

    @Test
    public void testGenerateAndAddAll() throws Exception {
        P46_Goldbach.reset();
        TreeSet<Long> g = P46_Goldbach.generated;
        assertEquals(0, g.size());
        P46_Goldbach.generateAndAddAll(3);
        assertEquals(6, g.size());
        assert (g.contains(4L));
        assert (g.contains(5L));
        assert (g.contains(10L));
        assert (g.contains(11L));
        assert (g.contains(20L));
        assert (g.contains(21L));
    }

    @Test
    public void testGenerateAndAddWithPrime() throws Exception {
        P46_Goldbach.reset();
        TreeSet<Long> g = P46_Goldbach.generated;
        assertEquals(0, g.size());
        P46_Goldbach.generateAndAddWithPrime(3);
        assertEquals(3, g.size());
        assert (g.contains(5L));  // 3 + 2 * 1^2 = 3 + 2 * 1 = 3 + 2 = 5
        assert (g.contains(11L)); // 3 + 2 * 2^2 = 3 + 2 * 4 = 3 + 8 = 11
        assert (g.contains(21L)); // 3 + 2 * 3^2 = 3 + 2 * 9 = 3 + 18 = 21
    }

    @Test
    public void testGenerateAndAddWithSquare() throws Exception {
        P46_Goldbach.reset();
        TreeSet<Long> g = P46_Goldbach.generated;
        assertEquals(0, g.size());
        P46_Goldbach.generateAndAddWithSquare(5, 3);
        assertEquals(3, g.size());
        assert (g.contains(20L)); // 2 + 2 * 3^2 = 2 + 2 * 9 = 2 + 18
        assert (g.contains(34L)); // 2 + 2 * 4^2 = 2 + 2 * 16 = 2 + 32 = 34
        assert (g.contains(52L)); // 2 + 2 * 5^2 = 2 + 2 * 25 = 2 + 50 = 52
    }

    @Test
    public void testGenerateAndAdd() throws Exception {
        P46_Goldbach.reset();
        P46_Goldbach.generateAndAdd(13, 5);
        assertEquals(1, P46_Goldbach.generated.size());
        assert (P46_Goldbach.generated.contains(63L));
    }
}