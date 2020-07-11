package cn.xiongyu;

/**
 * ClassName: Zero
 * Description:
 * Create by xiongyu
 * Date: 2020/5/11 2:52 下午
 */

import java.util.*;

public class Zero {

    static int[][] arr = new int[35][35];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Init();
        String[] strs = sc.nextLine().split(",");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        System.out.println(roundNumber(b) - roundNumber(a - 1));
    }

    public static void Init() {
        for (int i = 0; i < 33; i++) {
            arr[i][0] = arr[i][i] = 1;
            for (int j = 1; j < i; j++)
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
        }

    }

    public static int roundNumber(int value) {
        char[] tmp = toBinary(value);
        int sum = 0;
        for (int len = 1; len < tmp.length; len++) {
            for (int j = (len + 1) / 2; j < len; j++)
                sum += arr[len - 1][j];
        }
        int zeros = 0;
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] == '1') {
                int k = (tmp.length + 1) / 2;
                int m = Math.max(0, k - (zeros + 1));
                int n = tmp.length - i - 1;
                for (int j = n; j >= m; j--)
                    sum += arr[n][j];
            } else {
                zeros++;
            }
        }
        if (2 * zeros >= tmp.length)
            sum++;
        return sum;
    }

    private static char[] toBinary(int value) {
        return Integer.toBinaryString(value).toCharArray();
    }
}
