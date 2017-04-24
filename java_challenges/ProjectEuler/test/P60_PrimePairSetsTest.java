import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class P60_PrimePairSetsTest {

    @Test
    public void testGetSum() throws Exception {
        assertEquals(Long.valueOf(10), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(1l, 2l, 3l, 4l))));
        assertEquals(Long.valueOf(10), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(1l, 2l, 3l, 4l))));
        assertEquals(Long.valueOf(10), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(3l, 7l))));
        assertEquals(Long.valueOf(107), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(3l, 37l, 67l))));
        assertEquals(Long.valueOf(792), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(3l, 7l, 109l, 673l))));
    }
}
