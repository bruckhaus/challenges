import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void testMax() throws Exception {
        LinkedList l = new LinkedList(19);
        assertEquals(19, l.max());
        l.append(18);
        assertEquals(19, l.max());
        l.append(28);
        assertEquals(28, l.max());
        l.append(4);
        assertEquals(28, l.max());
        l.append(7);
        assertEquals(28, l.max());
        l.append(72);
        assertEquals(72, l.max());
        l.append(72);
        assertEquals(72, l.max());
        l.append(71);
        assertEquals(72, l.max());
    }
}