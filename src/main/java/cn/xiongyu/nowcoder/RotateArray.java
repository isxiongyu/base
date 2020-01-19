package cn.xiongyu.nowcoder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * ClassName: RotateArray
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-19 下午4:09
 * Author: xiongyu
 */
public class RotateArray {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int i = 0, j = 0;
        while (right >= left && bottom >= top) {
//            System.out.println(matrix[i][j]);
            if (visited[i][j]) {
                return res;
            }
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if (i == top && j < right) {
                j++;
            } else if (i < bottom && j == right) {
                i++;
            } else if (i == bottom && j > left) {
                j--;
            } else if (i > top + 1 && j == left) {
                i--;
            } else {
                j++;
                left++;
                right--;
                top++;
                bottom--;
            }
        }
        return res;
    }
    @Test
    public void test01() {
        int[][] matrix = {{1, 2}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(printMatrix(matrix));
    }
}
