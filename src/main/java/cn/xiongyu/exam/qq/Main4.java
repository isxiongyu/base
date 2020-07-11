package cn.xiongyu.exam.qq;

import java.util.Scanner;

/**
 * ClassName: Main4
 * Description:
 * Create by xiongyu
 * Date: 2020/4/26 9:39 下午
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

    }
}
