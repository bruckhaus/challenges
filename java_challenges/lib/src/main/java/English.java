import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class English {
    // Provides set of common English words and methods for analyzing English text.

    static final String WORDS_FILE = "file/english-words-1000.txt";
    private static Set<String> words;

    static {
        try {
            loadEnglishWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadEnglishWords() throws IOException {
        List lines = new ResourceFile(WORDS_FILE).getLines();
        words = new HashSet<>();
        for (Object line : lines) {
            String word = line.toString();
            words.add(word);
        }
    }

    static boolean hasEnglishWords(String text, double threshold) {
        String[] tokens = text.split(" ");
        int countTokens = 0;
        int englishWords = 0;
        for (String token : tokens) {
            countTokens++;
            token = token.toLowerCase();
            if (words.contains(token)) englishWords++;
        }
        double englishWordRatio = 1.0 * englishWords / countTokens;
        return countTokens >= 1 && englishWordRatio >= threshold;
    }
}
