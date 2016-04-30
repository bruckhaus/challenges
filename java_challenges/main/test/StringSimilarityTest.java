import org.junit.Test;

import static org.junit.Assert.*;

public class StringSimilarityTest {
    @Test
    public void getSimilarity() throws Exception {
        assertEquals(11, StringSimilarity.getSimilarity("ababaa"));
        assertEquals(3, StringSimilarity.getSimilarity("aa"));
        assertEquals(36, StringSimilarity.getSimilarity("aabbaabbaabbaa"));
    }

    @Test
    public void getSimilarity1() throws Exception {
        assertEquals(6, StringSimilarity.getSimilarity("ababaa", "ababaa"));
        assertEquals(0, StringSimilarity.getSimilarity("ababaa", "babaa"));
        assertEquals(3, StringSimilarity.getSimilarity("ababaa", "abaa"));
        assertEquals(0, StringSimilarity.getSimilarity("ababaa", "baa"));
        assertEquals(1, StringSimilarity.getSimilarity("ababaa", "aa"));
        assertEquals(1, StringSimilarity.getSimilarity("ababaa", "a"));
        assertEquals(0, StringSimilarity.getSimilarity("ababaa", ""));
    }

    @Test
    public void getSuffixes() throws Exception {
        assertEquals("[ababaa, babaa, abaa, baa, aa, a]", StringSimilarity.getSuffixes("ababaa").toString());
        assertEquals("[987654321, 87654321, 7654321, 654321, 54321, 4321, 321, 21, 1]",
                StringSimilarity.getSuffixes("987654321").toString());
    }

}