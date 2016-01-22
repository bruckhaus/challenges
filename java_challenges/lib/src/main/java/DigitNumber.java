import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class DigitNumber {

    static long replaceDigits(long number, List replacements) {
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

    static boolean isValidPositionCode(long prime, int positionCode) {
        int l = ("" + prime).length();
        return positionCode < Math.pow(2, l);
    }

    static long replacePositions(long number, int positionCode, int newValue) {
        char[] chars = ("" + number).toCharArray();
        int position = chars.length - 1;
        while (positionCode > 0) {
            if (positionCode % 2 == 1) {
                chars[position] = (char) ('0' + newValue);
            }
            positionCode /= 2;
            position--;
        }
        return Long.parseLong(String.valueOf(chars));
    }

    static char[] getSortedDigits(long l) {
        char[] chars = ("" + l).toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    static int getDigitSum(BigInteger number) {
        int sum = 0;
        String numberString = number.toString();
        for (int i = 0; i < numberString.length(); i++) {
            sum += Character.getNumericValue(numberString.charAt(i));
        }
        return sum;
    }
}
