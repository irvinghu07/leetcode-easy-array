package medium;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-09
 */


import jdk.nashorn.internal.ir.IdentNode;

import java.util.HashMap;
import java.util.HashSet;

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
        ;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0, temp = 0;
        HashSet<String> record = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !record.contains(generateRecord(i, j))) {
                    // find a candidate
                    temp = traverse(record, grid, i, j);
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    private int traverse(HashSet<String> record, int[][] grid, int i, int j) {
        int count = 1;
        record.add(generateRecord(i, j));
        if (findRight(record, grid, i, j)) {
            record.add(generateRecord(i, j + 1));
            count += traverse(record, grid, i, j + 1);
        }
        if (findDown(record, grid, i, j)) {
            record.add(generateRecord(i + 1, j));
            count += traverse(record, grid, i + 1, j);
        }
        if (findLeft(record, grid, i, j)) {
            record.add(generateRecord(i, j - 1));
            count += traverse(record, grid, i, j - 1);
        }
        if (findUp(record, grid, i, j)) {
            record.add(generateRecord(i - 1, j));
            count += traverse(record, grid, i - 1, j);
        }
        return count;
    }

    private String generateRecord(int i, int j) {
        return String.format("{%d-%d}", i, j);
    }

    private boolean findDown(HashSet<String> record, int[][] grid, int i, int j) {
        if (record.contains(generateRecord(i + 1, j))) {
            return false;
        }
        return i + 1 >= grid.length ? false : grid[i + 1][j] == 1;
    }

    private boolean findRight(HashSet<String> record, int[][] grid, int i, int j) {
        if (record.contains(generateRecord(i, j + 1))) {
            return false;
        }
        return j + 1 >= grid[0].length ? false : grid[i][j + 1] == 1;
    }

    private boolean findLeft(HashSet<String> record, int[][] grid, int i, int j) {
        if (record.contains(generateRecord(i, j - 1))) {
            return false;
        }
        return j - 1 < 0 ? false : grid[i][j - 1] == 1;
    }

    private boolean findUp(HashSet<String> record, int[][] grid, int i, int j) {
        if (record.contains(generateRecord(i - 1, j))) {
            return false;
        }
        return i - 1 < 0 ? false : grid[i - 1][j] == 1;
    }
}
