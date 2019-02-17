package main.java.test;

/**
 * 判断long型或者double型是否保证原子性。
 * 32位是做不到原子性，64位可以保证原子性
 *
 * @author ZhuQiuPing
 *         on 2018/9/17
 */
public class LongAtemTest implements Runnable {

    private static long field = 0;
    private volatile long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public LongAtemTest(long value) {
        this.setValue(value);
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 100000) {
            LongAtemTest.field = this.getValue();
            i++;
            long temp = LongAtemTest.field;
            if(temp != 1L && temp != -1L) {
                System.out.println("出现错误" + temp);
                System.exit(0);
            }
        }
        System.out.println("运行正确");
    }

    public static void main(String[] args) throws InterruptedException {
        //获取并打印当前JVM是32位还是64位
        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch + "-bits");

        LongAtemTest test1 = new LongAtemTest(1);
        LongAtemTest test2 = new LongAtemTest(-1);
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
