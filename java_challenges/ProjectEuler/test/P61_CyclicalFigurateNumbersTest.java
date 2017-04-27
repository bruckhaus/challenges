import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class P61_CyclicalFigurateNumbersTest {
    @Test
    public void getSum() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(1234l);
        assertEquals(0, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(3456l);
        assertEquals(1234, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(5678l);
        assertEquals(1234 + 3456, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(7890l);
        assertEquals(1234 + 3456 + 5678, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(9012l);
        assertEquals(1234 + 3456 + 5678 + 7890, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(1234l);
        assertEquals(1234 + 3456 + 5678 + 7890 + 9012, P61_CyclicalFigurateNumbers.getSum(list));
    }
}
