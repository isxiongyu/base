package cn.xiongyu.nowcoder.offer;

import org.junit.Test;

/**
 * ClassName: Ugly
 * Package: cn.xiongyu.nowcoder.offer
 * Description:
 * Date: 2020/2/15 下午9:09
 * Author: xiongyu
 */
public class Ugly {
    public int uglyNum(int index) {
        if (index <= 1) return index;
        int[] cache = new int[index];
        cache[0] = 1;
        int s1 = 0, s2 = 0, s3 = 0;
        for (int i = 1; i < index; i++) {
            int end = cache[i - 1];
            while (cache[s1] * 2 <= end)
                s1++;
            while (cache[s2] * 3 <= end)
                s2++;
            while (cache[s3] * 5 <= end)
                s3++;
            cache[i] = Math.min(Math.min(cache[s1] * 2, cache[s2] * 3), cache[s3] * 5);
        }
        return cache[index - 1];
    }
    @Test
    public void test() {
        System.out.println(new Ugly().uglyNum(1500));
    }
}
