package cn.xiongyu.nowcoder.offer;

import java.lang.String;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: SlideWindow
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-13 下午10:17
 * Author: xiongyu
 */
public class SlideWindow {
    public List<Integer> maxInWindows(int [] num, int size) {
        List<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return res;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - size + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= size - 1) {
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(new SlideWindow().maxInWindows(num, size));
    }
}
