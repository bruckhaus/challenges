import org.junit.Test;

import static org.junit.Assert.*;

public class P52_PermutedMultiplesTest {

    @Test
    public void findSmallestPermutedMultiple() throws Exception {
        assertEquals(1, P52_PermutedMultiples.findSmallestPermutedMultiple(1));
        assertEquals(125874, P52_PermutedMultiples.findSmallestPermutedMultiple(2));
        assertEquals(142857, P52_PermutedMultiples.findSmallestPermutedMultiple(3));
        assertEquals(142857, P52_PermutedMultiples.findSmallestPermutedMultiple(4));
        assertEquals(142857, P52_PermutedMultiples.findSmallestPermutedMultiple(5));
        assertEquals(142857, P52_PermutedMultiples.findSmallestPermutedMultiple(6));
    }

    @Test
    public void hasSameDigitMultiples() throws Exception {
        assert (P52_PermutedMultiples.hasSameDigitMultiples(125874, 2));
        assert (!P52_PermutedMultiples.hasSameDigitMultiples(125874, 3));
        assert (P52_PermutedMultiples.hasSameDigitMultiples(142857, 2));
        assert (P52_PermutedMultiples.hasSameDigitMultiples(142857, 3));
        assert (P52_PermutedMultiples.hasSameDigitMultiples(142857, 4));
        assert (P52_PermutedMultiples.hasSameDigitMultiples(142857, 5));
        assert (P52_PermutedMultiples.hasSameDigitMultiples(142857, 6));
        assert (!P52_PermutedMultiples.hasSameDigitMultiples(142857, 7));
    }
}