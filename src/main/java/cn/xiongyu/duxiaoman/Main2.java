package cn.xiongyu.duxiaoman;

import java.util.Scanner;

/**
 * ClassName: Main2
 * Description:
 * Create by xiongyu
 * Date: 2020/4/20 4:36 下午
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] matrix = new int[n][m];
        int index = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = index % 10;
                index++;
            }
        }
    }
}
