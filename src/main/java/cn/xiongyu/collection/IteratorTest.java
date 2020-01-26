package cn.xiongyu.collection;

import java.lang.String;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ClassName: IteratorTest
 * Package: cn.xiongyu.collection
 * Description:
 * Date: 19-10-4 下午10:08
 * Author: xiongyu
 */
public class IteratorTest {
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        set.add("xiongyu");
        set.add("gaoxiaoye");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
}
