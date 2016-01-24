import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMatrixTest {

    @Test
    public void grow() throws Exception {
        SpiralMatrix spiral = new SpiralMatrix(7);
        spiral.grow(1);
        spiral.grow(3);
        spiral.grow(5);
        spiral.grow(7);
    }
}