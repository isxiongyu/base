package cn.xiongyu.practice;

/**
 * ClassName: SuperClass
 * Package: cn.xiongyu
 * Description:
 * Date: 19-8-27 上午10:00
 * Author: xiongyu
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public final void m1() {
        System.out.println("SuperClass final");
    }
}
