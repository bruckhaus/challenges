import org.junit.Test;

import static org.junit.Assert.*;

public class PandigitalTest {

    @Test
    public void testFindOutOfOrderPosition() throws Exception {
        assertEquals(7, Pandigital.positionToIncrease(123456789L));
        assertEquals(4, Pandigital.positionToIncrease(123549876L));
        assertEquals(4, Pandigital.positionToIncrease(987645321L));
        assertEquals(1, Pandigital.positionToIncrease(123));
        assertEquals(0, Pandigital.positionToIncrease(132));
        assertEquals(1, Pandigital.positionToIncrease(213));
        assertEquals(0, Pandigital.positionToIncrease(231));
        assertEquals(1, Pandigital.positionToIncrease(312));
        assertEquals(-1, Pandigital.positionToIncrease(321));
        assertEquals(-1, Pandigital.positionToIncrease(987654321L));
    }

    @Test
    public void testIncreasePosition() throws Exception {
        assertEquals(123456799, Pandigital.increasePosition(123456789L));
        assertEquals(123569876, Pandigital.increasePosition(123549876L));
        assertEquals(987655321, Pandigital.increasePosition(987645321L));
        assertEquals(133, Pandigital.increasePosition(123));
        assertEquals(232, Pandigital.increasePosition(132));
        assertEquals(233, Pandigital.increasePosition(213));
        assertEquals(331, Pandigital.increasePosition(231));
        assertEquals(322, Pandigital.increasePosition(312));
    }

    @Test
    public void testNext() throws Exception {
        assertEquals(123456798, Pandigital.appendInOrder(123456789L));
        assertEquals(123564789, Pandigital.appendInOrder(123549876L));
        assertEquals(987651234, Pandigital.appendInOrder(987645321L));
        assertEquals(132, Pandigital.appendInOrder(123));
        assertEquals(213, Pandigital.appendInOrder(132));
        assertEquals(231, Pandigital.appendInOrder(213));
        assertEquals(312, Pandigital.appendInOrder(231));
        assertEquals(321, Pandigital.appendInOrder(312));
    }
}