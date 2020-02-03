package cn.xiongyu.nowcoder.offer;



import org.junit.Test;

import java.lang.String;
import java.util.*;

/**
 * ClassName: StringArrange
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-19 下午12:46
 * Author: xiongyu
 */
public class StringArrange {
    public ArrayList<String> Permutation(String str) {
        LinkedHashSet<String> res = new LinkedHashSet<>();
        if (str == null || str.length() == 0) {
            return new ArrayList<>(res);
        }
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        dfs(cs, res, new ArrayList<>(), new StringBuffer());
        return new ArrayList<>(res);
    }
    public void dfs(char[] cs, Set<String> res, List<Integer> used, StringBuffer curr) {
        if (curr.length() == cs.length) {
            res.add(curr.toString());
        }
        for (int i = 0; i < cs.length; i++) {
            if (used.contains(i)) {
                continue;
            }
            List<Integer> copy = new ArrayList<>(used);
            StringBuffer sb = new StringBuffer(curr);
            sb.append(cs[i]);
            copy.add(i);
            dfs(cs, res, copy, sb);
        }
    }
    @Test
    public void test01() {
        System.out.println(Permutation("aa"));
    }
}
