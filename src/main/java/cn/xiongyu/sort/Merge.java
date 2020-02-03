package cn.xiongyu.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Merge
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-22 上午11:50
 * Author: xiongyu
 */
public class Merge {
    public void merge(int[] array, int start, int end, int mid) {
        int[] copy = new int[array.length];
        int i = start;
        int j = mid;
        int index = start;
        while (i < mid && j < end) {
            if (array[i] < array[j]) {
                copy[index++] = array[i++];
            } else {
                copy[index++] = array[j++];
            }
        }
        while (i < mid) {
            copy[index++] = array[i++];
        }
        while (j < end) {
            copy[index++] = array[j++];
        }
        for (int m = start; m < end; m++) {
            array[m] = copy[m];
        }
    }
    public void mergeSort(int[] array, int start, int end) {
        if (end <= start + 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, end, mid);
    }
    @Test
    public void test() {
        int nums = 100000;
        int[] array = new int[nums];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * nums);
        }
        long start = System.currentTimeMillis();
        mergeSort(array, 0, array.length);
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
        mergeSort(array, 0, array.length);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
