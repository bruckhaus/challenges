import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Words {

    public static final String RESOURCES_P042_WORDS_TXT = "./resources/p042_words.txt";

    public static int letterCode(char c) {
        return c - 'A' + 1;
    }

    public static int wordCode(String word) {
        char[] chars = word.toCharArray();
        int code = 0;
        for (char c : chars) code += letterCode(c);
        return code;
    }

    public static ArrayList<String> words() throws IOException {
        return getWords(readWordFile());
    }

    public static List<String> readWordFile() throws IOException {
        List<String> lines = new ArrayList<>();
        FileReader fileReader = new FileReader(RESOURCES_P042_WORDS_TXT);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String word;
        while ((word = bufferedReader.readLine()) != null) lines.add(word);
        bufferedReader.close();
        return lines;
    }

    private enum States {START, OPEN_QUOTE, WORD, CLOSE_QUOTE, COMMA}

    public static ArrayList<String> getWords(List<String> lines) {
        ArrayList<String> result = new ArrayList<>();
        for (String line : lines) {
            String[] strings = StringUtils.splitString(line, ",\"");
            Collections.addAll(result, strings);
        }
        return result;
    }

    public static ArrayList<String> getWordsStateMachine(List<String> lines) {
        // use a state machine for practice, assume input is well-formed:
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        States state = States.START;
        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (char c : chars) {
                switch (state) {
                    case START:
                        switch (c) {
                            case '"':
                                state = States.OPEN_QUOTE;
                                break;
                        }
                        break;
                    case OPEN_QUOTE:
                        state = States.WORD;
                        word = word + c;
                        break;
                    case WORD:
                        switch (c) {
                            case '"':
                                words.add(word);
                                word = "";
                                state = States.CLOSE_QUOTE;
                                break;
                            default:
                                word = word + c;
                                break;
                        }
                        break;
                    case CLOSE_QUOTE:
                        switch (c) {
                            case ',':
                                state = States.COMMA;
                                break;
                            case '"':
                                state = States.OPEN_QUOTE;
                                break;
                        }
                        break;
                    case COMMA:
                        switch (c) {
                            case '"':
                                state = States.OPEN_QUOTE;
                                break;
                        }
                        break;
                }
            }
        }
        return words;
    }
}
