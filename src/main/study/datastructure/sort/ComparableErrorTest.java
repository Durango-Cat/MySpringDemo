package main.study.datastructure.sort;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 算法4 练习2.5.3
 * 这段代码有问题，我看了半天没看出来，就手动实现下, 还是没看出来有啥问题
 *
 * @author zhuqp on 2019/5/2
 */
public class ComparableErrorTest {

    public static void main(String[] args) {
        Balance b1 = new Balance(232.306);
        Balance b4 = new Balance(232.305);
        Balance b5 = new Balance(232.304);
        Balance b6 = new Balance(232.3);
        Balance b2 = new Balance(232.205);
        Balance b3 = new Balance(232);

        List<Balance> bList = Lists.newArrayList(b3, b2, b3, b1, b4, b6, b5);
        bList.sort(Balance::compareTo);
        bList.forEach(System.out::println);
    }

}


class Balance implements Comparable<Balance> {
    private double amount;

    public Balance(double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Balance that) {

        int result;
        if(this.amount < that.amount - 0.005) {
            result = -1;
        } else if(this.amount > that.amount + 0.005) {
            result = 1;
        } else {
            result = 0;
        }
        System.out.println(this.amount + "\t" + that.amount + "\t" + result);
        return result;
    }

    @Override
    public String toString() {
        return this.amount + "";
    }
}
