import org.junit.Test;

public class KDifferenceTest {

    @Test
    public void testKDifference() throws Exception {
        assert 2 == KDifference.kDifference(3, 1, new int[]{1, 2, 3});
        assert 3 == KDifference.kDifference(5, 2, new int[]{1, 5, 3, 4, 2});
        assert 0 == KDifference.kDifference(10, 1,
                new int[]{363374326, 364147530, 61825163, 1073065718, 1281246024,
                        1399469912, 428047635, 491595254, 879792181, 1069262793});
    }
}