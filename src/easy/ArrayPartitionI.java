package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: leetcode-Sort Array By Parity
 * Date: 2018-12-13
 */
//Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
//
//        Example 1:
//        Input: [1,4,3,2]
//
//        Output: 4
//        Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
//        Note:
//        n is a positive integer, which is in the range of [1, 10000].
//        All the integers in the array will be in the range of [-10000, 10000].
public class ArrayPartitionI {
    public static void main(String[] args) {
        int[] a = {1, 1};
        System.out.println(new ArrayPartitionI().arrayPairSum(a));
    }

    public int arrayPairSum(int[] nums) {
        if (nums.length < 1000) {
            Arrays.sort(nums);
        } else {
            new QuickSort().sort(nums);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public class QuickSort {
        public void sort(int[] a) {
            // choose three random numbers as candidates for pivot
            // then choose the median from these three numbers as the pivot
            preparePivot(a);
            //at this point
            //pivot is the first element in the array
//        System.out.println("pivot: " + a[0]);
            quickSort(a, 0, a.length);

        }

        private void quickSort(int[] a, int low, int high) {
            if (low < high) {
                int mid = partition(a, low, high);
                quickSort(a, low, mid);
                quickSort(a, mid + 1, high);
            }

        }

        private int partition(int[] a, int low, int high) {
            int i = low + 1;
            int j = high - 1;
//        System.out.println(String.format("low:%d high:%d", low, high));
            int pivot = a[low];
            while (i <= j) {
                while (i <= j && a[i] <= pivot) {
                    i++;
                }
                while (i <= j && pivot <= a[j]) {
                    j--;
                }
                if (i < j) {
                    swapValues(a, i, j);
                }
            }
            swapValues(a, low, j);
            return j;
        }

        private void preparePivot(int[] a) {
            int[] numbers = findThreeRandomNum(a);
            int[] numbersAtIndex = Arrays.copyOf(numbers, 3);
            convertToValues(numbers, a);
            HashMap<Integer, Integer> record = new HashMap<>();
            //        <value, index>
            for (int i = 0; i < numbers.length; i++) {
                record.put(numbers[i], numbersAtIndex[i]);
            }
            int pivot = findMedianInRandoms(numbers);
            swapValues(a, 0, record.get(pivot));
        }

        private void convertToValues(int[] nums, int[] a) {
            for (int j = 0; j < nums.length; j++) {
                nums[j] = a[nums[j]];
            }
        }

        private int findMedianInRandoms(int[] threeRandomNum) {
            Arrays.sort(threeRandomNum);
            return threeRandomNum[1];
        }

        private int[] findThreeRandomNum(int[] a) {
            int[] nums = {0, 0, 0};
            Random random = new Random();
            int index;
            int i = 0;
            while (i < 3) {
                index = random.nextInt(a.length);
                boolean flag = true;
                for (int num : nums) {
                    if (num == index) {
                        flag = false;
                    }
                }
                if (flag) {
                    nums[i] = index;
                    i++;
                }
            }
            return nums;
        }

        public void swapValues(int[] arr, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
            if (firstIndex != secondIndex) {
                int temp = arr[firstIndex];
                arr[firstIndex] = arr[secondIndex];
                arr[secondIndex] = temp;

            }
        }
    }
}
