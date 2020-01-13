package cn.xiongyu.designPattern.proxy.dynamic.cglib;

/**
 * ClassName: Service
 * Package: cn.xiongyu.designPattern.proxy.dynamic.cglib
 * Description:
 * Date: 19-10-6 下午9:15
 * Author: xiongyu
 */
public class Service {
    public void doSomething(int a, int b) {
        System.out.println("执行doSomething方法");
    }
    public final void doSomething2() {
        System.out.println("执行doSomething2方法");
    }
}
