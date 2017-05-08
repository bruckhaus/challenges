import org.junit.Test;

import static org.junit.Assert.*;

public class P40_ChampernownesConstantTest {
    @Test
    public void testFindSolution() throws Exception {
        assertEquals(1, P40_ChampernownesConstant.findSolution(0));
        assertEquals(1, P40_ChampernownesConstant.findSolution(1));
        assertEquals(5, P40_ChampernownesConstant.findSolution(2));
        assertEquals(15, P40_ChampernownesConstant.findSolution(3));
        assertEquals(105, P40_ChampernownesConstant.findSolution(4));
        assertEquals(210, P40_ChampernownesConstant.findSolution(5));
        assertEquals(210, P40_ChampernownesConstant.findSolution(6));
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(0, P40_ChampernownesConstant.getValue(1236543210, 0));
        assertEquals(1, P40_ChampernownesConstant.getValue(1236543210, 1));
        assertEquals(2, P40_ChampernownesConstant.getValue(1236543210, 2));
        assertEquals(3, P40_ChampernownesConstant.getValue(1236543210, 3));
        assertEquals(4, P40_ChampernownesConstant.getValue(1236543210, 4));
        assertEquals(5, P40_ChampernownesConstant.getValue(1236543210, 5));
        assertEquals(6, P40_ChampernownesConstant.getValue(1236543210, 6));
        assertEquals(3, P40_ChampernownesConstant.getValue(1236543210, 7));
        assertEquals(2, P40_ChampernownesConstant.getValue(1236543210, 8));
        assertEquals(1, P40_ChampernownesConstant.getValue(1236543210, 9));
    }
}