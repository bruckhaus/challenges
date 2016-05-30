class PolygonalForEuler61 {

    private static Polygonal triangular = new Triangular();
    private static Polygonal square = new Square();
    private static Polygonal pentagonal = new Pentagonal();
    private static Polygonal hexagonal = new Hexagonal();
    private static Polygonal heptagonal = new Heptagonal();
    private static Polygonal octagonal = new Octagonal();

    private int LENGTH = 4;
    private int HALF_LENGTH = 2;
    private int MIN_ORDER = 3;
    private int MAX_ORDER = 8;
    private int MIN_VALUE = 1000;
    private int MAX_VALUE = 9999;

    private int base;
    private int exponent;
    private int value;

    PolygonalForEuler61(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
        this.value = (int) calculate();
    }

    boolean hasValidLength() {
        return this.getLength() == LENGTH;
    }

    Long getHead() {
        String s = "" + getValue();
        if (s.length() < HALF_LENGTH) return Long.parseLong(s);
        return Long.parseLong(s.substring(0, HALF_LENGTH));
    }

    Long getTail() {
        String s = "" + getValue();
        if (s.length() < HALF_LENGTH) return Long.parseLong(s);
        return Long.parseLong(s.substring(s.length() - HALF_LENGTH));
    }
    // ---
    // getters and setters:

    int getValue() {
        return value;
    }

    int getBase() {
        return base;
    }

    int getLength() {
        return ("" + value).length();
    }

    // ---
    // private methods:

    private long calculate() {
        switch (base) {
            case 3:
                return triangular.function(exponent);
            case 4:
                return square.function(exponent);
            case 5:
                return pentagonal.function(exponent);
            case 6:
                return hexagonal.function(exponent);
            case 7:
                return heptagonal.function(exponent);
            case 8:
                return octagonal.function(exponent);
            default:
                return -1;
        }
    }
}
