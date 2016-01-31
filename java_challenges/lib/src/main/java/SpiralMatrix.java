import java.util.Arrays;

class SpiralMatrix {
    // A two-dimensional matrix that starts with 1 in the middle and grows in spiral fashion:
    // size 1:
    //        1
    // size 3:
    //        5  4  3
    //        6  1  2
    //        7  8  9
    // size 5:
    //        17 16 15 14 13
    //        18  5  4  3 12
    //        19  6  1  2 11
    //        20  7  8  9 10
    //        21 22 23 24 25
    // size 7:
    //        37 36 35 34 33 32 31
    //        38 17 16 15 14 13 30
    //        39 18  5  4  3 12 29
    //        40 19  6  1  2 11 28
    //        41 20  7  8  9 10 27
    //        42 21 22 23 24 25 26
    //        43 44 45 46 47 48 49

    @SuppressWarnings("FieldCanBeLocal")
    private boolean PRINT_DEBUG_INFO = false;

    private static final boolean FIRST_DIAGONAL = true;
    private static final boolean SECOND_DIAGONAL = false;
    private static final int[] UP = new int[]{0, -1};
    private static final int[] LEFT = new int[]{-1, 0};
    private static final int[] DOWN = new int[]{0, 1};
    private static final int[] RIGHT = new int[]{1, 0};

    private int[][] spiral;
    private int arraySize;
    private int lastValue;
    private int length;
    private int x;
    private int y;
    private int countDiagonalElements;
    private int countDiagonalPrimes;

    SpiralMatrix(int size) {
        arraySize = size;
        spiral = new int[arraySize][arraySize];
        y = (arraySize - 1) / 2;
        x = (arraySize - 1) / 2;
        spiral[x][y] = 1;
        lastValue = 1;
        length = 1;
    }

    double getDiagonalPrimeRatio() {
        countDiagonalPrimes = 0;
        countDiagonalElements = 0;
        updateCounts(FIRST_DIAGONAL);
        updateCounts(SECOND_DIAGONAL);
        return 1.0 * countDiagonalPrimes / (countDiagonalElements - 1);
    }

    private void updateCounts(boolean firstDiagonal) {
        int j;
        for (int i = 0; i < arraySize; i++) {
            j = firstDiagonal ? i : arraySize - 1 - i;
            int value = spiral[i][j];
            if (value == 0) continue;
            countDiagonalElements++;
            if (Prime.checkPrime(value)) countDiagonalPrimes++;
        }
    }

    void grow() {
        length += 2;
        x++;
        y++;
        go(UP);
        go(LEFT);
        go(DOWN);
        go(RIGHT);
    }

    private void go(int[] direction) {
        for (int i = 1; i < length; i++) {
            x += direction[0];
            y += direction[1];
            lastValue++;
            spiral[x][y] = lastValue;
        }
        show(Arrays.toString(direction));
    }

    int getElementCount() {
        int count = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (spiral[i][j] != 0) count++;
            }
        }
        return count;
    }

    private void show(String message) {
        if (!PRINT_DEBUG_INFO) return;
        System.out.println("after going " + message);
        for (int j = 0; j < arraySize; j++) {
            for (int i = 0; i < arraySize; i++) {
                System.out.printf("%5d ", spiral[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
