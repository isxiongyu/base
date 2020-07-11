package cn.xiongyu.exam.butedance;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/7/11 7:18 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strs = sc.nextLine().split(" ");
            String s = strs[0];
            String t = strs[1];
            int[] cnt = new int[128];
            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (cnt[c] == 0) {
                    count++;
                }
                cnt[c]++;
            }
            int[] window = new int[128];
            int l = 0, r = 0;
            //ans表示{长度，l，r}
            int[] ans = {Integer.MAX_VALUE, 0, 0};
            int form = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                window[c]++;
                if (window[c] == cnt[c]) form++;
                while (l <= r && form == count) {
                    if (r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }
                    c = s.charAt(l);
                    window[c]--;
                    l++;
                    if (window[c] < cnt[c]) {
                        form--;
                        break;
                    }
                }
                r++;
            }
            String res = "";

            if (ans[0] != Integer.MAX_VALUE) {
                res = s.substring(ans[1], ans[2] + 1);
            }
            System.out.println(res);
        }
    }
}
//ADKSBACWDMVJDNAHFNFJ CDV
//ABCD ABCD

