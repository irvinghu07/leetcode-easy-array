package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @see </a href="https://leetcode.com/problems/subsets/">instruction</>
 * * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        System.out.println(new Subsets().subsets(a));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length, lengthMax = 2 + length * (length - 1);
        List<List<Integer>> result = new ArrayList<>(lengthMax);
        // initializing the list
//        for (int i = 0; i < lengthMax; i++) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            result.add(i, temp);
//        }
        for (int i = 1; i <= length; i++) {
            // generate i * i matrix
            generateMatrix(i, nums, result);
        }
        return result;
    }

    private void generateMatrix(int limit, int[] nums, List<List<Integer>> result) {
        int length = nums.length;
        for (int i = 0, j = i + 1; i < length && j < length; i++) {
            int capacity = 0;
            while (j < length && capacity < limit){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                capacity++;
                while (capacity < limit) {
                    temp.add(nums[j]);
                    capacity++;
                    j++;
                }
                result.add(temp);
            }
        }
    }
}
