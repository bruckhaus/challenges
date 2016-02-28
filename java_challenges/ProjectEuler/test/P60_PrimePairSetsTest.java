import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class P60_PrimePairSetsTest {

    @Test
    public void testFindPrimeArray() throws Exception {
        assertArrayEquals(new long[]{3, 7}, P60_PrimePairSets.findPrimeArray(2));
        assertArrayEquals(new long[]{3, 37, 67}, P60_PrimePairSets.findPrimeArray(3));
        assertArrayEquals(new long[]{3, 7, 109, 673}, P60_PrimePairSets.findPrimeArray(4));
    }

    @Test
    public void findPrimeArray() throws Exception {

    }

    @Test
    public void searchPrimeArray() throws Exception {
//        Integer[] array = new Integer[]{};
//        assertArrayEquals(array, P60_PrimePairSets.searchPrimeArray(2, 2).toArray());
//        assertArrayEquals(null, P60_PrimePairSets.searchPrimeArray(2, 3));
//        assertArrayEquals(new long[]{3, 7}, P60_PrimePairSets.searchPrimeArray(2, 4));
    }

    @Test
    public void searchPrimeArray1() throws Exception {

    }

    @Test
    public void checkPair() throws Exception {

    }

    @Test
    public void makeList() throws Exception {

    }

    @Test
    public void getSum() throws Exception {

    }

    @Test
    public void testSearchPrimeArray() throws Exception {
    }

    @Test
    public void testGetPrimeArray() throws Exception {
//        assertArrayEquals(new long[]{3, 7}, P60_PrimePairSets.getPrimeArray(2, 4, new int[]{1}));
//        assertArrayEquals(new long[]{3, 7, 11}, P60_PrimePairSets.getPrimeArray(3, 5, new int[]{1, 3}));
    }

    @Test
    public void testIsConcatenable() throws Exception {
//        assert (P60_PrimePairSets.isConcatenablePrimes(2, new long[]{3, 7}));
//        assert (!P60_PrimePairSets.isConcatenablePrimes(2, new long[]{3, 5}));
//        assert (P60_PrimePairSets.isConcatenablePrimes(3, new long[]{3, 37, 67}));
//        assert (!P60_PrimePairSets.isConcatenablePrimes(3, new long[]{11, 37, 67}));
//        assert (P60_PrimePairSets.isConcatenablePrimes(4, new long[]{3, 7, 109, 673}));
//        assert (!P60_PrimePairSets.isConcatenablePrimes(4, new long[]{3, 19, 109, 673}));
    }

    @Test
    public void testIsConcatenable1() throws Exception {
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 7}, new int[]{0, 1}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 7}, new int[]{0, 1}, false));
//        assert (!P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 5}, new int[]{0, 1}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 5}, new int[]{0, 1}, false));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 37, 67}, new int[]{0, 1}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 37, 67}, new int[]{0, 1}, false));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 37, 67}, new int[]{0, 2}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 37, 67}, new int[]{0, 2}, false));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 37, 67}, new int[]{1, 2}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 37, 67}, new int[]{1, 2}, false));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 11, 67}, new int[]{0, 1}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 11, 67}, new int[]{0, 1}, false));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 11, 67}, new int[]{0, 2}, true));
//        assert (P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 11, 67}, new int[]{0, 2}, false));
//        assert (!P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 11, 67}, new int[]{1, 2}, true));
//        assert (!P60_PrimePairSets.isConcatenablePrimes(new long[]{3, 11, 67}, new int[]{1, 2}, false));
    }

    @Test
    public void testConcatenate() throws Exception {
//        assertEquals(311, P60_PrimePairSets.concatenate(3, 11));
//        assertEquals(367, P60_PrimePairSets.concatenate(3, 67));
//        assertEquals(1234567890, P60_PrimePairSets.concatenate(12345, 67890));
    }

    @Test
    public void testGetSum() throws Exception {
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{3, 7}));
        assertEquals(107, P60_PrimePairSets.getSum(new long[]{3, 37, 67}));
        assertEquals(792, P60_PrimePairSets.getSum(new long[]{3, 7, 109, 673}));
    }
}
