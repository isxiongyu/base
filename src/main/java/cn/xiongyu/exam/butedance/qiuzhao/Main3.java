package cn.xiongyu.exam.butedance.qiuzhao;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/8/16 10:34 上午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 视频数
        int m = sc.nextInt();  // 广告数
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] lens = new int[n];
        for (int i = 0; i < lens.length; i++) {
            lens[i] = sc.nextInt();
        }
        Arrays.sort(lens);
        int res = Integer.MIN_VALUE;
        for (int x = 0; x < lens.length; x++) {
            int num = m / (n - x);
            int ans = lens[x] / (num - 1);
            for (int i = num - 1; i >= 2; i--) {
                int interval = lens[0] / (i - 1);
                long sum = 0;
                for (int j = x; j < lens.length; j++) {
                    int count = lens[j] / interval + 1;
                    sum += count;
                    if (sum >= m) {
                        ans = Math.max(ans, interval);
                        break;
                    }
                }
                if (sum < m) {
                    break;
                }
            }
            res = Math.max(res, ans);
        }
        System.out.println(res);
    }
}
//3 9
//90 1000 5000
