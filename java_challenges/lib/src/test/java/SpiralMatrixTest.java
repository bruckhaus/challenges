import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMatrixTest {

    @Test
    public void grow() throws Exception {
        SpiralMatrix spiral = new SpiralMatrix(7);
        assertEquals(1, spiral.getElementCount());
        spiral.grow();
        assertEquals(9, spiral.getElementCount());
        spiral.grow();
        assertEquals(25, spiral.getElementCount());
        spiral.grow();
        assertEquals(49, spiral.getElementCount());
    }

    @Test
    public void getDiagonalPrimeRatio() throws Exception {
        double delta = 0.001;
        SpiralMatrix spiral = new SpiralMatrix(7);
        assertEquals(0.000, spiral.getDiagonalPrimeRatio(), delta);
        spiral.grow();
        assertEquals(0.600, spiral.getDiagonalPrimeRatio(), delta);
        spiral.grow();
        assertEquals(0.555, spiral.getDiagonalPrimeRatio(), delta);
        spiral.grow();
        assertEquals(0.615, spiral.getDiagonalPrimeRatio(), delta);
    }
}
