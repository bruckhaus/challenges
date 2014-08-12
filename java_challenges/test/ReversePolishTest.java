import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePolishTest {

    @Test
    public void testEvaluate() {
        Double eta = 1E-5;
        assertEquals(2, ReversePolish.evaluate("1 1 +"), eta);
        assertEquals(-4, ReversePolish.evaluate("1 2 3 + -"), eta);
        assertEquals(0, ReversePolish.evaluate("1 2 + 3 -"), eta);
        assertEquals(-2.66666, ReversePolish.evaluate("-4 2 * 3 /"), eta);
        assertEquals(-38.66666, ReversePolish.evaluate("-4 29 3 / *"), eta);
    }
}