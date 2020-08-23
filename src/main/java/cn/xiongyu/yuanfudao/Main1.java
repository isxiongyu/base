package cn.xiongyu.yuanfudao;

import sun.nio.cs.ext.MacArabic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * ClassName: MAin1
 * Description:
 * Create by xiongyu
 * Date: 2020/8/1 7:32 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] pairs = new Pair[2 * n];
        for (int i = 0; i < n; i++) {
            pairs[2 * i] = new Pair(sc.nextInt(), 0);
            pairs[2 * i + 1] = new Pair(sc.nextInt(), 1);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.x != o2.x) return o1.x - o2.x;
                return o2.y - o1.y;
            }
        });
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (Pair pair : pairs) {
            int y = pair.y;
            if (y == 0) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count--;
            }
        }
        System.out.println(ans);
    }
}
class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
