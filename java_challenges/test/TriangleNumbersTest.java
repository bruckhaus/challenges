import org.junit.Test;

public class TriangleNumbersTest {

    @Test
    public void testIsTriangleNumber() throws Exception {
        assert(TriangleNumbers.isTriangleNumber(1));
        assert(!TriangleNumbers.isTriangleNumber(2));
        assert(TriangleNumbers.isTriangleNumber(3));
        assert(!TriangleNumbers.isTriangleNumber(4));
        assert(!TriangleNumbers.isTriangleNumber(5));
        assert(TriangleNumbers.isTriangleNumber(6));
        assert(!TriangleNumbers.isTriangleNumber(7));
        assert(!TriangleNumbers.isTriangleNumber(8));
        assert(!TriangleNumbers.isTriangleNumber(9));
        assert(TriangleNumbers.isTriangleNumber(10));
    }
}
