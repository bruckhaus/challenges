public class Pentagonal {

    private static long index = 0;
    private static long current = 0;

    public static void reset() {
        index = 0;
        current = 0;
    }

    public static long current() {
        return current;
    }

    public static long next() {
        index++;
        current = index * (3 * index - 1) / 2;
        return current;
    }
}
