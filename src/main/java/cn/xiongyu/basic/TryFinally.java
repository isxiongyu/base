package cn.xiongyu.basic;

/**
 * ClassName: TryFinally
 * Package: cn.xiongyu.basic
 * Description:
 * Date: 19-10-7 下午9:05
 * Author: xiongyu
 */
public class TryFinally {
    Integer a= new Integer(1);
    int m1(){
        try {
            return a;
        } finally {
            a = 2;
        }
    }

    public static void main(String[] args) {
        TryFinally tryFinally = new TryFinally();
        int a = tryFinally.m1();
        System.out.println(a);
    }
}
