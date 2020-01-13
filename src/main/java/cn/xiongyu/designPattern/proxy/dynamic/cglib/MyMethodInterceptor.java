package cn.xiongyu.designPattern.proxy.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.net.NetHooks;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassName: MyMethodInterceptor
 * Package: cn.xiongyu.designPattern.proxy.dynamic.cglib
 * Description:
 * Date: 19-10-6 下午8:56
 * Author: xiongyu
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("服务前");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("服务后");
        return obj;
    }
}
