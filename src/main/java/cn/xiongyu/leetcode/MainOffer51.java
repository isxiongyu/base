package cn.xiongyu.leetcode;

/**
 * ClassName: MainOffer51
 * Description:
 * Create by xiongyu
 * Date: 2020/6/21 11:00 下午
 */
public class MainOffer51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return count;
    }
    private void mergeSort(int[] nums, int i, int j) {
        if (i >= j - 1) return;
        int mid = i + (j - i) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid, j);
        merge(nums, i, j);
    }
    private void merge(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int[] tmp = new int[nums.length];
        int i = left, j = mid;
        int curr = 0;
        while (i < mid && j < right) {
            if (nums[i] <= nums[j]) {
                tmp[curr++] = nums[i++];
            } else {
                count += mid - i;
                tmp[curr++] = nums[j++];
            }
        }
        while (i < mid) {
            tmp[curr++] = nums[i++];
        }
        while (j < right) {
            tmp[curr++] = nums[j++];
        }
        curr = 0;
        for (int m = left; m < right; m++) {
            nums[m] = tmp[curr++];
        }
    }

    public static void main(String[] args) {
        MainOffer51 mainOffer51 = new MainOffer51();
        int[] nums = {2, 1};
        int ans = mainOffer51.reversePairs(nums);
        System.out.println(ans);
    }
}
