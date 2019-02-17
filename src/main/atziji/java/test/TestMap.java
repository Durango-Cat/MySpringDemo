package main.atziji.java.test;

import com.google.common.collect.Maps;
import org.junit.Test;

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
}
