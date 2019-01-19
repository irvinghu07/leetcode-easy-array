package array.easy;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-13
 */

//    Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//        To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//
//        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
//
//        Example 1:
//
//        Input: [[1,1,0],[1,0,1],[0,0,0]]
//        Output: [[1,0,0],[0,1,0],[1,1,1]]
//        Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//        Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
//        Example 2:
//
//        Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//        Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//        Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
//        Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//        Notes:
//
//        1 <= A.length = A[0].length <= 20
//        0 <= A[i][j] <= 1
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] a = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int row_length = A[0].length;
        int cow_length = A.length;
        if (row_length <= 1 && cow_length <= 1) {
            A[0][0] = A[0][0] == 0 ? 1 : 0;
            return A;
        }
        for (int i = 0; i < cow_length; i++) {
            if (row_length % 2 == 1) {
                A[i][row_length / 2] = A[i][row_length / 2] == 0 ? 1 : 0;
            }
            for (int j = 0; j < row_length / 2; j++) {
                int placeHolder = A[i][j];
                A[i][j] = A[i][row_length - 1 - j] == 0 ? 1 : 0;
                A[i][row_length - 1 - j] = placeHolder == 0 ? 1 : 0;
            }
        }
        return A;
    }
}


