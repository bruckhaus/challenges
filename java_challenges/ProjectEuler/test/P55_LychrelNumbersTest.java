import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class P55_LychrelNumbersTest {

    @Test
    public void testGetLychrelCount() throws Exception {
        assertEquals(0, P55_LychrelNumbers.getLychrelCount(10));
        assertEquals(0, P55_LychrelNumbers.getLychrelCount(100));
        assertEquals(13, P55_LychrelNumbers.getLychrelCount(1000));
        assertEquals(249, P55_LychrelNumbers.getLychrelCount(10000));
    }

    @Test
    public void testIsLychrelNumber() throws Exception {
        assert (P55_LychrelNumbers.isLychrelNumber(196));
        assert (P55_LychrelNumbers.isLychrelNumber(4994));
    }

    @Test
    public void testGetLychrelTransform() throws Exception {
        assertEquals(new BigInteger("2"), P55_LychrelNumbers.getLychrelTransform(new BigInteger("1")));
        assertEquals(new BigInteger("444"), P55_LychrelNumbers.getLychrelTransform(new BigInteger("123")));
        assertEquals(new BigInteger("777777"), P55_LychrelNumbers.getLychrelTransform(new BigInteger("123456")));
        assertEquals(new BigInteger("2222222211"),
                P55_LychrelNumbers.getLychrelTransform(new BigInteger("1234567890")));
    }

    @Test
    public void testIsPalindrome() throws Exception {
        assert (P55_LychrelNumbers.isPalindrome(new BigInteger("1")));
        assert (P55_LychrelNumbers.isPalindrome(new BigInteger("191")));
        assert (P55_LychrelNumbers.isPalindrome(new BigInteger("123454321")));
        assert (P55_LychrelNumbers.isPalindrome(new BigInteger("1001")));
        assert (P55_LychrelNumbers.isPalindrome(new BigInteger("1234444321")));
        assert (!P55_LychrelNumbers.isPalindrome(new BigInteger("12")));
        assert (!P55_LychrelNumbers.isPalindrome(new BigInteger("123456789")));
        assert (!P55_LychrelNumbers.isPalindrome(new BigInteger("1234564321")));
        assert (!P55_LychrelNumbers.isPalindrome(new BigInteger("12398321")));
        assert (!P55_LychrelNumbers.isPalindrome(new BigInteger("1231")));
        assert (!P55_LychrelNumbers.isPalindrome(new BigInteger("1919129191")));
    }
}
