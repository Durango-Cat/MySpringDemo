package main.atziji.java.test.about.collectiontest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对ArrayList转换成subList后
 * 对原集合增删操作，subList会报异常的测试
 *
 * Create by ZhuQiuPing
 * on 2017/11/12
 */
public class SubListChangeThrowExceptionTest {
    public static void main(String[] args) {
        List<String> studentList = Lists.newArrayList();
        studentList.add("旭旭");
        studentList.add("胖虎");
        studentList.add("小懒");
        studentList.add("渝中");
        studentList.add("大懒");
        studentList.add("中懒");
        studentList.add("懒货");

//        List<String> subList = studentList.subList(0, 3);
//
//        System.out.println(subList instanceof ArrayList);
//
//        studentList.remove(2);
//
//        subList.forEach(System.out::println);

        //测试完毕，我在下面测试写其他的东西
        String[] str = new String[10];
        str = studentList.toArray(str);
        for (String studentInfo: str) {
            System.out.println(studentInfo);
        }
    }
}
