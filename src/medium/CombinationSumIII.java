package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @see </a href="https://leetcode.com/problems/combination-sum-iii/">instruction</>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int start, int n, int k, ArrayList<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == k) {
            int sum = 0;
            for (Integer integer : tempList) sum += integer;
            if (sum == n) {
                result.add(tempList);
                backTrack(start + 1, n, k, new ArrayList<>(), result);
                return;
            }
            tempList.remove(k - 1);
            return;

        }
        for (int i = start + 1; i < n; i++) {
            if (tempList.size() < k) {
                int sum = 0;
                for (Integer integer : tempList) sum += integer;
                if (sum + i == n) {
                    tempList.add(i);
                    result.add(tempList);
                } else if (sum + i < n && tempList.size() < k) {
                    tempList.add(i);
                    backTrack(i, n, k, tempList, result);
                }
            }
        }
    }
}
