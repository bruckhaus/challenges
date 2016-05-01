import org.junit.Test;

public class FuzzySearchTest {
    @Test
    public void getMatches() throws Exception {
        FuzzySearch fuzzy = new FuzzySearch("file/files.txt");
        checkResult(fuzzy, "[]", "abcd");
        checkResult(fuzzy, "[]", "bruckhaus");
        checkResult(fuzzy, "[README.md, python_challenges/README.md]", "readme");
        checkResult(fuzzy, "[java_challenges/out/production/java_challenges/RomanNumeral.class]", "tilmann");
        checkResult(fuzzy, "[java_challenges/out/production/java_challenges/KDifference.class, " +
                "java_challenges/out/test/java_challenges/KDifferenceTest.class, " +
                "java_challenges/out/test/java_challenges/MatrixTest.class, " +
                "java_challenges/out/test/java_challenges/MaxDiffTest.class, " +
                "java_challenges/out/test/java_challenges/ReversePolishTest.class, " +
                "java_challenges/out/test/java_challenges/ReverseStringTest.class, " +
                "java_challenges/out/test/java_challenges/StrDistTest.class]", "susie");
    }

    @Test
    public void isMatch() throws Exception {
        assert (FuzzySearch.isMatch("", ""));
        assert (FuzzySearch.isMatch("123456789", ""));
        assert (FuzzySearch.isMatch("123456789", "1"));
        assert (FuzzySearch.isMatch("123456789", "2"));
        assert (FuzzySearch.isMatch("123456789", "19"));
        assert (FuzzySearch.isMatch("123456789", "2468"));
        assert (FuzzySearch.isMatch("123456789", "123456789"));
        assert (!FuzzySearch.isMatch("123456789", "11"));
        assert (!FuzzySearch.isMatch("123456789", "x"));
        assert (!FuzzySearch.isMatch("", "x"));
    }

//  Helpers:

    private void checkResult(FuzzySearch fuzzy, String expected, String input) {
        String result = fuzzy.getMatches(input).toString();
        if (!expected.equals(result))
            System.out.printf("Unexpected result:\n" +
                    "  input    = %s\n" +
                    "  expected = %s\n" +
                    "  result   = %s\n", input, expected, result);
        assert (expected.equals(result));
    }
}
