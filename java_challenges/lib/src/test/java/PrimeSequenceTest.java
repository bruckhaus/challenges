import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrimeSequenceTest {

    @Test
    public void testFindPrimes() throws Exception {
        PrimeSequence p = new PrimeSequence();
        assertEquals("[2]", p.findPrimes(1).toString());
        assertEquals("[3, 7]", p.findPrimes(2).toString());
        assertEquals("[3, 37, 67]", p.findPrimes(3).toString());
        assertEquals("[3, 7, 109, 673]", p.findPrimes(4).toString());
        assertEquals("[13, 5197, 5701, 6733, 8389]", p.findPrimes(5).toString());
    }

    @Test
    public void testFindList() throws Exception {
        PrimeSequence p = new PrimeSequence();
        assertEquals("[1]", p.findList(1).toString());
        assertEquals("[2, 4]", p.findList(2).toString());
        assertEquals("[2, 12, 19]", p.findList(3).toString());
        assertEquals("[2, 4, 29, 122]", p.findList(4).toString());
        assertEquals("[6, 692, 751, 868, 1051]", p.findList(5).toString());
    }

    @Test
    public void testFind() throws Exception {
        PrimeSequence p = new PrimeSequence();
        assertEquals("[2, 4, 29, 122]", p.find(4, 122, 0).toString());
        assertEquals("[9, 64, 123, 144]", p.find(4, 144, 0).toString());
        assertEquals("[5, 52, 176, 283]", p.find(4, 283, 0).toString());
        assertEquals("[50, 112, 556, 868]", p.find(4, 868, 0).toString());
        assertEquals("[6, 692, 751, 868]", p.find(4, 868, 31).toString());
        assertNull(p.find(4, 121, 0));
        assertNull(p.find(4, 123, 0));
        assertNull(p.find(4, 143, 0));
        assertNull(p.find(4, 145, 0));
    }

    @Test
    public void testCheckPartial() throws Exception {
        List<Integer> result;
        result = PrimeSequence.checkPartial(PrimeSequence.makeList(2), 3);
        assertNull(result);

        result = PrimeSequence.checkPartial(PrimeSequence.makeList(2), 4);
        assertNotNull(result);
        assertArrayEquals(new Integer[]{2, 4}, result.toArray());
    }

    @Test
    public void testMakeList() throws Exception {
        assertArrayEquals(new Integer[]{1}, PrimeSequence.makeList(1).toArray());
        assertArrayEquals(new Integer[]{777}, PrimeSequence.makeList(777).toArray());
    }
}
