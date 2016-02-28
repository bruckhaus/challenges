import org.junit.Test;

import java.util.Collections;
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
    public void testSearchPrimeArrayWithOneSeed() throws Exception {
        List<Integer> result = P60_PrimePairSets.searchPrimeArray(2, 2);
        assertNull(result);
        result = P60_PrimePairSets.searchPrimeArray(2, 3);
        assert result == null;
        result = P60_PrimePairSets.searchPrimeArray(2, 4);
        assert result != null;
        Collections.sort(result);
        Integer[] array = new Integer[]{2, 4};
        assertArrayEquals(array, result.toArray());
    }

    @Test
    public void testSearchPrimeArrayWithTwoSeeds() throws Exception {
        List<Integer> result = P60_PrimePairSets.searchPrimeArray(3, 2, 1);
        assert result == null;
        result = P60_PrimePairSets.searchPrimeArray(3, 19, 11);
        assert result == null;
        result = P60_PrimePairSets.searchPrimeArray(3, 19, 12);
        assert result != null;
        Collections.sort(result);
        Integer[] array = new Integer[]{2, 12, 19};
        assertArrayEquals(array, result.toArray());
    }

    @Test
    public void testGetSum() throws Exception {
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{1, 2, 3, 4}));
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{3, 7}));
        assertEquals(107, P60_PrimePairSets.getSum(new long[]{3, 37, 67}));
        assertEquals(792, P60_PrimePairSets.getSum(new long[]{3, 7, 109, 673}));
    }
}
