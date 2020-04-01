package main.memory;

/**
 * jconsole或者jvisualvm  检测死锁
 *
 * @author Zhuqiuping on 2020/3/30
 */
public class MyTest3 {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {

        synchronized (Thread1.class) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread2().run();
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {

        synchronized (Thread2.class) {
            //try {
            //    Thread.sleep(300);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            new Thread1().run();
        }
    }
}
