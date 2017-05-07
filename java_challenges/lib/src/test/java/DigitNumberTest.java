import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DigitNumberTest {

    @Test
    public void replaceDigits() throws Exception {
        assertEquals(123406789L, DigitNumber.replaceDigit(123456789, 4, 0));
        assertEquals(923456789L, DigitNumber.replaceDigit(123456789, 0, 9));
        assertEquals(123456788L, DigitNumber.replaceDigit(123456789, 8, 8));
    }

    @Test
    public void replaceDigit() throws Exception {
        ArrayList<int[]> replacements = new ArrayList<>();
        replacements.add(new int[]{3, 0});
        replacements.add(new int[]{4, 0});
        replacements.add(new int[]{5, 0});
        assertEquals(123000789L, DigitNumber.replaceDigits(123456789, replacements));
        replacements.clear();
        replacements.add(new int[]{0, 9});
        replacements.add(new int[]{1, 8});
        replacements.add(new int[]{2, 7});
        assertEquals(987456788L, DigitNumber.replaceDigits(123456788, replacements));
    }

    @Test
    public void getSortedDigits() throws Exception {
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7'};
        assertArrayEquals(chars, DigitNumber.getSortedDigits(76543210));
        assertArrayEquals(chars, DigitNumber.getSortedDigits(32107654));
        assertArrayEquals(chars, DigitNumber.getSortedDigits(12345670));
        assertArrayEquals(chars, DigitNumber.getSortedDigits(10234567));
    }

    @Test
    public void testGetDigitSum() throws Exception {
        assertEquals(1, DigitNumber.getDigitSum(new BigInteger("1")));
        assertEquals(27, DigitNumber.getDigitSum(new BigInteger("999")));
        assertEquals(15, DigitNumber.getDigitSum(new BigInteger("12345")));
        assertEquals(45, DigitNumber.getDigitSum(new BigInteger("123456789")));
        assertEquals(90, DigitNumber.getDigitSum(new BigInteger("1234567890123456789")));
        assertEquals(135, DigitNumber.getDigitSum(new BigInteger("123456789012345678901234567890")));
    }
}
