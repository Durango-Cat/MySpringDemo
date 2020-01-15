package main.classloader;

/**
 * 线程上下文 类加载器（Context ClassLoader)
 * 从jdk1.2开始引入, 可以参考Thread类里面的getContextClassLoader()与setContextClassLoader(ClassLoader cl)
 * 分别用来获取和设置上下文类加载器。如果没有通过setContextClassLoader(ClassLoader cl)进行设置的话，
 * 线程将继承其父线程的上下文类加载器。Java应用运行时的初始线程的上下文类加载器是系统类加载器。
 *
 *
 * 当前类加载器（Current ClassLoader)
 * 每个类都会使用自己的类加载器（即加载自身的类加载器）来去加载其他类（指的是所依赖的类），
 * 如果ClassX引用了ClassY, 那么ClassX的类加载器就会去加载ClassY(前提是ClassY尚未被加载）
 * @author zhuqp on 2020/1/15
 */
public class ThreadContextClassLoader {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        //因为在lang包下
        System.out.println(Thread.class.getClassLoader());
    }

}
