package cn.xiongyu.basic;

/**
 * ClassName: External
 * Package: cn.xiongyu.basic
 * Description:
 * Date: 19-10-7 下午8:10
 * Author: xiongyu
 */
public class External {
    static class Inner {
        Inner() {
            System.out.println("skfjksadlfk");
        }
    }

    public static void main(String[] args) {
        new External.Inner();
    }
}
