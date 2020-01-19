package main.classloader;


import com.mysql.jdbc.Driver;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文 类加载器的一般使用模式（获取--使用--还原）
 *
 * @author Zhuqiuping on 2020/1/16
 */
public class ThreadClassLoaderUseMode {

    public static void main(String[] args) {
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
    }
}
