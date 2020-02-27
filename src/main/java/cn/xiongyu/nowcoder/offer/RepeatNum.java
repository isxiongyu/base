package cn.xiongyu.nowcoder.offer;

import org.junit.Test;

/**
 * ClassName: RepeatNum
 * Package: cn.xiongyu.nowcoder.offer
 * Description:
 * Date: 2020/2/17 下午9:43
 * Author: xiongyu
 */
public class RepeatNum {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int temp = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
//            System.out.println(right);
        }
        return temp - right - 1;
    }
    @Test
    public void test() {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        System.out.println(search(nums, target));
    }
}
