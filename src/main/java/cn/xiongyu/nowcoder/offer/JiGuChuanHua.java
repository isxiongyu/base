package cn.xiongyu.nowcoder.offer;

/**
 * ClassName: JiGuChuanHua
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 19-12-17 下午8:59
 * Author: xiongyu
 */
import java.util.*;
public class JiGuChuanHua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //第i次在小袁手中的方案数
        long[] dp1 = new long[n + 1];
        dp1[0] = 1;
        //第i次不在小袁手中的方案数
        long[] dp2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp1[i] = dp2[i - 1];
            dp2[i] = Math.max(dp1[i - 1] * (k - 1), dp2[i - 1] * (k - 2)) % 1000000007;
            System.out.println(dp1[i]);
        }
        System.out.println(dp1[n]);
    }
}
