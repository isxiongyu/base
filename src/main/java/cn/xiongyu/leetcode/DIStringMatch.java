package cn.xiongyu.leetcode;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: DIStringMatch
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-10 下午2:15
 * Author: xiongyu
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        List<Integer> result = new ArrayList<>();
        int[] results = new int[S.length()];
        return results;
    }
    void dfs(String S, ArrayList<Integer> result, Integer[] results) {
        if (result.size() == S.length()) {
            result.toArray(results);
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            ArrayList<Integer> res = (ArrayList) result.clone();
            if (res.size() == 0) {
                res.add(i);
            } else if (res.contains(i)) {
                continue;
            } else {
                char c = S.charAt(i);
                if (c == 'I' && i < res.get(res.size() - 1)) {
                    continue;
                } else if(c == 'D' && i > res.get(res.size() - 1)) {
                    continue;
                } else {
                    res.add(i);
                }
            }
            dfs(S, res, results);
        }
    }

    public static void main(String[] args) {
        DIStringMatch dism = new DIStringMatch();
        int[] a = dism.diStringMatch("IDID");
        System.out.println(Arrays.toString(a));
    }
}
