package main.atziji.normalstructure.test;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * 测String的另外一个类，因为TestString里面测试方法太多了
 *
 * @author Zhuqiuping on 2019/3/27
 */
public class TestStringOne {
    
    @Test
    public void test1() {
        //新的需求里面包括的
            Set<String> str1 = Sets.newHashSet("S22", "S22", "S56", "S20", "S80", "S71", "S73", "S21", "S35", "I22", 
                    "S76", "S67", "S77", "S14", "S82", "S28", "S00", "S24","S10","S65");
            //旧的需求
            Set<String> str2 = Sets.newHashSet("S22","S20","S24","S21","S80","S82","I22","S13","S35","S28","S56",
                    "S67","S71","S73");
            str2.addAll(Sets.newHashSet("S22","V40","S10",
                    "S20","V50","V52","S21","S30","S80","S82","I22","S13","V13","S75","S35","S14","S28","S23","S56","S65","V66","S67","V69","S71",
                    "S73","V73","V86","E74","E84"));

            Set<String> difference = Sets.difference(str1, str2);
            difference.forEach(System.out::println);

    }
}
