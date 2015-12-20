import org.junit.Test;

public class PanDigitalTest {

    @Test
    public void testPanDigitalPrime() throws Exception {
        assert new PanDigitalPrime(9).maxPrime() == 7652413;
    }

    @Test
    public void testPandigital() {
        assert new PanDigital(1).list().equals("1");
        assert new PanDigital(2).list().equals("1, 12, 21");
        assert new PanDigital(3).list().equals("1, 12, 21, 123, 132, 213, 231, 312, 321");
        assert new PanDigital(4).list().equals("1, 12, 21, 123, 132, 213, 231, 312, 321, " +
                "1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, " +
                "3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321");
    }
}