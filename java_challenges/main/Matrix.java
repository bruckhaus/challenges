import java.util.Arrays;

public class Matrix {
    public static int traverse(int[][] a, int m, int n) {
        int paths = 0;

        System.out.println("\nMatrix.traverse:");
        System.out.println("m: " + m);
        System.out.println("n: " + n);
        System.out.println("a:");
        for (int i = 0; i < a.length; i++) {
            System.out.println("    " + Arrays.toString(a[i]));
        }

        paths = countPaths(a, m, n, 0, 0);

        System.out.println("result: " + paths);
        return paths;
    }

    private static int countPaths(int[][] a, int m, int n, int i, int j) {
        if (i >= m || j >= n) {
            return 0;
        } else if (a[i][j] == 0) {
            return 0;
        } else if (i == m - 1 && j == n - 1) {
            return 1;
        } else {
            return countPaths(a, m, n, i + 1, j) + countPaths(a, m, n, i, j + 1);
        }
    }
}
