package array.medium;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-10
 */

/**
 * @see {<a href="https://leetcode.com/problems/array-nesting/">introduction</a>}
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * <p>
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * <p>
 * <p>
 * Note:
 * <p>
 * N is an integer within the range [1, 20,000].
 * The elements of A are all distinct.
 * Each element of A is an integer within the range [0, N-1].
 */
public class ArrayNesting {

    public static void main(String[] args) {
        int[] a = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(new ArrayNesting().arrayNesting(a));
    }

    public int arrayNestingOptimal(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }

    public int arrayNesting(int[] nums) {
        int placeHolder = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            placeHolder = traverse(nums, nums[i]);
            max = Math.max(max, placeHolder);
        }
        return max;
    }

    private int traverse(int[] nums, int num) {
        if (num >= 0 && nums[num] != -1) {
            int temp = nums[num];
            nums[num] = -1;
            return 1 + traverse(nums, temp);
        }
        return 0;
    }
}
