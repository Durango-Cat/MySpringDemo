package memorymodel;


import org.junit.Test;

/**
 * 测试volatile这个关键字
 *
 * @author Zhuqiuping on 2020/6/17
 */
public class VolatileTest {

    private static volatile boolean flag = true;

    private static boolean flagNew = true;

    private static int i = 0;

    private static int iNew = 0;

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (flag) {
                    i++;
                }
                System.out.printf("**********test2 跳出成功, i=%d **********\n", i);
            }
        };
        long startTime = System.currentTimeMillis();
        thread.start();
        long threadTempTime = System.currentTimeMillis();
        System.out.println("线程执行花费的时间：" + (threadTempTime - startTime));
        Thread.sleep(100);
        flag = false;
        long endTime = System.currentTimeMillis();
        System.out.printf("**********test2 main thread 结束, i=%d **********\n", i);
        System.out.println("线程执行花费的时间：" + (endTime - threadTempTime));
    }

    @Test
    public void test2() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (flagNew) {
                    iNew++;
                    System.out.println("i=" + iNew);
                }
                System.out.printf("**********test2 跳出成功, i=%d **********\n", iNew);
            }
        };
        thread.start();
        Thread.sleep(100);
        flagNew = false;
        System.out.printf("**********test2 main thread 结束, i=%d **********\n", iNew);
    }
}
