package cn.xiongyu.exam.tongcheng58;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/8/31 7:40 下午
 */
public class Main2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//    }
    public int question(int a, int b) {
        for (int k = 0; k <= 500; k++) {
            int x = k + a;
            int y = k + b;
            if (isSquar(x) && isSquar(y)) return k;
        }
        return -1;
    }
    public boolean isSquar(int n) {
        return Math.abs((int) Math.sqrt(n) * (int) Math.sqrt(n) - n) <= Math.pow(10, -5);
    }
}
