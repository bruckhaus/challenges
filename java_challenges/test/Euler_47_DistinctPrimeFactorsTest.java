import org.junit.Test;

import static org.junit.Assert.*;

public class Euler_47_DistinctPrimeFactorsTest {

    @Test
    public void testFindFirst() throws Exception {
        assertEquals(134043, Euler_47_DistinctPrimeFactors.findFirst());
    }

    @Test
    public void testIsSolution() throws Exception {
        assert(Euler_47_DistinctPrimeFactors.isSolution(134043));
        assert(!Euler_47_DistinctPrimeFactors.isSolution(644));
    }

    @Test
    public void testHasFourDistinctPrimeFactors() throws Exception {
        assert(!Euler_47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134042));
        assert(Euler_47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134043));
        assert(Euler_47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134044));
        assert(Euler_47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134045));
        assert(Euler_47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134046));
        assert(!Euler_47_DistinctPrimeFactors.hasFourDistinctPrimeFactors(134047));
    }
}