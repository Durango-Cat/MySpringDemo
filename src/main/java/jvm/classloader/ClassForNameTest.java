package main.java.jvm.classloader;

/**
 * 测试下ClassLoader里面的loadClass、Class.forName是否会主动加载类
 *
 * 结果：load.loadClass加载类，并不会主动使用类，不会导致类的初始化；
 *      Class.forName是主动加载类中的一种，能够主动加载类
 *
 *      所以：加载不代表一定会初始化
 * @author zhuqp on 2020/1/2
 */
public class ClassForNameTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader load = ClassLoader.getSystemClassLoader();
        Class<?> clazz = load.loadClass("main.java.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("-----------------");

        clazz = Class.forName("main.java.jvm.classloader.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("class CL");
    }
}