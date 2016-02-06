import org.junit.Test;

import static org.junit.Assert.*;

public class P59_XorDecryptionTest {

    @Test
    public void testDecryptedCheckSum() throws Exception {
        assertEquals(107359, P59_XorDecryption.decryptedCheckSum(P59_XorDecryption.CYPHER_FILE));
    }

    @Test
    public void testGetCypher() throws Exception {
        String cypher = P59_XorDecryption.getCypher(P59_XorDecryption.CYPHER_FILE);
        assertEquals(1201, cypher.length());
    }

    @Test
    public void testBreakCypher() throws Exception {
        String cypher = P59_XorDecryption.getCypher(P59_XorDecryption.CYPHER_FILE);
        String message = P59_XorDecryption.breakCypher(cypher);
        assertEquals("(The Gospel of John, chapter 1) 1 In the beginning", message.substring(0, 50));
        assertEquals(1201, message.length());
    }
}
