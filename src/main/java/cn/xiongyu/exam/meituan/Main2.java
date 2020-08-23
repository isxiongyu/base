package cn.xiongyu.exam.meituan;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/8/15 4:00 下午
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int ans = 0;
        String st = "";
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            String[] citys = sc.nextLine().split(" ");
            if (flag) {
                st = citys[0];
                flag = false;
            }
            if (citys[1].equals(st)) {
                ans++;
                flag = true;
            }
        }
        System.out.println(ans);
    }
}
//6
//bj nj
//nj gz
//gz sh
//sh bj
//bj fz
//fz bj