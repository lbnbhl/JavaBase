package JavaGuide.concurrent;

/**
 * @autor wwl
 * @date 2023/1/28-22:11
 * 字节码分析synchronized原理
 */
public class SynchronizedClass {
    static final Object lock = new Object();
    static int counter = 0;
    public static void main(String[] args) {
//        synchronized (lock) {
//            counter++;
//        }
        SynchronizedClass test = new SynchronizedClass();
        test.hh();
    }

    public synchronized void hh(){
        System.out.println("hhhhhhhhhhhh");
    }
}
