package cn.xiongyu.nowcoder;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/**
 * ClassName: SlideWindow
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-13 下午10:17
 * Author: xiongyu
 */
public class SlideWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return list;
        }
        int start = 0;
        int end = size;
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        while (end <= num.length) {
            if (maxIndex < start) {
                max = Integer.MIN_VALUE;
                for (int i = start; i < end; i++) {
                    if (num[i] >= max) {
                        max = num[i];
                        maxIndex = i;
                    }
                }
            } else {
                if (num[end - 1] >= max) {
                    max = num[end - 1];
                    maxIndex = end - 1;
                }
            }
            list.add(max);
            start++;
            end++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(new SlideWindow().maxInWindows(num, size));
    }
}
