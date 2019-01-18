package medium;

/**
 * @see </a href="https://leetcode.com/problems/max-chunks-to-make-sorted/">instruction</>
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 * <p>
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note:
 * <p>
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] a = {1, 0, 2, 3, 4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(a));
    }


    /**
     * @param arr
     * @return
     * @see </a href="https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation">solution</>
     * The basic idea is to use max[] array to keep track of the max value until the current position, and compare it to the sorted array (indexes from 0 to arr.length - 1). If the max[i] equals the element at index i in the sorted array, then the final count++.
     * <p>
     * Update: As @AF8EJFE pointed out, the numbers range from 0 to arr.length - 1. So there is no need to sort the arr, we can simply use the index for comparison. Now this solution is even more straightforward with O(n) time complelxity.
     * <p>
     * For example,
     * <p>
     * original: 0, 2, 1, 4, 3, 5, 7, 6
     * max:      0, 2, 2, 4, 4, 5, 7, 7
     * sorted:   0, 1, 2, 3, 4, 5, 6, 7
     * index:    0, 1, 2, 3, 4, 5, 6, 7
     * The chunks are: 0 | 2, 1 | 4, 3 | 5 | 7, 6
     * <p>
     * public int maxChunksToSorted(int[] arr) {
     * if (arr == null || arr.length == 0) return 0;
     * <p>
     * int[] max = new int[arr.length];
     * max[0] = arr[0];
     * for (int i = 1; i < arr.length; i++) {
     * max[i] = Math.max(max[i - 1], arr[i]);
     * }
     * <p>
     * int count = 0;
     * for (int i = 0; i < arr.length; i++) {
     * if (max[i] == i) {
     * count++;
     * }
     * }
     * <p>
     * return count;
     * }
     * Update2:
     * The code can be further simplified as follows.
     * <p>
     * public int maxChunksToSorted(int[] arr) {
     * if (arr == null || arr.length == 0) return 0;
     * <p>
     * int count = 0, max = 0;
     * for (int i = 0; i < arr.length; i++) {
     * max = Math.max(max, arr[i]);
     * if (max == i) {
     * count++;
     * }
     * }
     * <p>
     * return count;
     * }
     * The solution to Ver2 is very similar, with only slight modification:
     * https://discuss.leetcode.com/topic/117855/simple-java-solution-with-explanation
     */
    public int maxChunksToSorted(int[] arr) {
        int max = 0, length = arr.length, res = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
