package cn.xiongyu.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Bubble
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-20 下午2:19
 * Author: xiongyu
 */
public class Bubble {
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
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
        bubbleSort(array);
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
        bubbleSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
