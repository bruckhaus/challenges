import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_43_SubstringDivisibilityTest {

    @Test
    public void testSumSubStringDivisibles() throws Exception {
        assertEquals(16695334890L, Euler_43_SubstringDivisibility.sumSubStringDivisibles());
    }

    @Test
    public void testIsSubStringDivisible() throws Exception {
        Pandigital.setLength(10);
        assert(Euler_43_SubstringDivisibility.isSubStringDivisible(1406357289L));
        assert(!Euler_43_SubstringDivisibility.isSubStringDivisible(1406357298L));
    }

    @Test
    public void testGetSubstringNumber() throws Exception {
        Pandigital.setLength(10);
        assertEquals(102, Euler_43_SubstringDivisibility.getSubstringNumber(0));
        assertEquals(23, Euler_43_SubstringDivisibility.getSubstringNumber(1));
        assertEquals(234, Euler_43_SubstringDivisibility.getSubstringNumber(2));
        assertEquals(345, Euler_43_SubstringDivisibility.getSubstringNumber(3));
        assertEquals(456, Euler_43_SubstringDivisibility.getSubstringNumber(4));
        assertEquals(567, Euler_43_SubstringDivisibility.getSubstringNumber(5));
        assertEquals(678, Euler_43_SubstringDivisibility.getSubstringNumber(6));
        assertEquals(789, Euler_43_SubstringDivisibility.getSubstringNumber(7));
    }
}