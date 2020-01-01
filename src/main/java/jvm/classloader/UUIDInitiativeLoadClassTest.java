package main.java.jvm.classloader;

import java.util.UUID;

/**
 * 类中使用UUID的常量 调用时还是会主动加载类
 * 这个UUID属于编译时不能确定，运行时才确定的，就会导致目标类被初始化，调用时属于主动加载
 * 因为它不属于编译器能确定的常量，没法放到常量池中，如果把这个class文件删除掉，就会提示找不到类
 * ClassNotFoundException
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
