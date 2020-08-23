package cn.xiongyu.sort;


import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: Head
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-20 下午3:37
 * Author: xiongyu
 */
public class Heap {
    public void heapSort(int[] array) {
        createHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            maxHeap(array, i, 0);
        }
    }
    public void createHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }
    public void maxHeap(int[] array, int end, int index) {
        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;
        int max = index;
        if (leftNode < end && array[leftNode] > array[max]) {
            max = leftNode;
        }
        if (rightNode < end && array[rightNode] > array[max]) {
            max = rightNode;
        }
        if (max != index) {
            swap(array, max, index);
//            交换之后继续构造大顶堆,位置为交换的位置
            maxHeap(array, end, max);
        }
    }
    public void swap(int[] array, int i, int j) {
        if (array == null || i >= array.length || i < 0 || j < 0 || j >= array.length) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    @Test
    public void test() {
        int nums = 100000;
        int[] array = new int[nums];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * nums);
        }
        long start = System.currentTimeMillis();
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println(end - start);
    }
    @Test
    public void test02() {
        ExecutorService executor1 = Executors.newCachedThreadPool();
        ExecutorService executor2 = Executors.newFixedThreadPool(6);
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        ExecutorService executor4 = Executors.newScheduledThreadPool(8);
        int nums = 100000;
        int[] array = new int[nums];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * nums);
        }
        int[] copy = array.clone();
        heapSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
