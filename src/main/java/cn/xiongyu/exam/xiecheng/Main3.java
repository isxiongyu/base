package cn.xiongyu.exam.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName Main3
 * Description
 * Create by xiongyu
 * Date 2020/4/1 8:25 下午
 */
public class Main3 {
    public static void main(String[] args) {
        String[] strs = {"surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        List<String> ans = new ArrayList<>();
        for (String str : strs) {
            if (Math.abs(str.length() - s.length()) > 2) continue;
            char[] strCs = str.toCharArray();
            int[][] dp = new int[cs.length + 1][strCs.length + 1];
            for (int i = 0; i <= cs.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= strCs.length; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= cs.length; i++) {
                for (int j = 1; j <= strCs.length; j++) {
                    if (cs[i - 1] == strCs[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {

                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                    }
                }
            }
            if (dp[cs.length][strCs.length] <= 2) {
                ans.add(str);
            }
        }
        if (ans.size() == 0) {
            System.out.println("null");
            return;
        }
        for (String str : ans) {
            System.out.println(str);
        }

    }
}
