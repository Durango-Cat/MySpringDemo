package main.java.test;

import org.junit.Test;

/**
 * 线程围栏试试
 *
 * @author ZhuQiuPing
 *         on 2018/8/29
 */
public class CountDownLatchTest {

    //private static ExecutorService service = Executors.newFixedThreadPool(15);


    @Test
    public void testStringAddIntegerNumber() {
        String min = "50";
        String max = "400";

        Integer interval = 50;
        //小于就是大于0

        String max1 = "501";
        System.out.println(min.compareTo(interval + ""));
        String temp = min;
        System.out.println(temp.compareTo(max1));
        System.out.println((temp = (Integer.parseInt(min) + interval) + ""));
        System.out.println(temp instanceof String);
        System.out.println((temp.compareTo(max)));
        for(; temp.compareTo(max) >= 0; temp = (Long.parseLong(min) + interval) + "") {
            System.out.println(temp);
        }
    }
}
