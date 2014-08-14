import org.junit.Test;
import static org.junit.Assert.*;

public class FuzzySearchTest {

    @Test
    public void testFind() throws Exception {
        String[] expected = {"ding", "dong"};
        assertArrayEquals(expected, new FuzzySearch().find("ab"));
    }
}