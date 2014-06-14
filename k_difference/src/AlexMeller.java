import java.util.Arrays;

public class AlexMeller {
    public static int kDifference(int n, int k, int[] a) {
/* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        try {
//            BufferedReader is = new BufferedReader(
//                    new InputStreamReader(System.in));
//            String line1 = is.readLine();
//            String line2 = is.readLine();
//            String[] tokens1 = line1.split(" ");
//            n = Integer.parseInt(tokens1[0]);
//            k = Integer.parseInt(tokens1[1]);
//            a = new int[n];
//            String[] tokens2 = line2.split(" ");
//            for (int i = 0; i < k; i++) {
//                a[i] = Integer.parseInt(tokens2[i]);
//            }
//        } catch (Exception ex) {
//    }

        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(a, a[i] + k) >= 0)
                count++;
        }
        return (count);
    }
}