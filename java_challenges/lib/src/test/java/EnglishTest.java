import org.junit.Test;

public class EnglishTest {

    @Test
    public void testHasEnglishWords() throws Exception {
        assert (English.hasEnglishWords("this is a word", 1.0));
        assert (English.hasEnglishWords("this is a word Krümelkeks", 0.8));
        assert (!English.hasEnglishWords("this is a word Krümelkeks", 1.0));
    }
}
