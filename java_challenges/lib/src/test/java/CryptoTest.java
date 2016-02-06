import org.junit.Test;

import static org.junit.Assert.*;

public class CryptoTest {

    @Test
    public void testGetKey() throws Exception {
        Crypto.reset();
        assertEquals(null, Crypto.getKey());
    }

    @Test
    public void testNextKey() throws Exception {
        Crypto.reset();
        Crypto.nextKey();
        assert ("aaa".equals(Crypto.getKey()));
        Crypto.nextKey();
        assert ("aab".equals(Crypto.getKey()));
        for (int i = 0; i < 26; i++) Crypto.nextKey();
        assert ("abb".equals(Crypto.getKey()));
        for (int i = 0; i < 26 * 26; i++) Crypto.nextKey();
        assert ("bbb".equals(Crypto.getKey()));
    }

    @Test
    public void testDecrypt() throws Exception {
        Crypto.setKey("xyz");
        String cypher = ",\u0011\u0013\u000BY\u0013\u000BY\u0017\u0001Y\u0019\u0001\t\u0012\u001D\u000B[";
        String message = "This is my cypher!";
        assertEquals(cypher, Crypto.decrypt(message));
        assertEquals(message, Crypto.decrypt(cypher));
    }

    @Test
    public void testGetCheckSum() throws Exception {
        assertEquals(97, Crypto.getCheckSum("a"));
        assertEquals(97 * 2, Crypto.getCheckSum("aa"));
        assertEquals(97 * 3, Crypto.getCheckSum("aaa"));
        assertEquals(97 + 98 + 99, Crypto.getCheckSum("abc"));
        assertEquals(97 + 98 + 99, Crypto.getCheckSum("cba"));
        assertEquals(1954, Crypto.getCheckSum("Check the sum of this!"));
    }

    @Test
    public void testSetKey() throws Exception {
        String message = "This is my cypher!";

        Crypto.setKey("bob");
        String cypher = "6\u0007\u000B\u0011O\u000B\u0011O\u000F\u001BO\u0001\u001B\u001F\n\u0007\u001DC";
        assertEquals(cypher, Crypto.decrypt(message));

        Crypto.setKey("cba");
        cypher = "7\n\b\u0010B\b\u0010B\f\u001AB\u0002\u001A\u0012\t\u0006\u0010@";
        assertEquals(cypher, Crypto.decrypt(message));
    }

    @Test
    public void testSetKeyCode() throws Exception {
        Crypto.setKey("bob");
        assertEquals(69232, Crypto.getKeyCode());
        Crypto.setKey("udo");
        assertEquals(81803, Crypto.getKeyCode());
    }

    @Test
    public void testGetKeyCharacter() throws Exception {
        assertEquals("a", Crypto.getKeyCharacter(0));
        assertEquals("m", Crypto.getKeyCharacter(12));
        assertEquals("z", Crypto.getKeyCharacter(25));
    }
}
