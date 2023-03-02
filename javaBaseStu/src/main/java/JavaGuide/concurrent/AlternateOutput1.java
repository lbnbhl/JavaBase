package JavaGuide.concurrent;

/**
 * @autor wwl
 * @date 2023/2/26-14:50
 * 交替输出的wait版
 * 线程 1 输出 a 5 次，线程 2 输出 b 5 次，线程 3 输出 c 5 次。现在要求输出 abcabcabcabcabc 怎么实现
 */
public class AlternateOutput1 {

    public int flag;
    public int loopNum;

    public AlternateOutput1 (int flag,int loopNum){
        this.flag = flag;
        this.loopNum = loopNum;
    }

    public void print(int waitFlag, int nextFlag, String str){
        for (int i = 0; i < loopNum; i++) {
            synchronized (this){
                while (this.flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(str);
                flag = nextFlag;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        AlternateOutput1 alternateOutput = new AlternateOutput1(2, 5);

        Thread t1 = new Thread(() -> {
            alternateOutput.print(1,2,"a");
        }, "t1");

        Thread t2 = new Thread(() -> {
            alternateOutput.print(2,3,"b");
        }, "t2");

        Thread t3 = new Thread(() -> {
            alternateOutput.print(3,1,"c");
        }, "t3");

        t1.start();
        t2.start();
        t3.start();



    }
}
