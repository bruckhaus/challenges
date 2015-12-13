import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_44_PentagonalTest {

    @Test
    public void testIsSpecialPair() throws Exception {
        assert (!Euler_44_Pentagonal.isSpecialPair(70, 22));
        assert (Euler_44_Pentagonal.isSpecialPair(7042750, 1560090));
    }
}