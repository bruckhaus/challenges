public class SpiralMatrix {
    // TODO: unit tests for SpiralMatrix

    private int[][] spiral;
    private int matrixSize;
    private int lastValue;
    private int length;
    private int x;
    private int y;
    private boolean printDebugInfo = false;

    SpiralMatrix(int spiralSize) {
        spiral = new int[spiralSize][spiralSize];
        matrixSize = spiralSize;
        lastValue = 0;
        x = (matrixSize - 1) / 2 - 1;
        y = (matrixSize - 1) / 2;
    }

    double getDiagonalPrimeRatio() {
        int elements = 0;
        int primes = 0;
        for (int i = 0; i < matrixSize; i++) {
            int value = spiral[i][i];
            if (value == 0) continue;
            elements++;
            Boolean isPrime = Prime.checkPrime(value);
            String marker = isPrime ? " *" : "";
//            System.out.printf("diagonal 1 value = %d%s\n", value, marker);
            if (isPrime) primes++;
        }
        for (int i = 0; i < matrixSize; i++) {
            int value = spiral[i][matrixSize - 1 - i];
            if (value == 0) continue;
            elements++;
            Boolean isPrime = Prime.checkPrime(value);
            String marker = isPrime ? " *" : "";
//            System.out.printf("diagonal 2 value = %d%s\n", value, marker);
            if (isPrime) primes++;
        }
        double ratio = 1.0 * primes / (elements - 1);
        System.out.println("ratio = " + ratio);
        return ratio;
    }

    void grow(int newLength) {
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
        if (newLength % 2 != 1) throw new IllegalArgumentException("Spiral can only grow to odd sizes: " + newLength);
        System.out.println("newLength = " + newLength);
        length = newLength;
        goStart();
        goUp();
        goLeft();
        goDown();
        goRight();
    }

    private void goStart() {
        x++;
        lastValue++;
        spiral[x][y] = lastValue;
        show("start");
    }

    private void goUp() {
        for (int j = 1; j < length - 1; j++) {
            y--;
            lastValue++;
            spiral[x][y] = lastValue;
        }
        show("up");
    }

    private void goLeft() {
        for (int i = 1; i < length; i++) {
            x--;
            lastValue++;
            spiral[x][y] = lastValue;
        }
        show("left");
    }

    private void goDown() {
        for (int j = 1; j < length; j++) {
            y++;
            lastValue++;
            spiral[x][y] = lastValue;
        }
        show("down");
    }

    private void goRight() {
        for (int i = 1; i < length; i++) {
            x++;
            lastValue++;
            spiral[x][y] = lastValue;
        }
        show("right");
    }

    private void show(String message) {
        if (!printDebugInfo) return;
        System.out.println("after going " + message);
        for (int j = 0; j < matrixSize; j++) {
            for (int i = 0; i < matrixSize; i++) {
                System.out.printf("%5d ", spiral[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
