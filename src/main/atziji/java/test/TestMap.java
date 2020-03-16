package main.atziji.java.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhuQiuPing
 *         on 2018/11/14
 */
public class TestMap {

    @Test
    public void testOne() {
        //Map<String, Object> xxx = Maps.newLinkedHashMap();
        //Object xxxinfo = xxx.get("123");
        //System.out.println(xxxinfo + "");

        //String ezsonar = "ezsonar_2019-09-29-10";
        //String str = "http://192.168.1.136/ezsonar/apm/dashboard/show?id=5d2ec0cb45ce37d39482e0fb&isShare=false&parentLevel_0=eyJxdWVyeSI6e30sInBhcmFtcyI6e319&report=true";
        //System.out.println(str.startsWith("htttp://192.168.1.136"));
        //
        //System.out.println(str.substring(21)));
        //System.out.println(ezsonar.split("-").length);
        //System.out.println(ezsonar.startsWith("ezsonarnpm_"));

    }

    @Test
    public void testTwo() {
        Map<String, Object> twoMap = Maps.newLinkedHashMap();
        System.out.println(twoMap.get(null));
    }

    @Test
    public void testThree() {
        Map<String, Object> threeMap = Maps.newLinkedHashMap();
        threeMap.put("key", "ewefwefwf");
        threeMap.put("one", "32342");
        threeMap.put("hot", "ewe2342fwefwf");
        threeMap.put("two", "tgfr4tf");
        threeMap.put("three", "34rfds3");

        System.out.println(threeMap.size());

        threeMap.remove("43234");
        System.out.println(threeMap.size());
    }

    @Test
    public void testFour() {
        List<Long> timeList = Lists.newArrayList();
        timeList.add(1563152400L);
        timeList.add(1563152460L);
        timeList.add(1563152520L);
        timeList.add(1563152580L);
        timeList.add(1563152640L);
        timeList.add(1563152700L);
        timeList.add(1563152760L);
        timeList.add(1563152820L);
        timeList.add(1563152880L);
        timeList.add(1563152940L);

        Map<Long, Integer> map = Maps.newLinkedHashMap();
        for (Long time : timeList) {
            System.out.println(time /300);
            final Long createdAt = (time / 300) * 300 * 1000L;
            Integer integer = map.get(createdAt);
            if (integer == null) {
                map.put(createdAt, 1);
            } else {
                map.put(createdAt, ++integer);
            }
        }

        map.forEach((key, value) -> System.out.println(key + "-- > " + value));
    }

    @Test
    public void testFive() {
        Map<String, String> xxMap = Maps.newLinkedHashMap();
        xxMap.put("1", "fredfer");
        xxMap.put("2", "233434");
        xxMap.put("3", "ytgrdfvfv");
        xxMap.put("4", "w45trgfdew");
        xxMap.put("5", "34tgvcds");
        xxMap.put("6", "tgbvfer4tr");
        xxMap.put("7", "cvfr43wdfr");

        List<String> indexList = Lists.newArrayList("1", "2", "233", "4", "0", "6", "7");
        Set<String> keySet = xxMap.keySet();
        for(String index : indexList) {
            if(keySet.contains(index)) {
                xxMap.remove(index);
            }
        }

        System.out.println(xxMap.size());
        System.out.println(xxMap);
    }
}
