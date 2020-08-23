package cn.xiongyu.exam.pinxixi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/8/2 7:07 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] launch = new int[n + 1][2];
        int[][] dinner = new int[m + 1][2];
        for (int i = 1; i <= n; i++) {
            launch[i][0] = sc.nextInt();
            launch[i][1] = sc.nextInt();
        }
        Arrays.sort(launch, (o1, o2) -> o1[0] - o2[0]);
        for (int j = 1; j <= m; j++) {
            dinner[j][0] = sc.nextInt();
            dinner[j][1] = sc.nextInt();
        }
        Arrays.sort(dinner, (o1, o2) -> o1[0] - o2[0]);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int mei = launch[i][1] + dinner[j][1];
                if (mei >= t) {
                    ans = Math.min(ans, launch[i][0] + dinner[j][0]);
                    break;
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }
}
