package cn.xiongyu.designPattern.abstractFactory;

import java.lang.String;

/**
 * ClassName: FactoryTest
 * Package: cn.xiongyu.designPattern.factory
 * Description:
 * Date: 19-10-5 下午8:55
 * Author: xiongyu
 */
public class FactoryTest {
    public static void main(String[] args) {
        Provider factory = new SmsProduce();
        Sender send = factory.produce();
        send.send();
    }
}
