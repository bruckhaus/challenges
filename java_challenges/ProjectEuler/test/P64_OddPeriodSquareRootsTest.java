import org.junit.Test;

import static org.junit.Assert.*;

public class P64_OddPeriodSquareRootsTest {

    @Test
    public void countFractions() throws Exception {
        assertEquals(1322, P64_OddPeriodSquareRoots.countFractions());
    }

    @Test
    public void testHasNaturalRoot() throws Exception {
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(1));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(2));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(3));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(4));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(5));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(6));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(7));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(8));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(9));
        assertTrue(!P64_OddPeriodSquareRoots.hasNaturalRoot(10));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(16));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(25));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(36));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(49));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(64));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(81));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(100));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(121));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(144));
        assertTrue(P64_OddPeriodSquareRoots.hasNaturalRoot(169));
    }

    @Test
    public void getPeriod() throws Exception {
        assertEquals(1, P64_OddPeriodSquareRoots.getPeriod(2));
        assertEquals(2, P64_OddPeriodSquareRoots.getPeriod(3));
        assertEquals(0, P64_OddPeriodSquareRoots.getPeriod(4));
        assertEquals(1, P64_OddPeriodSquareRoots.getPeriod(5));
        assertEquals(2, P64_OddPeriodSquareRoots.getPeriod(6));
        assertEquals(4, P64_OddPeriodSquareRoots.getPeriod(7));
        assertEquals(2, P64_OddPeriodSquareRoots.getPeriod(8));
        assertEquals(0, P64_OddPeriodSquareRoots.getPeriod(9));
        assertEquals(1, P64_OddPeriodSquareRoots.getPeriod(10));
        assertEquals(2, P64_OddPeriodSquareRoots.getPeriod(11));
    }
}
