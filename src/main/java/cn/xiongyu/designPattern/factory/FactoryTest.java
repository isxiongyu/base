package cn.xiongyu.designPattern.factory;

/**
 * ClassName: FactoryTest
 * Package: cn.xiongyu.designPattern.factory
 * Description:
 * Date: 19-10-5 下午8:55
 * Author: xiongyu
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender send = SendFactory.produceEmail();
        send.send();
    }
}
