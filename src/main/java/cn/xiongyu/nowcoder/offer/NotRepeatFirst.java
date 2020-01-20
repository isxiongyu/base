package cn.xiongyu.nowcoder.offer;

/**
 * ClassName: NotRepeatFirst
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-11 下午3:32
 * Author: xiongyu
 */
import java.util.*;
public class NotRepeatFirst {
    static StringBuffer sb = new StringBuffer();
    Map<Character, int[]> map = new TreeMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (sb.length() == 0) {
            return '#';
        }
        char[] cs = new char[sb.length()];
        sb.getChars(0, sb.length(), cs, 0);
        int i = 0;
        for (char c : cs) {
            if (map.containsKey(c)) {
                map.get(c)[1]++;
            } else {
                int[] a = new int[]{i, 1};
                map.put(c, a);
            }
            i++;
        }
        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        list.sort(new MyComparator());
        Map.Entry e1 = list.get(0);
        int[] val = (int[])e1.getValue();
        if (val[1] == 1) {
            return sb.charAt(val[0]);
        }
        return '#';
    }

    public static void main(String[] args) {
        sb.append("google");
        System.out.println(new NotRepeatFirst().FirstAppearingOnce());
    }
}
class MyComparator implements Comparator<Map.Entry<Character, int[]>> {
    public int compare(Map.Entry e1, Map.Entry e2) {
        int[] o1 = (int[]) e1.getValue();
        int[] o2 = (int[]) e2.getValue();
        if (o1[1] != o2[1]) {
            return o1[1] - o2[1];
        } else {
            return o1[0] - o2[0];
        }
    }
}
