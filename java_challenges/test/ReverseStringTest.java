import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void testReverseString() throws Exception {
        assert "cba".equals(ReverseString.reverseString("abc"));
        assert "!gnirtS TSET ym si sihT".equals(ReverseString.reverseString("This is my TEST String!"));
        assert "".equals(ReverseString.reverseString(""));
        assert "x".equals(ReverseString.reverseString("x"));
    }
}