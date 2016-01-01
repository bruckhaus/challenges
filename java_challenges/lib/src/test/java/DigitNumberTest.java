import org.junit.Test;

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
        replacements.add(new int[] {3, 0});
        replacements.add(new int[] {4, 0});
        replacements.add(new int[] {5, 0});
        assertEquals(123000789L, DigitNumber.replaceDigits(123456789, replacements));
        replacements.clear();
        replacements.add(new int[] {0, 9});
        replacements.add(new int[] {1, 8});
        replacements.add(new int[] {2, 7});
        assertEquals(987456789L, DigitNumber.replaceDigits(123456789, replacements));
    }
}