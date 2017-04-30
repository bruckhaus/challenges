import org.junit.Test;

import static org.junit.Assert.*;

public class P62_CubicPermutationsTest {
    @Test
    public void getSmallestCube() throws Exception {
        P62_CubicPermutations.reset();
        P62_CubicPermutations.findCube(3);
        assertEquals(41_063_625, P62_CubicPermutations.getSmallestCube(405), 1E-10);
        assertEquals(41_063_625, P62_CubicPermutations.getSmallestCube(384), 1E-10);
        assertEquals(41_063_625, P62_CubicPermutations.getSmallestCube(345), 1E-10);
    }

    @Test
    public void testReset() throws Exception {
        P62_CubicPermutations.reset();
        assertEquals(1, P62_CubicPermutations.getCount(123));
        assertEquals(2, P62_CubicPermutations.getCount(123));
        P62_CubicPermutations.reset();
        assertEquals(1, P62_CubicPermutations.getCount(123));
    }

    @Test
    public void findCube() throws Exception {
        P62_CubicPermutations.reset();
        assertEquals(1, P62_CubicPermutations.findCube(1), 1E-10);
        P62_CubicPermutations.reset();
        assertEquals(125, P62_CubicPermutations.findCube(2), 1E-10);
        P62_CubicPermutations.reset();
        assertEquals(41_063_625, P62_CubicPermutations.findCube(3), 1E-10);
        P62_CubicPermutations.reset();
        assertEquals(1_006_012_008, P62_CubicPermutations.findCube(4), 1E-10);
        P62_CubicPermutations.reset();
        assertEquals(127_035_954_683L, P62_CubicPermutations.findCube(5), 0);
    }

    @Test
    public void testGetCount() throws Exception {
        P62_CubicPermutations.reset();
        assertEquals(1, P62_CubicPermutations.getCount(1));
        assertEquals(2, P62_CubicPermutations.getCount(1));
        assertEquals(3, P62_CubicPermutations.getCount(1));
        assertEquals(4, P62_CubicPermutations.getCount(1));
        P62_CubicPermutations.reset();
        assertEquals(1, P62_CubicPermutations.getCount(1));
        assertEquals(2, P62_CubicPermutations.getCount(1));
        assertEquals(3, P62_CubicPermutations.getCount(1));
        assertEquals(4, P62_CubicPermutations.getCount(1));
        assertEquals(1, P62_CubicPermutations.getCount(99));
        assertEquals(2, P62_CubicPermutations.getCount(99));
        assertEquals(3, P62_CubicPermutations.getCount(99));
        assertEquals(4, P62_CubicPermutations.getCount(99));
    }

    @Test
    public void getOrderedDigits() throws Exception {
        assertEquals("123", P62_CubicPermutations.getOrderedDigits(123));
        assertEquals("123", P62_CubicPermutations.getOrderedDigits(321));
        assertEquals("00112233", P62_CubicPermutations.getOrderedDigits(30130221));
        assertEquals("00112233", P62_CubicPermutations.getOrderedDigits(30130221.0));
        assertEquals("00112233", P62_CubicPermutations.getOrderedDigits(30130221.123));
    }
}
