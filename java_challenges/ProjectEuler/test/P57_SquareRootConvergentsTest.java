import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class P57_SquareRootConvergentsTest {

    @Test
    public void getCount() throws Exception {
        assertEquals(0, P57_SquareRootConvergents.getCount(0));
        assertEquals(1, P57_SquareRootConvergents.getCount(10));
        assertEquals(15, P57_SquareRootConvergents.getCount(100));
        assertEquals(153, P57_SquareRootConvergents.getCount(1000));
    }

    @Test
    public void getNextDenominator() throws Exception {
        assertEquals(new BigInteger("5"), P57_SquareRootConvergents.getNextDenominator(
                new BigInteger("3"), new BigInteger("2")));
        assertEquals(new BigInteger("12"), P57_SquareRootConvergents.getNextDenominator(
                new BigInteger("7"), new BigInteger("5")));
        assertEquals(new BigInteger("29"), P57_SquareRootConvergents.getNextDenominator(
                new BigInteger("17"), new BigInteger("12")));
    }

    @Test
    public void getNextNumerator() throws Exception {
        assertEquals(new BigInteger("7"), P57_SquareRootConvergents.getNextNumerator(
                new BigInteger("3"), new BigInteger("2")));
        assertEquals(new BigInteger("17"), P57_SquareRootConvergents.getNextNumerator(
                new BigInteger("7"), new BigInteger("5")));
        assertEquals(new BigInteger("41"), P57_SquareRootConvergents.getNextNumerator(
                new BigInteger("17"), new BigInteger("12")));
    }

    @Test
    public void hasMoreDigits() throws Exception {
        assert (P57_SquareRootConvergents.hasMoreDigits(new BigInteger("11"), new BigInteger("1")));
        assert (P57_SquareRootConvergents.hasMoreDigits(new BigInteger("11"), new BigInteger("9")));
        assert (P57_SquareRootConvergents.hasMoreDigits(new BigInteger("110"), new BigInteger("19")));
        assert (!P57_SquareRootConvergents.hasMoreDigits(new BigInteger("11"), new BigInteger("11")));
        assert (!P57_SquareRootConvergents.hasMoreDigits(new BigInteger("11"), new BigInteger("991")));
        assert (!P57_SquareRootConvergents.hasMoreDigits(new BigInteger("11"), new BigInteger("111")));
        assert (!P57_SquareRootConvergents.hasMoreDigits(new BigInteger("11"), new BigInteger("9900")));
    }
}