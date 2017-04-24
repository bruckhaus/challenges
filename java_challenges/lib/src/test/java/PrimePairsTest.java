import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PrimePairsTest {

    @Test
    public void testBuildPairs() throws Exception {
        PrimePairs.reset();
        assertEquals("[[]]", PrimePairs.buildPairs(0).toString());
        assertEquals("[[], []]", PrimePairs.buildPairs(1).toString());
        assertEquals("[[], [], []]", PrimePairs.buildPairs(2).toString());
        assertEquals("[[], [], [], []]", PrimePairs.buildPairs(3).toString());
        assertEquals("[[], [], [], [], [2]]", PrimePairs.buildPairs(4).toString());
        assertEquals("[[], [], [], [], [2], [2]]", PrimePairs.buildPairs(5).toString());
        assertEquals("[[], [], [], [], [2], [2], []]", PrimePairs.buildPairs(6).toString());
        assertEquals("[[], [], [], [], [2], [2], [], [2]]", PrimePairs.buildPairs(7).toString());
        assertEquals("[[], [], [], [], [2], [2], [], [2], [4, 6]]", PrimePairs.buildPairs(8).toString());
        assertEquals("[[], [], [], [], [2], [2], [], [2], [4, 6], [5]]", PrimePairs.buildPairs(9).toString());
    }

    @Test
    public void testGetPairs() throws Exception {
        assertEquals("[]", PrimePairs.getPairs(0).toString());     // no prime for index 0
        assertEquals("[]", PrimePairs.getPairs(1).toString());     // 2: no pairs
        assertEquals("[]", PrimePairs.getPairs(2).toString());     // 3: no pairs
        assertEquals("[]", PrimePairs.getPairs(3).toString());     // 5: no pairs
        assertEquals("[2]", PrimePairs.getPairs(4).toString());    // 7: 37, 73
        assertEquals("[2]", PrimePairs.getPairs(5).toString());    // 11: 311, 113
        assertEquals("[]", PrimePairs.getPairs(6).toString());     // 13: no pairs
        assertEquals("[2]", PrimePairs.getPairs(7).toString());    // 17: 317, 173
        assertEquals("[4, 6]", PrimePairs.getPairs(8).toString()); // 19: 719, 197 + 1319, 1913
        assertEquals("[5]", PrimePairs.getPairs(9).toString());    // 23: 1123, 2311
        assertEquals("[]", PrimePairs.getPairs(10).toString());    // 29: no pairs
    }

    @Test
    public void testGet() throws Exception {
        assertEquals("[]", PrimePairs.get(0).toString());     // no prime for index 0
        assertEquals("[]", PrimePairs.get(1).toString());     // 2: no pairs
        assertEquals("[]", PrimePairs.get(2).toString());     // 3: no pairs
        assertEquals("[]", PrimePairs.get(3).toString());     // 5: no pairs
        assertEquals("[2]", PrimePairs.get(4).toString());    // 7: 37, 73
        assertEquals("[2]", PrimePairs.get(5).toString());    // 11: 311, 113
        assertEquals("[]", PrimePairs.get(6).toString());     // 13: no pairs
        assertEquals("[2]", PrimePairs.get(7).toString());    // 17: 317, 173
        assertEquals("[4, 6]", PrimePairs.get(8).toString()); // 19: 719, 197 + 1319, 1913
        assertEquals("[5]", PrimePairs.get(9).toString());    // 23: 1123, 2311
        assertEquals("[]", PrimePairs.get(10).toString());    // no pairs for 29
    }

    @Test
    public void testGetPrimePair() throws Exception {
        assertNull(PrimePairs.getPrimePair(1, 2));
        assertArrayEquals(new Integer[]{2, 4}, PrimePairs.getPrimePair(2, 4).toArray());
        assertArrayEquals(new Integer[]{2, 4}, PrimePairs.getPrimePair(4, 2).toArray());
        // concatenable primes {13, 5197, 5701, 6733, 8389}, indices {6, 692, 751, 868, 1051}
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
    public void testIsConcatenablePrimes() throws Exception {
        assert (!PrimePairs.isConcatenable(3L, 2L));
        assert (!PrimePairs.isConcatenable(5L, 2L));
        assert (!PrimePairs.isConcatenable(5L, 3L));
        assert (!PrimePairs.isConcatenable(7L, 2L));
        assert (PrimePairs.isConcatenable(7L, 3L));       // 37 and 73 are prime
        assert (!PrimePairs.isConcatenable(7L, 5L));
        assert (!PrimePairs.isConcatenable(11L, 2L));
        assert (PrimePairs.isConcatenable(11L, 3L));      // 113 and 311 are prime
        assert (!PrimePairs.isConcatenable(11L, 5L));
        // concatenable primes {13, 5197, 5701, 6733, 8389}, indices {6, 692, 751, 868, 1051}
        assert (PrimePairs.isConcatenable(13L, 5197L));
        assert (PrimePairs.isConcatenable(13L, 5701L));
        assert (PrimePairs.isConcatenable(13L, 6733L));
        assert (PrimePairs.isConcatenable(13L, 8389L));
        assert (PrimePairs.isConcatenable(5197L, 5701L));
        assert (PrimePairs.isConcatenable(5197L, 6733L));
        assert (PrimePairs.isConcatenable(5197L, 8389L));
        assert (PrimePairs.isConcatenable(5701L, 6733L));
        assert (PrimePairs.isConcatenable(5701L, 8389L));
        assert (PrimePairs.isConcatenable(6733L, 8389L));
    }

    @Test
    public void testIsConcatenableIndices() throws Exception {
        assert (!PrimePairs.isConcatenable(2, 1));
        assert (!PrimePairs.isConcatenable(3, 1));
        assert (!PrimePairs.isConcatenable(3, 2));
        assert (!PrimePairs.isConcatenable(4, 1));
        assert (PrimePairs.isConcatenable(4, 2));   // prime[2] == 3, prime[4] == 7, 37 and 73 are prime.
        assert (!PrimePairs.isConcatenable(4, 3));
        assert (!PrimePairs.isConcatenable(5, 1));
        assert (PrimePairs.isConcatenable(5, 2));   // prime[2] == 3, prime[5] == 11, 311 and 113 are prime.
        assert (!PrimePairs.isConcatenable(5, 3));
    }

    @Test
    public void testIsConcatenableList() throws Exception {
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
        // concatenable prime list {13, 5197, 5701, 6733, 8389}
        list.clear();
        list.add(6);    // 13
        list.add(692);  // 5197
        list.add(751);  // 5701
        list.add(868);  // 6733
        list.add(1051); // 8389
        assert (PrimePairs.isConcatenable(list));
        list.add(5);
        assert (!PrimePairs.isConcatenable(list));
    }

    @Test
    public void testIsPair() throws Exception {
        assert (!PrimePairs.isPair(1, 2));
        assert (!PrimePairs.isPair(2, 1));
        // {2, 12, 19}
        assert (PrimePairs.isPair(2, 12));
        assert (PrimePairs.isPair(2, 19));
        assert (PrimePairs.isPair(12, 19));
        assert (PrimePairs.isPair(19, 12));
        // concatenable primes {13, 5197, 5701, 6733, 8389}, indices {6, 692, 751, 868, 1051}
        assert (PrimePairs.isPair(6, 692));
        assert (PrimePairs.isPair(6, 751));
        assert (PrimePairs.isPair(6, 868));
        assert (PrimePairs.isPair(6, 1051));
        assert (PrimePairs.isPair(692, 751));
        assert (PrimePairs.isPair(692, 868));
        assert (PrimePairs.isPair(692, 1051));
        assert (PrimePairs.isPair(751, 868));
        assert (PrimePairs.isPair(751, 1051));
        assert (PrimePairs.isPair(868, 1051));
    }

    @Test
    public void testGetPrimeArray() throws Exception {
        List<Integer> list = new ArrayList<>();
        assertArrayEquals(new long[0], PrimePairs.getPrimeArray(list));
        list.add(1);
        assertArrayEquals(new long[]{2}, PrimePairs.getPrimeArray(list));
        list.add(2);
        assertArrayEquals(new long[]{2, 3}, PrimePairs.getPrimeArray(list));
        list.add(3);
        assertArrayEquals(new long[]{2, 3, 5}, PrimePairs.getPrimeArray(list));
    }

    @Test
    public void testConcatenate() throws Exception {
        assertEquals(12, PrimePairs.concatenate(1, 2));
        assertEquals(12345678901L, PrimePairs.concatenate(1234567890, 1));
    }

    @Test
    public void testGetPrime() throws Exception {
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

    @Test
    public void testGetListFromPair() throws Exception {
        assertArrayEquals(new Integer[]{1, 2}, PrimePairs.getListFromPair(1, 2).toArray());
        assertArrayEquals(new Integer[]{1, 2}, PrimePairs.getListFromPair(2, 1).toArray());
    }
}
