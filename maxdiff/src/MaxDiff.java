public class MaxDiff {

    public static int maxDifference(int[] a) {
        int min = Integer.MAX_VALUE;
        int maxDiff = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            int diff = a[i] - min;
            if (diff > maxDiff && diff > 0) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }

};
