package main.memory;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 测试堆空间占满后 报的OutofMemoryError异常
 *
 * 让最小的和最大的堆空间都是5m  并且打印出堆空间异常，打出到磁盘上，在idea里面看不到 通过
 * Dump(转储）
 * @author Zhuqiuping on 2020/3/25
 */
public class MyTest1 {

    public static void main(String[] args) {

        List<MyTest1> myTest1List = Lists.newArrayList();

        for( ; ; ) {
            myTest1List.add(new MyTest1());
            //尽量不要写这行代码
            System.gc();
        }
    }
}
