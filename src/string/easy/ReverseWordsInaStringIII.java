package string.easy;

/**
 * {@see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">intruction</a>}
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInaStringIII {
    public static void main(String[] args) {
        System.out.println(new ReverseWordsInaStringIII().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder(s);
        int length = strings.length, index = 0;
        for (int i = 0; i < length; i++) {
            final char[] chars = strings[i].toCharArray();
            int strLength = chars.length;
            for (int j = strLength - 1; j >= 0; j--) {
                stringBuilder.setCharAt(index, chars[j]);
                index++;
            }
            index++;
        }
        return stringBuilder.toString();
    }
}
