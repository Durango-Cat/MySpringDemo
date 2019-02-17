package main.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author ZhuQiuPing
 *         on 2018/12/12
 */
public class TestCallable {

    //static class Task implements Callable<String> {
    //    public String name;
    //    private int time;
    //
    //    public Task(String name, int time) {
    //        this.name = name;
    //        this.time = time;
    //    }
    //
    //    public Task() {
    //    }
    //
    //
    //    @Override
    //    public String call() throws Exception {
    //        String stringList = "";
    //        //for(int i = 0; i < time; i++) {
    //            //stringList.add(call);
    //            Thread.sleep(3000);
    //            System.out.println(name + "    " +  1 + "round");
    //        //}
    //        return name;
    //    }
    //}

    static class Task implements Callable<String> {
        static int val = 0;
        @Override
        public String call() throws Exception {
            if (val == 3) Thread.sleep(3000);
            return "Hello Wolrd" + (val ++);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = newFixedThreadPool(3);

        //ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MILLISECONDS,
        //        new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        //Task task2 = new Task("two", 2);

        //Future<?> future2 = executor.submit(task2);
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new Task());
        }
        List<String> ans = new ArrayList<>(tasks.size());
        try {
            List<Future<String>> fts = executor.invokeAll(tasks, 2, TimeUnit.SECONDS);
            for (Future<String> f : fts) {
                try {
                    f.cancel(true);
                    if (!f.isCancelled()) {
                        ans.add(f.get());
                    } else {
                        System.out.println("task was cancelled!" + f);
                    }
                } catch (ExecutionException e) {
                    ans.add("error");
                    System.out.println(e.getCause());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        for (String s : ans) {
            System.out.println(s);
        }

        //try {
        //    //executor.awaitTermination(3, TimeUnit.SECONDS);
        //    List<Future<?>> futures = new ArrayList<Future<?>>();
        //    for(int i = 0; i < 7; i++) {
        //        Task task = new Task(i+"---", 1);
        //        Future<?> future = executor.submit(task);
        //        futures.add(future);
        //    }
        //        for (Future<?> f : futures) {
        //            if (!f.isDone()) {
        //                System.out.println("没执行完" + f.get());
        //                f.cancel(true);
        //            } else {
        //                try {
        //                    System.out.println(f.get() + "---走这里了");
        //                } catch (ExecutionException e) {
        //                    System.out.println("打印结果");
        //                }
        //            }
        //        }
        //
        //    //System.out.println(executor.getPoolSize());
        //    //System.out.println(executor.getCompletedTaskCount());
        //        executor.shutdown();
        //    //System.out.println(executor.isTerminated());
        //    //System.out.println(futures.);
        //    ////System.out.println(Thread.activeCount());
        //    //
        //    //System.out.println(futures);
        //} catch (InterruptedException e) {
        //    System.out.println("executor is interrupted");
        //} catch (ExecutionException e) {
        //    System.out.println("....");
        //}
        //finally {
        //    System.out.println("别走这里啊");
        //}
        //try {

            //List<String> result = future.get(3000, TimeUnit.MILLISECONDS);
            //if(future.isDone()) {
            //    System.out.println("你不可能完成的");
            //} else {
            //    future.cancel(true);
            //    System.out.println("这才正常");
            //}
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //} catch (ExecutionException e) {
        //    e.printStackTrace();
        //} catch (TimeoutException e) {
        //    e.printStackTrace();
        //}
    }
}
