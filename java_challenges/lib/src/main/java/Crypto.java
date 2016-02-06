public class Crypto {
    // Provides methods for generating keys and decrypting messages.

    private static int keyCode;
    private static String key;

    static {
        reset();
    }

    static void reset() {
        keyCode = -1;
        key = null;
    }

    static void setKey(String newKey) {
        key = newKey;
        setKeyCode();
    }

    static void setKeyCode() {
        keyCode = 26 * 26 * key.charAt(0) + 26 * key.charAt(1) + key.charAt(2);
    }

    static String getKey() {
        return key;
    }

    static int getKeyCode() {
        return keyCode;
    }

    static boolean nextKey() {
        keyCode++;
        updateKey();
        return keyCode < 26 * 26 * 26;
    }

    static void updateKey() {
        int positionValue = keyCode / 26 / 26;
        key = getKeyCharacter(positionValue);
        positionValue = keyCode / 26 % 26;
        key += getKeyCharacter(positionValue);
        positionValue = keyCode % 26;
        key += getKeyCharacter(positionValue);
    }

    static String getKeyCharacter(int value) {
        return Character.toString((char) ('a' + value));
    }

    static String decrypt(String cypher) {
        String decrypted = "";
        int position = 0;
        for (char code : cypher.toCharArray()) {
            char keyChar = key.charAt(position % 3);
            decrypted += (char) (code ^ keyChar);
            position++;
        }
        return decrypted;
    }

    static int getCheckSum(String text) {
        int checkSum = 0;
        for (char code : text.toCharArray()) checkSum += code;
        return checkSum;
    }
}
