package cn.xiongyu.nowcoder.offer;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: NumStr
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-13 下午4:48
 * Author: xiongyu
 */
public class NumStr {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        char last = '0';
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if ((str[i] < '0' || str[i] > '9') && (str[i] != '-' && str[i] != '+' && str[i] != '.' && str[i] != 'e' && str[i] != 'E')) {
                return false;
            }
            if (str[i] == '+' || str[i] == '-') {
                if (i != 0 && (last != 'e' && last != 'E')) {
                    return false;
                }
                list.add(str[i]);
                last = str[i];
            }else if (str[i] == 'e' || str[i] == 'E') {
                if (i != 0 && (list.contains('e') || list.contains('E'))) {
                    return false;
                }
                list.add(str[i]);
                last = str[i];
            } else if (str[i] == '.') {
                if (list.contains('.') || list.contains('e') || list.contains('E')) {
                    return false;
                }
                list.add(str[i]);
                last = str[i];
            } else {
                last = str[i];
            }
        }
        return last >= '0' && last <= '9';
    }

    public static void main(String[] args) {
        String s = "100e+1.2";
        System.out.println(new NumStr().isNumeric(s.toCharArray()));
    }
}
