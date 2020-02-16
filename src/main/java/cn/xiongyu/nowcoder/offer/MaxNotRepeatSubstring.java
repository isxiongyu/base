package cn.xiongyu.nowcoder.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: MaxNotRepeatSubstring
 * Package: cn.xiongyu.nowcoder.offer
 * Description:
 * Date: 2020/2/15 下午8:22
 * Author: xiongyu
 */
public class MaxNotRepeatSubstring {
    public int maxSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
//        int[] dp = new int[s.length() + 1];
        int dp = 0;
        int[] record = new int[26];
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            int index = record[c - 'a'];
            if (index == 0) dp++;
            else if (i - index > dp) dp++;
            else dp = i - index;
            record[c - 'a'] = i;
        }
        return dp;
    }
    @Test
    public void test() {
        String s = "jidosrghiwerop";
        System.out.println(new MaxNotRepeatSubstring().maxSubstring(s));
    }
}
