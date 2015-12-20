import org.junit.Test;

public class StrDistTest {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testStrDist() throws Exception {
        assert 4 == StrDist.strDist("baba", "ba");
        assert 2 == StrDist.strDist("ab", "ab");
        assert 1 == StrDist.strDist("x", "x");
        assert 0 == StrDist.strDist("", "");
        assert 0 == StrDist.strDist("abc", "xyz");
        assert 0 == StrDist.strDist("", "a");
        assert 12 == StrDist.strDist("123456789012", "12");
        assert 34 == StrDist.strDist("Some matching thing in the middle matches the sub-string", "match");
        assert 46 == StrDist.strDist("Some matching thing in the middle matches the sub-string", "ing");
        assert 6 == StrDist.strDist("ba, ba, black sheep, have you any wool?", "ba");
        assert 42 == StrDist.strDist("ba, ba, black sheep, have you any wool? ba", "ba");
        assert 0 == StrDist.strDist("ba, ba, black sheep, have you any wool? ba", "bam");
        assert 28 == StrDist.strDist("abaababababbbbabaaababababbabbbbb", "a");
    }
}