package main.atziji.java.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author ZhuQiuPing
 *         on 2018/11/14
 */
public class TestMap {

    @Test
    public void testOne() {
        Map<String, Object> xxx = Maps.newLinkedHashMap();
        Object xxxinfo = xxx.get("123");
        System.out.println(xxxinfo + "");
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

}
