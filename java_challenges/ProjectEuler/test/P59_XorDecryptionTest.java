import org.junit.Test;

public class P59_XorDecryptionTest {

    @Test
    public void testGetKey() throws Exception {
        String key = P59_XorDecryption.getNextKey();
        assert ("aaa".equals(key));
        key = P59_XorDecryption.getNextKey();
        assert ("aab".equals(key));
        for (int i = 0; i < 26; i++) key = P59_XorDecryption.getNextKey();
        assert ("abb".equals(key));
        for (int i = 0; i < 26 * 26; i++) key = P59_XorDecryption.getNextKey();
        assert ("bbb".equals(key));
    }
}
