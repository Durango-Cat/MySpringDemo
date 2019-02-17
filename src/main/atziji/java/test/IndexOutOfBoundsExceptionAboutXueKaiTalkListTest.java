package main.atziji.java.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 学凯的博客中写到随便在List定义好长度中添加元素，会报数组越界异常
 *
 * Create by ZhuQiuPing
 * on 2017/10/22
 */
public class IndexOutOfBoundsExceptionAboutXueKaiTalkListTest {

    public static void main(String[] args) {
        String stt1 = "test1";
        String stt2 = "test2";
        List<String> stringList = new ArrayList<>(2);
        stringList.add(stt1);
        stringList.add(stt2);
        String stt3 = "test1";
        String stt4 = "test1";
        String stt5 = "test1";
        List<String> stringList1 = new ArrayList<>();
        stringList1.add(stt3);
        stringList1.add(stt4);
        stringList1.add(stt5);

        stringList.addAll(0, stringList1);
        System.out.println(stringList.size());
    }
}
