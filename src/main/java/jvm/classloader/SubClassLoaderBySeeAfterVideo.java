package main.java.jvm.classloader;

import java.io.*;

/**
 * 继承ClassLoader的子ClassLoader
 *
 * 继承了ClassLoader抽象类，竟然没有要实现的方法，这说明ClassLoader这个抽象类不希望都去实现子ClassLoader
 * @author zhuqp on 2020/1/4
 */
public class SubClassLoaderBySeeAfterVideo extends ClassLoader {

    /**
     * 因为会从外部传进来需要加载的类名字和后缀名，此处就直接写成静态变量方便后面使用
     */
    private String classLoaderName;

    private final String classLoaderNameSuffix = ".class";

    /**
     * 此方法里面第一个显示的写出一个super(); 就是为了提醒，ClassLoader这个抽象类的无参构造器
     * 在创建的时候，会直接调用系统类加载器当做父类
     *
     * @param classLoaderName 需要被加载类的名字
     */
    public SubClassLoaderBySeeAfterVideo(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    /**
     * 如果不想使用系统类加载器当做父类的类加载器，ClassLoader也是支持传一个类加载器当做父类
     * 的类加载器
     *
     * @param parent            要当做父类类加载器
     * @param classLoaderName   需要被加载类的名字
     */
    public SubClassLoaderBySeeAfterVideo(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }


    @Override
    public Class findClass(String classLoaderName) {
        byte[] datas = loadClassData(classLoaderName);
        return defineClass(classLoaderName, datas, 0, datas.length);
    }

    private byte[] loadClassData(String binaryName) {
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;

        try {
            //此处将classLoaderName里面的 . 转换成 / (windows要转换成//)
//            binaryName = binaryName.replace(".", "//");
            this.classLoaderName = this.classLoaderName.replace(".", "//");
            is = new FileInputStream(new File(binaryName + this.classLoaderNameSuffix));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())) {
                baos.write(ch);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(baos != null) {
                try {
                    baos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        SubClassLoaderBySeeAfterVideo subClassLoaderBySeeAfterVideo = new SubClassLoaderBySeeAfterVideo("load1");
        test(subClassLoaderBySeeAfterVideo);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("main.java.jvm.classloader.AddFinalToParamTest");

        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}
