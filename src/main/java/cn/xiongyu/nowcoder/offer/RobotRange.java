package cn.xiongyu.nowcoder.offer;


import org.junit.Test;

/**
 * ClassName: RobotRange
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-19 下午2:39
 * Author: xiongyu
 */
public class RobotRange {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (!isPass(threshold, row, col) || visited[row * cols + col]) {
            return 0;
        }
        int sum = 1;
        visited[row * cols + col] = true;
        if (row - 1 >= 0) {
            sum += movingCountCore(threshold, rows, cols, row - 1, col, visited);
        }
        if (row + 1 < rows) {
            sum += movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        if (col - 1 >= 0) {
            sum += movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        if (col + 1 < cols) {
            sum += movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return sum;
    }
    private boolean isPass(int threshold, int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= threshold;
    }
    @Test
    public void test01() {
        System.out.println(movingCount(18, 100, 100));
//        System.out.println(isPass(18, 35, 38));
    }
}
