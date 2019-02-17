package main.atziji.thread.test;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Set;

/**
 * 账号类（测试synchronized功能用）
 *
 * @author ZhuQiuPing
 *         on 2019/1/7
 */
public class AccountFromSynchronized {

    @Getter
    @Setter
    private static double balance;

    public static void addAmount(double amount) {
        double temp = balance;

        //Thread
    }

    @Test
    public void testOne() {
        Set<String> setOne = Sets.newHashSet();
        setOne.add("1");
        setOne.add("2");
        setOne.add("3");
        setOne.add("4");
        setOne.add("5");
        setOne.add("6");
        setOne.add("7");

        Set<String> setTwo = Sets.newHashSet();
        System.out.println(setOne.containsAll(setTwo));
    }

}
