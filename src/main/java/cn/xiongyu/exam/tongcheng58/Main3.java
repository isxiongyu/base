package cn.xiongyu.exam.tongcheng58;

/**
 * ClassName: Main3
 * Description:
 * Create by xiongyu
 * Date: 2020/8/31 8:53 下午
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(translateNum(12158));
    }
    public static int translateNum (int num) {
        String s = num + "";
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int subNum = Integer.parseInt(s.substring(i - 2, i));
            if (subNum >= 10 && subNum <= 25) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
