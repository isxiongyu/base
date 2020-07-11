package cn.xiongyu.concurrent;

/**
 * ClassName: ThreadState
 * Description:
 * Create by xiongyu
 * Date: 2020/5/10 3:26 下午
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }
    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }
    static class Waiting implements Runnable {

        @Override
        public void run() {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
