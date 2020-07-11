package cn.xiongyu.exam.xiecheng;

import java.util.Scanner;

/**
 * ClassName Main1
 * Description
 * Create by xiongyu
 * Date 2020/4/1 6:55 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1000];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] strs = sc.nextLine().split(",");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            for (int j = a; j < b; j++) {
                arr[j]++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1000; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
