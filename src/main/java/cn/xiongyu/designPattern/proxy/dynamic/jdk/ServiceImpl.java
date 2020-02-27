package cn.xiongyu.designPattern.proxy.dynamic.jdk;

/**
 * ClassName: ServiceImpl
 * Package: cn.xiongyu.designPattern.proxy.dynamic
 * Description:
 * Date: 19-10-6 下午8:26
 * Author: xiongyu
 */
public class ServiceImpl implements Service {
    @Override
    public void doSomething() {
        System.out.println("执行doSomething方法");
    }

    @Override
    public void doSomething2() {
        System.out.println("执行doSomething2方法");
    }
}
