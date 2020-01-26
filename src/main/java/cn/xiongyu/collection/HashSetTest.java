package cn.xiongyu.collection;

import java.lang.String;
import java.util.HashSet;

/**
 * ClassName: HashSetTest
 * Package: cn.xiongyu.collection
 * Description:
 * Date: 19-10-4 下午9:15
 * Author: xiongyu
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set2.add(1);
        System.out.println(set1.equals(set2));
        System.out.println(set1.toString());
    }
}
