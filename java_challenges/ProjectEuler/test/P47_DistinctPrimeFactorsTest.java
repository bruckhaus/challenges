import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P47_DistinctPrimeFactorsTest {

    @Test
    public void testFindFirst() throws Exception {
         assertEquals(134043, P47_DistinctPrimeFactors.findFirst());
    }

    @Test
    public void testIsSolution() throws Exception {
        assert (P47_DistinctPrimeFactors.isSolution(134043));
        assert (!P47_DistinctPrimeFactors.isSolution(644));
    }

    @Test
    public void testHasFourDistinctPrimeFactors() throws Exception {
        assert (!P47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134042));
        assert (P47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134043));
        assert (P47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134044));
        assert (P47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134045));
        assert (P47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134046));
        assert (!P47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134047));
    }
}