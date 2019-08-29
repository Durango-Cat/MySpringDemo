package main.java.test;


//import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试foreach 底层原理，会直接在命令行中执行javap看编译后的class文件是怎么处理两种情况下的foreach
 * @author Zhuqiuping on 2019/8/29
 */
public class TestForeach {
    private static List<String> strForeachList = new ArrayList<String>();
    private static String[] strArrList = new String[]{"098", "987", "876", "765", "654"};

    public static void main(String[] args) {
        strForeachList.add("123");
        strForeachList.add("234");
        strForeachList.add("345");
        strForeachList.add("456");
        strForeachList.add("567");
        String info = "";
        for (String str : strForeachList) {
            info += str + " ";
        }
        System.out.println(info);

        String xxx = "";
        for(String str : strArrList) {
            xxx += str + "";
        }
        System.out.println(xxx);
    }
}
