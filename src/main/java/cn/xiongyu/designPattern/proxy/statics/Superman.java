package cn.xiongyu.designPattern.proxy.statics;

/**
 * ClassName: SuperMan
 * Package: cn.xiongyu.designPattern.proxy.statics
 * Description:
 * Date: 19-10-6 下午8:15
 * Author: xiongyu
 */
public class Superman implements Subject {

    @Override
    public void shopping() {
        System.out.println("超人在shopping");
    }
}
