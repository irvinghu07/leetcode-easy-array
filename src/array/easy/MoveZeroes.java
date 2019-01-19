package array.easy; /**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2018-12-24
 */

import java.util.Arrays;

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
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            while (nums[i] != 0) {
                i++;
            }
            while (nums[j] == 0) {
                j--;
            }
            swapValue(nums, i, j);
        }
    }

    private void swapValue(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
