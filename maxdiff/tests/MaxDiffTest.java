import org.junit.Test;

public class MaxDiffTest {

    @Test
    public void testMaxDifference() throws Exception {
        assert 8 == MaxDiff.maxDifference(new int[]{2, 3, 10, 2, 4, 8, 1});
        assert 2 == MaxDiff.maxDifference(new int[]{7, 9, 5, 6, 3, 2});
        assert -1 == MaxDiff.maxDifference(new int[]{5, 4, 3, 2, 1});
        assert 1 == MaxDiff.maxDifference(new int[]{1, 2});
        assert 1 == MaxDiff.maxDifference(new int[]{111, 112});
        assert -1 == MaxDiff.maxDifference(new int[]{});
    }
}