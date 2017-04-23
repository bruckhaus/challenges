import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrimeSequenceTest {

    @Test
    public void findList() throws Exception {
        PrimeSequence p = new PrimeSequence();                                               // indices:
        assertEquals("2", p.findList(1).toString());                          // 1
        assertEquals("3, 7", p.findList(2).toString());                       // 2, 4
        assertEquals("3, 37, 67", p.findList(3).toString());                  // 2, 12, 19
        assertEquals("3, 7, 109, 673", p.findList(4).toString());             // 2, 4, 29, 122
        assertEquals("13, 5197, 5701, 6733, 8389", p.findList(5).toString()); // 6, 692, 751, 868, 1051
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void testFind() throws Exception {
        PrimeSequence p = new PrimeSequence();
        assertArrayEquals(new Integer[]{2, 4, 29, 122}, p.find(4, 122, 0).toArray());
        assertArrayEquals(new Integer[]{9, 64, 123, 144}, p.find(4, 144, 0).toArray());
        assertArrayEquals(new Integer[]{5, 52, 176, 283}, p.find(4, 283, 0).toArray());
        assertArrayEquals(new Integer[]{50, 112, 556, 868}, p.find(4, 868, 0).toArray());
        assertArrayEquals(new Integer[]{6, 692, 751, 868}, p.find(4, 868, 31).toArray());
        assertNull(p.find(4, 121, 0));
        assertNull(p.find(4, 123, 0));
        assertNull(p.find(4, 143, 0));
        assertNull(p.find(4, 145, 0));
    }

    @Test
    public void testMakeList() throws Exception {
        assertArrayEquals(new Integer[]{1}, PrimeSequence.makeList(1).toArray());
        assertArrayEquals(new Integer[]{777}, PrimeSequence.makeList(777).toArray());
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
}
