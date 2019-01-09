package medium;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-09
 */

import java.util.*;

/**
 * Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
 * <p>
 * Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * A[i] is a permutation of [1, 2, ..., A.length]
 */
public class PancakeSorting {
    public static void main(String[] args) {
        int[] a = {1,4,2,3};
        new PancakeSorting().pancakeSort(a);
    }

    public List<Integer> pancakeSort(int[] A) {
        LinkedList<Integer> ret = new LinkedList<>();
        Random random = new Random();
        if (!isSorted(A)) {
            while (!isSorted(A)) {
                int k = 0;
                do {
                    k = random.nextInt(A.length + 1);
                } while (k < 2);
                ret.add(k);
                System.out.println("k: " + k);
                for (int j = 0; j < k / 2; j++) {
                    swapValue(A, j, k - 1 - j);
                    System.out.println(Arrays.toString(A));
                    System.out.println("==============");
                }
            }
        }
        return ret;
    }

    private void swapValue(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
