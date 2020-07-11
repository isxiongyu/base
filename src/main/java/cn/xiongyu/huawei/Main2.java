package cn.xiongyu.huawei;

import java.util.*;

/**
 * ClassName Main2
 * Description
 * Create by xiongyu
 * Date 2020/4/15 6:53 下午
 */
public class Main2 {
    static int ans = Integer.MAX_VALUE;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static Map<String, Integer> caching = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        int[][] paths = new int[y][x];
        for (int i = 0; i < x; i++) {
            Arrays.fill(paths[i], Integer.MAX_VALUE);
        }
        for (int m = 0; m < n; m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int step = sc.nextInt();
            paths[j][i] = step;
        }
        if (paths[0][0] == Integer.MAX_VALUE) paths[0][0] = 1;
        boolean[][] visited = new boolean[x][y];
        visited[0][0] = true;
        dfs(paths, 0, 0, 0, visited);
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
    private static int dfs(int[][] paths, int curr, int i, int j, boolean[][] visited) {
        if (i == paths.length - 1 && j == paths[0].length - 1) {
            ans = Math.min(ans, curr);
            return curr;
        }
        int ans = Integer.MAX_VALUE;
        String key = i + " " + j;
        if (paths[i][j] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (caching.containsKey(key)) return caching.get(key);
        for (int m = 0; m < 4; m++) {
            int newI = i + dirs[m][0];
            int newJ = j + dirs[m][1];
            if (newI >= 0 && newI < paths.length &&
                    newJ >= 0 && newJ < paths[0].length && !visited[newI][newJ]) {
                visited[newI][newJ] = true;
                ans = Math.min(ans, dfs(paths, curr + paths[i][j], newI, newJ, visited));
                visited[newI][newJ] = false;
            }
        }
        caching.put(key, ans);
        return ans;
    }
}
//3 3 7
//0 1 2
//0 2 0
//1 0 1
//1 2 5
//2 0 0
//2 1 3
//2 2 1

