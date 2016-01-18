import org.junit.Test;

import static org.junit.Assert.*;

public class P54_PokerHandsTest {

    @Test
    public void scoreHands() throws Exception {
        assertEquals(376, P54_PokerHands.scoreHands());
    }
}
