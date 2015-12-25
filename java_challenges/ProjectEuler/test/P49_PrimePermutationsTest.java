import org.junit.Test;

import static org.junit.Assert.*;

public class P49_PrimePermutationsTest {

    @Test
    public void testFindPrimePermutation() throws Exception {
        assertEquals(296962999629L, P49_PrimePermutations.findPrimePermutation());
    }

    @Test
    public void testIsSolution() throws Exception {
        assert (!P49_PrimePermutations.isSolution(1487));
        assert (P49_PrimePermutations.isSolution(2969));
    }

    @Test
    public void testIsPrimeSequence() throws Exception {
        assert (P49_PrimePermutations.isPrimeSequence(1487));
        assert (P49_PrimePermutations.isPrimeSequence(1009));
        assert (!P49_PrimePermutations.isPrimeSequence(1013));
        assert (P49_PrimePermutations.isPrimeSequence(2969));
    }

    @Test
    public void testIsPermutationSequence() throws Exception {
        assert (!P49_PrimePermutations.isPermutationSequence(1009));
        assert (P49_PrimePermutations.isPermutationSequence(1480));
        assert (P49_PrimePermutations.isPermutationSequence(1487));
        assert (P49_PrimePermutations.isPermutationSequence(2969));
    }

    @Test
    public void testGetSortedChars() throws Exception {
        char[] sortedChars;
        sortedChars = new char[]{'1', '2', '3', '4'};
        assertArrayEquals(sortedChars, P49_PrimePermutations.getSortedChars(4321));
        sortedChars = new char[]{'1', '4', '7', '8'};
        assertArrayEquals(sortedChars, P49_PrimePermutations.getSortedChars(1487));
        assertArrayEquals(sortedChars, P49_PrimePermutations.getSortedChars(4817));
        assertArrayEquals(sortedChars, P49_PrimePermutations.getSortedChars(8147));
    }

    @Test
    public void testGetConcatenatedPrimes() throws Exception {
        assertEquals(100043307660L, P49_PrimePermutations.getConcatenatedSequence(1000));
        assertEquals(123445647894L, P49_PrimePermutations.getConcatenatedSequence(1234));
        assertEquals(148748178147L, P49_PrimePermutations.getConcatenatedSequence(1487));
        assertEquals(296962999629L, P49_PrimePermutations.getConcatenatedSequence(2969));
    }
}
