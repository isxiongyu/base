package cn.xiongyu.exam.meituan;

import java.util.*;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/8/15 4:16 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //订单数
        int m = sc.nextInt();
        Map<Integer, List<Integer>> relationsMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            putMap(relationsMap, num1, num2);
            putMap(relationsMap, num2, num1);
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        for (int num : relationsMap.keySet()) {
            if (visited[num - 1]) continue;
            List<Integer> ans = new ArrayList<>();
            dfs(ans, relationsMap, visited, num);
            Collections.sort(ans);
            if (ans.size() != 0) {
                res.add(ans);
            }
        }
        res.sort(Comparator.comparingInt(o -> o.get(0)));
        System.out.println(res.size());
        for (List<Integer> r : res) {
            for (int num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(List<Integer> ans,
                            Map<Integer, List<Integer>> relationsMap,
                            boolean[] visited, int num) {
        ans.add(num);
        visited[num - 1] = true;
        if (!relationsMap.containsKey(num)) return;
        for (int n : relationsMap.get(num)) {
            if (!visited[n - 1]) {
                visited[n - 1] = true;
                dfs(ans, relationsMap, visited, n);
            }
        }
    }
    private static void putMap(Map<Integer, List<Integer>> relationsMap, int num1, int num2) {
        if (relationsMap.containsKey(num1)) {
            List<Integer> list = relationsMap.get(num1);
            list.add(num2);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(num2);
            relationsMap.put(num1, list);
        }
    }
}
//5 5
//1 2
//2 3
//1 3
//4 5
//5 5
