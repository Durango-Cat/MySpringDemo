package main.atziji.guava.test.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 测试guava中MutliMap的用法
 *
 * Create by ZhuQiuPing
 * on 2017/11/11
 */
public class MultiMapTest {

    public static void main(String[] args) {

        List<String> nameList = Lists.newArrayList();
        nameList.add("彬彬");
        nameList.add("徐录");
        nameList.add("杨旭");
        nameList.add("徐克");

        //Multimap是为了存储一键多值的情况
        Multimap<String, String> multimap = ArrayListMultimap.create();
        for(String name : nameList) {
            multimap.put("计算机专业", name);
        }
        multimap.put("null", null);
        multimap.put("null", "瓜子二手车");
        System.out.println(multimap.entries());
        Map<String, Collection<String>> nameMap = multimap.asMap();
        System.out.println(nameMap.entrySet());
//        System.out.println(nameMap.values());
//        System.out.println();
//        System.out.println(multimap.values());
//        System.out.println(multimap.size());

//        Collection<String> nameCollection = multimap.get("计算机专业");
//        System.out.println(nameCollection);


//        Collection<String> nameLists= nameMap.remove("计算机专业");
////        System.out.println(nameMap);
//        System.out.println(nameLists);
//        System.out.println(nameMap.size());

//        Collection<Map.Entry<String, String>> entries = multimap.entries();
//        System.out.println(entries);

//        System.out.println(multimap.containsKey("计算机专业"));

//        System.out.println(multimap.containsValue("彬彬"));

//        System.out.println(multimap.containsEntry("计算机专业", "彬彬"));
        //返回的是multimap中键和键的个数
//        System.out.println(multimap.keys());

//        System.out.println(multimap.keySet());
//        multimap.
    }
}
