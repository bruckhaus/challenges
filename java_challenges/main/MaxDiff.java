public class MaxDiff {

    public static int maxDifference(int[] a) {
        int min = Integer.MAX_VALUE;
        int maxDiff = -1;
        for (int i : a) {
            if (i < min) min = i;
            int diff = i - min;
            if (diff > maxDiff && diff > 0) maxDiff = diff;
        }
        return maxDiff;
    }
}