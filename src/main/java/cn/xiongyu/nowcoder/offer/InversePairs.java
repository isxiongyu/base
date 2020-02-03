package cn.xiongyu.nowcoder.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: InversePairs
 * Package: cn.xiongyu.nowcoder.offer
 * Description:
 * Date: 2020/2/3 下午11:28
 * Author: xiongyu
 */
public class InversePairs {
    int ans = 0;
    public int inversePairs(int [] array) {
        helper(array, 0, array.length);
        return ans;
    }
    private void helper(int[] array, int left, int right) {
        if (right <= left + 1) {
            return;
        }
        int mid = left + (right - left) / 2;
        helper(array, left, mid);
        helper(array, mid, right);
        merge(array, left, right);
    }
    private void merge(int[] array, int left, int right) {
        int[] midArray = new int[right - left];
        int mid = left + (right - left) / 2;
        int i = left;
        int j = mid;
        int curr = 0;
        while (i < mid && j < right) {
            if (array[i] > array[j]) {
                midArray[curr++] = array[j++];
                ans += mid - i;
            } else {
                midArray[curr++] = array[i++];
            }
        }
        while (i < mid) {
            midArray[curr++] = array[i++];
//            ans += right - mid;
        }
        while (j < right) {
            midArray[curr++] = array[j++];
        }
        for (int m = left; m < right; m++) {
            array[m] = midArray[m - left];
        }
    }
    @Test
    public void test() {
        int[] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int ans = new InversePairs().inversePairs(array);//2519
        System.out.println(ans);
    }
}
