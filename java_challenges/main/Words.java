import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Words {

    public static final String RESOURCES_P042_WORDS_TXT = "./resources/p042_words.txt";

    public static String[] words() throws IOException {
        List<String> lines = new ArrayList<>();
        FileReader fileReader = new FileReader(RESOURCES_P042_WORDS_TXT);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String word = null;
        while ((word = bufferedReader.readLine()) != null) lines.add(word);
        bufferedReader.close();
        String regex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        return lines.get(0).split(regex, -1);
    }

    public static int wordCode(String word) {
        char[] chars = word.toCharArray();
        int code = 0;
        for (char c : chars) {
            code += letterCode(c);
        }
        return code;

    }

    public static int letterCode(char c) {
        return c - 'a' + 1;
    }
}
