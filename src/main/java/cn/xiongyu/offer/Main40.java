package cn.xiongyu.offer;

import java.util.Arrays;

/**
 * ClassName: Main40
 * Description:
 * Create by xiongyu
 * Date: 2020/6/27 12:45 上午
 */
public class Main40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length <= k) return arr;
        int[] res = new int[k];
        helper(arr, k, 0, arr.length);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    private void helper(int[] arr, int k, int start, int end) {
        if (end - start <= 1) return;
        int base = arr[start];
        int i = start + 1, j = end - 1;
        while (i <= j) {
            if (arr[i] > base && arr[j] < base) swap(arr, i, j);
            if (i <= j && arr[j] >= base) j--;
            if (i <= j && arr[i] <= base) i++;
        }
        swap(arr, start, j);
        System.out.println(j);
        if (j == k - 1) return;
        if (j > k - 1) helper(arr, k, start, j);
        else helper(arr, k, j, end);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Main40 main40 = new Main40();
        int[] arr = {3,2,1};
        int k = 2;
        int[] res = main40.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
