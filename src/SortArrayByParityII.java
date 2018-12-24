import java.util.Arrays;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-13
 */
//Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//
//        Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//
//        You may return any answer array that satisfies this condition.
//
//
//
//        Example 1:
//
//        Input: [4,2,5,7]
//        Output: [4,5,2,7]
//        Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
//        Note:
//
//        2 <= A.length <= 20000
//        A.length % 2 == 0
//        0 <= A[i] <= 1000
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] A = {3, 1, 4, 2};
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(A)));
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, pivot = 0;
        while (i + 1 < A.length) {
            pivot = i + 1;
            if (isEven(i)) {
                if (!isEven(A[i])) {
                    while (pivot < A.length && !isEven(A[pivot])) {
                        pivot++;
                    }
                    swapValue(A, i, pivot);
                }
            } else {
                if (isEven(A[i])) {
                    while (pivot < A.length && isEven(A[pivot])) {
                        pivot++;
                    }
                    swapValue(A, i, pivot);
                }
            }
            i++;
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
