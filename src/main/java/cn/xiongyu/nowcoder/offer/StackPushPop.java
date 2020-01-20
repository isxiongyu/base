package cn.xiongyu.nowcoder.offer;

import java.util.Stack;

/**
 * ClassName: StackPushPop
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-12 下午3:59
 * Author: xiongyu
 */
public class StackPushPop {
    Stack<Integer> stack = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length <= 1) {
            return true;
        }
        int i = 0;
        int j = 0;
        stack.push(pushA[i]);
        while (i < pushA.length && j < popA.length) {
            if (stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                i++;
                if (i >= pushA.length) {
                    break;
                }
                stack.push(pushA[i]);
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{3,5,4,1,2};
        System.out.println(new StackPushPop().IsPopOrder(pushA, popA));
    }
}
