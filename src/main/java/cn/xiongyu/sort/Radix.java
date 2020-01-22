package cn.xiongyu.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ClassName: Radix
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-22 下午12:41
 * Author: xiongyu
 */
public class Radix {
    public void radixSort(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int radix = 1;
        while (max / radix > 0) {
            radixSortCore(array, radix);
            radix *= 10;
        }
    }
    public void radixSortCore(int[] array, int radix) {
        int[] temp = new int[array.length];
        int[] bucket = new int[20];
        for (int i = 0; i < array.length; i++) {
            bucket[(array[i] / radix) % 10 + 10]++;
        }
        for (int i = 1; i < 20; i++) {
            bucket[i] += bucket[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            temp[bucket[(array[i] / radix) % 10  + 10] - 1] = array[i];
            bucket[(array[i] / radix) % 10  + 10]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }
    @Test
    public void test() {
        int nums = 100000;
        int[] array = new int[nums];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * nums);
            if (Math.random() > 0.5) {
                array[i] *= -1;
            }
        }
        long start = System.currentTimeMillis();
        radixSort(array);
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
            if (Math.random() > 0.5) {
                array[i] *= -1;
            }
        }
        int[] copy = array.clone();
        radixSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
