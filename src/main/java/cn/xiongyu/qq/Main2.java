package cn.xiongyu.qq;

import java.util.Scanner;

/**
 * ClassName: Main2
 * Description:
 * Create by xiongyu
 * Date: 2020/4/26 8:29 下午
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

    }
}
