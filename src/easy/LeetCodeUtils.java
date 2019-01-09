package easy;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-24
 */
public class LeetCodeUtils {
    public static void main(String[] args) {
cleanArray("[[1,2],\n" +
        " * [3,4]]");
    }
    public static void cleanArray(String s){
        s = s.replaceAll("\\[", "{");
        s = s.replaceAll("\\]", "}");
        System.out.println(s);
    }

    public static void printArr(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.println(b[i][j]);
            }
            System.out.println("===================");
        }
    }

    private static void swapValue(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
