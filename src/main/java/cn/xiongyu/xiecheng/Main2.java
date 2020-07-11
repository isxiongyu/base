package cn.xiongyu.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName Main2
 * Description
 * Create by xiongyu
 * Date 2020/4/1 7:40 下午
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] birthYear = new int[p];
        for (int i = 0; i < p; i++) {
            birthYear[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        //dp[i][j]表示，在i年，j年出生的海豚数目
        long[][] dp = new long[x + 1][x + 1];
        dp[0][0] = n;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    for (int y = 0; y < birthYear.length; y++) {
                        int year = birthYear[y];
                        if (year > j) break;
                        dp[i][j] += dp[i][j - year];
                    }
                }
                if (j > m) {
                    dp[i][j] -= dp[i][j - m - 1];
                }
            }
        }
        long num = 0;
        for (int j = 0; j <= x; j++) {
            num += dp[x][j];
        }
        System.out.println(num);
    }
}
