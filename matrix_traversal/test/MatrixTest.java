import org.junit.Test;

public class MatrixTest {

    @Test
    public void testTraverse() throws Exception {
        assert 1 == Matrix.traverse(
                new int[][]{
                        {1}},
                1, 1);
        assert 1 == Matrix.traverse(
                new int[][]{
                        {1, 1},
                        {0, 1}},
                2, 2);
        assert 2 == Matrix.traverse(
                new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}},
                3, 3);
        assert 11 == Matrix.traverse(
                new int[][]{
                        {1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}},
                4, 4);
        assert 23 == Matrix.traverse(
                new int[][]{
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1}},
                4, 5);
        assert 10 == Matrix.traverse(
                new int[][]{
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}},
                3, 4);
        assert 4 == Matrix.traverse(
                new int[][]{
                        {1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1}},
                3, 4);
    }
}