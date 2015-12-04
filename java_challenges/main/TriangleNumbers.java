public class TriangleNumbers {

    public static boolean isTriangleNumber(int number) {
        int triangleNumber = 0;
        for (int n = 1; triangleNumber < number; n++) {
            triangleNumber = (int) ((float) (0.5 * n) * (n + 1));
        }
        return triangleNumber == number;
    }
}
