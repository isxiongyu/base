package cn.xiongyu.designPattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: Proxy
 * Package: cn.xiongyu.designPattern.proxy.dynamic
 * Description:
 * Date: 19-10-6 下午8:26
 * Author: xiongyu
 */
public class ProxyUtil {
    public Service getProxyByJDK(Service service) {
        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("服务前");
                Object obj = method.invoke(service, args);
                System.out.println("服务后");
                return obj;
            }
        });
        return serviceProxy;
    }
}
