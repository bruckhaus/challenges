import java.io.IOException;
import java.util.List;

public class P59_XorDecryption {
    // Project Euler - Problem 59 - XOR decryption
    // Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard
    // Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
    // A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given
    // value, taken from a secret key. The advantage with the XOR function is that using the same encryption key on the
    // cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
    // For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of
    // random bytes. The user would keep the encrypted message and the encryption key in different locations, and
    // without both "halves", it is impossible to decrypt the message.
    // Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
    // If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the
    // message. The balance for this method is using a sufficiently long password key for security, but short enough to
    // be memorable. Your task has been made easy, as the encryption key consists of three lower case characters.
    // Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the
    // knowledge that the plain text must contain common English words, decrypt the message and find the sum of the
    // ASCII values in the original text.

    static final String CYPHER_FILE = "file/p059_cipher.txt";
    static final String WORDS_FILE = "file/english-words-1000.txt";
    private static int keyCode = 0;

    public static void main(String[] args) throws IOException {
        String message = "\nThe encryption key is %s.\n";
        String key = P59_XorDecryption.findKey(CYPHER_FILE);
        System.out.printf(message, key);
    }

    private static String findKey(String cypherFile) throws IOException {
        loadEnglishWords();
        List lines = new ResourceFile(cypherFile).getLines();
        String cyper = lines.get(0).toString();
        String[] codes = cyper.split(",");
        int position = 0;
        String clearText = "";
        char letter = 0;
        while (true) {
            String key = getKey();
            for (String code : codes) {
                char keyChar = key.charAt(position % 3);
                letter = (char) (code.charAt(0) ^ keyChar);
                System.out.printf("%s", letter);
                position++;
            }
            clearText += String.valueOf(letter);
            if (hasEnglishWords(clearText)) return key;
        }
    }

    private static void loadEnglishWords() throws IOException {
        List lines = new ResourceFile(WORDS_FILE).getLines();
        for (Object line : lines) {
            System.out.println("line = " + line);
        }
    }

    static String getKey() {
        int positionValue = keyCode / 26 / 26;
        String key = Character.toString((char) ('a' + positionValue));
        positionValue = keyCode / 26 % 26;
        key += Character.toString((char) ('a' + positionValue));
        positionValue = keyCode % 26;
        key += Character.toString((char) ('a' + positionValue));
        keyCode++;
        return key;
    }

    private static boolean hasEnglishWords(String text) {
        return true;
    }
}
