package cn.xiongyu.nowcoder.offer;

import java.lang.String;

/**
 * ClassName: UglyNumber
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-18 下午10:07
 * Author: xiongyu
 */
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] contain = new int[index];
        int maxIndex = 0;
        contain[0] = 1;
        int fac2 = 0;
        int fac3 = 0;
        int fac5 = 0;
        while (maxIndex < index - 1) {
            while (contain[fac2] * 2 <= contain[maxIndex]) {
                fac2++;
            }
            while (contain[fac3] * 3 <= contain[maxIndex]) {
                fac3++;
            }
            while (contain[fac5] * 5 <= contain[maxIndex]) {
                fac5++;
            }
            int min = Math.min(contain[fac2] * 2, Math.min(contain[fac3] * 3, contain[fac5] * 5));
            contain[++maxIndex] = min;
        }
        return contain[maxIndex];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().GetUglyNumber_Solution(3));
    }
}
