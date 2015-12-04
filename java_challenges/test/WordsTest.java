import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    public void testReadWordFile() throws Exception {
        List<String> lines = Words.readWordFile();
        assertEquals(1, lines.size());
        assertEquals("\"A\",\"ABILITY\",\"", lines.get(0).substring(0, 15));
    }

    @Test
    public void testWords() throws Exception {
        ArrayList<String> words = Words.words();
        assertEquals(1786, words.size());
    }

    @Test
    public void testGetWords2() throws Exception {
        String line = "\"SOCCER\",\"THE\",\"BEAUTIFUL\",\"GAME\"";
        ArrayList<String> input = new ArrayList<>();
        input.add(line);
        String[] result = Words.getWords2(input);
        String[] expected = new String[] {"SOCCER", "THE", "BEAUTIFUL", "GAMEX"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetWords() throws Exception {

    }
}
