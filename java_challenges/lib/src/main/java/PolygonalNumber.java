class PolygonalNumber {

    private static Polygonal triangular = new Triangular();
    private static Polygonal square = new Square();
    private static Polygonal pentagonal = new Pentagonal();
    private static Polygonal hexagonal = new Hexagonal();
    private static Polygonal heptagonal = new Heptagonal();
    private static Polygonal octagonal = new Octagonal();


    private Integer base;
    private Integer exponent;
    private Long value;

    PolygonalNumber(Integer base, Integer exponent) {
        this.base = base;
        this.exponent = exponent;
        this.value = calculate();
    }

    // ---
    // getters and setters:

    Long getValue() {
        return value;
    }

    Integer getBase() {
        return base;
    }

    int getLength() {
        return ("" + value).length();
    }

    // ---
    // private methods:

    public Long calculate() {
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
                return -1l;
        }
    }
}
