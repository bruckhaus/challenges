import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class P61_CyclicalFigurateNumbersTest {
    @Test
    public void getSum() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("12");
        assertEquals(0, P61_CyclicalFigurateNumbers.getSum(list));
        list.add("34");
        assertEquals(1234, P61_CyclicalFigurateNumbers.getSum(list));
        list.add("56");
        assertEquals(1234 + 3456, P61_CyclicalFigurateNumbers.getSum(list));
        list.add("78");
        assertEquals(1234 + 3456 + 5678, P61_CyclicalFigurateNumbers.getSum(list));
        list.add("90");
        assertEquals(1234 + 3456 + 5678 + 7890, P61_CyclicalFigurateNumbers.getSum(list));
        list.add("12");
        assertEquals(1234 + 3456 + 5678 + 7890 + 9012, P61_CyclicalFigurateNumbers.getSum(list));
    }

    @Test
    public void testGetList1() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] polygonal = new int[]{8, 19};
        assertEquals(1045, PolygonalNumber.calculate(polygonal));
        solution.add(polygonal);
        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.find(1).toArray());
    }

    @Test
    public void testGetList2() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] p1 = new int[]{5, 55};
        int[] p2 = new int[]{8, 19};
        assertEquals(4510, PolygonalNumber.calculate(p1));
        assertEquals(1045, PolygonalNumber.calculate(p2));
        solution.add(p1);
        solution.add(p2);
        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.find(2).toArray());
    }

    @Test
    public void testGetList3() throws Exception {
//        List<String> result = P61_CyclicalFigurateNumbers.find(3);
//        List<int[]> expected = new ArrayList<>();
//        int[] pentagonal = {5, 59};
//        int[] square = {4, 96};
//        int[] heptagonal = {7, 26};
//        expected.add(pentagonal);
//        expected.add(square);
//        expected.add(heptagonal);
//        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testGetListWithThreeArgs() throws Exception {
    }

    @Test
    public void testCheckSolution() throws Exception {
        List<int[]> solution = new ArrayList<>();
        List<int[]> newSolution;

        int[] triangle = {3, 127};
        newSolution = P61_CyclicalFigurateNumbers.checkSolution(3, solution, triangle);
        assert newSolution != null;
        assertEquals(1, solution.size());
        assertEquals(1, newSolution.size());
        assertArrayEquals(solution.toArray(), newSolution.toArray());

        int[] pentagonal = {5, 44};
        newSolution = P61_CyclicalFigurateNumbers.checkSolution(3, solution, pentagonal);
        assert newSolution != null;
        assertEquals(2, solution.size());
        assertEquals(2, newSolution.size());
        assertArrayEquals(solution.toArray(), newSolution.toArray());

        int[] square = {4, 91};
        newSolution = P61_CyclicalFigurateNumbers.checkSolution(3, solution, square);
        assert newSolution != null;
        assertEquals(3, solution.size());
        assertEquals(3, newSolution.size());
        assertArrayEquals(solution.toArray(), newSolution.toArray());
    }

    @Test
    public void testIsSolution() throws Exception {
        List<int[]> solution = new ArrayList<>();
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
        solution.add(new int[]{3, 127});
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
        solution.add(new int[]{5, 44});
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
        solution.add(new int[]{4, 91});
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
    }
}
