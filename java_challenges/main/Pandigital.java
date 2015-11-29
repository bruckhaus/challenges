import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Pandigital {

    public static int current = 123456789;
    private static TreeSet<Character> encountered = new TreeSet<>();
    private static int position;

    public static long next() {
        positionToIncrease();
        increasePosition();
        appendInOrder();
        return 0L;
    }

    private static long appendInOrder() {
        return appendInOrder(current);
    }

    public static long appendInOrder(long number) {
        number = increasePosition(number);
        char[] combo = ("" + number).toCharArray();
        position++;
        for (char value : encountered) {
            combo[position] = value;
            position++;
        }
        return Long.parseLong(new String(combo));
    }

    public static long increasePosition() {
        return increasePosition(current);
    }

    public static long increasePosition(long number) {
        position = positionToIncrease(number);
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

    public static int positionToIncrease() {
        return positionToIncrease(current);
    }

    public static int positionToIncrease(long number) {
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
}
