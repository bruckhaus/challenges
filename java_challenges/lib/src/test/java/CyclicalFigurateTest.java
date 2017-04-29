import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class CyclicalFigurateTest {

    @Test
    public void testBuildPolygonals() throws Exception {
        CyclicalFigurate c = new CyclicalFigurate();
        TreeMap<Long, List<PolygonalNumber>> p = c.buildPolygonals();
        int polygonalCount = 0;
        for (Long key : p.keySet()) {
            List<PolygonalNumber> value = p.get(key);
            polygonalCount += value.size();
        }
        assertEquals(351, polygonalCount);
        // We know that 8128, 2882, and 8281 must be in the polygonal map (see Euler problem 61 definition):
        assertEquals("[p(3,128)=8256, p(4,91)=8281]", p.get(82L).toString());
        assertEquals("[p(3,127)=8128, p(4,90)=8100, p(5,74)=8177, p(6,64)=8128]", p.get(81L).toString());
        assertEquals("[p(3,75)=2850, p(4,53)=2809, p(5,44)=2882, p(6,38)=2850, p(7,34)=2839, p(8,31)=2821]",
                p.get(28L).toString());
        for (Map.Entry<Long, List<PolygonalNumber>> entry : p.entrySet()) {
            List<PolygonalNumber> list = entry.getValue();
            for (PolygonalNumber n : list) {
                assertTrue(n.getBase() >= c.MIN_ORDER && n.getBase() <= c.MAX_ORDER);
                assertTrue(n.getValue() >= c.MIN_VALUE && n.getLength() <= c.MAX_VALUE);
            }
        }
    }

    @Test
    public void testFind() throws Exception {
    }

    @Test
    public void testFindPolygonals() throws Exception {
    }

    @Test
    public void testAddPolygonal() throws Exception {
        CyclicalFigurate c = new CyclicalFigurate();
        TreeMap<Long, List<PolygonalNumber>> map = new TreeMap<>();
        assertEquals("{}", map.toString());
        map = c.addPolygonal(map, new PolygonalNumber(8, 123));
        assertEquals("{451=[p(8,123)=45141]}", map.toString());
        map = c.addPolygonal(map, new PolygonalNumber(7, 765));
        assertEquals("{451=[p(8,123)=45141], 14619=[p(7,765)=1461915]}", map.toString());
    }

    @Test
    public void checkSolution() throws Exception {
        int size = 0;
        List<PolygonalNumber> partial = new ArrayList<>();
        PolygonalNumber p = new PolygonalNumber(0, 0);
        List<PolygonalNumber> result = CyclicalFigurate.checkSolution(size, partial, p);
        assertNull(result);
    }

    @Test
    public void isSolution() throws Exception {
        List<PolygonalNumber> l = new ArrayList<>();
        assertEquals(true, CyclicalFigurate.isSolution(0, l));
    }

    @Test
    public void hasRequiredDigitCounts() throws Exception {
        List<PolygonalNumber> l = new ArrayList<>();
        assertEquals(true, CyclicalFigurate.hasRequiredDigitCounts(l));
    }

    @Test
    public void isCyclicAndWraps() throws Exception {
    }

    @Test
    public void isCyclic() throws Exception {
    }

//    @Test
//    public void testHasUniqueOrders() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] one = {1, 101};
//        int[] two = {2, 202};
//        int[] three = {3, 303};
//        int[] dupe = {1, 404};
//        solution.add(one);
//        assert (PolygonalNumber.hasUniqueOrders(solution));
//        solution.add(two);
//        assert (PolygonalNumber.hasUniqueOrders(solution));
//        solution.add(three);
//        assert (PolygonalNumber.hasUniqueOrders(solution));
//        solution.add(dupe);
//        assert (!PolygonalNumber.hasUniqueOrders(solution));
//    }
//
//    @Test
//    public void testHasRequiredDigitCounts() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] triangle = {3, 101};
//        int[] square = {4, 88};
//        int[] pentagonal = {5, 77};
//        int[] hexagonal = {6, 71};
//        assertEquals(5151, PolygonalNumber.calculate(triangle));
//        assertEquals(7744, PolygonalNumber.calculate(square));
//        assertEquals(8855, PolygonalNumber.calculate(pentagonal));
//        assertEquals(10011, PolygonalNumber.calculate(hexagonal));
//        solution.add(triangle);
//        assert (PolygonalNumber.hasRequiredDigitCounts(solution, 4));
//        solution.add(square);
//        assert (PolygonalNumber.hasRequiredDigitCounts(solution, 4));
//        solution.add(pentagonal);
//        assert (PolygonalNumber.hasRequiredDigitCounts(solution, 4));
//        solution.add(hexagonal);
//        assert (!PolygonalNumber.hasRequiredDigitCounts(solution, 4));
//    }
//
//    @Test
//    public void testIsPartialOrWraps() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] triangle = {3, 127};
//        int[] pentagonal = {5, 44};
//        int[] square = {4, 91};
//        assertEquals(8128, PolygonalNumber.calculate(triangle));
//        assertEquals(2882, PolygonalNumber.calculate(pentagonal));
//        assertEquals(8281, PolygonalNumber.calculate(square));
//        // wraps, not partial (note: not cyclic):
//        solution.clear();
//        solution.add(triangle);
//        solution.add(square);
//        assert (PolygonalNumber.isPartialOrWraps(2, solution));
//        // partial, does not wrap (note: not cyclic):
//        solution.clear();
//        solution.add(triangle);
//        solution.add(triangle);
//        assert (PolygonalNumber.isPartialOrWraps(3, solution));
//        // not partial, does not wrap (note: is cyclic):
//        solution.clear();
//        solution.add(triangle);
//        solution.add(pentagonal);
//        assert (!PolygonalNumber.isPartialOrWraps(2, solution));
//    }
//
//    @Test
//    public void testIsCyclicList() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] triangle = {3, 127};
//        int[] pentagonal = {5, 44};
//        int[] square = {4, 91};
//        assertEquals(8128, PolygonalNumber.calculate(triangle));
//        assertEquals(2882, PolygonalNumber.calculate(pentagonal));
//        assertEquals(8281, PolygonalNumber.calculate(square));
//        solution.add(triangle);
//        assert (PolygonalNumber.isCyclicList(solution));
//        solution.add(pentagonal);
//        assert (PolygonalNumber.isCyclicList(solution));
//        solution.add(square);
//        assert (PolygonalNumber.isCyclicList(solution));
//    }
//
//    @Test
//    public void testIsCyclicWithPrevious() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] triangle = {3, 127};
//        int[] pentagonal = {5, 44};
//        int[] square = {4, 91};
//        assertEquals(8128, PolygonalNumber.calculate(triangle));
//        assertEquals(2882, PolygonalNumber.calculate(pentagonal));
//        assertEquals(8281, PolygonalNumber.calculate(square));
//        solution.add(triangle);
//        solution.add(pentagonal);
//        solution.add(square);
//        solution.add(square);
//        assert !PolygonalNumber.isCyclicWithPrevious(solution, 0);
//        assert PolygonalNumber.isCyclicWithPrevious(solution, 1);
//        assert PolygonalNumber.isCyclicWithPrevious(solution, 2);
//        assert !PolygonalNumber.isCyclicWithPrevious(solution, 3);
//        assert !PolygonalNumber.isCyclicWithPrevious(solution, 4);
//    }
//
//    @Test
//    public void testIsCyclicListMembers() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] triangle = {3, 127};
//        int[] pentagonal = {5, 44};
//        int[] square = {4, 91};
//        assertEquals(8128, PolygonalNumber.calculate(triangle));
//        assertEquals(2882, PolygonalNumber.calculate(pentagonal));
//        assertEquals(8281, PolygonalNumber.calculate(square));
//        solution.add(triangle);
//        solution.add(pentagonal);
//        solution.add(square);
//        solution.add(square);
//        assert PolygonalNumber.isCyclicListMembers(solution, 0, 1);
//        assert PolygonalNumber.isCyclicListMembers(solution, 1, 2);
//        assert !PolygonalNumber.isCyclicListMembers(solution, 2, 3);
//        assert !PolygonalNumber.isCyclicListMembers(solution, 3, 4);
//        assert PolygonalNumber.isCyclicListMembers(solution, 2, 0);
//        assert PolygonalNumber.isCyclicListMembers(solution, 3, 0);
//    }
//
//    @Test
//    public void testIsCyclic() throws Exception {
//        // 8128, 2882, 8281 are cyclic:
//        // triangle   P(3,127) = 8128
//        // square     P(4, 91) = 8281
//        // pentagonal P(5, 44) = 2882
//        int[] triangle = {3, 127};
//        int[] square = {4, 91};
//        int[] pentagonal = {5, 44};
//        assertEquals(8128, PolygonalNumber.calculate(triangle));
//        assertEquals(8281, PolygonalNumber.calculate(square));
//        assertEquals(2882, PolygonalNumber.calculate(pentagonal));
//        assert PolygonalNumber.isCyclic(triangle, pentagonal);
//        assert PolygonalNumber.isCyclic(pentagonal, square);
//        assert PolygonalNumber.isCyclic(square, triangle);
//        assert !PolygonalNumber.isCyclic(pentagonal, triangle);
//        assert !PolygonalNumber.isCyclic(square, pentagonal);
//        assert !PolygonalNumber.isCyclic(triangle, square);
//    }
//
//    @Test
//    public void testGetFirstDigits() throws Exception {
//        int[] polygonal = {3, 1};
//        assertEquals(1, PolygonalNumber.calculate(polygonal));
//        assert "1".equals(PolygonalNumber.getHead(polygonal, 2));
//        polygonal = new int[]{4, 5};
//        assertEquals(25, PolygonalNumber.calculate(polygonal));
//        assert "25".equals(PolygonalNumber.getHead(polygonal, 2));
//        polygonal = new int[]{8, 19};
//        assertEquals(1045, PolygonalNumber.calculate(polygonal));
//        assert "10".equals(PolygonalNumber.getHead(polygonal, 2));
//        polygonal = new int[]{8, 192};
//        assertEquals(110208, PolygonalNumber.calculate(polygonal));
//        assert "11".equals(PolygonalNumber.getHead(polygonal, 2));
//    }
//
//    @Test
//    public void testGetLastDigits() throws Exception {
//        int[] polygonal = {3, 1};
//        assertEquals(1, PolygonalNumber.calculate(polygonal));
//        assert "1".equals(PolygonalNumber.getTail(polygonal, 2));
//        polygonal = new int[]{4, 5};
//        assertEquals(25, PolygonalNumber.calculate(polygonal));
//        assert "25".equals(PolygonalNumber.getTail(polygonal, 2));
//        polygonal = new int[]{8, 19};
//        assertEquals(1045, PolygonalNumber.calculate(polygonal));
//        assert "45".equals(PolygonalNumber.getTail(polygonal, 2));
//        polygonal = new int[]{8, 192};
//        assertEquals(110208, PolygonalNumber.calculate(polygonal));
//        assert "08".equals(PolygonalNumber.getTail(polygonal, 2));
//    }
//
//    // moved from P61_CyclicalFigurateNumbers:
//
//    @Test
//    public void testGetList1() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] polygonal = new int[]{8, 19};
//        assertEquals(1045, PolygonalNumber.calculate(polygonal));
//        solution.add(polygonal);
//        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.find(1).toArray());
//    }
//
//    @Test
//    public void testGetList2() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        int[] p1 = new int[]{5, 55};
//        int[] p2 = new int[]{8, 19};
//        assertEquals(4510, PolygonalNumber.calculate(p1));
//        assertEquals(1045, PolygonalNumber.calculate(p2));
//        solution.add(p1);
//        solution.add(p2);
//        assertArrayEquals(solution.toArray(), P61_CyclicalFigurateNumbers.find(2).toArray());
//    }

//    @Test
//    public void testGetList3() throws Exception {
//        List<String> result = P61_CyclicalFigurateNumbers.find(3);
//        List<int[]> expected = new ArrayList<>();
//        int[] pentagonal = {5, 59};
//        int[] square = {4, 96};
//        int[] heptagonal = {7, 26};
//        expected.add(pentagonal);
//        expected.add(square);
//        expected.add(heptagonal);
//        assertArrayEquals(expected.toArray(), result.toArray());
//    }

//    @Test
//    public void testGetListWithThreeArgs() throws Exception {
//    }
//
//    @Test
//    public void testCheckSolution() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        List<int[]> newSolution;
//
//        int[] triangle = {3, 127};
//        newSolution = P61_CyclicalFigurateNumbers.checkSolution(3, solution, triangle);
//        assert newSolution != null;
//        assertEquals(1, solution.size());
//        assertEquals(1, newSolution.size());
//        assertArrayEquals(solution.toArray(), newSolution.toArray());
//
//        int[] pentagonal = {5, 44};
//        newSolution = P61_CyclicalFigurateNumbers.checkSolution(3, solution, pentagonal);
//        assert newSolution != null;
//        assertEquals(2, solution.size());
//        assertEquals(2, newSolution.size());
//        assertArrayEquals(solution.toArray(), newSolution.toArray());
//
//        int[] square = {4, 91};
//        newSolution = P61_CyclicalFigurateNumbers.checkSolution(3, solution, square);
//        assert newSolution != null;
//        assertEquals(3, solution.size());
//        assertEquals(3, newSolution.size());
//        assertArrayEquals(solution.toArray(), newSolution.toArray());
//    }
//
//    @Test
//    public void testIsSolution() throws Exception {
//        List<int[]> solution = new ArrayList<>();
//        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
//        solution.add(new int[]{3, 127});
//        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
//        solution.add(new int[]{5, 44});
//        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
//        solution.add(new int[]{4, 91});
//        assert P61_CyclicalFigurateNumbers.isSolution(3, solution);
//    }
}
