import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CyclicPolygonalTest {

    @Test
    public void testGetValue() throws Exception {
        assertEquals(-1, new PolygonalForEuler61(-1, -1).getValue());
        assertEquals(-1, new PolygonalForEuler61(1, -1).getValue());
        assertEquals(-1, new PolygonalForEuler61(-1, 1).getValue());
        assertEquals(-1, new PolygonalForEuler61(0, 0).getValue());
        assertEquals(-1, new PolygonalForEuler61(1, 1).getValue());
        assertEquals(-1, new PolygonalForEuler61(2, 1).getValue());
        assertEquals(1, new PolygonalForEuler61(3, 1).getValue());
        assertEquals(6, new PolygonalForEuler61(3, 3).getValue());
        assertEquals(16, new PolygonalForEuler61(4, 4).getValue());
        assertEquals(35, new PolygonalForEuler61(5, 5).getValue());
    }

    @Test
    public void testDigitCount() throws Exception {
        assertEquals(0, PolygonalForEuler61.getDigitCount(new int[]{1, 1}));
        assertEquals(3, PolygonalForEuler61.getDigitCount(new int[]{3, 20}));
        assertEquals(4, PolygonalForEuler61.getDigitCount(new int[]{3, 50}));
        assertEquals(5, PolygonalForEuler61.getDigitCount(new int[]{3, 200}));
        assertEquals(3, PolygonalForEuler61.getDigitCount(new int[]{4, 30}));
        assertEquals(4, PolygonalForEuler61.getDigitCount(new int[]{4, 90}));
        assertEquals(5, PolygonalForEuler61.getDigitCount(new int[]{4, 190}));
        assertEquals(3, PolygonalForEuler61.getDigitCount(new int[]{5, 20}));
        assertEquals(4, PolygonalForEuler61.getDigitCount(new int[]{5, 40}));
        assertEquals(5, PolygonalForEuler61.getDigitCount(new int[]{5, 120}));
        assertEquals(3, PolygonalForEuler61.getDigitCount(new int[]{6, 20}));
        assertEquals(4, PolygonalForEuler61.getDigitCount(new int[]{6, 40}));
        assertEquals(5, PolygonalForEuler61.getDigitCount(new int[]{6, 120}));
        assertEquals(3, PolygonalForEuler61.getDigitCount(new int[]{7, 20}));
        assertEquals(4, PolygonalForEuler61.getDigitCount(new int[]{7, 40}));
        assertEquals(5, PolygonalForEuler61.getDigitCount(new int[]{7, 120}));
        assertEquals(3, PolygonalForEuler61.getDigitCount(new int[]{8, 10}));
        assertEquals(4, PolygonalForEuler61.getDigitCount(new int[]{8, 20}));
        assertEquals(5, PolygonalForEuler61.getDigitCount(new int[]{8, 80}));
    }

    @Test
    public void testHasUniqueOrders() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] one = {1, 101};
        int[] two = {2, 202};
        int[] three = {3, 303};
        int[] dupe = {1, 404};
        solution.add(one);
        assert (PolygonalForEuler61.hasUniqueOrders(solution));
        solution.add(two);
        assert (PolygonalForEuler61.hasUniqueOrders(solution));
        solution.add(three);
        assert (PolygonalForEuler61.hasUniqueOrders(solution));
        solution.add(dupe);
        assert (!PolygonalForEuler61.hasUniqueOrders(solution));
    }

    @Test
    public void testHasRequiredDigitCounts() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 101};
        int[] square = {4, 88};
        int[] pentagonal = {5, 77};
        int[] hexagonal = {6, 71};
        assertEquals(5151, PolygonalForEuler61.calculate(triangle));
        assertEquals(7744, PolygonalForEuler61.calculate(square));
        assertEquals(8855, PolygonalForEuler61.calculate(pentagonal));
        assertEquals(10011, PolygonalForEuler61.calculate(hexagonal));
        solution.add(triangle);
        assert (PolygonalForEuler61.hasRequiredDigitCounts(solution, 4));
        solution.add(square);
        assert (PolygonalForEuler61.hasRequiredDigitCounts(solution, 4));
        solution.add(pentagonal);
        assert (PolygonalForEuler61.hasRequiredDigitCounts(solution, 4));
        solution.add(hexagonal);
        assert (!PolygonalForEuler61.hasRequiredDigitCounts(solution, 4));
    }

    @Test
    public void testIsPartialOrWraps() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, PolygonalForEuler61.calculate(triangle));
        assertEquals(2882, PolygonalForEuler61.calculate(pentagonal));
        assertEquals(8281, PolygonalForEuler61.calculate(square));
        // wraps, not partial (note: not cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(square);
        assert (PolygonalForEuler61.isPartialOrWraps(2, solution));
        // partial, does not wrap (note: not cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(triangle);
        assert (PolygonalForEuler61.isPartialOrWraps(3, solution));
        // not partial, does not wrap (note: is cyclic):
        solution.clear();
        solution.add(triangle);
        solution.add(pentagonal);
        assert (!PolygonalForEuler61.isPartialOrWraps(2, solution));
    }

    @Test
    public void testIsCyclicList() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, PolygonalForEuler61.calculate(triangle));
        assertEquals(2882, PolygonalForEuler61.calculate(pentagonal));
        assertEquals(8281, PolygonalForEuler61.calculate(square));
        solution.add(triangle);
        assert (PolygonalForEuler61.isCyclicList(solution));
        solution.add(pentagonal);
        assert (PolygonalForEuler61.isCyclicList(solution));
        solution.add(square);
        assert (PolygonalForEuler61.isCyclicList(solution));
    }

    @Test
    public void testIsCyclicWithPrevious() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, PolygonalForEuler61.calculate(triangle));
        assertEquals(2882, PolygonalForEuler61.calculate(pentagonal));
        assertEquals(8281, PolygonalForEuler61.calculate(square));
        solution.add(triangle);
        solution.add(pentagonal);
        solution.add(square);
        solution.add(square);
        assert !PolygonalForEuler61.isCyclicWithPrevious(solution, 0);
        assert PolygonalForEuler61.isCyclicWithPrevious(solution, 1);
        assert PolygonalForEuler61.isCyclicWithPrevious(solution, 2);
        assert !PolygonalForEuler61.isCyclicWithPrevious(solution, 3);
        assert !PolygonalForEuler61.isCyclicWithPrevious(solution, 4);
    }

    @Test
    public void testIsCyclicListMembers() throws Exception {
        List<int[]> solution = new ArrayList<>();
        int[] triangle = {3, 127};
        int[] pentagonal = {5, 44};
        int[] square = {4, 91};
        assertEquals(8128, PolygonalForEuler61.calculate(triangle));
        assertEquals(2882, PolygonalForEuler61.calculate(pentagonal));
        assertEquals(8281, PolygonalForEuler61.calculate(square));
        solution.add(triangle);
        solution.add(pentagonal);
        solution.add(square);
        solution.add(square);
        assert PolygonalForEuler61.isCyclicListMembers(solution, 0, 1);
        assert PolygonalForEuler61.isCyclicListMembers(solution, 1, 2);
        assert !PolygonalForEuler61.isCyclicListMembers(solution, 2, 3);
        assert !PolygonalForEuler61.isCyclicListMembers(solution, 3, 4);
        assert PolygonalForEuler61.isCyclicListMembers(solution, 2, 0);
        assert PolygonalForEuler61.isCyclicListMembers(solution, 3, 0);
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
        assertEquals(8128, PolygonalForEuler61.calculate(triangle));
        assertEquals(8281, PolygonalForEuler61.calculate(square));
        assertEquals(2882, PolygonalForEuler61.calculate(pentagonal));
        assert PolygonalForEuler61.isCyclic(triangle, pentagonal);
        assert PolygonalForEuler61.isCyclic(pentagonal, square);
        assert PolygonalForEuler61.isCyclic(square, triangle);
        assert !PolygonalForEuler61.isCyclic(pentagonal, triangle);
        assert !PolygonalForEuler61.isCyclic(square, pentagonal);
        assert !PolygonalForEuler61.isCyclic(triangle, square);
    }

    @Test
    public void testGetFirstDigits() throws Exception {
        int[] polygonal = {3, 1};
        assertEquals(1, PolygonalForEuler61.calculate(polygonal));
        assert "1".equals(PolygonalForEuler61.getHead(polygonal, 2));
        polygonal = new int[]{4, 5};
        assertEquals(25, PolygonalForEuler61.calculate(polygonal));
        assert "25".equals(PolygonalForEuler61.getHead(polygonal, 2));
        polygonal = new int[]{8, 19};
        assertEquals(1045, PolygonalForEuler61.calculate(polygonal));
        assert "10".equals(PolygonalForEuler61.getHead(polygonal, 2));
        polygonal = new int[]{8, 192};
        assertEquals(110208, PolygonalForEuler61.calculate(polygonal));
        assert "11".equals(PolygonalForEuler61.getHead(polygonal, 2));
    }

    @Test
    public void testGetLastDigits() throws Exception {
        int[] polygonal = {3, 1};
        assertEquals(1, PolygonalForEuler61.calculate(polygonal));
        assert "1".equals(PolygonalForEuler61.getTail(polygonal, 2));
        polygonal = new int[]{4, 5};
        assertEquals(25, PolygonalForEuler61.calculate(polygonal));
        assert "25".equals(PolygonalForEuler61.getTail(polygonal, 2));
        polygonal = new int[]{8, 19};
        assertEquals(1045, PolygonalForEuler61.calculate(polygonal));
        assert "45".equals(PolygonalForEuler61.getTail(polygonal, 2));
        polygonal = new int[]{8, 192};
        assertEquals(110208, PolygonalForEuler61.calculate(polygonal));
        assert "08".equals(PolygonalForEuler61.getTail(polygonal, 2));
    }

}