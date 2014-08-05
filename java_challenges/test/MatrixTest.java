import org.junit.Test;

public class MatrixTest {

    @Test
    public void testTraverse() throws Exception {

        assert 1 == new Matrix(new int[][]{{1}}).traverse();

        assert 1 == new Matrix(new int[][]{
                {1, 1},
                {0, 1}
        }).traverse();

        assert 2 == new Matrix(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        }).traverse();

        assert 11 == new Matrix(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        }).traverse();

        assert 23 == new Matrix(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        }).traverse();

        assert 10 == new Matrix(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        }).traverse();

        assert 4 == new Matrix(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        }).traverse();
    }
}