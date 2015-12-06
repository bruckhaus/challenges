import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_43_SubstringDivisibilityTest {

    @Test
    public void testSumSubStringDivisibles() throws Exception {

    }

    @Test
    public void testIsSubStringDivisible() throws Exception {

    }

    @Test
    public void testGetSubstringNumber() throws Exception {
        assertEquals(123, Euler_43_SubstringDivisibility.getSubstringNumber(1));
        assertEquals(234, Euler_43_SubstringDivisibility.getSubstringNumber(2));
        assertEquals(345, Euler_43_SubstringDivisibility.getSubstringNumber(3));
        assertEquals(456, Euler_43_SubstringDivisibility.getSubstringNumber(4));
        assertEquals(567, Euler_43_SubstringDivisibility.getSubstringNumber(5));
        assertEquals(678, Euler_43_SubstringDivisibility.getSubstringNumber(6));
        assertEquals(789, Euler_43_SubstringDivisibility.getSubstringNumber(7));
        assertEquals(890, Euler_43_SubstringDivisibility.getSubstringNumber(8));
    }
}