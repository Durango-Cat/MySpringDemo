package main.java.sort;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 插入排序、选择排序、希尔排序的比较
 *
 * @author ZhuQiuPing
 *         on 2018/5/14
 */
public class SortCompareTest {

    public static double time(String alg, Double[] a) {
        if(alg == null || alg.isEmpty()) {
            return 0.0;
        }

        if("Selection sort".equals(alg)) {

        }
        return 0;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        Random random = new Random();

        for(int t = 0; t < T; t++) {
            //每一次循环都会对该数组进行一次赋值和排序
            for(int i = 0; i < N; i++) {
                a[i] = random.nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    @Test
    public void testListString() {
        List<String> weekList = Lists.newArrayList();
        weekList.add("analyzier_2018-04");
        weekList.add("analyzier_2018-03");
        weekList.add("analyzier_2018-05");
        weekList.add("analyzier_2018-06");
        weekList.add("analyzier_2018-02");
        weekList.add("analyzier_2018-01");
        weekList.add("analyzier_2017-11");
        weekList.add("analyzier_2017-12");

        weekList.forEach(System.out::println);
        Collections.sort(weekList);

        weekList.forEach(System.out::println);
    }

    @Test
    public void testList() {
        List<String> stringList = Lists.newArrayList("@猪猪", "乐乐", "豆豆", "豆豆", "乐乐", "@猪猪");
        stringList.forEach(System.out::print);
        System.out.println();
        stringList.remove("@猪猪");
        stringList.forEach(System.out::print);
    }

    @Test
    public void testString() {
        String str = "_trans_ref.TT";
        //System.out.println(".".contains(str));
        System.out.println(str.startsWith("-"));
        System.out.println(str.startsWith("0x", 1));
        System.out.println(str.startsWith("#", 0));
    }
}
