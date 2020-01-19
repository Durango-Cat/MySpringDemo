package main.classloader;

/**
 * 线程的类加载器（当前线程类加载器就是AppClassLoader
 * 这块看Launcher的类就能看到this.loader被赋值为AppClassLoader之后，就拿这个this.classLoader赋值给当前线程的线程上下文类加载器。
 * 所以线程上下文的 类加载器就是AppClassLoader)
 *
 * @author Zhuqiuping on 2020/1/16
 */
public class ThreadClassLoader implements Runnable {

    private Thread thread;

    public ThreadClassLoader() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);
        //Class: class sun.misc.Launcher$AppClassLoader
        System.out.println("Class: " + classLoader.getClass());
        //Parent: class sun.misc.Launcher$ExtClassLoader
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new ThreadClassLoader();
    }
}
