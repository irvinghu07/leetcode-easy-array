package string.easy;

/**
 * {@see <a href="https://leetcode.com/problems/to-lower-case/">instruction</a>}
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int asi = (int) chars[i];
            if (65 <= asi && asi <= 90) chars[i] += 32;
        }
        return new String(chars);
    }
}
