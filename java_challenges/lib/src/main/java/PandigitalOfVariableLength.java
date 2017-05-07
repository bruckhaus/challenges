import java.util.ArrayList;
import java.util.Arrays;

public class PandigitalOfVariableLength {

    private int length = 1;
    private int maxLength = -1;
    private int[] position;
    private static ArrayList<String> Digits =
            new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    PandigitalOfVariableLength(int length) {
        maxLength = length;
        resetPosition();
    }

    public long get() {
        StringBuilder result = new StringBuilder();
        ArrayList<String> digits = new ArrayList<>(Digits);
        for (int i = 0; i < length; i++) result.append(digits.remove(position[i]));
        return Integer.valueOf(result.toString());
    }

    public long next() {
        for (int i = length - 2; i >= 0; i--) {
            if (position[i] + i < length - 1) {
                position[i]++;
                return get();
            } else position[i] = 0;
        }
        if (length < maxLength) {
            length++;
            resetPosition();
            return get();
        } else return -1;
    }

    public String list() {
        StringBuilder result = new StringBuilder("" + get());
        Long p = next();
        while (p != -1) {
            result.append(", ").append(p);
            p = next();
        }
        return result.toString();
    }

    private void resetPosition() {
        position = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
