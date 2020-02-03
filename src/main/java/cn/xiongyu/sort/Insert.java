package cn.xiongyu.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: Insert
 * Package: cn.xiongyu.sort
 * Description:
 * Date: 20-1-20 下午12:23
 * Author: xiongyu
 */
public class Insert {
    public void insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j;
            int temp = array[i];
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
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
        insertSort(array);
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
        insertSort(array);
        Arrays.sort(copy);
        System.out.println(Arrays.equals(array, copy));
    }
}
