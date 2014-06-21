import org.junit.Test;

public class PanDigitalTest {
    @Test
    public void testPanDigital() throws Exception {
        assert new PanDigital().panDigital() == 7652413;
    }
}