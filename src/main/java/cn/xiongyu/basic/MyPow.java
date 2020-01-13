package cn.xiongyu.basic;

/**
 * ClassName: BitOpe
 * Package: cn.xiongyu.basic
 * Description:
 * Date: 19-10-9 下午3:42
 * Author: xiongyu
 */
public class MyPow {

    public double pow(double x, int n) {
        int flag = 1;
        if (n < 0)
            flag = -1;
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * pow(x, 1 * flag);
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.pow(2, 2147483647));
    }

}
