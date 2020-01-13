package cn.xiongyu.designPattern.proxy.dynamic;

import cn.xiongyu.designPattern.proxy.dynamic.cglib.MyMethodInterceptor;
import cn.xiongyu.designPattern.proxy.dynamic.cglib.Service;
import net.sf.cglib.proxy.Enhancer;

/**
 * ClassName: ProxyTest
 * Package: cn.xiongyu.designPattern.proxy.dynamic
 * Description:
 * Date: 19-10-6 下午8:32
 * Author: xiongyu
 */
public class ProxyTest {
    public static void main(String[] args) {
//        jdk
//        ProxyUtil proxyUtil = new ProxyUtil();
//        Service service = new ServiceImpl();
//        Service proxy = proxyUtil.getProxyByJDK(service);
//        proxy.doSomething();
//        cglib
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Service service = (Service) enhancer.create();
        service.doSomething(1, 2);
//        service.doSomething2();
    }
}
