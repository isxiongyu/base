package cn.xiongyu.offer;

import java.util.Arrays;

/**
 * ClassName: Main39
 * Description:
 * Create by xiongyu
 * Date: 2020/6/26 11:45 下午
 */
public class Main39 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length);
    }
    private int helper(int[] nums, int left, int right) {
        if (right - left <= 1) return nums[left];
        int base = nums[left];
        int i = left + 1, j = right - 1;
        while (i <= j) {
            if (nums[i] > base && nums[j] < base) swap(nums, i, j);
            if (i <= j && nums[j] >= base) j--;
            if (i <= j && nums[i] <= base) i++;
        }
        swap(nums, left, j);
        System.out.println(Arrays.toString(nums));
        if (j == nums.length / 2) return nums[j];
        if (j < nums.length / 2) {
            return helper(nums, i, right);
        } else {
            return helper(nums, left, i);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Main39 main39 = new Main39();
        int[] nums = {3,3,4};
        int ans = main39.majorityElement(nums);
        System.out.println(ans);
    }
}
