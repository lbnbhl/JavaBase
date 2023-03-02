package JavaGuide.concurrent;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @autor wwl
 * @date 2023/1/31-0:49
 */
@Slf4j
public class MyLockTest {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("locking...");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.debug("unlocking...");
                lock.unlock();
            }
        },"t1").start();
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("locking...");
            } finally {
                log.debug("unlocking...");
                lock.unlock();
            }
        },"t2").start();
    }
}
