import org.junit.Test;

import static org.junit.Assert.*;

public class P58_SpiralPrimesTest {

    @Test
    public void getCriticalPrimeLength() throws Exception {
        assertEquals(3, P58_SpiralPrimes.getCriticalPrimeLength(1.0));
        assertEquals(5, P58_SpiralPrimes.getCriticalPrimeLength(0.6));
        assertEquals(11, P58_SpiralPrimes.getCriticalPrimeLength(0.5));
        assertEquals(31, P58_SpiralPrimes.getCriticalPrimeLength(0.4));
        assertEquals(49, P58_SpiralPrimes.getCriticalPrimeLength(0.3));
        assertEquals(309, P58_SpiralPrimes.getCriticalPrimeLength(0.2));
        assertEquals(26241, P58_SpiralPrimes.getCriticalPrimeLength(0.1));
    }
}