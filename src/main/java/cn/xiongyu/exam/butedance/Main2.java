package cn.xiongyu.exam.butedance;

import java.util.Scanner;

/**
 * ClassName: Main2
 * Description:
 * Create by xiongyu
 * Date: 2020/7/11 7:23 下午
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String[] s = sc.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            String[] strs = sc.nextLine().split(" ");
            int[] a = new int[strs.length];
            for (int j = 0; j < a.length; j++) {
                a[j] = Integer.parseInt(strs[j]);
            }
            System.out.println(a[n - 1] ^ findKth(a, 0, n, n - k));
        }
    }
    private static int findKth(int[] arr, int st, int en, int k) {
        if (en - st <= k) return findMin(arr, st, en, k);
        return help(arr, st, en, k);
    }
    private static int help(int[] arr, int st, int en, int k) {
        if (en - st <= 1) return arr[st];
        int i = st + 1, j = en - 1;
        int base = arr[st];
        while (i <= j) {
            if (arr[i] > base && arr[j] < base) swap(arr, i, j);
            if (i <= j && arr[i] <= base) i++;
            if (i <= j && arr[j] >= base) j--;
        }
        swap(arr, st, j);
        if (j == k - 1) return arr[j];
        if (j > k - 1) return help(arr, st, j, k);
        return help(arr, j + 1, en, k);
    }
    private static int findMin(int[] arr, int st, int en, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = st; i < en; i++) {
            ans = Math.min(ans, arr[i]);
        }
        return ans;
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
//2
//5 3
//2 3 2 5 4
//5 2
//2 3 2 5 4


