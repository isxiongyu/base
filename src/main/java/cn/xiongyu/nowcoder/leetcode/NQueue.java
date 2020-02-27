package cn.xiongyu.nowcoder.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: NQueue
 * Package: cn.xiongyu.nowcoder.leetcode
 * Description:
 * Date: 2020/2/22 下午3:48
 * Author: xiongyu
 */
public class NQueue {
    List<List<String>> results = new ArrayList<>();
    StringBuffer s = new StringBuffer();
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return results;
        int[][] record = new int[n][n];
        for (int i = 0; i < n; i++) {
            s.append(".");
        }
        dfs(n, 0, record, new ArrayList());
        return results;
    }
    private void dfs(int n, int index, int[][] record, List<String> res) {
        System.out.println(res);
        if (index == n) {
            results.add(res);
        }
        for (int i = 0; i < n; i++) {
            if (checkCol(index, i, record) && checkDiag(index, i, record) && checkSubDiag(index, i, record)) {
                int[][] copyRecord = record.clone();
                List<String> copyRes = new ArrayList<>(res);
                copyRecord[index][i] = 1;
                StringBuffer sb = new StringBuffer(s);
                sb.replace(i, i + 1, "Q");
                copyRes.add(sb.toString());
                dfs(n, index + 1, copyRecord, copyRes);
            }
        }
    }
    private boolean checkCol(int row, int col, int[][] record) {
        for (int i = 0; i < row; i++) {
            if (record[i][col] == 1) return false;
        }
        return true;
    }
    private boolean checkDiag(int row, int col, int[][] record) {
        row -= 1;
        col -= 1;
        while (row >= 0 && col >= 0) {
            if (record[row--][col--] == 1) return false;
        }
        return true;
    }
    private boolean checkSubDiag(int row, int col, int[][] record) {
        row -= 1;
        col += 1;
        while (row >= 0 && col < record.length) {
            if (record[row--][col++] == 1) return false;
        }
        return true;
    }
    @Test
    public void test() {
        System.out.println(new NQueue().solveNQueens(4));
    }
}
