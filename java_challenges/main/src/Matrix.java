import java.util.Arrays;

public class Matrix {

    Boolean SolveRecursively = true;

    int[][] maze = new int[][]{{}};
    int rows = 0;
    int columns = 0;

    public Matrix(int[][] maze) {
        this.maze = maze;
        rows = maze.length;
        columns = maze[0].length;
    }

    public int solve() {
        int paths;
        showStart();
        paths = SolveRecursively ? countPathsRecursive(maze, 0, 0) : countPaths();
        showResult(paths);
        return paths;
    }

    private int countPaths() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j > 0 && maze[i][j] == 1) maze[0][j] = maze[0][j - 1];
                else if (i > 0 && j == 0 && maze[i][j] == 1) maze[i][0] = maze[i - 1][0];
                else if (i > 0 && j > 0 && maze[i][j] == 1) maze[i][j] = maze[i - 1][j] + maze[i][j - 1];
            }
        }
        return maze[rows - 1][columns - 1];
    }

    private int countPathsRecursive(int[][] maze, int i, int j) {
        if (i >= rows || j >= columns) {
            return 0;
        } else if (maze[i][j] == 0) {
            return 0;
        } else if (i == rows - 1 && j == columns - 1) {
            return 1;
        } else {
            return countPathsRecursive(maze, i + 1, j) + countPathsRecursive(maze, i, j + 1);
        }
    }

    private void showMaze() {
        for (int[] row : maze) {
            System.out.println("    " + Arrays.toString(row));
        }
    }

    private void showStart() {
        System.out.println("\nMaze: ");
        showMaze();
    }

    private void showResult(int paths) {
        if (!SolveRecursively) {
            System.out.println("Path count analysis:");
            showMaze();
        }
        System.out.println("result: " + paths);
    }
}