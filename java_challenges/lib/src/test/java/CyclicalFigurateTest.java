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
        assertEquals(302, polygonalCount);
        // We know that 8128, 2882, and 8281 must be in the polygonal map (see Euler problem 61 definition):
        assertEquals("[p(3,128)=8256, p(4,91)=8281]", p.get(82L).toString());
        assertEquals("[p(3,127)=8128, p(5,74)=8177, p(6,64)=8128]", p.get(81L).toString());
        assertEquals("[p(3,75)=2850, p(5,44)=2882, p(6,38)=2850, p(7,34)=2839, p(8,31)=2821]",
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
    public void testFind() throws Exception {
    }

    @Test
    public void testFindPolygonals() throws Exception {
        // size 1: p(3,45)=1035
        // size 2: p(5,55)=4510, p(8,19)=1045
        // size 3: p(5,59)=?, p(4,96)=?, p(7,26)=?
        CyclicalFigurate c = new CyclicalFigurate();
        assertEquals("[p(3,45)=1035]", c.findPolygonals(1).toString());
        assertEquals("[p(7,32)=2512, p(3,49)=1225]", c.findPolygonals(2).toString());
//        assertEquals("[p(7,32)=2512, p(3,49)=1225]", c.findPolygonals(3).toString());
    }

    @Test
    public void testFindStep() throws Exception {
        CyclicalFigurate c = new CyclicalFigurate();
        List<PolygonalNumber> list;
        list = c.find(2, 2, 12L, 0);
        assertEquals("[p(7,32)=2512, p(3,49)=1225]", list.toString());
        list = c.find(3, 2, 12L, 0);
        assertEquals("[p(7,32)=2512, p(3,49)=1225]", list.toString());
        list = c.find(2, 2, 25L, 0);
        assertEquals("[p(4,75)=5625, p(3,71)=2556]", list.toString());
        list = c.find(3, 2, 25L, 0);
        assertEquals("[p(4,75)=5625, p(3,71)=2556]", list.toString());
    }

    @Test
    public void testMakeList() throws Exception {
        CyclicalFigurate c = new CyclicalFigurate();
        TreeMap<Long, List<PolygonalNumber>> p = c.buildPolygonals();
        List<PolygonalNumber> list = p.get(10L);
        assertEquals("[p(3,45)=1035, p(3,46)=1081, p(4,32)=1024, p(4,33)=1089, " +
                "p(5,27)=1080, p(6,23)=1035, p(7,21)=1071, p(8,19)=1045]", list.toString());
        assertEquals("[p(3,45)=1035]", c.makeList(10L, 0).toString());
        assertEquals("[p(3,46)=1081]", c.makeList(10L, 1).toString());
        assertEquals("[p(4,32)=1024]", c.makeList(10L, 2).toString());
        assertEquals("[p(4,33)=1089]", c.makeList(10L, 3).toString());
        assertEquals("[p(5,27)=1080]", c.makeList(10L, 4).toString());
        assertEquals("[p(6,23)=1035]", c.makeList(10L, 5).toString());
        assertEquals("[p(7,21)=1071]", c.makeList(10L, 6).toString());
        assertEquals("[p(8,19)=1045]", c.makeList(10L, 7).toString());
        assertNull(c.makeList(10L, 8));
    }

    @Test
    public void testCheckSolution() throws Exception {
        List<PolygonalNumber> partial = new ArrayList<>();
        List<PolygonalNumber> solution;
        PolygonalNumber p;
        // any list of length 1 is a solution:
        p = new PolygonalNumber(0, 0);
        solution = CyclicalFigurate.checkSolution(1, partial, p);
        assertEquals("[p(0,0)=-1]", solution.toString());
        //  any list of length 1 is a solution:
        partial.clear();
        p = new PolygonalNumber(3, 127);
        solution = CyclicalFigurate.checkSolution(3, partial, p);
        assertEquals("[p(3,127)=8128]", solution.toString());
        // p(3,127), p(5,44) -> pass:
        p = new PolygonalNumber(5, 44);
        solution = CyclicalFigurate.checkSolution(3, partial, p);
        assertEquals("[p(3,127)=8128, p(5,44)=2882]", solution.toString());
        // p(3,127), p(5,44), p(4,91) -> pass:
        p = new PolygonalNumber(4, 91);
        solution = CyclicalFigurate.checkSolution(3, partial, p);
        assertEquals("[p(3,127)=8128, p(5,44)=2882, p(4,91)=8281]", solution.toString());
        // p(3,127), p(5,44), p(4,91), p(4,91) -> fail:
        solution = CyclicalFigurate.checkSolution(4, partial, p);
        assertNull(solution);
    }

    @Test
    public void testIsSolution() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();

        list.clear();
        assertTrue(CyclicalFigurate.isSolution(2, list));
        list.add(new PolygonalNumber(5, 55));   // 4510
        assertTrue(CyclicalFigurate.isSolution(2, list));
        list.add(new PolygonalNumber(8, 19));   // 1045
        assertTrue(CyclicalFigurate.isSolution(2, list));

        list.clear();
        assertTrue(CyclicalFigurate.isSolution(3, list));
        list.add(new PolygonalNumber(3, 127));
        assertTrue(CyclicalFigurate.isSolution(3, list));
        list.add(new PolygonalNumber(5, 44));
        assertTrue(CyclicalFigurate.isSolution(3, list));
        list.add(new PolygonalNumber(4, 91));
        assertTrue(CyclicalFigurate.isSolution(3, list));
        list.add(new PolygonalNumber(4, 91));
        assertTrue(!CyclicalFigurate.isSolution(3, list));
        assertTrue(!CyclicalFigurate.isSolution(4, list));
    }

    @Test
    public void testIsCyclicSolution() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();
        assertTrue(CyclicalFigurate.isCyclicSolution(3, list));
        list.add(new PolygonalNumber(3, 127));
        assertTrue(CyclicalFigurate.isCyclicSolution(3, list));
        list.add(new PolygonalNumber(5, 44));
        assertTrue(CyclicalFigurate.isCyclicSolution(3, list));
        list.add(new PolygonalNumber(4, 91));
        assertTrue(CyclicalFigurate.isCyclicSolution(3, list));
        list.add(new PolygonalNumber(4, 91));
        assertTrue(!CyclicalFigurate.isCyclicSolution(3, list));
        assertTrue(!CyclicalFigurate.isCyclicSolution(4, list));
    }

    @Test
    public void testHasRequiredDigitCounts() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();
        assertEquals(true, CyclicalFigurate.hasRequiredDigitCounts(list));
        PolygonalNumber triangle = new PolygonalNumber(3, 101);
        PolygonalNumber square = new PolygonalNumber(4, 88);
        PolygonalNumber pentagonal = new PolygonalNumber(5, 77);
        PolygonalNumber hexagonal = new PolygonalNumber(6, 71);
        assertEquals(new Long(5151), triangle.getValue());
        assertEquals(new Long(7744), square.getValue());
        assertEquals(new Long(8855), pentagonal.getValue());
        assertEquals(new Long(10011), hexagonal.getValue());
        list.add(triangle);
        assertTrue(CyclicalFigurate.hasRequiredDigitCounts(list));
        list.add(square);
        assertTrue(CyclicalFigurate.hasRequiredDigitCounts(list));
        list.add(pentagonal);
        assertTrue(CyclicalFigurate.hasRequiredDigitCounts(list));
        list.add(hexagonal);
        assertFalse(CyclicalFigurate.hasRequiredDigitCounts(list));
    }

    @Test
    public void testIsCyclicAndWraps() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();
        PolygonalNumber triangle = new PolygonalNumber(3, 127);
        PolygonalNumber pentagonal = new PolygonalNumber(5, 44);
        PolygonalNumber square = new PolygonalNumber(4, 91);
        assertEquals(new Long(8128), triangle.getValue());
        assertEquals(new Long(2882), pentagonal.getValue());
        assertEquals(new Long(8281), square.getValue());
        // cyclic, does not wrap, not full size -> pass:
        list.clear();
        list.add(triangle);
        list.add(pentagonal);
        assertTrue(CyclicalFigurate.isCyclicAndWraps(3, list));
        // cyclic, wraps, full size -> pass:
        list.clear();
        list.add(triangle);
        list.add(pentagonal);
        list.add(square);
        assertTrue(CyclicalFigurate.isCyclicAndWraps(3, list));
        // cyclic, does not wrap, full size -> fail:
        list.clear();
        list.add(triangle);
        list.add(pentagonal);
        assertFalse(CyclicalFigurate.isCyclicAndWraps(2, list));
    }

    @Test
    public void testIsCyclic() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();
        PolygonalNumber triangle = new PolygonalNumber(3, 127);
        PolygonalNumber pentagonal = new PolygonalNumber(5, 44);
        PolygonalNumber square = new PolygonalNumber(4, 91);
        assertEquals(new Long(8128), triangle.getValue());
        assertEquals(new Long(2882), pentagonal.getValue());
        assertEquals(new Long(8281), square.getValue());
        list.add(triangle);
        assertTrue(CyclicalFigurate.isCyclic(list));
        list.add(pentagonal);
        assertTrue(CyclicalFigurate.isCyclic(list));
        list.add(square);
        assertTrue(CyclicalFigurate.isCyclic(list));
        list.add(square);
        assertTrue(!CyclicalFigurate.isCyclic(list));
    }

    @Test
    public void testIsWrapping() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();
        PolygonalNumber triangle = new PolygonalNumber(3, 127);
        PolygonalNumber pentagonal = new PolygonalNumber(5, 44);
        PolygonalNumber square = new PolygonalNumber(4, 91);
        assertEquals(new Long(8128), triangle.getValue());
        assertEquals(new Long(2882), pentagonal.getValue());
        assertEquals(new Long(8281), square.getValue());
        list.add(triangle);
        assertTrue(!CyclicalFigurate.isWrapping(list));
        list.add(pentagonal);
        assertTrue(!CyclicalFigurate.isWrapping(list));
        list.add(square);
        assertTrue(CyclicalFigurate.isWrapping(list));
        list.add(square);
        assertTrue(CyclicalFigurate.isWrapping(list));
    }

    @Test
    public void testIsFullSize() throws Exception {
        List<PolygonalNumber> list = new ArrayList<>();
        PolygonalNumber triangle = new PolygonalNumber(3, 127);
        PolygonalNumber pentagonal = new PolygonalNumber(5, 44);
        PolygonalNumber square = new PolygonalNumber(4, 91);
        assertEquals(new Long(8128), triangle.getValue());
        assertEquals(new Long(2882), pentagonal.getValue());
        assertEquals(new Long(8281), square.getValue());
        list.add(triangle);
        assertTrue(!CyclicalFigurate.isFullSize(3, list));
        list.add(pentagonal);
        assertTrue(!CyclicalFigurate.isFullSize(3, list));
        list.add(square);
        assertTrue(CyclicalFigurate.isFullSize(3, list));
        list.add(square);
        assertTrue(!CyclicalFigurate.isFullSize(3, list));
    }

    @Test
    public void testEachOrderHasDifferentPolygonal() throws Exception {
        List<PolygonalNumber> solution = new ArrayList<>();
        PolygonalNumber one = new PolygonalNumber(1, 101);
        PolygonalNumber two = new PolygonalNumber(2, 202);
        PolygonalNumber three = new PolygonalNumber(3, 303);
        PolygonalNumber dupe = new PolygonalNumber(1, 404);
        solution.add(one);
        assertTrue(CyclicalFigurate.eachOrderHasDifferentPolygonal(solution));
        solution.add(two);
        assertTrue(CyclicalFigurate.eachOrderHasDifferentPolygonal(solution));
        solution.add(three);
        assertTrue(CyclicalFigurate.eachOrderHasDifferentPolygonal(solution));
        solution.add(dupe);
        assertFalse(CyclicalFigurate.eachOrderHasDifferentPolygonal(solution));
    }
}
