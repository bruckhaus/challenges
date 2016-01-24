public class SpiralMatrix {

    private int[][] spiral;
    private int size = 0;
    private int maxValue = 0;
    private DIRECTION direction = DIRECTION.RIGHT;

    private enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    SpiralMatrix(int spiralSize) {
        spiral = new int[spiralSize][spiralSize];
        size = 0;
        maxValue = 0;
        grow(spiralSize);
    }

    float getDiagonalPrimeRatio() {
        return 0;
    }

    void grow(int length) {
        while (!isComplete()) {
            int i = getNextI();
            int j = getNextJ();
            setValue(i, j);
        }
        size = length;
    }

    void setValue(int i, int j) {
        maxValue++;
        spiral[i][j] = maxValue;
    }

    boolean isComplete() {
        return maxValue >= Math.pow(size, 2);
    }
}
