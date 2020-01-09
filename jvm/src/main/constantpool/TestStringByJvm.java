package main.constantpool;

import org.junit.Test;

/**
 * 字符串的各种在jvm里面的测试类
 *
 * @author zhuqp on 2019/12/29
 */
public class TestStringByJvm {
    /**
     * 根据不同方式的创建字符串 来判断两个字符串存放的位置是否相同
     * 要么都是字符串常量池  要么都是堆内存
     *
     * 结果：false
     * 分析：因为第一个str1是放在字符串常量池里的，  str2和 str3也是放在字符串常量池里。
     * 但是str2 和str3在相加的时候 身份是变量，变量相加就是放到了堆内存中，
     * 为啥str2 和 str3相加就放到堆内存中呢，网上搜到的反编译后字节码
     * String str1 = "foo";
     *
     * String str2 = "bar";
     *
     * String str4 = (new StringBuilder()).append(str1).append(str2).toString();
     */
    @Test
    public void testLiteralsAndHeatByStringCreateType() {
        String str1 = "Hello World";
        String str2 = "Hello";
        String str3 = " World";
        String str4 = str2 + str3;
        System.out.println(str4 == str1);
    }
}
