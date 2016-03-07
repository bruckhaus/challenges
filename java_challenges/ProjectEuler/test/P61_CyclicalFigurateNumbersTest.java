import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class P61_CyclicalFigurateNumbersTest {

    @Test
    public void testGetList() throws Exception {

    }

    @Test
    public void testGetList1() throws Exception {

    }

    @Test
    public void testCheckSolution() throws Exception {
        List<int[]> solution = new ArrayList<>();
        List<int[]> newSolution;

        int[] triangle = {3, 127};
        newSolution = P61_CyclicalFigurateNumbers.checkSolution(solution, triangle);
        assert newSolution != null;
        assertArrayEquals(solution.toArray(), newSolution.toArray());

        solution.add(triangle);
        int[] pentagonal = {5, 44};
        newSolution = P61_CyclicalFigurateNumbers.checkSolution(solution, pentagonal);
        System.out.println("solution = " + solution.toString());
        System.out.println("newSolution = " + newSolution);
        assert newSolution != null;
        assertEquals(P61_CyclicalFigurateNumbers.getSum(solution), P61_CyclicalFigurateNumbers.getSum(newSolution));

        solution.add(pentagonal);
        int[] square = {4, 91};
        solution.add(square);
        newSolution = P61_CyclicalFigurateNumbers.checkSolution(solution, triangle);
        assert newSolution != null;
        assertArrayEquals(solution.toArray(), newSolution.toArray());
    }

    @Test
    public void testIsSolution() throws Exception {
        // todo: positive and negative tests to check that last is cyclic with first
        List<int[]> solution = new ArrayList<>();
        assert P61_CyclicalFigurateNumbers.isSolution(solution);
        int[] triangle = {3, 127};
        solution.add(triangle);
        assert P61_CyclicalFigurateNumbers.isSolution(solution);
        int[] pentagonal = {5, 44};
        solution.add(pentagonal);
        assert P61_CyclicalFigurateNumbers.isSolution(solution);
        int[] square = {4, 91};
        solution.add(square);
        assert P61_CyclicalFigurateNumbers.isSolution(solution);
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
}