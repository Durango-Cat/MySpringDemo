package main.atziji.thread.test;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadGroup
 *
 * @author ZhuQiuPing
 *         on 2019/1/4
 */
public class ThreadGroupTest implements Runnable {

    private Result result;

    public ThreadGroupTest(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start \n", name);
        try {
            doTask();
            //result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted \n", name);
            return;
        }
        System.out.printf("Thread %s: End \n", name);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d \n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        ThreadGroupTest threadGroupTest = new ThreadGroupTest(result);

        for(int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadGroup, threadGroupTest);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        threadGroupTest.waitFinish(threadGroup);
        threadGroup.interrupt();
    }

    private void waitFinish(ThreadGroup threadGroup) {
        //while()
    }

    private static class Result {
        @Setter
        @Getter
        private String name;
    }
}


