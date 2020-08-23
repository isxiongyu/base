package cn.xiongyu.exam.pinxixi;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: Main4
 * Description:
 * Create by xiongyu
 * Date: 2020/8/2 7:18 下午
 */
public class Main4 {
    static int ans = 0;
    static int mod = 1000000009;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] land = new char[6][];
        for (int i = 0; i < 6; i++) {
            land[i] = sc.nextLine().toCharArray();
        }
        dfs(land, 0, 0);
        System.out.println(ans);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println("22");
        });
    }
    private static void dfs(char[][] land, int i, int j) {
        if (i == 6 && j == 0) {
            ans = (ans + 1) % mod;
            return;
        }
        if (land[i][j] == '*') {
            j++;
            if (j >= 6) {
                i++;
                j = 0;
            }
            dfs(land, i, j);
            return;
        }
        for (int m = 1; m <= 6; m++) {
            boolean flag = true;
            for (int[] dir : dirs) {
                int newI = dir[0] + i;
                int newJ = dir[1] + j;
                if (newI >= 0 && newI < 6 && newJ >= 0 && newJ < 6) {
                    if (land[newI][newJ] == m + '0') {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) continue;
            land[i][j] = (char) (m + '0');
            int nextJ = j + 1;
            int nextI = i;
            if (nextJ >= 6) {
                nextI++;
                nextJ = 0;
            }
            dfs(land, nextI, nextJ);
            land[i][j] = '#';
        }
    }
}
