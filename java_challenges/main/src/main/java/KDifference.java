import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDifference {

    public static int kDifference(int n, int k, int[] a) {
        showStart(n, k, a);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : a) {
            if (map.containsKey(i - k)) count++;
            if (map.containsKey(i + k)) count++;
            map.put(i, 1);
        }
        showResult(count);
        return count;
    }

    private static void showStart(int n, int k, int[] a) {
        System.out.println("\nkDifference:");
        System.out.println("n: " + n);
        System.out.println("k: " + k);
        System.out.println("a: " + Arrays.toString(a));
    }
    private static void showResult(int count) {
        System.out.println("result: " + count);
    }
}