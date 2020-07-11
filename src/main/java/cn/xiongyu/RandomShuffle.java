package cn.xiongyu;

import java.util.*;

/**
 * ClassName: Main
 * Description:
 * Create by xiongyu
 * Date: 2020/4/28 11:06 上午
 */
public class RandomShuffle {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shuffle(int[] arr) {
        Random r = new Random();
        for (int i = arr.length; i > 1; i--) {
            System.out.println(r.nextInt(i));
            swap(arr, i - 1, r.nextInt(i));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
}
