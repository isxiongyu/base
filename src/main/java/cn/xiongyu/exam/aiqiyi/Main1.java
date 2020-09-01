package cn.xiongyu.exam.aiqiyi;

import cn.xiongyu.basic.BaseData;

import java.util.Scanner;

/**
 * ClassName: Main1
 * Description:
 * Create by xiongyu
 * Date: 2020/8/23 3:26 下午
 */
public class Main1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countZero(n));
        Class<BaseData> baseDataClass = BaseData.class;
        BaseData baseData = baseDataClass.newInstance();

    }
    private static int countZero(int n) {
        int div = 5;
        int ans = 0;
        while (div < n) {
            ans = ans + n / div;
            div *= 5;
        }
        return ans;
    }
}
