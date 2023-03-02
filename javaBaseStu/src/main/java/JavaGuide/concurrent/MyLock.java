package JavaGuide.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * @autor wwl
 * @date 2023/1/31-0:46
 * 自定义锁
 */
class MyLock implements Lock {
    private MyLock.MySync sync = new MyLock.MySync();

    MyLock() {
    }

    public void lock() {
        this.sync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        this.sync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return this.sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return this.sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    public void unlock() {
        this.sync.release(1);
    }

    public Condition newCondition() {
        return this.sync.newCondition();
    }

    class MySync extends AbstractQueuedSynchronizer {
        MySync() {
        }

        protected boolean tryAcquire(int arg) {
            if (this.compareAndSetState(0, 1)) {
                this.setExclusiveOwnerThread(Thread.currentThread());
                return true;
            } else {
                return false;
            }
        }

        protected boolean tryRelease(int arg) {
            this.setExclusiveOwnerThread((Thread)null);
            this.setState(0);
            return true;
        }

        protected boolean isHeldExclusively() {
            return this.getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }
}