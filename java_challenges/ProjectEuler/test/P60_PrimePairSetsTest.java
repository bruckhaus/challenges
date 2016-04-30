import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class P60_PrimePairSetsTest {

    @Test
    public void testFindPrimeArray() throws Exception {
        assertArrayEquals(new long[]{2}, P60_PrimePairSets.findPrimeArray(1));
        assertArrayEquals(new long[]{3, 7}, P60_PrimePairSets.findPrimeArray(2));
        assertArrayEquals(new long[]{3, 37, 67}, P60_PrimePairSets.findPrimeArray(3));
        assertArrayEquals(new long[]{3, 7, 109, 673}, P60_PrimePairSets.findPrimeArray(4));
        assertArrayEquals(new long[]{13, 5197, 5701, 6733, 8389}, P60_PrimePairSets.findPrimeArray(5));
    }

    @Test
    public void testFindIndexArray() throws Exception {
        assertArrayEquals(new Integer[]{1}, P60_PrimePairSets.findIndexArray(1).toArray());
        assertArrayEquals(new Integer[]{2, 4}, P60_PrimePairSets.findIndexArray(2).toArray());
        assertArrayEquals(new Integer[]{2, 12, 19}, P60_PrimePairSets.findIndexArray(3).toArray());
        assertArrayEquals(new Integer[]{2, 4, 29, 122}, P60_PrimePairSets.findIndexArray(4).toArray());
        assertArrayEquals(new Integer[]{6, 692, 751, 868, 1051}, P60_PrimePairSets.findIndexArray(5).toArray());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void testFindIndexArray2() throws Exception {
        assertArrayEquals(new Integer[]{2, 4, 29, 122}, P60_PrimePairSets.findIndexArray(4, 122, 0).toArray());
        assertArrayEquals(new Integer[]{9, 64, 123, 144}, P60_PrimePairSets.findIndexArray(4, 144, 0).toArray());
        assertArrayEquals(new Integer[]{5, 52, 176, 283}, P60_PrimePairSets.findIndexArray(4, 283, 0).toArray());
        assertArrayEquals(new Integer[]{50, 112, 556, 868}, P60_PrimePairSets.findIndexArray(4, 868, 0).toArray());
        assertArrayEquals(new Integer[]{6, 692, 751, 868}, P60_PrimePairSets.findIndexArray(4, 868, 31).toArray());
        assertNull(P60_PrimePairSets.findIndexArray(4, 121, 0));
        assertNull(P60_PrimePairSets.findIndexArray(4, 123, 0));
        assertNull(P60_PrimePairSets.findIndexArray(4, 143, 0));
        assertNull(P60_PrimePairSets.findIndexArray(4, 145, 0));
    }

    @Test
    public void testPairsForSizeFiveSolution() throws Exception {
        assert (PrimePairs.get(692).contains(6));
        assert (PrimePairs.get(751).contains(6));
        assert (PrimePairs.get(751).contains(692));
        assert (PrimePairs.get(868).contains(6));
        assert (PrimePairs.get(868).contains(692));
        assert (PrimePairs.get(868).contains(751));
        assert (PrimePairs.get(1051).contains(6));
        assert (PrimePairs.get(1051).contains(692));
        assert (PrimePairs.get(1051).contains(751));
        assert (PrimePairs.get(1051).contains(868));
        assert (!PrimePairs.get(1051).contains(869));
    }

    @Test
    public void testGetSum() throws Exception {
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{1, 2, 3, 4}));
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{3, 7}));
        assertEquals(107, P60_PrimePairSets.getSum(new long[]{3, 37, 67}));
        assertEquals(792, P60_PrimePairSets.getSum(new long[]{3, 7, 109, 673}));
    }

    @Test
    public void testMakeList() throws Exception {
        assertArrayEquals(new Integer[]{1}, P60_PrimePairSets.makeList(1).toArray());
        assertArrayEquals(new Integer[]{777}, P60_PrimePairSets.makeList(777).toArray());
    }

    @Test
    public void testCheckPartial() throws Exception {
        List<Integer> result;
        result = P60_PrimePairSets.checkPartial(P60_PrimePairSets.makeList(2), 3);
        assertNull(result);

        result = P60_PrimePairSets.checkPartial(P60_PrimePairSets.makeList(2), 4);
        assertNotNull(result);
        assertArrayEquals(new Integer[]{2, 4}, result.toArray());
    }
}
