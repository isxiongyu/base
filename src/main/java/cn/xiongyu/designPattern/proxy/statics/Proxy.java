package cn.xiongyu.designPattern.proxy.statics;

/**
 * ClassName: Proxy
 * Package: cn.xiongyu.designPattern.proxy.statics
 * Description:
 * Date: 19-10-6 下午8:16
 * Author: xiongyu
 */
public class Proxy implements Subject {

    private Superman superman;

    Proxy(Superman superman) {
        this.superman = superman;
    }

    @Override
    public void shopping() {
        System.out.println("做大量的商品专业评估");
        System.out.println("==========代理之前==========");
        superman.shopping();//被代理人真正的业务
        System.out.println("==========代理之后==========");
        //代购之后要做的事情
        System.out.println("代购之后的客户满意度调查");
    }
}
