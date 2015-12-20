import org.junit.Test;

import static org.junit.Assert.*;

public class PowerSumTest {

    @Test
    public void testCountPowerNumbers() throws Exception {
        assertEquals(2, PowerSum.countPowerNumbers(0, 1));
        assertEquals(5, PowerSum.countPowerNumbers(25, 30));
        assertEquals(20, PowerSum.countPowerNumbers(0, 30));
        assertEquals(35, PowerSum.countPowerNumbers(0, 50));
        assertEquals(61, PowerSum.countPowerNumbers(0, 100));
        assertEquals(500, PowerSum.countPowerNumbers(0, 1000));
        assertEquals(4174, PowerSum.countPowerNumbers(0, 10000));
//        assertEquals(9570, PowerSum.countPowerNumbers(0, 25000));
    }
}