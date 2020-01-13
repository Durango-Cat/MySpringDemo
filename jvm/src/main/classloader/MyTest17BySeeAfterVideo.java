package main.classloader;

import org.junit.Test;

/**
 * @author Zhuqiuping on 2020/1/10
 */
public class MyTest17BySeeAfterVideo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        SubClassLoaderBySeeAfterVideo loader1 = new SubClassLoaderBySeeAfterVideo("loader1");

        Class<?> clazz = loader1.loadClass("main.classloader.MySample");
        System.out.println("class's hashcode : " + clazz.hashCode());
        //如果注掉newInstance 那么并不会实例化MySample对象及MyCat对象，没有调用MySample构造器，那么就不会主动调用到MyCat。
        // 但是MyCat类并不会因为没有在MySample构造器中调用， 而没加载
        //类的加载并不会在它首次调用时才加载，通过-XX:+TraceClassLoading 后发现注掉下面代码，就没有加载。意思就是没有使用，jvm就没有加载它。
        //Object MySample1 = clazz.newInstance();
    }

    /**
     * 前提：删掉了target里面MySample 和MyCat两个的class文件
     * 结果：两个都去了指定的路径下 加载自定义类加载器
     */
    @Test
    public void testAddPath() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SubClassLoaderBySeeAfterVideo loader1 = new SubClassLoaderBySeeAfterVideo("loader1");
        loader1.setPath("/Users/zhuqiuping/test/");
        Class<?> clazz = loader1.loadClass("main.classloader.MySample");
        //System.out.println("class's hashcode : " + clazz.hashCode());
        //如果注掉newInstance 那么并不会实例化MySample对象及MyCat对象，没有调用MySample构造器，那么就不会主动调用到MyCat。
        // 但是MyCat类并不会因为没有在MySample构造器中调用， 而没加载
        //类的加载并不会在它首次调用时才加载，通过-XX:+TraceClassLoading 后发现注掉下面代码，就没有加载。意思就是没有使用，jvm就没有加载它。

        //newInstance() 就是通过反射的方式创建类的实例
        Object MySample1 = clazz.newInstance();
    }

    /**
     * 指定文件夹下的MySample和MyCat class都存在， target里面的只有MySample.class
     *
     * 是由于加载了MySample的类加载器 尝试着去加载MyCat  MySample的类加载器是应用类加载器， 但是MyCat不在classpath路径下
     * 但是很好奇，为啥这个找不到的时候 都不能用自定义类加载器的指定地方去加载吗？
     */
    @Test
    public void testDeleteMyCatsClassInTarget() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SubClassLoaderBySeeAfterVideo loader1 = new SubClassLoaderBySeeAfterVideo("loader1");
        loader1.setPath("/Users/zhuqiuping/test/");
        Class<?> clazz = loader1.loadClass("main.classloader.MySample");
        //System.out.println("class's hashcode : " + clazz.hashCode());
        //如果注掉newInstance 那么并不会实例化MySample对象及MyCat对象，没有调用MySample构造器，那么就不会主动调用到MyCat。
        // 但是MyCat类并不会因为没有在MySample构造器中调用， 而没加载
        //类的加载并不会在它首次调用时才加载，通过-XX:+TraceClassLoading 后发现注掉下面代码，就没有加载。意思就是没有使用，jvm就没有加载它。
        Object MySample1 = clazz.newInstance();
    }

    /**
     * 前提：指定路径下的MySample和MyCat class文件都存在，target里面只有MyCat，
     * 结果：正常输出，神了，是由两个完全不同的类加载器去加载。
     * 目前 MySample里面引用了MyCat， MyCat对MySample类是没有任何引用的
     *
     */
    @Test
    public void testDeleteMySamplesClassInTarget() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SubClassLoaderBySeeAfterVideo loader1 = new SubClassLoaderBySeeAfterVideo("loader1");
        loader1.setPath("/Users/zhuqiuping/test/");
        Class<?> clazz = loader1.loadClass("main.classloader.MySample");
        //System.out.println("class's hashcode : " + clazz.hashCode());
        //如果注掉newInstance 那么并不会实例化MySample对象及MyCat对象，没有调用MySample构造器，那么就不会主动调用到MyCat。
        // 但是MyCat类并不会因为没有在MySample构造器中调用， 而没加载
        //类的加载并不会在它首次调用时才加载，通过-XX:+TraceClassLoading 后发现注掉下面代码，就没有加载。意思就是没有使用，jvm就没有加载它。
        Object MySample1 = clazz.newInstance();
    }

    /**
     * 前提：在MyCat类构造器中加上一句 MySample.class的打印，target里面删掉MySample的class文件
     *
     * 结果：MySample和MyCat都加载了，执行到MyCat构造器的最后一句时报了找到类的异常
     * 这块涉及到了命名空间，是因为MyCat是由父加载器加载的类，它就看不到子加载器里面加载的类都有什么，所以在自己的类加载器中找不到MySample就报错了
     */
    @Test
    public void testDeleteMySamplesClassAfterEditMyCatCons() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SubClassLoaderBySeeAfterVideo loader1 = new SubClassLoaderBySeeAfterVideo("loader1");
        loader1.setPath("/Users/zhuqiuping/test/");
        Class<?> clazz = loader1.loadClass("main.classloader.MySample");
        //System.out.println("class's hashcode : " + clazz.hashCode());
        //如果注掉newInstance 那么并不会实例化MySample对象及MyCat对象，没有调用MySample构造器，那么就不会主动调用到MyCat。
        // 但是MyCat类并不会因为没有在MySample构造器中调用， 而没加载
        //类的加载并不会在它首次调用时才加载，通过-XX:+TraceClassLoading 后发现注掉下面代码，就没有加载。意思就是没有使用，jvm就没有加载它。
        Object MySample1 = clazz.newInstance();
    }

    /**
     * 结果：正常，因为Mysample加载器属于子类加载器，子类加载器能看到父类的东西，所以这样查看父类的MyCat就是能看到
     */
    @Test
    public void testDeleteMySampleClassAfterEditMySampleCons()  throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SubClassLoaderBySeeAfterVideo loader1 = new SubClassLoaderBySeeAfterVideo("loader1");
        loader1.setPath("/Users/zhuqiuping/test/");
        Class<?> clazz = loader1.loadClass("main.classloader.MySample");
        //System.out.println("class's hashcode : " + clazz.hashCode());
        //如果注掉newInstance 那么并不会实例化MySample对象及MyCat对象，没有调用MySample构造器，那么就不会主动调用到MyCat。
        // 但是MyCat类并不会因为没有在MySample构造器中调用， 而没加载
        //类的加载并不会在它首次调用时才加载，通过-XX:+TraceClassLoading 后发现注掉下面代码，就没有加载。意思就是没有使用，jvm就没有加载它。
        Object MySample1 = clazz.newInstance();
    }
}
