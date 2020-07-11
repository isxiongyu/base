package cn.xiongyu.exam.qq;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/4/26 8:17 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        long n = sc.nextInt();
        long mod = 100003;
        long notReflCount = m % mod;
        long sumCount = m % mod;
        for (int i = 1; i < n; i++) {
            notReflCount = notReflCount * (m - 1) % mod;
            sumCount = sumCount * m % mod;
        }
        long ans = (sumCount - notReflCount + mod) % mod;
        System.out.println(ans);
    }
}
