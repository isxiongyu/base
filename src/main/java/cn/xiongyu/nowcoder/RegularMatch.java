package cn.xiongyu.nowcoder;

import org.junit.jupiter.api.Test;

/**
 * ClassName: RegularMatch
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-19 下午12:05
 * Author: xiongyu
 */
public class RegularMatch {
    public boolean match(char[] str, char[] pattern)
    {
        if ((str == null && pattern != null) || (str != null && pattern == null)) {
            return false;
        }
        return coreMatch(str, pattern, 0, 0);
    }
    private boolean coreMatch(char[] str, char[] pattern, int i, int j) {
        if (i >= str.length && j >= pattern.length) {
            return true;
        }
        if (i < str.length && j >= pattern.length) {
            return false;
        }
        if (i >= str.length) {
            if (j + 1 >= pattern.length) {
                return false;
            }
            if (pattern[j + 1] == '*') {
                return coreMatch(str, pattern, i, j + 2);
            } else {
                return false;
            }
        }
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if (pattern[j] == str[i] || pattern[j] == '.') {
                return coreMatch(str, pattern, i + 1, j + 2) || coreMatch(str, pattern, i, j + 2) || coreMatch(str, pattern, i + 1, j);
            } else {
                return coreMatch(str, pattern, i, j + 2);
            }
        }
        if (pattern[j] == str[i] || pattern[j] == '.') {
            return coreMatch(str, pattern, i + 1, j + 1);
        }
        return false;
    }
    @Test
    public void test01() {
        char[] str = {'a'};
        char[] pattern = {'.'};
        System.out.println(new RegularMatch().match(str, pattern));
    }
}
