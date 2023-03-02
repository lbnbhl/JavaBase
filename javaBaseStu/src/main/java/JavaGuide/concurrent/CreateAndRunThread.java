package JavaGuide.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @autor wwl
 * @date 2023/1/28-16:12
 */
@Slf4j
public class CreateAndRunThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.info("线程t1运行..........");
            }
        };

        Runnable runnable = () -> log.info("线程t2运行..........");
        Thread t2 = new Thread( runnable,"t2" );

        FutureTask<Integer> task = new FutureTask<Integer>(
                ()->{
                    log.info("线程t3运行..........");
                    return 10;
                }
        );
        Thread t3 = new Thread(task, "t3"){
            @Override
            public void run() {
                log.info("hhhhhhhhhhhhhhhhhhhdhftyjryyyyyyyyj6tryytjtyjrtyjrtjyrj.");
            }
        };

        t1.join();

        t1.start();
        t2.start();
        t3.start();
    }


}
