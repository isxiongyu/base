package cn.xiongyu.huawei;

import java.util.Scanner;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/4/15 7:46 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int ans = 0;
        for (int i = 0; i < strs.length; i += 2) {
            ans += Math.min(Integer.parseInt(strs[i]), Integer.parseInt(strs[i + 1]));
        }
        System.out.println(ans);
    }
}
