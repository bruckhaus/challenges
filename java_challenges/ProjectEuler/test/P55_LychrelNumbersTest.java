import org.junit.Test;

import static org.junit.Assert.*;

public class P55_LychrelNumbersTest {

    @Test
    public void testGetLychrelCount() throws Exception {
        assertEquals(-1, P55_LychrelNumbers.getLychrelCount(10));
        assertEquals(-1, P55_LychrelNumbers.getLychrelCount(100));
        assertEquals(-1, P55_LychrelNumbers.getLychrelCount(1000));
        assertEquals(-1, P55_LychrelNumbers.getLychrelCount(10000));
    }

    @Test
    public void testIsLychrelNumber() throws Exception {
        assert (P55_LychrelNumbers.isLychrelNumber(196));
        assert (P55_LychrelNumbers.isLychrelNumber(4994));
    }

    @Test
    public void testGetLychrelTransform() throws Exception {

    }

    @Test
    public void testIsPalindrome() throws Exception {

    }
}
