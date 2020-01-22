package cn.xiongyu.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ClassName: Head
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-20 下午3:37
 * Author: xiongyu
 */
public class Head {
    public void headSort(int[] array) {
        createHead(array);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            maxHead(array, i, 0);
        }

    }
    public void createHead(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHead(array, array.length, i);
        }
    }
    public void maxHead(int[] array, int end, int index) {
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
            maxHead(array, end, max);
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
        headSort(array);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println(end - start);
    }
    @Test
    public void test02() {
        int nums = 100000;
        int[] array = new int[nums];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * nums);
        }
        int[] copy = array.clone();
        headSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
