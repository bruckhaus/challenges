import java.util.TreeSet;

public class Pandigital {

    private static int minDigit = 1;
    private static long minPandigital = 123456789L;
    private static long maxPandigital = 987654321L;
    public static long current = minPandigital;
    private static TreeSet<Character> encountered = new TreeSet<>();
    private static int position;

    public static void main(String[] args) {
        System.out.println(current);
        while (hasNext()) {
            next();
            System.out.println(current);
        }
    }

    public static void setLength(int length) {
        if (length == 10) {
            minDigit = 0;
            minPandigital = 1023456789L;
            maxPandigital = 9876543210L;
        } else {
            minPandigital = 0;
            maxPandigital = 0;
            for (int j = minDigit; j <= length; j++) minPandigital = minPandigital * 10 + j;
            for (int j = length; j >= minDigit; j--) maxPandigital = maxPandigital * 10 + j;
        }
        current = minPandigital;
    }

    public static void setCurrent(long number) {
        current = number;
    }

    public static boolean hasNext() {
        return current < maxPandigital;
    }

    public static long next(long number) {
        number = incrementPosition(number);
        char[] combo = ("" + number).toCharArray();
        position++;
        for (char value : encountered) {
            combo[position] = value;
            position++;
        }
        current = Long.parseLong(new String(combo));
        return current;
    }

    public static long incrementPosition(long number) {
        position = findPosition(number);
        char[] combo = ("" + number).toCharArray();
        for (char value : encountered) {
            if (value > combo[position]) {
                combo[position] = value;
                encountered.remove(value);
                return Long.parseLong(new String(combo));
            }
        }
        return -1;
    }

    public static int findPosition(long number) {
        char[] combo = ("" + number).toCharArray();
        char current = Character.MAX_VALUE;
        char max = Character.MIN_VALUE;
        position = combo.length;
        encountered.clear();
        while (position > 0 && current >= max) {
            position--;
            current = combo[position];
            encountered.add(current);
            if (current > max) max = current;
        }
        if (current >= max) return -1;
        return position;
    }

    public static long next() {
        return next(current);
    }
}
