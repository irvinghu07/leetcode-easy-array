package array.easy;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/majority-element/">instruction</a>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(new MajorityElement().majorityElement(a));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int currentVal = nums[0], count = 0, max = 0, maxVal = currentVal;
        for (int i = 1; i < length; i++) {
            if (currentVal == nums[i]) count++;
            else {
                currentVal = nums[i];
                count = 0;
            }
            if (max < count) {
                max = count;
                maxVal = currentVal;
            }
        }
        return maxVal;
    }
}
