package cn.xiongyu.designPattern.factory;

/**
 * ClassName: SendFactory
 * Package: cn.xiongyu.designPattern.factory
 * Description:
 * Date: 19-10-5 下午8:48
 * Author: xiongyu
 */
public class SendFactory {
    public static Sender produceSms() {
        return new SendSms();
    }
    public static Sender produceEmail() {
        return new SendEmail();
    }
}
