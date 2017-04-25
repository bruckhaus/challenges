import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicPolygonalSequenceTest {
    @Test
    public void getSum() throws Exception {
        CyclicPolygonalSequence list = new CyclicPolygonalSequence();
        assertEquals(0, list.getSum());
        list.add(new int[]{3, 10});
        assertEquals(55, PolygonalNumber.getSum(list));
        list.add(new int[]{4, 11});
        assertEquals(176, PolygonalNumber.getSum(list));
        list.add(new int[]{6, 12});
        assertEquals(452, PolygonalNumber.getSum(list));
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