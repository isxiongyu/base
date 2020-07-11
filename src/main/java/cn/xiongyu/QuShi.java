package cn.xiongyu;

import java.util.Scanner;

/**
 * ClassName: qushi
 * Description:
 * Create by xiongyu
 * Date: 2020/5/7 7:59 下午
 */
public class QuShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        int interval = 1;
        int start = 0;
        while (count < n - 1) {
            int curr = start;
            int step = 0;
            while (step <= interval) {
                curr++;
                curr = curr == n + 1 ? 1 : curr;
                if (!visited[curr]) {
                    step++;
                }
            }
            visited[curr] = true;
            start = curr;
            count++;
            interval++;
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
