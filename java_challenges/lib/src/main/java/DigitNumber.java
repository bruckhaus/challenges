import java.util.List;

public class DigitNumber {

    public static long replaceDigits(long number, List replacements) {
        long temp = number;
        for (Object item : replacements) {
            int[] replacement = (int[]) item;
            int position = replacement[0];
            int newValue = replacement[1];
            temp = replaceDigit(temp, position, newValue);
        }
        return temp;
    }

    static long replaceDigit(long number, int position, int newValue) {
        char[] chars = ("" + number).toCharArray();
        chars[position] = (char) ('0' + newValue);
        return Long.parseLong(String.valueOf(chars));
    }
}
