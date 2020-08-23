package cn.xiongyu.exam.pinxixi;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/8/2 7:51 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.execute();
        int k = sc.nextInt();
        int n = sc.nextInt();
        if (k == 0) {
            System.out.println("paradox");
            return;
        }
        int back = 0;
        for (int i = 0; i < n; i++) {
            int step = sc.nextInt();
            if (step == k) {
                System.out.println("paradox");
                return;
            }
            if (step < k) {
                k -= step;
            } else {
                k = step - k;
                back++;
            }
        }
        System.out.print(k + " ");
        System.out.println(back);
    }
}
