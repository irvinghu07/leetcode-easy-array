package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * {@see <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">instruction</a>}
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInanArray {
    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindAllNumbersDisappearedInanArray().findDisappearedNumbers(a));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] >= 0) nums[val - 1] *= -1;
        }
        for (int i = 0; i < length; i++) if (nums[i] > 0) list.add(i + 1);
        return list;
    }
}
