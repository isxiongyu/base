package cn.xiongyu.leetcode;

/**
 * ClassName: Main1201
 * Description:
 * Create by xiongyu
 * Date: 2020/6/17 11:47 下午
 */
public class Main1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int numA = 1, numB = 1, numC = 1;
        int curr = 1;
        while (n > 0) {
            while (numA * a <= curr) numA++;
            while (numB * b <= curr) numB++;
            while (numC * c <= curr) numC++;
            curr = Math.min(numA * a, Math.min(numB * b, numC * c));
            n--;
        }
        return curr;
    }

    public static void main(String[] args) {
        Main1201 main1201 = new Main1201();
        int n = 1000000000, a = 2, b = 217983653, c = 336916467;
        int ans = main1201.nthUglyNumber(n, a, b, c);
        System.out.println(ans);
    }
}
