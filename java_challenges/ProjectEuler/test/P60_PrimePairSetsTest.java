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
    public void testFindIndexArray() throws Exception {
        List<Integer> result = P60_PrimePairSets.findIndexArray(2);
        assertNull(result);
        result = P60_PrimePairSets.findIndexArray(3);
        assert result == null;
        result = P60_PrimePairSets.findIndexArray(4);
        assert result != null;
        Collections.sort(result);
        Integer[] array = new Integer[]{2, 4};
        assertArrayEquals(array, result.toArray());
    }

    @Test
    public void testSearchPrimeArrayWithTwoSeeds() throws Exception {
        List<Integer> result;
        Integer[] array;

//         not a solution for these seeds:
//        result = P60_PrimePairSets.findIndexArray(3, 2, 1);
//        assertNull(result);
//        result = P60_PrimePairSets.findIndexArray(3, 19, 11);
//        assertNull(result);
//
//         solution for 3 primes:
//        result = P60_PrimePairSets.findIndexArray(3, 19, 12);
//        assertNotNull(result);
//        Collections.sort(result);
//        array = new Integer[]{2, 12, 19};
//        assertArrayEquals(array, result.toArray());

        // solution for 4 primes:
//        array = new Integer[]{2, 12, 19}; // FIXME: not the expected values
//        result = P60_PrimePairSets.findIndexArray(4, 868);
//        assertNotNull(result);
//        Collections.sort(result);
//        assertArrayEquals(array, result.toArray());

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

        // solution for 5 primes:
        array = new Integer[]{2, 12, 19}; // FIXME: not the expected values
        result = P60_PrimePairSets.findIndexArray(5);
        assertNotNull(result);
        Collections.sort(result);
        assertArrayEquals(array, result.toArray());

        // solution for 5 primes:
//        array = new Integer[]{2, 12, 19}; // FIXME: not the expected values
//        result = P60_PrimePairSets.findIndexArray(5, 1051, 868);
//        assertNotNull(result);
//        Collections.sort(result);
//        assertArrayEquals(array, result.toArray());
    }

    @Test
    public void testGetSum() throws Exception {
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{1, 2, 3, 4}));
        assertEquals(10, P60_PrimePairSets.getSum(new long[]{3, 7}));
        assertEquals(107, P60_PrimePairSets.getSum(new long[]{3, 37, 67}));
        assertEquals(792, P60_PrimePairSets.getSum(new long[]{3, 7, 109, 673}));
    }
}
