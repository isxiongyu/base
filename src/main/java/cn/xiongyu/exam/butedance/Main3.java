package cn.xiongyu.exam.butedance;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/7/11 8:10 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
                if (stack.isEmpty()) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(arr[stack.peek()] + " ");
                }
                stack.push(i);
            }
            System.out.println();
        }
    }
}
//5
//5 4 3 2 1
//5
//1 2 3 4 5
