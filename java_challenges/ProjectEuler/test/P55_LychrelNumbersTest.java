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
        assertEquals(123321, P55_LychrelNumbers.getLychrelCount(123));
    }

    @Test
    public void testIsPalindrome() throws Exception {
        assert (P55_LychrelNumbers.isPalindrome(1));
        assert (P55_LychrelNumbers.isPalindrome(191));
        assert (P55_LychrelNumbers.isPalindrome(123454321));
        assert (P55_LychrelNumbers.isPalindrome(1001));
        assert (P55_LychrelNumbers.isPalindrome(1234444321));
        assert (!P55_LychrelNumbers.isPalindrome(12));
        assert (!P55_LychrelNumbers.isPalindrome(123456789));
        assert (!P55_LychrelNumbers.isPalindrome(1234564321));
        assert (!P55_LychrelNumbers.isPalindrome(12398321));
        assert (!P55_LychrelNumbers.isPalindrome(1231));
        assert (!P55_LychrelNumbers.isPalindrome(1919129191));
    }
}
