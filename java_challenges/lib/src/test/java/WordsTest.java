import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordsTest {

    @Test
    public void testLetterCode() throws Exception {
        assertEquals(19, Words.letterCode('S'));
    }

    @Test
    public void testWordCode() throws Exception {
        assertEquals(55, Words.wordCode("SKY"));
    }

    @Test
    public void testWords() throws Exception {
        List words = Words.words();
        assertEquals(1786, words.size());
        assertEquals("A", words.get(0));
        assertEquals("INCLUDE", words.get(777));
        assertEquals("YOUTH", words.get(1785));
    }
}
