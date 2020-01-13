package cn.xiongyu.nowcoder;

/**
 * ClassName: ArrayFind
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-8 上午11:04
 * Author: xiongyu
 */
public class ArrayFind {
    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int n = array.length;
        int m = array[0].length;
        if (m == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (right > left) {
                int mid = left + (right - left) / 2;
                if (array[i][mid] == target) {
                    return true;
                }
                if (array[i][mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (array[i][left] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int target = 11;
        System.out.println(Find(target, array));
    }
}
