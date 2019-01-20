package array.easy; /**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2018-12-24
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array nums, write a function to move all 0's to
 * the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) if (0 != num) queue.add(num);
        for (int i = 0; i < nums.length; i++) nums[i] = !queue.isEmpty() ? queue.remove() : 0;
    }
}
