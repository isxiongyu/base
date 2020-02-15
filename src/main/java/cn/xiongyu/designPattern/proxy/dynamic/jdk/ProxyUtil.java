package cn.xiongyu.designPattern.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
//    用于生成proxy代理对象
    public static void main(String[] args) throws IOException {
        byte[] classFles = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{Service.class});
        String path = "/home/xiongyu/Documents/java-study/class/ServiceProxy.class";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(classFles);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                fos.close();
        }
    }
}
