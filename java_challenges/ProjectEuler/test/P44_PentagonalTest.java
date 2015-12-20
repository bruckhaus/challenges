import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P44_PentagonalTest {

    @Test
    public void testIsSpecialPair() throws Exception {
        assert (!P44_Pentagonal.isSpecialPair(70, 22));
        assert (P44_Pentagonal.isSpecialPair(7042750, 1560090));
    }

    @Test
    public void testMinPairDiff() throws Exception {
        assertEquals(5482660, P44_Pentagonal.minPairDiff(true));
    }
}