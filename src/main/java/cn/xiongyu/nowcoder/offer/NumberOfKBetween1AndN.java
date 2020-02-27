package cn.xiongyu.nowcoder.offer;

import org.junit.Test;

/**
 * ClassName: NumberOfKBetween1AndN
 * Package: cn.xiongyu.nowcoder.offer
 * Description:
 * Date: 2020/2/17 下午6:13
 * Author: xiongyu
 */
public class NumberOfKBetween1AndN {
    public int number(int n, int k) {
        if (n < k) return 0;
        int count = 0;
        int m;
        for (int i = 1; (m = n / i) > 0; i *= 10) {
            count += (m / 10) * i;
            int curr = m % 10;
            if (curr > k) {
                count += i;
            } else if (curr == k) {
                count += n - m * i + 1;
            }
        }
        return count;
    }
    @Test
    public void test() {
        System.out.println(new NumberOfKBetween1AndN().number(21345, 1));
    }
}
