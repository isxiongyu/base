package cn.xiongyu.duxiaoman;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/4/20 4:17 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] dp = new boolean[201][201];
        for (int i = 1; i <= 200; i++) {
            dp[i][1] = true;
        }
        for (int j = 1; j <= 200; j++) {
            dp[1][j] = true;
        }
        dp[1][1] = false;
        helper(200, 200, dp);
        while (sc.hasNext()) {
            String[] strs = sc.nextLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            if (dp[n][m]) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
        }
    }
    private static void helper(int n, int m, boolean[][] dp) {
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                for (int x = 1; x < i; x++) {
                    dp[i][j] = dp[i][j] || ((!dp[x][j]) && (!dp[i - x][j]));
                }
                if (dp[i][j]) {
                    continue;
                }
                for (int y = 1; y < j; y++) {
                    dp[i][j] = dp[i][j] || ((!dp[i][y]) && (!dp[i][j - y]));
                }
            }
        }
    }
}
//4 2
//3 2
//2 2