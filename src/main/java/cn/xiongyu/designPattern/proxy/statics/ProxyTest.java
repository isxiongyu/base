package cn.xiongyu.designPattern.proxy.statics;

import java.lang.String;

/**
 * ClassName: ProxyTest
 * Package: cn.xiongyu.designPattern.proxy.statics
 * Description:
 * Date: 19-10-6 下午8:18
 * Author: xiongyu
 */
public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Superman());
        proxy.shopping();
    }
}
