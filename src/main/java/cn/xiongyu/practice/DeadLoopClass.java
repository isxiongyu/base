package cn.xiongyu.practice;

/**
 * ClassName: DeadLoopClass
 * Package: cn.xiongyu.practice
 * Description:
 * Date: 19-11-5 下午2:48
 * Author: xiongyu
 */
public class DeadLoopClass {
    static {
        System.out.println("执行static方法");
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                DeadLoopClass dlc = new DeadLoopClass();
            }
        };
        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}
