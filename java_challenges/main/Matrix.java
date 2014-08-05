import java.util.Arrays;

public class Matrix {

    int[][] maze = new int[][]{{}};
    int rows = 0;
    int columns = 0;

    public Matrix(int[][] maze) {
        this.maze = maze;
        rows = maze.length;
        columns = maze[0].length;
    }

    public int traverse() {
        show();
        int paths;
        paths = countPaths(maze, 0, 0);
        conclude(paths);
        return paths;
    }

    private int countPaths(int[][] maze, int i, int j) {
        if (i >= rows || j >= columns) {
            return 0;
        } else if (maze[i][j] == 0) {
            return 0;
        } else if (i == rows - 1 && j == columns - 1) {
            return 1;
        } else {
            return countPaths(maze, i + 1, j) + countPaths(maze, i, j + 1);
        }
    }

    private void show() {
        System.out.println("\nMatrix.traverse:");
        System.out.println("m: " + rows);
        System.out.println("n: " + columns);
        System.out.println("a:");
        for (int[] aMaze : maze) {
            System.out.println("    " + Arrays.toString(aMaze));
        }
    }

    private void conclude(int paths) {
        System.out.println("result: " + paths);
    }

}
