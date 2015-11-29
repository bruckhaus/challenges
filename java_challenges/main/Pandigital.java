import java.util.TreeSet;

public class Pandigital {

    public static final long MIN_PANDIGITAL = 1234567L;
    public static final long MAX_PANDIGITAL = 7654321L;
    public static long current = MIN_PANDIGITAL;
    private static TreeSet<Character> encountered = new TreeSet<>();
    private static int position;

    public static void main(String[] args) {
        System.out.println(current);
        while (hasNext()) {
            next();
            System.out.println(current);
        }
    }

    public static boolean hasNext() {
        return current < MAX_PANDIGITAL;
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
        return number;
    }

    public static int findPosition(long number) {
        char[] combo = ("" + number).toCharArray();
        char current = Character.MAX_VALUE;
        char max = Character.MIN_VALUE;
        char min = Character.MAX_VALUE;
        position = combo.length;
        encountered.clear();
        while (position > 0 && current >= max) {
            position--;
            current = combo[position];
            encountered.add(current);
            if (current > max) max = current;
            if (current < min) min = current;
        }
        if (current >= max) return -1;
        return position;
    }

    public static long next() {
        return next(current);
    }

    public static long incrementPosition() {
        return incrementPosition(current);
    }

    public static int findPosition() {
        return findPosition(current);
    }

}
