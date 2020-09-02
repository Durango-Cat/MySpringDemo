package thread;

import org.junit.Test;

/**
 * 测试Daemon线程
 * Daemon线程 是一种支持型线程，因为它主要被用作程序中后台调度以及支持型工作。
 *
 * 执行结果：没有任何输出
 * @author Zhuqiuping on 2020/6/19
 */
public class DaemonTest {

    @Test
    public void test1() {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
