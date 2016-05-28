import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CyclicPolygonalTest {

    @Test
    public void testGetValue() throws Exception {
        assertEquals(-1, CyclicPolygonal.getValue(new int[]{-1, -1}));
        assertEquals(-1, CyclicPolygonal.getValue(new int[]{1, -1}));
        assertEquals(-1, CyclicPolygonal.getValue(new int[]{-1, 1}));
        assertEquals(-1, CyclicPolygonal.getValue(new int[]{0, 0}));
        assertEquals(-1, CyclicPolygonal.getValue(new int[]{1, 1}));
        assertEquals(-1, CyclicPolygonal.getValue(new int[]{2, 1}));
        assertEquals(1, CyclicPolygonal.getValue(new int[]{3, 1}));
        assertEquals(6, CyclicPolygonal.getValue(new int[]{3, 3}));
        assertEquals(16, CyclicPolygonal.getValue(new int[]{4, 4}));
        assertEquals(35, CyclicPolygonal.getValue(new int[]{5, 5}));
    }

    @Test
    public void testMakeList1() throws Exception {
        List<int[]> list = CyclicPolygonal.makeList(new int[]{3, 3});
        assertArrayEquals(new int[][]{{3, 3}}, list.toArray());
    }

    @Test
    public void testMakeList2() throws Exception {
        List<int[]> list = CyclicPolygonal.makeList(3, 3);
        assertArrayEquals(new int[][]{{3, 3}}, list.toArray());
    }

    @Test
    public void testMakePolygonal() throws Exception {
        assertArrayEquals(new int[]{3, 3}, CyclicPolygonal.makePolygonal(3, 3));
    }

    @Test
    public void testGetSum() throws Exception {
        List<int[]> list = new ArrayList<>();
        assertEquals(0, CyclicPolygonal.getSum(list));
        list.add(new int[]{3, 10});
        assertEquals(55, CyclicPolygonal.getSum(list));
        list.add(new int[]{4, 11});
        assertEquals(176, CyclicPolygonal.getSum(list));
        list.add(new int[]{6, 12});
        assertEquals(452, CyclicPolygonal.getSum(list));
    }

    @Test
    public void testDigitCount() throws Exception {
        assertEquals(0, CyclicPolygonal.getDigitCount(new int[]{1, 1}));
        assertEquals(3, CyclicPolygonal.getDigitCount(new int[]{3, 20}));
        assertEquals(4, CyclicPolygonal.getDigitCount(new int[]{3, 50}));
        assertEquals(5, CyclicPolygonal.getDigitCount(new int[]{3, 200}));
        assertEquals(3, CyclicPolygonal.getDigitCount(new int[]{4, 30}));
        assertEquals(4, CyclicPolygonal.getDigitCount(new int[]{4, 90}));
        assertEquals(5, CyclicPolygonal.getDigitCount(new int[]{4, 190}));
        assertEquals(3, CyclicPolygonal.getDigitCount(new int[]{5, 20}));
        assertEquals(4, CyclicPolygonal.getDigitCount(new int[]{5, 40}));
        assertEquals(5, CyclicPolygonal.getDigitCount(new int[]{5, 120}));
        assertEquals(3, CyclicPolygonal.getDigitCount(new int[]{6, 20}));
        assertEquals(4, CyclicPolygonal.getDigitCount(new int[]{6, 40}));
        assertEquals(5, CyclicPolygonal.getDigitCount(new int[]{6, 120}));
        assertEquals(3, CyclicPolygonal.getDigitCount(new int[]{7, 20}));
        assertEquals(4, CyclicPolygonal.getDigitCount(new int[]{7, 40}));
        assertEquals(5, CyclicPolygonal.getDigitCount(new int[]{7, 120}));
        assertEquals(3, CyclicPolygonal.getDigitCount(new int[]{8, 10}));
        assertEquals(4, CyclicPolygonal.getDigitCount(new int[]{8, 20}));
        assertEquals(5, CyclicPolygonal.getDigitCount(new int[]{8, 80}));
    }

    @Test
    public void testHasUniqueOrders() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] one = {1, 101};
        int[] two = {2, 202};
        int[] three = {3, 303};
        int[] dupe = {1, 404};
        solution.add(one);
        assert (CyclicPolygonal.hasUniqueOrders(solution));
        solution.add(two);
        assert (CyclicPolygonal.hasUniqueOrders(solution));
        solution.add(three);
        assert (CyclicPolygonal.hasUniqueOrders(solution));
        solution.add(dupe);
        assert (!CyclicPolygonal.hasUniqueOrders(solution));
    }

    @Test
    public void testHasRequiredDigitCounts() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 101};
        int[] square = {4, 88};
        int[] pentagonal = {5, 77};
        int[] hexagonal = {6, 71};
        assertEquals(5151, CyclicPolygonal.getValue(triangle));
        assertEquals(7744, CyclicPolygonal.getValue(square));
        assertEquals(8855, CyclicPolygonal.getValue(pentagonal));
        assertEquals(10011, CyclicPolygonal.getValue(hexagonal));
        solution.add(triangle);
        assert (CyclicPolygonal.hasRequiredDigitCounts(solution, 4));
        solution.add(square);
        assert (CyclicPolygonal.hasRequiredDigitCounts(solution, 4));
        solution.add(pentagonal);
        assert (CyclicPolygonal.hasRequiredDigitCounts(solution, 4));
        solution.add(hexagonal);
        assert (!CyclicPolygonal.hasRequiredDigitCounts(solution, 4));
    }

    @Test
    public void testIsPartialOrWraps() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, CyclicPolygonal.getValue(triangle));
        assertEquals(2882, CyclicPolygonal.getValue(pentagonal));
        assertEquals(8281, CyclicPolygonal.getValue(square));
        // wraps, not partial (note: not cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(square);
        assert (CyclicPolygonal.isPartialOrWraps(2, solution));
        // partial, does not wrap (note: not cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(triangle);
        assert (CyclicPolygonal.isPartialOrWraps(3, solution));
        // not partial, does not wrap (note: is cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(pentagonal);
        assert (!CyclicPolygonal.isPartialOrWraps(2, solution));
    }

    @Test
    public void testIsCyclicList() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, CyclicPolygonal.getValue(triangle));
        assertEquals(2882, CyclicPolygonal.getValue(pentagonal));
        assertEquals(8281, CyclicPolygonal.getValue(square));
        solution.add(triangle);
        assert (CyclicPolygonal.isCyclicList(solution));
        solution.add(pentagonal);
        assert (CyclicPolygonal.isCyclicList(solution));
        solution.add(square);
        assert (CyclicPolygonal.isCyclicList(solution));
    }

    @Test
    public void testIsCyclicWithPrevious() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, CyclicPolygonal.getValue(triangle));
        assertEquals(2882, CyclicPolygonal.getValue(pentagonal));
        assertEquals(8281, CyclicPolygonal.getValue(square));
        solution.add(triangle);
        solution.add(pentagonal);
        solution.add(square);
        solution.add(square);
        assert !CyclicPolygonal.isCyclicWithPrevious(solution, 0);
        assert CyclicPolygonal.isCyclicWithPrevious(solution, 1);
        assert CyclicPolygonal.isCyclicWithPrevious(solution, 2);
        assert !CyclicPolygonal.isCyclicWithPrevious(solution, 3);
        assert !CyclicPolygonal.isCyclicWithPrevious(solution, 4);
    }

    @Test
    public void testIsCyclicListMembers() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, CyclicPolygonal.getValue(triangle));
        assertEquals(2882, CyclicPolygonal.getValue(pentagonal));
        assertEquals(8281, CyclicPolygonal.getValue(square));
        solution.add(triangle);
        solution.add(pentagonal);
        solution.add(square);
        solution.add(square);
        assert CyclicPolygonal.isCyclicListMembers(solution, 0, 1);
        assert CyclicPolygonal.isCyclicListMembers(solution, 1, 2);
        assert !CyclicPolygonal.isCyclicListMembers(solution, 2, 3);
        assert !CyclicPolygonal.isCyclicListMembers(solution, 3, 4);
        assert CyclicPolygonal.isCyclicListMembers(solution, 2, 0);
        assert CyclicPolygonal.isCyclicListMembers(solution, 3, 0);
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
        assertEquals(8128, CyclicPolygonal.getValue(triangle));
        assertEquals(8281, CyclicPolygonal.getValue(square));
        assertEquals(2882, CyclicPolygonal.getValue(pentagonal));
        assert CyclicPolygonal.isCyclic(triangle, pentagonal);
        assert CyclicPolygonal.isCyclic(pentagonal, square);
        assert CyclicPolygonal.isCyclic(square, triangle);
        assert !CyclicPolygonal.isCyclic(pentagonal, triangle);
        assert !CyclicPolygonal.isCyclic(square, pentagonal);
        assert !CyclicPolygonal.isCyclic(triangle, square);
    }

    @Test
    public void testGetFirstDigits() throws Exception {
        int[] polygonal = {3, 1};
        assertEquals(1, CyclicPolygonal.getValue(polygonal));
        assert "1".equals(CyclicPolygonal.getFirstDigits(polygonal, 2));
        polygonal = new int[]{4, 5};
        assertEquals(25, CyclicPolygonal.getValue(polygonal));
        assert "25".equals(CyclicPolygonal.getFirstDigits(polygonal, 2));
        polygonal = new int[]{8, 19};
        assertEquals(1045, CyclicPolygonal.getValue(polygonal));
        assert "10".equals(CyclicPolygonal.getFirstDigits(polygonal, 2));
        polygonal = new int[]{8, 192};
        assertEquals(110208, CyclicPolygonal.getValue(polygonal));
        assert "11".equals(CyclicPolygonal.getFirstDigits(polygonal, 2));
    }

    @Test
    public void testGetLastDigits() throws Exception {
        int[] polygonal = {3, 1};
        assertEquals(1, CyclicPolygonal.getValue(polygonal));
        assert "1".equals(CyclicPolygonal.getLastDigits(polygonal, 2));
        polygonal = new int[]{4, 5};
        assertEquals(25, CyclicPolygonal.getValue(polygonal));
        assert "25".equals(CyclicPolygonal.getLastDigits(polygonal, 2));
        polygonal = new int[]{8, 19};
        assertEquals(1045, CyclicPolygonal.getValue(polygonal));
        assert "45".equals(CyclicPolygonal.getLastDigits(polygonal, 2));
        polygonal = new int[]{8, 192};
        assertEquals(110208, CyclicPolygonal.getValue(polygonal));
        assert "08".equals(CyclicPolygonal.getLastDigits(polygonal, 2));
    }

}