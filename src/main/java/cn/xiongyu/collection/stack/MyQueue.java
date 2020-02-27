package cn.xiongyu.collection.stack;

import java.lang.String;
import java.util.Stack;

/**
 * ClassName: MyQueue
 * Package: cn.xiongyu.collection.stack
 * Description:
 * Date: 19-9-24 下午5:15
 * Author: xiongyu
 */
class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.empty() && stack2.empty())
            stack1.push(x);
        else if (stack1.empty()) {
            stack2.push(x);
        } else {
            stack1.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int num;
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            num = stack1.pop();
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            num = stack1.pop();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return num;
    }

    /** Get the front element. */
    public int peek() {
        int num;
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            num = stack1.peek();
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            num = stack2.peek();
            System.out.println(num);
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return num;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.empty() && stack2.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int num = queue.peek();
        System.out.println(num);
    }
}