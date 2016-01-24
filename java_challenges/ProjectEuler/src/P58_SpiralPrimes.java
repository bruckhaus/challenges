class P58_SpiralPrimes {
    // Project Euler - Problem 58 - Spiral primes
    // Starting with 1 and spiralling anticlockwise in the following way,
    // a square spiral with side length 7 is formed.
    //        37 36 35 34 33 32 31
    //        38 17 16 15 14 13 30
    //        39 18  5  4  3 12 29
    //        40 19  6  1  2 11 28
    //        41 20  7  8  9 10 27
    //        42 21 22 23 24 25 26
    //        43 44 45 46 47 48 49
    // It is interesting to note that the odd squares lie along the bottom right diagonal,
    // but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime;
    // that is, a ratio of 8/13 ≈ 62%.
    // If one complete new layer is wrapped around the spiral above,
    // a square spiral with side length 9 will be formed.
    // If this process is continued, what is the side length of the square spiral
    // for which the ratio of primes along both diagonals first falls below 10%?

    private static final int LIMIT = 10;

    public static void main(String[] args) {
        String message = "The side length for which the prime ratio first falls below 10%% is %,d.\n";
        int length = P58_SpiralPrimes.getLength(LIMIT);
        System.out.printf(message, length);
    }

    private static final int MAX_SIZE = 100;
    private static int[][] spiral = new int[MAX_SIZE][MAX_SIZE];
    private static int spiralSize = 0;
    private static int sprialMaxValue = 0;

    private static int getLength(int limit) {
        for (int length = 3; length <= MAX_SIZE; length += 2) {
            growSpiral(length);
            if (getSpiralRatio() < 10) return length;
        }
        return -1;
    }

    private static float getSpiralRatio() {
        return 0;
    }

    private static void growSpiral(int length) {
        while (!spiralComplete(length)) {
            int i = getNextI();
            int j = getNextJ();
            setSpiralValue(i, j);
        }
        spiralSize = length;
    }

    private static void setSpiralValue(int i, int j) {
        sprialMaxValue++;
        spiral[i][j] = sprialMaxValue;
    }

    private static boolean spiralComplete(int length) {
        return sprialMaxValue >= Math.pow(length, 2);
    }
}
