import org.junit.Test;

import static org.junit.Assert.*;

public class P59_XorDecryptionTest {

    @Test
    public void testGetKey() throws Exception {
        String key = P59_XorDecryption.getKey();
        assert ("aaa".equals(key));
        key = P59_XorDecryption.getKey();
        assert ("aab".equals(key));
        for (int i = 0; i < 26; i++) key = P59_XorDecryption.getKey();
        assert ("abb".equals(key));
        for (int i = 0; i < 26 * 26; i++) key = P59_XorDecryption.getKey();
        assert ("bbb".equals(key));
    }
}
