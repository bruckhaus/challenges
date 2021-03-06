public class P44_Pentagonal {
    // Project Euler - Pentagon numbers - Problem 44
    // Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2.
    // The first ten pentagonal numbers are:
    // 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
    // It can be seen that P4 + P7 = 22 + 70 = 92 = P8.
    // However, their difference, 70 − 22 = 48, is not pentagonal.
    // Find the pair of [special] pentagonal numbers, Pj and Pk,
    // for which their sum and difference are pentagonal
    // and D = |Pk − Pj| is minimised; what is the value of D?

    public static final long NOT_FOUND = Long.MAX_VALUE;

    public static void main(String[] args) {
        long result = minPairDiff(false);
        System.out.printf(
                "The minimal difference between special pairs of pentagonal numbers is %d.", result);
    }

    public static long minPairDiff(boolean heuristic) {
        long min = NOT_FOUND;
        long value;
        long lastValue = 0;
        long delta;
        Pentagonal pentagonal = new Pentagonal();
        pentagonal.reset();
        while (true) {
            value = pentagonal.next();
            min = searchMin(min, value);
            if (min != NOT_FOUND && heuristic) return min;
            delta = value - lastValue;
            if (delta > min) return min;
            lastValue = value;
        }
    }

    private static long searchMin(long min, long limit) {
        Pentagonal pentagonal = new Pentagonal();
        long value;
        value = pentagonal.reset();
        while (value < limit) {
            value = pentagonal.next();
            if (isSpecialPair(limit, value)) min = Math.min(min, limit - value);
        }
        return min;
    }

    public static boolean isSpecialPair(long p1, long p2) {
        Pentagonal p = new Pentagonal();
        return p1 != p2 &&
                p.isPolygonal(p1 + p2) &&
                p.isPolygonal(Math.abs(p1 - p2));
    }
}
