package main.java.jvm.classloader;

import java.util.UUID;

/**
 * 类中使用UUID的常量 调用时还是会主动加载类
 *
 * @author Zhuqiuping on 2019/12/31
 */
public class UUIDInitiativeLoadClassTest {

    public static void main(String[] args) {
        System.out.println(MyParent3.UUIDS);
    }
}

class MyParent3 {
    public static final String UUIDS = UUID.randomUUID().toString();

    static {
        System.out.println("see me !");
    }
}
