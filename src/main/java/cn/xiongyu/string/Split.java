package cn.xiongyu.string;

import java.util.Arrays;

/**
 * ClassName: Split
 * Package: cn.xiongyu.string
 * Description:
 * Date: 19-9-19 上午9:51
 * Author: xiongyu
 */
public class Split {
    public static void main(String[] args) {
        String a = "fjreuiofvriheswrowui";
        String regex = "[ ]";
        String[] strings = a.split(regex);
        System.out.println(Arrays.toString(strings));
    }
}
