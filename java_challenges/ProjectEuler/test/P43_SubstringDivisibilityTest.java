import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P43_SubstringDivisibilityTest {

    @Test
    public void testSumSubStringDivisibles() throws Exception {
        assertEquals(16695334890L, P43_SubstringDivisibility.sumSubStringDivisibles());
    }

    @Test
    public void testIsSubStringDivisible() throws Exception {
        Pandigital.setLength(10);
        assert(P43_SubstringDivisibility.isSubStringDivisible(1406357289L));
        assert(!P43_SubstringDivisibility.isSubStringDivisible(1406357298L));
    }

    @Test
    public void testGetSubstringNumber() throws Exception {
        Pandigital.setLength(10);
        assertEquals(102, P43_SubstringDivisibility.getSubstringNumber(0));
        assertEquals(23, P43_SubstringDivisibility.getSubstringNumber(1));
        assertEquals(234, P43_SubstringDivisibility.getSubstringNumber(2));
        assertEquals(345, P43_SubstringDivisibility.getSubstringNumber(3));
        assertEquals(456, P43_SubstringDivisibility.getSubstringNumber(4));
        assertEquals(567, P43_SubstringDivisibility.getSubstringNumber(5));
        assertEquals(678, P43_SubstringDivisibility.getSubstringNumber(6));
        assertEquals(789, P43_SubstringDivisibility.getSubstringNumber(7));
    }
}