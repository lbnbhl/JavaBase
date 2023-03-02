package JavaGuide.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @autor wwl
 * @date 2023/2/26-14:25
 * wait和notify版顺序控制,比如，必须先 t2 后 t1 打印
 * park 和 unpark版 ，比如先 t4 后 t3
 */
@Slf4j
public class SequenceControl {
    public static Object obj = new Object();
    public static boolean t2runed = false;

    public static void main(String[] args) {

        Thread t1=new Thread(()->{
            synchronized (obj){
//                这里用while是防止其他线程notifyall错误的唤醒，因此要再次判断是否t2已经被执行过了
                while (!t2runed){
                    try {
                        log.info("t2还未执行，先等待");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("执行t1");
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (obj){
                log.info("执行t2。。。");
                t2runed = true;
                obj.notifyAll();
            }
        },"t2");

        Thread t3 = new Thread(()->{
            LockSupport.park();
            log.info("执行t3");
        },"t3");

        Thread t4 = new Thread(()->{
            log.info("执行t4");
            LockSupport.unpark(t3);
            log.info("t4执行完成，解锁t3");
        },"t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
