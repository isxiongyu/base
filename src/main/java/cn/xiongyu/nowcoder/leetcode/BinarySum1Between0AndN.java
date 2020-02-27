package cn.xiongyu.nowcoder.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: BinarySum1Between1N
 * Package: cn.xiongyu.nowcoder.leetcode
 * Description:
 * Date: 2020/2/25 下午10:05
 * Author: xiongyu
 */
public class BinarySum1Between0AndN {
    public int[] binarySum1Between0AndNCore(int n) {
        if (n < 0) return null;
        int[] res = new int[n + 1];
        if (n >= 1) {
            res[1] = 1;
        }
        if (n >= 2) {
            res[2] = 1;
        }
        if (n <= 2) return res;
        int pow2 = 2;
        int nextPow2 = pow2 << 1;
        for (int i = 3; i <= n; i++) {
            if (i == nextPow2) {
                res[i] = 1;
                pow2 = nextPow2;
                nextPow2 = nextPow2 << 1;
            } else {
                res[i] = res[pow2] + res[i - pow2];
            }
        }
        return res;
    }
    @Test
    public void test() {
        int[] res = new BinarySum1Between0AndN().binarySum1Between0AndNCore(10);
        System.out.println(Arrays.toString(res));
    }
}
