package cn.xiongyu.concurrent;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * ClassName: MyLock
 * Description:
 * Create by xiongyu
 * Date: 2020/5/13 4:07 下午
 */
public class MyLock implements Lock {
    private Sync sync = new Sync(1);
    private class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalStateException("count must large than zero");
            }
            setState(count);
        }

        @Override
        protected boolean tryAcquire(int reduceCount) {
            for(;;) {
                int current = getState();
                if (current <= 0) return false;
                int newCount = current - reduceCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

        @Override
        protected boolean tryRelease(int returnCount) {
            for(;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
