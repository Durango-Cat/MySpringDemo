package main.atziji.java.test.about.collectiontest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 用foreach来循环删除元素的测试
 *
 * Create by ZhuQiuPing
 * on 2017/11/14
 */
public class ListForRemoveDataTest {

    public static void main(String[] args) {
        List<String> nameList = Lists.newArrayList();
        nameList.add("1");
        nameList.add("2");
        nameList.add("3");
        nameList.add("4");
        nameList.add("5");
        nameList.add("6");
//
//        for(String name : nameList) {
//            if("1".equals(name)) {
//                nameList.remove(name);
//            }
//        }
//
//        for (String name : nameList) {
//            System.out.println(name);
//        }
//        List<String> nameList = Lists.newArrayList(null);
//        Map<String, Object> objectMap = Maps.newHashMap();
//        objectMap.put("id", "122312313341");
//        objectMap.put("name", "小米");
//        objectMap.put("subject", "数学");
//
//        System.out.println(objectMap.get("id"));
//        String str = null;
//        String[] aaa = {"xxx", "2323", "dwew"};
//        if(Arrays.binarySearch(aaa, str) == -1) {
//            System.out.println("对着呢");
//        }
//        List<String> zxz = Lists.newArrayList();

        Iterator<String> iterator = nameList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            int index = nameList.indexOf(str);
            if("3".equals(str)) {
                str = "10";
                nameList.set(index, str);
            }
        }
        System.out.println(nameList.indexOf("10"));

    }
}
