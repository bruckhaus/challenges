import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PrimePairsTest {

    @Test
    public void addPairs() throws Exception {
        assertArrayEquals(new Integer[0], PrimePairs.addPairs(0).toArray());      // no prime for index 0
        assertArrayEquals(new Integer[0], PrimePairs.addPairs(1).toArray());      // no pairs for 2
        assertArrayEquals(new Integer[0], PrimePairs.addPairs(2).toArray());      // no pairs for 3
        assertArrayEquals(new Integer[0], PrimePairs.addPairs(3).toArray());      // no pairs for 5
        assertArrayEquals(new Integer[]{2}, PrimePairs.addPairs(4).toArray());    // 7: 37, 73
        assertArrayEquals(new Integer[]{2}, PrimePairs.addPairs(5).toArray());    // 11: 311, 113
        assertArrayEquals(new Integer[0], PrimePairs.addPairs(6).toArray());      // no pairs for 13
        assertArrayEquals(new Integer[]{2}, PrimePairs.addPairs(7).toArray());    // 17: 317, 173
        assertArrayEquals(new Integer[]{4, 6}, PrimePairs.addPairs(8).toArray()); // 19: 719, 197 + 1317, 1713
        assertArrayEquals(new Integer[]{5}, PrimePairs.addPairs(9).toArray());    // 23: 1123, 2311
        assertArrayEquals(new Integer[0], PrimePairs.addPairs(10).toArray());     // no pairs for 29
    }

    @Test
    public void get() throws Exception {
        assertArrayEquals(new Integer[0], PrimePairs.get(0).toArray());      // no prime for index 0
        assertArrayEquals(new Integer[0], PrimePairs.get(1).toArray());      // 2: no pairs
        assertArrayEquals(new Integer[0], PrimePairs.get(2).toArray());      // 3: no pairs
        assertArrayEquals(new Integer[0], PrimePairs.get(3).toArray());      // 5: no pairs
        assertArrayEquals(new Integer[]{2}, PrimePairs.get(4).toArray());    // 7: 37, 73
        assertArrayEquals(new Integer[]{2}, PrimePairs.get(5).toArray());    // 11: 311, 113
        assertArrayEquals(new Integer[0], PrimePairs.get(6).toArray());      // 13: no pairs
        assertArrayEquals(new Integer[]{2}, PrimePairs.get(7).toArray());    // 17: 317, 173
        assertArrayEquals(new Integer[]{4, 6}, PrimePairs.get(8).toArray()); // 19: 719, 197 + 1317, 1713
        assertArrayEquals(new Integer[]{5}, PrimePairs.get(9).toArray());    // 23: 1123, 2311
        assertArrayEquals(new Integer[0], PrimePairs.get(10).toArray());     // no pairs for 29
    }

    @Test
    public void isConcatenablePrimes() throws Exception {
        assert (!PrimePairs.isConcatenable(3L, 2L));
        assert (!PrimePairs.isConcatenable(5L, 2L));
        assert (!PrimePairs.isConcatenable(5L, 3L));
        assert (!PrimePairs.isConcatenable(7L, 2L));
        assert (PrimePairs.isConcatenable(7L, 3L));
        assert (!PrimePairs.isConcatenable(7L, 5L));
        assert (!PrimePairs.isConcatenable(11L, 2L));
        assert (PrimePairs.isConcatenable(11L, 3L));
        assert (!PrimePairs.isConcatenable(11L, 5L));
    }

    @Test
    public void isConcatenableIndices() throws Exception {
        assert (!PrimePairs.isConcatenable(2, 1));
        assert (!PrimePairs.isConcatenable(3, 1));
        assert (!PrimePairs.isConcatenable(3, 2));
        assert (!PrimePairs.isConcatenable(4, 1));
        assert (PrimePairs.isConcatenable(4, 2));
        assert (!PrimePairs.isConcatenable(4, 3));
        assert (!PrimePairs.isConcatenable(5, 1));
        assert (PrimePairs.isConcatenable(5, 2));
        assert (!PrimePairs.isConcatenable(5, 3));
    }

    @Test
    public void isConcatenableList() throws Exception {
        List<Integer> list = new ArrayList<>();
        // concatenable list {3, 7}:
        list.add(4); // 3
        list.add(2); // 7
        assert (PrimePairs.isConcatenable(list));
        list.add(5);
        assert (!PrimePairs.isConcatenable(list));
        // concatenable prime list {3, 37, 67}:
        list.clear();
        list.add(2);  // 3
        list.add(12); // 37
        list.add(19); // 67
        assert (PrimePairs.isConcatenable(list));
        list.add(5);
        assert (!PrimePairs.isConcatenable(list));
        // concatenable prime list {3, 7, 109, 673}:
        list.clear();
        list.add(2);   // 3
        list.add(4);   // 7
        list.add(29);  // 109
        list.add(122); // 673
        assert (PrimePairs.isConcatenable(list));
        list.add(5);
        assert (!PrimePairs.isConcatenable(list));
    }

    @Test
    public void getPrimeArray() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        assertArrayEquals(new long[0], PrimePairs.getPrimeArray(list));
        list.add(1);
        assertArrayEquals(new long[]{2}, PrimePairs.getPrimeArray(list));
        list.add(2);
        assertArrayEquals(new long[]{2, 3}, PrimePairs.getPrimeArray(list));
        list.add(3);
        assertArrayEquals(new long[]{2, 3, 5}, PrimePairs.getPrimeArray(list));
    }

    @Test
    public void concatenate() throws Exception {
        assertEquals(12, PrimePairs.concatenate(1, 2));
        assertEquals(12345678901L, PrimePairs.concatenate(1234567890, 1));
    }

    @Test
    public void getPrime() throws Exception {
        assertEquals(2, PrimePairs.getPrime(1));
        assertEquals(3, PrimePairs.getPrime(2));
        assertEquals(5, PrimePairs.getPrime(3));
        assertEquals(7, PrimePairs.getPrime(4));
        assertEquals(11, PrimePairs.getPrime(5));
        assertEquals(13, PrimePairs.getPrime(6));
        assertEquals(17, PrimePairs.getPrime(7));
        assertEquals(19, PrimePairs.getPrime(8));
        assertEquals(23, PrimePairs.getPrime(9));
        assertEquals(29, PrimePairs.getPrime(10));
    }

}
