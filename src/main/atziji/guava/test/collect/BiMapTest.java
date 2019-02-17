package main.atziji.guava.test.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * 双向Map测试
 *
 * @author ZhuQiuPing
 *         on 2018/1/4
 */
public class BiMapTest {

    @Test
    public void testBiMap() {
        BiMap<String, String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一", "monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");

//        System.out.println("英文结果：" + weekNameMap.get("星期一"));
//
//        System.out.println("反转后的结果：" + weekNameMap.inverse().get("monday"));

        weekNameMap.forcePut("不知道会怎么样", "I don't konw how about that?");
        //值出现重复，可以用forcePut来替代上一个值相同的键名称，即值冲突将这个键名称改为最新的。
//        weekNameMap.forcePut("星期八", "Sunday");
        //但是如果值重复，用put就会报IllegalArgumentException:value already present: Sunday
//        System.out.println(weekNameMap);
//        Set<String> values = weekNameMap.values();
//        System.out.println(values);
//        System.out.println(weekNameMap);
    }
}
