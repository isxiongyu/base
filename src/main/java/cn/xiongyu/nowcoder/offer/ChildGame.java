package cn.xiongyu.nowcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ChildGame
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-11 下午5:06
 * Author: xiongyu
 */
public class ChildGame {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        int j = 0;
        while (true) {
            System.out.println(list);
            if (list.size() == 1) {
                break;
            }
            if (j == m - 1) {
                list.remove(i);
                j = 0;
                if (i >= list.size()) {
                    i = 0;
                }
                continue;
            }
            i++;
            j++;
            if (i >= list.size()) {
                i = 0;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new ChildGame().LastRemaining_Solution(5, 3));
    }
}
