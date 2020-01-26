package cn.xiongyu.string;

import java.lang.String;

/**
 * ClassName: stringTest
 * Package: cn.xiongyu.string
 * Description:
 * Date: 19-10-15 下午5:37
 * Author: xiongyu
 */
public class stringTest {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1, 2, 3};
        char[] arr = new char[]{'a', 'b', 'c'};
        String s = new String(arr);
        StringBuffer sb = new StringBuffer(s);
        sb.insert(1, 5);
        System.out.println(sb);
    }
}
