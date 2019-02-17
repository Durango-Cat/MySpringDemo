package main.atziji.guava.test.collect;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * set的交、并、差集
 *
 * @author ZhuQiuPing
 *         on 2018/2/7
 */
public class SetsTest {

    Set<String> stringSet = Sets.newHashSet("d12", "212", "sdca");
    Set<String> set1 = Sets.newHashSet("232", "3sds", "d12", "212");

    //差集
    @Test
    public void testOne() {

        Sets.SetView<String> ss = Sets.difference(stringSet, set1);
        for(String str : ss) {
            System.out.println(str);
        }
    }
    //并集
    @Test
    public void testTwo() {

        Sets.SetView<String> ss = Sets.intersection(stringSet, set1);
        for(String str : ss) {
            System.out.print(str + "\t");
        }
    }

    //交集
    @Test
    public void testThree() {
        Sets.SetView<String> ss = Sets.union(stringSet, set1);
        for(String str : ss) {
            System.out.print(str + "\t");
        }
    }

    //针对两边都对称的差集
    @Test
    public void testFour() {
        Sets.SetView<String> set4 = Sets.symmetricDifference(stringSet, set1);
        for(String str : set4) {
            System.out.print(str + "\t");
        }
    }

    //返回一个Set中元素所有组合，包括了父集合集合在内
    @Test
    public void testFive() {
        Set<String> set5 = Sets.newHashSet("I want to eat french fries", "I drink juice", "I'm eating dumplings");
        Set<Set<String>> sets = Sets.powerSet(set5);
        for(Set<String> set1 : sets) {
            System.out.println(set1);
        }
    }

    //两个集合的所有组合方式，但也是第一个集合在数一直在前面
    @Test
    public void testSix() {
        Set<String> set1 = Sets.newHashSet("I want to see ", "I hate ", "I like ");
        Set<String> set2 = Sets.newHashSet("Tom", "Jack", "rose");
        Set<List<String>> listSet = Sets.cartesianProduct(set1, set2);
        System.out.println(listSet);
    }
}
