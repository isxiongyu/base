package cn.xiongyu.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: SleepUtil
 * Description:
 * Create by xiongyu
 * Date: 2020/5/10 3:28 下午
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
