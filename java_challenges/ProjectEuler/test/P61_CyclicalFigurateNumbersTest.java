import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class P61_CyclicalFigurateNumbersTest {

    @Test
    public void testGetList1() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] polygonal = new int[]{8, 19};
        assertEquals(1045, P61_CyclicalFigurateNumbers.getValue(polygonal));
        solution.add(polygonal);
        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.findSolutionList(1).toArray());
    }

    @Test
    public void testGetList2() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] p1 = new int[]{8, 19};
        int[] p2 = new int[]{5, 55};
        assertEquals(1045, P61_CyclicalFigurateNumbers.getValue(p1));
        assertEquals(4510, P61_CyclicalFigurateNumbers.getValue(p2));
        solution.add(p1);
        solution.add(p2);
        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.findSolutionList(2).toArray());
    }

    @Test
    public void testGetList3() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {5, 52};
        int[] pentagonal = {7, 35};
        int[] square = {8, 19};
        solution.add(triangle);
        solution.add(pentagonal);
        solution.add(square);
        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.findSolutionList(3).toArray());
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
        // todo: positive and negative tests to check that last is cyclic with first
        List<int[]> solution = new ArrayList<>();
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
        solution.add(new int[]{3, 127});
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
        solution.add(new int[]{5, 44});
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
        solution.add(new int[]{4, 91});
        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
    }

    @Test
    public void testIsCyclic() throws Exception {
        // 8128, 2882, 8281 are cyclic:
        // triangle   P(3,127) = 8128
        // square     P(4, 91) = 8281
        // pentagonal P(5, 44) = 2882
        int[] triangle = {3, 127};
        int[] square = {4, 91};
        int[] pentagonal = {5, 44};
        assertEquals(8128, P61_CyclicalFigurateNumbers.getValue(triangle));
        assertEquals(8281, P61_CyclicalFigurateNumbers.getValue(square));
        assertEquals(2882, P61_CyclicalFigurateNumbers.getValue(pentagonal));
        assert P61_CyclicalFigurateNumbers.isCyclic(triangle, pentagonal);
        assert P61_CyclicalFigurateNumbers.isCyclic(pentagonal, square);
        assert P61_CyclicalFigurateNumbers.isCyclic(square, triangle);
        assert !P61_CyclicalFigurateNumbers.isCyclic(pentagonal, triangle);
        assert !P61_CyclicalFigurateNumbers.isCyclic(square, pentagonal);
        assert !P61_CyclicalFigurateNumbers.isCyclic(triangle, square);
    }

    @Test
    public void testMakeList() throws Exception {
        List<int[]> list = P61_CyclicalFigurateNumbers.makeList(3, 3);
        assertArrayEquals(new int[][]{{3, 45}}, list.toArray());
    }

    @Test
    public void testMakePolygonal() throws Exception {
        assertArrayEquals(new int[]{3, 3}, P61_CyclicalFigurateNumbers.makePolygonal(3, 3));
    }

    @Test
    public void testGetSum() throws Exception {
        List<int[]> list = new ArrayList<>();
        assertEquals(0, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(new int[]{3, 10});
        assertEquals(55, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(new int[]{4, 11});
        assertEquals(176, P61_CyclicalFigurateNumbers.getSum(list));
        list.add(new int[]{6, 12});
        assertEquals(452, P61_CyclicalFigurateNumbers.getSum(list));
    }

    @Test
    public void testDigitCount() throws Exception {
        assertEquals(0, P61_CyclicalFigurateNumbers.digitCount(new int[]{1, 1}));
        assertEquals(3, P61_CyclicalFigurateNumbers.digitCount(new int[]{3, 20}));
        assertEquals(4, P61_CyclicalFigurateNumbers.digitCount(new int[]{3, 50}));
        assertEquals(5, P61_CyclicalFigurateNumbers.digitCount(new int[]{3, 200}));
        assertEquals(3, P61_CyclicalFigurateNumbers.digitCount(new int[]{4, 30}));
        assertEquals(4, P61_CyclicalFigurateNumbers.digitCount(new int[]{4, 90}));
        assertEquals(5, P61_CyclicalFigurateNumbers.digitCount(new int[]{4, 190}));
        assertEquals(3, P61_CyclicalFigurateNumbers.digitCount(new int[]{5, 20}));
        assertEquals(4, P61_CyclicalFigurateNumbers.digitCount(new int[]{5, 40}));
        assertEquals(5, P61_CyclicalFigurateNumbers.digitCount(new int[]{5, 120}));
        assertEquals(3, P61_CyclicalFigurateNumbers.digitCount(new int[]{6, 20}));
        assertEquals(4, P61_CyclicalFigurateNumbers.digitCount(new int[]{6, 40}));
        assertEquals(5, P61_CyclicalFigurateNumbers.digitCount(new int[]{6, 120}));
        assertEquals(3, P61_CyclicalFigurateNumbers.digitCount(new int[]{7, 20}));
        assertEquals(4, P61_CyclicalFigurateNumbers.digitCount(new int[]{7, 40}));
        assertEquals(5, P61_CyclicalFigurateNumbers.digitCount(new int[]{7, 120}));
        assertEquals(3, P61_CyclicalFigurateNumbers.digitCount(new int[]{8, 10}));
        assertEquals(4, P61_CyclicalFigurateNumbers.digitCount(new int[]{8, 20}));
        assertEquals(5, P61_CyclicalFigurateNumbers.digitCount(new int[]{8, 80}));
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(-1, P61_CyclicalFigurateNumbers.getValue(new int[]{-1, -1}));
        assertEquals(-1, P61_CyclicalFigurateNumbers.getValue(new int[]{1, -1}));
        assertEquals(-1, P61_CyclicalFigurateNumbers.getValue(new int[]{-1, 1}));
        assertEquals(-1, P61_CyclicalFigurateNumbers.getValue(new int[]{0, 0}));
        assertEquals(-1, P61_CyclicalFigurateNumbers.getValue(new int[]{1, 1}));
        assertEquals(-1, P61_CyclicalFigurateNumbers.getValue(new int[]{2, 1}));
        assertEquals(1, P61_CyclicalFigurateNumbers.getValue(new int[]{3, 1}));
        assertEquals(6, P61_CyclicalFigurateNumbers.getValue(new int[]{3, 3}));
        assertEquals(16, P61_CyclicalFigurateNumbers.getValue(new int[]{4, 4}));
        assertEquals(35, P61_CyclicalFigurateNumbers.getValue(new int[]{5, 5}));
    }

    @Test
    public void testGetFirstDigits() throws Exception {
        int[] polygonal = {3, 1};
        assertEquals(1, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "1".equals(P61_CyclicalFigurateNumbers.getFirstDigits(polygonal, 2));
        polygonal = new int[]{4, 5};
        assertEquals(25, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "25".equals(P61_CyclicalFigurateNumbers.getFirstDigits(polygonal, 2));
        polygonal = new int[]{8, 19};
        assertEquals(1045, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "10".equals(P61_CyclicalFigurateNumbers.getFirstDigits(polygonal, 2));
        polygonal = new int[]{8, 192};
        assertEquals(110208, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "11".equals(P61_CyclicalFigurateNumbers.getFirstDigits(polygonal, 2));
    }

    @Test
    public void testGetLastDigits() throws Exception {
        int[] polygonal = {3, 1};
        assertEquals(1, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "1".equals(P61_CyclicalFigurateNumbers.getLastDigits(polygonal, 2));
        polygonal = new int[]{4, 5};
        assertEquals(25, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "25".equals(P61_CyclicalFigurateNumbers.getLastDigits(polygonal, 2));
        polygonal = new int[]{8, 19};
        assertEquals(1045, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "45".equals(P61_CyclicalFigurateNumbers.getLastDigits(polygonal, 2));
        polygonal = new int[]{8, 192};
        assertEquals(110208, P61_CyclicalFigurateNumbers.getValue(polygonal));
        assert "08".equals(P61_CyclicalFigurateNumbers.getLastDigits(polygonal, 2));
    }

    @Test
    public void testHasUniqueOrders() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] one = {1, 101};
        int[] two = {2, 202};
        int[] three = {3, 303};
        int[] dupe = {1, 404};
        solution.add(one);
        assert (P61_CyclicalFigurateNumbers.hasUniqueOrders(solution));
        solution.add(two);
        assert (P61_CyclicalFigurateNumbers.hasUniqueOrders(solution));
        solution.add(three);
        assert (P61_CyclicalFigurateNumbers.hasUniqueOrders(solution));
        solution.add(dupe);
        assert (!P61_CyclicalFigurateNumbers.hasUniqueOrders(solution));
    }

    @Test
    public void testIsPartialOrWraps() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, P61_CyclicalFigurateNumbers.getValue(triangle));
        assertEquals(2882, P61_CyclicalFigurateNumbers.getValue(pentagonal));
        assertEquals(8281, P61_CyclicalFigurateNumbers.getValue(square));
        // wraps, not partial (note: not cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(square);
        assert (P61_CyclicalFigurateNumbers.isPartialOrWraps(2, solution));
        // partial, does not wrap (note: not cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(triangle);
        assert (P61_CyclicalFigurateNumbers.isPartialOrWraps(3, solution));
        // not partial, does not wrap (note: is cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(pentagonal);
        assert (!P61_CyclicalFigurateNumbers.isPartialOrWraps(2, solution));
    }

    @Test
    public void testIsCyclicList() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, P61_CyclicalFigurateNumbers.getValue(triangle));
        assertEquals(2882, P61_CyclicalFigurateNumbers.getValue(pentagonal));
        assertEquals(8281, P61_CyclicalFigurateNumbers.getValue(square));
        solution.add(triangle);
        assert (P61_CyclicalFigurateNumbers.isCyclicList(solution));
        solution.add(pentagonal);
        assert (P61_CyclicalFigurateNumbers.isCyclicList(solution));
        solution.add(square);
        assert (P61_CyclicalFigurateNumbers.isCyclicList(solution));
    }

    @Test
    public void testHasRequiredDigitCounts() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 101};
        int[] square = {4, 88};
        int[] pentagonal = {5, 77};
        int[] hexagonal = {6, 71};
        assertEquals(5151, P61_CyclicalFigurateNumbers.getValue(triangle));
        assertEquals(7744, P61_CyclicalFigurateNumbers.getValue(square));
        assertEquals(8855, P61_CyclicalFigurateNumbers.getValue(pentagonal));
        assertEquals(10011, P61_CyclicalFigurateNumbers.getValue(hexagonal));
        solution.add(triangle);
        assert (P61_CyclicalFigurateNumbers.hasRequiredDigitCounts(solution));
        solution.add(square);
        assert (P61_CyclicalFigurateNumbers.hasRequiredDigitCounts(solution));
        solution.add(pentagonal);
        assert (P61_CyclicalFigurateNumbers.hasRequiredDigitCounts(solution));
        solution.add(hexagonal);
        assert (!P61_CyclicalFigurateNumbers.hasRequiredDigitCounts(solution));
    }

    @Test
    public void testIsCyclicWithPrevious() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, P61_CyclicalFigurateNumbers.getValue(triangle));
        assertEquals(2882, P61_CyclicalFigurateNumbers.getValue(pentagonal));
        assertEquals(8281, P61_CyclicalFigurateNumbers.getValue(square));
        solution.add(triangle);
        solution.add(pentagonal);
        solution.add(square);
        solution.add(square);
        assert !P61_CyclicalFigurateNumbers.isCyclicWithPrevious(solution, 0);
        assert P61_CyclicalFigurateNumbers.isCyclicWithPrevious(solution, 1);
        assert P61_CyclicalFigurateNumbers.isCyclicWithPrevious(solution, 2);
        assert !P61_CyclicalFigurateNumbers.isCyclicWithPrevious(solution, 3);
        assert !P61_CyclicalFigurateNumbers.isCyclicWithPrevious(solution, 4);
    }
}