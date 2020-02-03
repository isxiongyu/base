package cn.xiongyu.nowcoder.offer;


import org.junit.Test;

/**
 * ClassName: MatrixPath
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-19 下午5:13
 * Author: xiongyu
 */
public class MatrixPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (str == null || str.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        int strIndex = 0;
        boolean res = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[strIndex]) {
                boolean[] copy = new boolean[matrix.length];
                copy[i] = true;
                res = res || dfs(matrix, rows, cols, str, copy, i, strIndex + 1);
            }
        }
        return res;
    }
    private boolean dfs(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int matrixIndex, int strIndex) {
        boolean res = false;
        int[] dir = {-cols, cols, -1, 1};
        if (strIndex >= str.length) {
            return true;
        }
        for (int i = 0; i < dir.length; i++) {
            int index = matrixIndex + dir[i];
            if (index >= matrix.length || index < 0 || visited[index] || matrix[index] != str[strIndex]) {
                continue;
            }
            boolean[] vCopy = visited.clone();
            vCopy[index] = true;
            res = res || dfs(matrix, rows, cols, str, vCopy, index, strIndex + 1);
        }
        return res;
    }
    @Test
    public void test() {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCB".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
