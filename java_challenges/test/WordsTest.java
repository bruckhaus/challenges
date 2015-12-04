import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void testGetWords() throws Exception {
        ArrayList<String> inputList = getInputList();
        ArrayList<String> expected = getExpectedList();
        ArrayList<String> result = Words.getWords(inputList);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testGetWordsStateMachine() throws Exception {
        ArrayList<String> inputList = getInputList();
        ArrayList<String> expected = getExpectedList();
        ArrayList<String> result = Words.getWordsStateMachine(inputList);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    private ArrayList<String> getInputList() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("\"SOCCER\",\"THE\",\"BEAUTIFUL\",\"GAME\"");
        inputList.add("\"TO\",\"BE\",\"OR\",\"NOT\",\"TO\",\"BE\"");
        return inputList;
    }

    private ArrayList<String> getExpectedList() {
        ArrayList<String> expected = new ArrayList<>();
        String[] expectedStrings = {"SOCCER", "THE", "BEAUTIFUL", "GAME", "TO", "BE", "OR", "NOT", "TO", "BE"};
        expected.addAll(Arrays.asList(expectedStrings));
        return expected;
    }
}
