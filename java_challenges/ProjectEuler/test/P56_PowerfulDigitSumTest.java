import org.junit.Test;

import static org.junit.Assert.*;

public class P56_PowerfulDigitSumTest {

    @Test
    public void testGetPowerfulDigitSum() throws Exception {
        assertEquals(0, P56_PowerfulDigitSum.getPowerfulDigitSum(1));
        assertEquals(13, P56_PowerfulDigitSum.getPowerfulDigitSum(5));
        assertEquals(45, P56_PowerfulDigitSum.getPowerfulDigitSum(10));
        assertEquals(406, P56_PowerfulDigitSum.getPowerfulDigitSum(50));
        assertEquals(972, P56_PowerfulDigitSum.getPowerfulDigitSum(100));
    }
}
