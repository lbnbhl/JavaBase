package JavaGuide.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @autor wwl
 * @date 2023/1/29-20:48
 */
public class waitTest {

    public static final Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
//        waitTest waitTest = new waitTest();
////        waitTest.method1();
////        waitTest.method2();
////        waitTest.method3();
//        Thread.sleep(1000);
//        lock.notifyAll();
//        Thread.sleep(0);
        AtomicInteger integer = new AtomicInteger(0);
        System.out.println(integer.updateAndGet(p->p+2));
    }

    public void method1() throws InterruptedException {
        synchronized (lock){
            this.wait();
            System.out.println("11111111111");
        }
    }

    public void method2() throws InterruptedException {
        synchronized (lock){
            this.wait();
            System.out.println("222222222");
        }
    }

    public void method3() throws InterruptedException {
        synchronized (lock){
            this.wait();
            System.out.println("3333333333");
        }
    }
}
