package main.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 线程中上下文的加载器
 *
 * @author Zhuqiuping on 2020/1/3
 */
public class ThreadClassLoaderTest {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);

        String resourceClassName = "classloader/ClassLoaderBySystemAndParentsTest.class";

        Enumeration<URL> resources = classLoader.getResources(resourceClassName);
        while(resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }

        System.out.println("------");
        //在不同类型的class文件 所用到的类加载器也是不一样的
        //比如目前这个类 就是用到了系统类加载器（应用类加载器）   如果是String类的class 在加载的时候是用的根类加载器
        Class<ThreadClassLoaderTest> threadClassLoaderTestClass = ThreadClassLoaderTest.class;
        ClassLoader classLoader1 = threadClassLoaderTestClass.getClassLoader();
        System.out.println(classLoader1);

        System.out.println("------");

        Class<String> stringClass = String.class;
        ClassLoader classLoader2 = stringClass.getClassLoader();
        System.out.println(classLoader2);
    }
}
