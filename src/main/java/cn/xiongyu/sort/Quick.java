package cn.xiongyu.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Quick
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-20 下午2:29
 * Author: xiongyu
 */
public class Quick {
    public void quickSort(int[] array) {
        quickSortCore(array, 0, array.length);
    }
    public void quickSortCore(int[] array, int start, int end) {
        if (start >= end - 1) {
            return;
        }
        int base = array[start];
        int i = start + 1;
        int j = end - 1;
        while (i <= j) {
            if (array[j] < base && array[i] > base) {
                swap(array, i, j);
            }
            if (array[j] >= base) {
                j--;
            }
            if (array[i] <= base) {
                i++;
            }
        }
        swap(array, j, start);
        quickSortCore(array, start, j);
        quickSortCore(array, j + 1, end);
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
//        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
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
        quickSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
