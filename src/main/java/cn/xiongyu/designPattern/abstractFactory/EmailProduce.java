package cn.xiongyu.designPattern.abstractFactory;

/**
 * ClassName: EmailProduce
 * Package: cn.xiongyu.designPattern.abstractFactory
 * Description:
 * Date: 19-10-5 下午9:02
 * Author: xiongyu
 */
public class EmailProduce implements Provider {
    @Override
    public Sender produce() {
        return new SendEmail();
    }
}
