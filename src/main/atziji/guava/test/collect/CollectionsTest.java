package main.atziji.guava.test.collect;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * 测试Collections
 *
 * @author ZhuQiuPing
 *         on 2018/2/7
 */
public class CollectionsTest {
    List<String> coll = Lists.newArrayList("ceheuf", "dasxsferf", "cesdewd", "dasxsdew", "cedesd");

    //测试filter方法
    @Test
    public void filterTest() {

        Collection<String> collection2 = Collections2.filter(coll, new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return s.length() > 6;
            }
        });

        System.out.println(collection2);
    }

    @Test
    public void permutationsTest() {
        List<String> list = Lists.newArrayList("hello","world","javab","c","someone");
        Collection<List<String>> collection = Collections2.permutations(list);
        System.out.println(collection);
    }

    @Test
    public void transformTest() {
       Collection<String> colls =  Collections2.transform(coll, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        });

        System.out.println(colls);
    }
}
