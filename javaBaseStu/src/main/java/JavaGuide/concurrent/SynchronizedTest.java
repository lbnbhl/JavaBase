package JavaGuide.concurrent;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @autor wwl
 * @date 2023/1/28-21:19
 * Synchronized测试
 */
@Slf4j
public class SynchronizedTest {
    public static synchronized void a() throws InterruptedException {
        sleep(1);
        log.debug("1");
    }
    public static synchronized void b() {
        log.debug("2");
    }

    public static void main(String[] args) {
        SynchronizedTest n1 = new SynchronizedTest();
        for (int i = 0; i < 2000; i++) {
            new Thread(()->{
                try {
                    a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(()->{ n1.b(); }).start();
        }
    }
}
