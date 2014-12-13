import org.junit.Test;

import static org.junit.Assert.*;

public class OverloadingTest {

    @Test
    public void testPower() throws Exception {
        double result;
        result = Overloading.power(3, 4, false);
        assertEquals(81.0, result, 0.00001);
        result = Overloading.power(3, 4, true);
        assertEquals(0.01234, result, 0.00001);
    }
}
