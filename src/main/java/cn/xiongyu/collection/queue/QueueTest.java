package cn.xiongyu.collection.queue;

import org.junit.Test;


/**
 * ClassName: TueueTest
 * Package: cn.xiongyu.collection.queue
 * Description:
 * Date: 2020/2/17 下午4:06
 * Author: xiongyu
 */
public class QueueTest {
    @Test
    public void test() {
        int nums = 100000;

        long start1 = System.currentTimeMillis();
        YePriorityQueue queue1 = new YePriorityQueue();
        for (int i = 0; i < nums; i++) {
            queue1.add((int) (Math.random() * nums));
        }
        while (!queue1.isEmpty()) {
            System.out.print(queue1.poll() + ", ");
        }
        long end1 = System.currentTimeMillis();
        System.out.println();
        System.out.println("叶用时: " + (end1 - start1));


        long start = System.currentTimeMillis();
        MyPriorityQueue queue = new MyPriorityQueue();
        for (int i = 0; i < nums; i++) {
            queue.add((int) (Math.random() * nums));
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("我用时: " + (end - start));
    }
}