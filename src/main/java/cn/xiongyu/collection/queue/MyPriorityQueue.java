package cn.xiongyu.collection.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: MyPriorityQueue
 * Package: cn.xiongyu.collection.queue
 * Description:
 * Date: 2020/2/17 下午3:18
 * Author: xiongyu
 */
public class MyPriorityQueue {
    List<Integer> queue = new ArrayList<>();
    public boolean add(int val) {
        queue.add(val);
        if (this.size() == 1) return true;
        int index = this.size() / 2 - 1;
        while (index >= 0) {
            minHeap(index);
            if (index == 0) break;
            index = index / 2 - 1;
        }
        return true;
    }
    public Integer poll() {
        if (this.size() == 0) return null;
        swap(0, this.size() - 1);
        int temp = queue.remove(this.size() - 1);
        if (this.size() == 0) return temp;
        minHeap(0);
        return temp;
    }
    public int size() {
        return queue.size();
    }
    public boolean isEmpty() {
        return queue.size() == 0;
    }
    private void minHeap(int index) {
        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;
        int min = index;
        if (leftNode < this.size() && queue.get(leftNode) < queue.get(min)) {
            min = leftNode;
        }
        if (rightNode < this.size() && queue.get(rightNode) < queue.get(min)) {
            min = rightNode;
        }
        if (min != index) {
            swap(min, index);
            minHeap(min);
        }
    }
    private void swap(int i, int j) {
        int temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);
    }
}
