package cn.xiongyu.exam.butedance.qiuzhao;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * ClassName: Main4
 * Description:
 * Create by xiongyu
 * Date: 2020/8/16 10:51 上午
 */
public class Main4 {
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(arr, m, 0, arr[0]);
    }
    private static void dfs(int[] arr, int m, int curr, long sum) {
        ans = Math.max(ans, (int) sum % m);
        if (curr + 1 >= arr.length) return;
        dfs(arr, m, curr + 1, (sum + arr[curr + 1]) % m);
        dfs(arr, m, curr + 1, sum);
    }
}
//5 5
//1 2 3 4 5
