import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Words {

    private static final String RESOURCES_P042_WORDS_TXT = "file/p042_words.txt";

    private static List<Object> words;

    static {
        try {
            ResourceFile wordFile = new ResourceFile(RESOURCES_P042_WORDS_TXT);
            addWords(wordFile.getLines());
            wordFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }

    static List<Object> words() {
        return words;
    }

    private static void addWords(List items) {
        words = new ArrayList<>();
        for (Object item : items) {
            String line = String.valueOf(item).replace("\"", "");
            String[] newWords = line.split(",");
            Collections.addAll(words, newWords);
        }
    }

    // --- static methods: ---

    static int letterCode(char c) {
        return c - 'A' + 1;
    }

    static int wordCode(String word) {
        char[] chars = word.toCharArray();
        int code = 0;
        for (char c : chars) code += letterCode(c);
        return code;
    }
}
