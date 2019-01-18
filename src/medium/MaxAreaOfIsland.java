package medium;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-09
 */


/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaOfIsland {
    private int[][] visited;

    private int[][] grid;

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0, temp = 0;
        this.visited = new int[grid.length][grid[0].length];
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    // find a candidate
                    temp = traverse(i, j);
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    private int traverse(int i, int j) {
        int count = 1;
        visited[i][j] = 1;
        if (findRight(i, j)) {
            visited[i][j + 1] = 1;
            count += traverse(i, j + 1);
        }
        if (findDown(i, j)) {
            visited[i + 1][j] = 1;
            count += traverse(i + 1, j);
        }
        if (findLeft(i, j)) {
            visited[i][j - 1] = 1;
            count += traverse(i, j - 1);
        }
        if (findUp(i, j)) {
            visited[i - 1][j] = 1;
            count += traverse(i - 1, j);
        }
        return count;
    }

    private boolean findDown(int i, int j) {
        if (i + 1 >= grid.length || visited[i + 1][j] == 1) {
            return false;
        }
        return grid[i + 1][j] == 1;
    }

    private boolean findRight(int i, int j) {
        if (j + 1 >= grid[0].length || visited[i][j + 1] == 1) {
            return false;
        }
        return grid[i][j + 1] == 1;
    }

    private boolean findLeft(int i, int j) {
        if (j - 1 < 0 || visited[i][j - 1] == 1) {
            return false;
        }
        return grid[i][j - 1] == 1;
    }

    private boolean findUp(int i, int j) {
        if (i - 1 < 0 || visited[i - 1][j] == 1) {
            return false;
        }
        return grid[i - 1][j] == 1;
    }
}
