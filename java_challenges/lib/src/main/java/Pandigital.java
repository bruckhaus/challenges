import java.util.TreeSet;

public class Pandigital {

    public static final int CURRENT_IS_MAX = -1;
    private static long minPandigital = 123456789L;
    private static long maxPandigital = 987654321L;
    private static int position;
    private static TreeSet<Character> encountered = new TreeSet<>();

    public static long current = minPandigital;

    public static void main(String[] args) {
        System.out.println(current);
        while (hasNext()) {
            next();
            System.out.println(current);
        }
    }

    public static long next(long pandigital) {
        position = findPosition(pandigital);
        long temp = incrementPosition(pandigital);
        current = fillEncounteredInOrder(temp);
        return current;
    }

    public static int findPosition(long pandigital) {
        char[] combo = ("" + pandigital).toCharArray();
        char positionValue = Character.MAX_VALUE;
        char maxValue = Character.MIN_VALUE;
        position = combo.length;
        encountered.clear();
        while (position > 0 && positionValue >= maxValue) {
            position--;
            positionValue = combo[position];
            encountered.add(positionValue);
            if (positionValue > maxValue) maxValue = positionValue;
        }
        if (positionValue >= maxValue) return CURRENT_IS_MAX;
        return position;
    }

    public static long incrementPosition(long pandigital) {
        char[] chars = ("" + pandigital).toCharArray();
        for (char value : encountered) {
            if (value > chars[position]) {
                chars[position] = value;
                encountered.remove(value);
                return Long.parseLong(new String(chars));
            }
        }
        return CURRENT_IS_MAX;
    }

    private static long fillEncounteredInOrder(long pandigital) {
        char[] chars = ("" + pandigital).toCharArray();
        position++;
        for (char value : encountered) {
            chars[position] = value;
            position++;
        }
        return Long.parseLong(new String(chars));
    }

    public static void setLength(int length) {
        if (length == 10) {
            minPandigital = 1023456789L;
            maxPandigital = 9876543210L;
        } else {
            minPandigital = 0;
            maxPandigital = 0;
            for (int j = 1; j <= length; j++) minPandigital = minPandigital * 10 + j;
            for (int j = length; j >= 1; j--) maxPandigital = maxPandigital * 10 + j;
        }
        current = minPandigital;
    }

    public static void setCurrent(long number) {
        current = number;
    }

    public static boolean hasNext() {
        return current < maxPandigital;
    }

    public static long next() {
        return next(current);
    }
}
