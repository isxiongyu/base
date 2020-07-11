package cn.xiongyu.jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/4/18 7:00 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextInt(), sc.nextInt());
        }
        Map<Double, Integer> map = new HashMap<>();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double k = xielv(nodes[i], nodes[j]);
                int val = (map.getOrDefault(k, 0) + 1);
                ans = Math.max(ans, val);
                map.put(k, val);
            }
        }
        System.out.println(ans);
    }
    private static double xielv(Node node1, Node node2) {
        double diffY = node2.y - node1.y;
        double diffX = node2.x - node1.x;
        if (diffX == 0) {
            return Double.MAX_VALUE;
        } else {
            return diffY / diffX;
        }
    }
}
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
//8
//0 0
//0 5
//2 2
//2 7
//3 -2
//5 0
//4 -2
//8 2