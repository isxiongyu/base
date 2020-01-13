package cn.xiongyu.practice;

import java.util.Arrays;

/**
 * ClassName: QuickSort
 * Package: cn.xiongyu
 * Description:
 * Date: 19-8-28 下午10:50
 * Author: xiongyu
 */
public class QuickSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int key = nums[0];
        int left = 0;
        int right = nums.length - 1;
        quick(nums, left, right);
    }
    private static void quick(int[] nums, int left, int right) {
        if (right < left) {
            return;
        }
        int i = left;
        int j = right;
        while (i != j) {
            while (j > i && nums[j] >= nums[left]) {
                j --;
            }
            while (j > i && nums[i] <= nums[left]) {
                i ++;
            }
            if (j > i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
        System.out.println(Arrays.toString(nums));
        quick(nums, left, i - 1);
        quick(nums,  j + 1, right);
    }
    public static void main (String[] args) {
        int[] nums = {9, 5, 2, 1, 5, 8, 7, 4, 5, 1, 2, 0, 3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
