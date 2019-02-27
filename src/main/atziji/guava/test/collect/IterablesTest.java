package main.atziji.guava.test.collect;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * 针对Iterables的测试
 *
 * @author ZhuQiuPing
 *         on 2018/1/23
 */
public class IterablesTest {

    @Test
    public void testCommonFunction() {
        List<String> list = Lists.newArrayList("2323", "323232");
        //懒加载的方式拼接多个集合
       //Iterable<String> iterables1 = Iterables.concat(list, Lists.newArrayList("c3ce", "212idwy"));
       // System.out.println(iterables1);

        //frequcency，对象在Iterable中出现的次数
        List<String> list2 = Lists.newArrayList("wewe", "wewe", "weare", "wewe", "wecan", "wedo", "wewe", "wenot");
        //int count = Iterables.frequency(list, new );
        //System.out.println(count);
        //
        //System.out.println(Iterables.partition(list2, 3));

        System.out.println(new BigDecimal("323.2").setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
    }
}
