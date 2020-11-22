import main.java.Fix34;
import org.junit.Test;

import static org.junit.Assert.*;

public class Fix34Test {

    @Test
    public void testFix34() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5},         Fix34.fix34(new int[]{1, 2, 3, 5, 4}));
        assertArrayEquals(new int[]{1, 3, 4, 1},            Fix34.fix34(new int[]{1, 3, 1, 4}));
        assertArrayEquals(new int[]{1, 3, 4, 1, 1, 3, 4},   Fix34.fix34(new int[]{1, 3, 1, 4, 4, 3, 1}));
        assertArrayEquals(new int[]{3, 4, 2, 2},            Fix34.fix34(new int[]{3, 2, 2, 4}));
    }
}
