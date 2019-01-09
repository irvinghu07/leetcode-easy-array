package easy;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-24
 */

/*
* Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal,
switching the row and column indices of the matrix.
Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]

Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
* */
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = new TransposeMatrix().transpose(A);
        printArr(B);
    }

    private static void printArr(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.println(b[i][j]);
            }
            System.out.println("===================");
        }
    }

    public int[][] transpose(int[][] A) {
        int row = A.length;
        int cow = A[0].length;
        int[][] B = new int[cow][row];
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < row; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }
}
