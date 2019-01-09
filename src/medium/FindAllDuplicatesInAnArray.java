package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-09
 */

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                ret.add(nums[i]);
            }
        }
        return ret;
    }
}
