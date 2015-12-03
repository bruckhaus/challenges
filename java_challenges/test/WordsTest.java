import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WordsTest {

    @Test
    public void testWordCode() throws Exception {
        assertEquals(55, Words.wordCode("sky"));
    }

    @Test
    public void testLetterCode() throws Exception {
        assertEquals(19, Words.letterCode('s'));
    }

    @Test
    public void testWords() throws Exception {
        String[] words = Words.words();
        assertEquals(1, words.length);
    }
}