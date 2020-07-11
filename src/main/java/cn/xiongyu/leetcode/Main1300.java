package cn.xiongyu.leetcode;

import scala.Int;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Main1300
 * Description:
 * Create by xiongyu
 * Date: 2020/6/14 7:41 下午
 */
public class Main1300 {
    public int findBestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        if (sum[arr.length - 1] <= target) {
            return arr[arr.length - 1];
        }
        int left = 0, right = arr[arr.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int s = getDiff(arr, mid, sum);
            System.out.println("mid=" + mid + "s=" + s);
            if (s < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            int tmpDiff = Math.abs(s - target);
            if (tmpDiff < diff) {
                diff = tmpDiff;
                ans = mid;
            }
            if (tmpDiff == diff && mid < ans) {
                ans = mid;
            }
        }
        return ans;
    }
    private int getDiff(int[] arr, int tar, int[] sum) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < tar) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("left=" + left + "right=" + right);
        }
        if (left == 0) {
            return (arr.length - left) * tar;
        }
        return (arr.length - left) * tar + sum[left - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1547,83230,57084,93444,70879};
        int target = 71237;
        Main1300 main1300 = new Main1300();
        int res = main1300.findBestValue(arr, target);
        System.out.println(res);
    }
}
