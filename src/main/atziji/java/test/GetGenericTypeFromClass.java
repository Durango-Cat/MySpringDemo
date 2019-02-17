package main.atziji.java.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 应用泛型设计中Type接口的四种子接口：TypeVariable，ParameterizedType，GenericArrayType和WildcardType
 *
 * Create by ZhuQiuPing
 * on 2017/10/29
 */
public class GetGenericTypeFromClass {

    public static void main(String[] args) {
//        List<String> lists = new ArrayList<>(null);
//        List<String> addList = Lists.newArrayListWithExpectedSize(10);
//        addList.add("1");
//        addList.add("2");
//        addList.add("3");
//        addList.add("4");
//        addList.add("5");
//        addList.add("6");
//        addList.add("7");
//        addList.add("8");

//        lists.addAll(addList);
//
//        System.out.println(lists.size());
//        Boolean is = new Boolean("");
//        System.out.println(is);

//        System.out.println(addList.subList(0, 0));
//        Collections.reverse(addList);
//        System.out.println(addList);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append(i).append(",");
        }

//        System.out.println(sb.toString());
        System.out.println(sb.toString().split(",")[9]);
    }
}
