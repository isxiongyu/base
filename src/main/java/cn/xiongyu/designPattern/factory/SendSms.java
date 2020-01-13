package cn.xiongyu.designPattern.factory;

/**
 * ClassName: SendEms
 * Package: cn.xiongyu.designPattern.factory
 * Description:
 * Date: 19-10-5 下午8:50
 * Author: xiongyu
 */
public class SendSms implements Sender {

    @Override
    public void send() {
        System.out.println("send sms");
    }
}
