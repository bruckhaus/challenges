import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDifference {
    public static int kDifference(int n, int k, int[] a) {
        System.out.println("\nkDifference:");
        System.out.println("n: " + n);
        System.out.println("k: " + k);
        System.out.println("a: " + Arrays.toString(a));

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (map.containsKey(a[i] - k)) {
                count++;
            }
            if (map.containsKey(a[i] + k)) {
                count++;
            }
            map.put(a[i], 1);
        }
        System.out.println("result: " + count);
        return count;
    }
}