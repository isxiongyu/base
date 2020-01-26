package cn.xiongyu.leetcode;

import java.lang.String;

/**
 * ClassName: MultiplyStrings
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-16 下午3:09
 * Author: xiongyu
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] res = new char[len1 + len2];
        for (int i = 0; i < len1 + len2; i++)
            res[i] = '0';
        int add = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            int index = len2 + i;
            for (int j = len2 - 1; j >= 0; j--) {
                int n1 = (int) (num1.charAt(i) - '0');
                int n2 = (int) (num2.charAt(j) - '0');
                int mul = n1 * n2 + add + (res[index] - '0');
                add = mul / 10;
                res[index] = (char) (mul % 10 + '0');
                index--;
            }
            if (add != 0) {
                res[index] = (char) (add + '0');
                add = 0;
            }

        }
        int leading = 0;
        while (leading < len1 + len2) {
            if ( res[leading] != '0') {
                break;
            }
            leading++;
        }
        return new String(res, leading, len1 + len2 - leading);
    }

    public static void main(String[] args) {
        MultiplyStrings mu = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println(mu.multiply(num1, num2));
    }
}
