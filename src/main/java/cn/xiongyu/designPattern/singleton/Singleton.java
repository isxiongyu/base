package cn.xiongyu.designPattern.singleton;

/**
 * ClassName: SingletonTest
 * Package: cn.xiongyu.designPattern.singleton
 * Description:
 * Date: 19-10-5 下午9:17
 * Author: xiongyu
 */
public class Singleton {
    public static volatile Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = getInstance();
        Singleton instance2 = getInstance();
        System.out.println(instance1 == instance2);
    }
}
