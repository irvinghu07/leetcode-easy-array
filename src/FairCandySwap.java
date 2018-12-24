/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2018-12-24
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ret = new int[2];
        int a = getSum(A);
        int b = getSum(B);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (b + A[i] - B[j] == a + B[j] - A[i]) {
                    ret[0] = A[i];
                    ret[1] = B[j];
                    return ret;
                }
            }
        }
        return ret;
    }

    private int getSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
