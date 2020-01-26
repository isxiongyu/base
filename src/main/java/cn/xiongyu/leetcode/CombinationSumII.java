package cn.xiongyu.leetcode;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: CombinationSumII
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-9 下午10:00
 * Author: xiongyu
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }
    void dfs(int[] candidates, int target, List<List<Integer>> results, ArrayList<Integer> result, int index) {
        if (target < 0)
            return;
        if (target == 0) {
            results.add(result);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            ArrayList<Integer> res = (ArrayList) result.clone();
            res.add(candidates[i]);
            dfs(candidates, target - candidates[i], results, res, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII csii = new CombinationSumII();
        csii.combinationSum2(candidates, target);
    }
}
