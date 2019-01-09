package easy;

import java.util.Arrays;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-13
 */
public class Main {
    public static void main(String[] args) {
//        int a = 3;
//        int b = 5;
//        a = a + b;
//        b = a - b;
//        a = a - b;
//        System.out.println(a);
//        System.out.println(b);
        int[] A = {0, 2, 1};
//        3, 1, 2, 4
        System.out.println(Arrays.toString(new Main().sortArrayByParity(A)));
    }

    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
//        i <= A.length - 1 && j >= 0
        while (i < j) {
            while (i < A.length && isEven(A[i])) {
                i++;
            }
            while (j >= 0 && !isEven(A[j])) {
                j--;
            }
            if (i < A.length && j >= 0 && i <= j && !isEven(A[i]) && isEven(A[j])) {
                swapValue(A, i, j);
            }
        }
        return A;
    }

    private void swapValue(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isEven(int val) {
        return val % 2 == 0;
    }
}
//    Given an array A of non-negative integers, return an array consisting of all the even elements of A,
// followed by all the odd elements of A.
//
//        You may return any answer array that satisfies this condition.
//
//        Example 1:
//
//        Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//        Note:
//
//        1 <= A.length <= 5000 0 <= A[i] <= 5000