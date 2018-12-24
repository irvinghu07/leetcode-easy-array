/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-24
 */
public class LeetCodeUtils {
    public static void main(String[] args) {
cleanArray("[[11,74,7,93],[40,11,74,7]]");
    }
    public static void cleanArray(String s){
        s = s.replaceAll("\\[", "{");
        s = s.replaceAll("\\]", "}");
        System.out.println(s);
    }
}
