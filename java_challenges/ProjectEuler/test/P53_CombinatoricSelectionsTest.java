import org.junit.Test;

import static org.junit.Assert.*;

public class P53_CombinatoricSelectionsTest {
    // For reference, Pascal's triangle for n <= 9:
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // 1 5 10 10 5 1
    // 1 6 15 20 15 6 1
    // 1 7 21 35 35 21 7 1
    // 1 8 28 56 70 56 28 8 1
    // 1 9 36 84 126 126 84 36 9 1

    @Test
    public void getCountMoreThan() throws Exception {
        assertEquals(18, P53_CombinatoricSelections.getCountGreater(9, 10));
        assertEquals(15, P53_CombinatoricSelections.getCountGreater(9, 20));
        assertEquals(11, P53_CombinatoricSelections.getCountGreater(9, 30));
        assertEquals(7, P53_CombinatoricSelections.getCountGreater(9, 40));
        assertEquals(5, P53_CombinatoricSelections.getCountGreater(9, 60));
        assertEquals(4, P53_CombinatoricSelections.getCountGreater(9, 70));
        assertEquals(2, P53_CombinatoricSelections.getCountGreater(9, 125));
        assertEquals(0, P53_CombinatoricSelections.getCountGreater(9, 126));
        assertEquals(4075, P53_CombinatoricSelections.getCountGreater(100, 1000000));
    }

    @Test
    public void getCount() throws Exception {
        assertEquals(1, P53_CombinatoricSelections.getCountGreaterForN(0, 0));
        assertEquals(0, P53_CombinatoricSelections.getCountGreaterForN(0, 1));
        assertEquals(0, P53_CombinatoricSelections.getCountGreaterForN(1, 1));
        assertEquals(0, P53_CombinatoricSelections.getCountGreaterForN(2, 2));
        assertEquals(0, P53_CombinatoricSelections.getCountGreaterForN(3, 3));
        assertEquals(1, P53_CombinatoricSelections.getCountGreaterForN(4, 5));
        assertEquals(4, P53_CombinatoricSelections.getCountGreaterForN(5, 4));
        assertEquals(3, P53_CombinatoricSelections.getCountGreaterForN(6, 6));
        assertEquals(4, P53_CombinatoricSelections.getCountGreaterForN(7, 9));
        assertEquals(9, P53_CombinatoricSelections.getCountGreaterForN(8, 0));
        assertEquals(5, P53_CombinatoricSelections.getCountGreaterForN(8, 10));
        assertEquals(10, P53_CombinatoricSelections.getCountGreaterForN(9, 0));
        assertEquals(8, P53_CombinatoricSelections.getCountGreaterForN(9, 1));
        assertEquals(6, P53_CombinatoricSelections.getCountGreaterForN(9, 9));
        assertEquals(4, P53_CombinatoricSelections.getCountGreaterForN(9, 36));
        assertEquals(2, P53_CombinatoricSelections.getCountGreaterForN(9, 84));
        assertEquals(2, P53_CombinatoricSelections.getCountGreaterForN(9, 125));
        assertEquals(0, P53_CombinatoricSelections.getCountGreaterForN(9, 126));
    }

    @Test
    public void choose() throws Exception {
        assertEquals(1, P53_CombinatoricSelections.choose(0, 0));
        assertEquals(2, P53_CombinatoricSelections.choose(2, 1));
        assertEquals(6, P53_CombinatoricSelections.choose(4, 2));
        assertEquals(20, P53_CombinatoricSelections.choose(6, 3));
        assertEquals(56, P53_CombinatoricSelections.choose(8, 3));
        assertEquals(126, P53_CombinatoricSelections.choose(9, 5));
        assertEquals(84, P53_CombinatoricSelections.choose(9, 6));
        assertEquals(36, P53_CombinatoricSelections.choose(9, 7));
    }
}
