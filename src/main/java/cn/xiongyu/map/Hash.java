package cn.xiongyu.map;

import java.util.Arrays;

/**
 * ClassName: Hash
 * Package: cn.xiongyu.map
 * Description:
 * Date: 19-9-18 下午5:20
 * Author: xiongyu
 */
public class Hash {
    public static void main(String[] args) {
        String [] array1 = {"1","2","3"};
        String [] array2 = {"3","2","1"};
        System.out.println(Arrays.hashCode(array1));
        System.out.println(Arrays.hashCode(array2));

    }
}
