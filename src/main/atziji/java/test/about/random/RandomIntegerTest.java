package main.atziji.java.test.about.random;


import java.util.Random;

/**
 * 使用随机数，最终获取整数的方式
 *
 * @author ZhuQiuPing
 *         on 2017/11/21
 */
public class RandomIntegerTest {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(11));
    }
}
