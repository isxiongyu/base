package cn.xiongyu.collection.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: YePriorityQueue
 * Package: cn.xiongyu.collection.queue
 * Description:
 * Date: 2020/2/17 下午5:10
 * Author: xiongyu
 */
public class YePriorityQueue {
    List<Integer> queue = new ArrayList<>();
    public boolean add(int t) {
        queue.add(t);
        heapUp(queue.size() - 1);
        return true;
    }
    public Integer poll() {
        if (queue.size() == 0) return null;
        int head = queue.get(0);
        queue.set(0, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);
        heapDowm(0);
        return head;
    }
    public int size() {
        return queue.size();
    }
    public boolean isEmpty() {
        return queue.size() == 0;
    }
    private void heapUp(int index) {
        int parent = (index - 1) / 2;
        if (parent < 0) return;
        Integer parent_value = queue.get(parent);
        if (parent_value > queue.get(index)) {
            queue.set(parent, queue.get(index));
            queue.set(index, parent_value);
            heapUp(parent);
        }
    }
    private void heapDowm(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int min = parent;
        if (right < queue.size() && queue.get(right) < queue.get(min)) min = right;
        if (left < queue.size() && queue.get(left) < queue.get(min)) min = left;
        if (min != parent) {
            int parent_value = queue.get(parent);
            queue.set(parent, queue.get(min));
            queue.set(min, parent_value);
            heapDowm(min);
        }
    }
}
