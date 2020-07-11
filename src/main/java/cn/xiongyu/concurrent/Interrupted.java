package cn.xiongyu.concurrent;

/**
 * ClassName: Interrupted
 * Description:
 * Create by xiongyu
 * Date: 2020/5/11 11:07 下午
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
// sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
//        sleepThread.setDaemon(true);
// busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
//        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
// 休眠5秒，让sleepThread和busyThread充分运行
        Thread.sleep(5000);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted()); // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("busy");
                SleepUtils.second(5);
            }
        }
    }
}