package cn.xiongyu.map;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: EntryTest
 * Package: cn.xiongyu.map
 * Description:
 * Date: 19-9-18 下午4:13
 * Author: xiongyu
 */
public class EntryTest {
    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("xiong", "yu");
        map.put("gao", "xiaoye");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
