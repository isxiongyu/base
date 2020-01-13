package cn.xiongyu.designPattern.abstractFactory;

/**
 * ClassName: SmsProduce
 * Package: cn.xiongyu.designPattern.abstractFactory
 * Description:
 * Date: 19-10-5 下午9:04
 * Author: xiongyu
 */
public class SmsProduce implements Provider {
    @Override
    public Sender produce() {
        return new SendSms();
    }
}
