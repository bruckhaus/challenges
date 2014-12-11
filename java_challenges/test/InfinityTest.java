import org.junit.Test;

import static org.junit.Assert.*;

public class InfinityTest {

    @Test
    public void testDoubleInfinity() throws Exception {
        assertEquals("Positive infinity", Infinity.double_infinity());
    }
}