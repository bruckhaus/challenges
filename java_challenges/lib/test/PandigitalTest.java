import org.junit.Test;

import static org.junit.Assert.*;

public class PandigitalTest {

    @Test
    public void testFindPosition() throws Exception {
        assertEquals(7, Pandigital.findPosition(123456789L));
        assertEquals(4, Pandigital.findPosition(123549876L));
        assertEquals(4, Pandigital.findPosition(987645321L));
        assertEquals(1, Pandigital.findPosition(123));
        assertEquals(0, Pandigital.findPosition(132));
        assertEquals(1, Pandigital.findPosition(213));
        assertEquals(0, Pandigital.findPosition(231));
        assertEquals(1, Pandigital.findPosition(312));
        assertEquals(-1, Pandigital.findPosition(321));
        assertEquals(-1, Pandigital.findPosition(987654321L));
    }

    @Test
    public void testIncrementPosition() throws Exception {
        assertEquals(123456799, Pandigital.incrementPosition(123456789L));
        assertEquals(123569876, Pandigital.incrementPosition(123549876L));
        assertEquals(987655321, Pandigital.incrementPosition(987645321L));
        assertEquals(133, Pandigital.incrementPosition(123));
        assertEquals(232, Pandigital.incrementPosition(132));
        assertEquals(233, Pandigital.incrementPosition(213));
        assertEquals(331, Pandigital.incrementPosition(231));
        assertEquals(322, Pandigital.incrementPosition(312));
    }

    @Test
    public void testNext() throws Exception {
        assertEquals(123456798, Pandigital.next(123456789L));
        assertEquals(123564789, Pandigital.next(123549876L));
        assertEquals(987651234, Pandigital.next(987645321L));
        assertEquals(132, Pandigital.next(123));
        assertEquals(213, Pandigital.next(132));
        assertEquals(231, Pandigital.next(213));
        assertEquals(312, Pandigital.next(231));
        assertEquals(321, Pandigital.next(312));
    }
}