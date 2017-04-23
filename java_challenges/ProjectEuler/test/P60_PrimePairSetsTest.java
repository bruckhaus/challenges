import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class P60_PrimePairSetsTest {

    @Test
    public void testGetSum() throws Exception {
        assertEquals(Integer.valueOf(10), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
        assertEquals(Integer.valueOf(10), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
        assertEquals(Integer.valueOf(10), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(3, 7))));
        assertEquals(Integer.valueOf(107), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(3, 37, 67))));
        assertEquals(Integer.valueOf(792), P60_PrimePairSets.getSum(new ArrayList<>(Arrays.asList(3, 7, 109, 673))));
    }
}
