package cn.xiongyu.exam.huawei;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/4/15 7:32 下午
 */
public class Main1 {
    public static void main(String[] args) {
        String sentence = "Note that the only valid version of the GPL as far as this " +
                "project is concerned is _this_ particular version of the license (ie v2, not v2.2 or v3.x or whatever), " +
                "unless explicitly otherwise stated";
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        if (!sentence.contains(strs[0])) {
            System.out.println("warning:is not find!");
            return;
        }
        String res = sentence.replaceAll(strs[0], strs[1]);
        System.out.println(res);
    }
}
