package cn.xiongyu.exam.qq;

import java.util.*;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/4/26 8:43 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Set<Integer> merge = new HashSet<>();
                if (map.size() == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(x);
                    set.add(y);
                    map.put(i, set);
                } else {
                    boolean flag = false;
                    for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                        Set<Integer> set = entry.getValue();
                        if (set.contains(x)) {
                            set.add(y);
                            merge.add(entry.getKey());
                            flag = true;
                        }
                        if (set.contains(y)) {
                            set.add(x);
                            merge.add(entry.getKey());
                            flag = true;
                        }
                    }
                    if (!flag) {
                        Set<Integer> set = new HashSet<>();
                        set.add(x);
                        set.add(y);
                        map.put(i, set);
                    }
                    if (merge.size() > 1) {
                        List<Integer> m = new ArrayList<>(merge);
                        Set<Integer> set = map.get(m.get(0));
                        for (int j = 1; j < m.size(); j++) {
                            set.addAll(map.get(m.get(j)));
                            map.remove(m.get(j));
                        }
                    }
                }
            }
            int ans = 0;
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                ans = Math.max(ans, entry.getValue().size());
            }
            System.out.println(ans);
        }
    }
}
//2
//4
//1 2
//3 4
//5 6
//1 6
//4
//1 2
//3 4
//5 6
//7 8

