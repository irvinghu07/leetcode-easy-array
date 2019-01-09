package medium;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Array
 * Date: 2019-01-09
 */

import java.util.Arrays;

/**
 * {@see <a href="https://leetcode.com/problems/beautiful-arrangement-ii/">code</a> }
 * Given two integers n and k, you need to construct a list which contains n different
 * positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|,
 * |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * <p>
 * If there are multiple answers, print any of them.
 * <p>
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3,
 * and the [1, 1] has exactly 1 distinct integer: 1.
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
 * and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * Note:
 * The n and k are in the range 1 <= k < n <= 104.
 */
public class BeautifulArrangementII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BeautifulArrangementII().constructArray(3, 2)));
    }

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        int agent = 0;
        for (int i = 1; i < n; i++) {
            if (agent < k) {
                if (res[i - 1] + k <= n) {
                    res[i] = res[i - 1] + k--;
                } else {
                    res[i] = res[i - 1] - k--;
                }
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
