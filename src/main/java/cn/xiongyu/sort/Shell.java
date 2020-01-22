package cn.xiongyu.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: Shell
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-20 下午12:47
 * Author: xiongyu
 */
public class Shell {
    public void shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int step = (array.length + 1) / 2;
        while (step >= 1) {
            for (int i = 0; i < step; i++) {
                for (int j = i + step; j < array.length; j += step) {
                    int m;
                    int temp = array[j];
                    for (m = j; m > 0 && temp < array[m - 1]; m--) {
                        array[m] = array[m -1];
                    }
                    array[m] = temp;
                }
            }
            step /= 2;
        }
    }
    @Test
    public void test() {
        int nums = 100000;
        int[] array = new int[nums];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * nums);
        }
        long start = System.currentTimeMillis();
        shellSort(array);
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
        shellSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
