package cn.xiongyu.designPattern.factory;

/**
 * ClassName: SendEmail
 * Package: cn.xiongyu.designPattern.factory
 * Description:
 * Date: 19-10-5 下午8:52
 * Author: xiongyu
 */
public class SendEmail implements Sender {
    @Override
    public void send() {
        System.out.println("send email");
    }
}
