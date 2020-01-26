package cn.xiongyu.practice;

import java.lang.String;

/**
 * ClassName: StringBufferTest
 * Package: cn.xiongyu.practice
 * Description:
 * Date: 19-9-25 下午2:15
 * Author: xiongyu
 */
public class StringBufferTest {
    public static void main(String[] args) {
        String s = "abcbcaabcbca";
        StringBuffer sb = new StringBuffer(s);
        String substring = sb.substring(10, 12);
        System.out.println(substring);
    }
}
