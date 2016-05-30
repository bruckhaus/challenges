import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CyclicPolygonalSequenceTest {
    @Test
    public void getSum() throws Exception {
        List<int[]> list = new ArrayList<>();
        assertEquals(0, PolygonalForEuler61.getSum(list));
        list.add(new int[]{3, 10});
        assertEquals(55, PolygonalForEuler61.getSum(list));
        list.add(new int[]{4, 11});
        assertEquals(176, PolygonalForEuler61.getSum(list));
        list.add(new int[]{6, 12});
        assertEquals(452, PolygonalForEuler61.getSum(list));
    }



    @Test
    public void hasUniqueOrders() throws Exception {

    }

    @Test
    public void hasRequiredDigitCounts() throws Exception {

    }

    @Test
    public void isCyclicAndWraps() throws Exception {

    }

    @Test
    public void isCyclicList() throws Exception {

    }

    @Test
    public void isPartialOrWraps() throws Exception {

    }

    @Test
    public void isCyclicWithPrevious() throws Exception {

    }

    @Test
    public void hasCyclicListMembers() throws Exception {

    }

    @Test
    public void isCyclic() throws Exception {

    }

    @Test
    public void getFirstDigits() throws Exception {

    }

    @Test
    public void getLastDigits() throws Exception {

    }

}