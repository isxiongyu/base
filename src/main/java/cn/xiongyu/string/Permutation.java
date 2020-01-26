package cn.xiongyu.string;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Permutation
 * Package: cn.xiongyu.string
 * Description:
 * Date: 19-9-25 下午3:27
 * Author: xiongyu
 */
public class Permutation {
    public boolean checkInclusion(String s1, String s2) {
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        List<Character> removeList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            list1.add(s1.charAt(i));
            list2.add(s1.charAt(i));
        }
        int flag = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (list1.size() == 0)
                return true;
            if (list1.contains(s2.charAt(i))) {
                removeList.add(s2.charAt(i));
                list1.removeAll(removeList);
                flag = 1;
            } else {
                if (flag == 1) {
                    list1 = (ArrayList<Character>) list2.clone();
                    removeList = new ArrayList<>();
                    System.out.println(list1);
                    flag = 0;
                    i--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Permutation pe = new Permutation();
        String s1= "ab";
        String s2 = "eidboaoo";
        boolean re = pe.checkInclusion(s1, s2);
        System.out.println(re);
    }
}
