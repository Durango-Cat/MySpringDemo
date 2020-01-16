package main.classloader;

/**
 * 测试不同类型 类加载器的加载范围
 *
 * @author Zhuqiuping on 2020/1/10
 */
public class ClassLoaderLoadRangeByType {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println();
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println();
        System.out.println(System.getProperty("java.class.path"));
    }
}
