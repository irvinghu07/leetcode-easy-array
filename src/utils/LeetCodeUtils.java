package utils;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-24
 */
public class LeetCodeUtils {
    public static void main(String[] args) {
        System.out.println(        upperCase("Max Chunks To Make Sorted")
        );
//        System.out.println(upperCase("Product of Array Except Self"));;
//        cleanArray("[[0,0,1,0,0,0,0,1,0,0,0,0,0],\n" +
//                " [0,0,0,0,0,0,0,1,1,1,0,0,0],\n" +
//                " [0,1,1,0,1,0,0,0,0,0,0,0,0],\n" +
//                " [0,1,0,0,1,1,0,0,1,0,1,0,0],\n" +
//                " [0,1,0,0,1,1,0,0,1,1,1,0,0],\n" +
//                " [0,0,0,0,0,0,0,0,0,0,1,0,0],\n" +
//                " [0,0,0,0,0,0,0,1,1,1,0,0,0],\n" +
//                " [0,0,0,0,0,0,0,1,1,0,0,0,0]]");
    }

    private static String  upperCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] == 32) {
                if ((int) chars[i + 1] > 97) {
                    chars[i + 1] -= 32;
                }
            }

        }
        return new String(chars).replaceAll(" ", "");
    }

    public static void cleanArray(String s) {
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
