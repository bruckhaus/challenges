import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    @Test
    public void testPower() throws Exception {
        Power p = new Power();
        assertEquals(1.0, p.power(0, 0), 0.0001);
        assertEquals(1.0, p.power(1, 0), 0.0001);
        assertEquals(1.0, p.power(1, 1), 0.0001);
        assertEquals(81.0, p.power(3, 4), 0.0001);
        assertEquals(1024.0, p.power(2, 10), 0.0001);
    }

    @Test
    public void testPower1() throws Exception {
        Power p = new Power();
        assertEquals(1.0, p.power("Yo!", 0, 0), 0.0001);
        assertEquals(1.0, p.power("Hello world!", 1, 0), 0.0001);
        assertEquals(1.0, p.power("", 1, 1), 0.0001);
        assertEquals(81.0, p.power("", 3, 4), 0.0001);
        assertEquals(1024.0, p.power("asdf", 2, 10), 0.0001);
    }
}
