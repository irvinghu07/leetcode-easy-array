package math;

import java.util.Arrays;

/**
 * {@see </a href="https://leetcode.com/problems/di-string-match/">instruction</>}
 * Given a math S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * <p>
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * <p>
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * <p>
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * <p>
 * Input: "DDI"
 * Output: [3,2,0,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class DIStringMatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DIStringMatch().diStringMatch("IDID")));
    }


    /**
     *  Solution:
     * {@see <a/ href="https://leetcode.com/problems/di-string-match/discuss/194904/C%2B%2BJavaPython-Straight-Forward">Solution</>}
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
//      I = 73; D = 64
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        char[] chars = S.toCharArray();
        for (int i = 0; i < n; i++)
            res[i] = chars[i] == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }
}
