package cn.xiongyu.exam.meituan;

import java.util.Scanner;

/**
 * ClassName: Main5
 * Description:
 * Create by xiongyu
 * Date: 2020/8/15 5:32 下午
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 总价格
        int m = sc.nextInt();   // 个数
        long ans = 0;
        for (int a = 1; a <= n; a++) {
            double num = n / (a * (1.0));
            double qq = Math.pow(Math.E, Math.log(num) / (m - 1));
            long q = (long) qq;
            if (Math.abs(Math.abs(qq - q) - 1) < 0.00001) {
                q++;
            }
            ans = (ans + q) % 998244353;
        }
        System.out.println(ans);
    }
}
