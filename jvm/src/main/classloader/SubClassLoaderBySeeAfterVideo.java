package main.classloader;

import com.google.common.base.Strings;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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

    private String path;

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

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 这个方法的主要作用，就是通过参数中的二进制名字 得到对应的类对象
     *
     * 最重要的就是实现这个findClass方法，本类中的测试方法中并没有直接调用findClass
     * 而是调用loadClass，在父类loadClass中会寻找子类实现的findClass方法，等于间接的被调用了。
     *
     * @param binaryName    字符串类型的"."拼接的二进制名字
     * @return
     */
    @Override
    public Class findClass(String binaryName) {
        byte[] datas = loadClassData(binaryName);
        Class clazz = defineClass(binaryName, datas, 0, datas.length);
        System.out.println("class's hashcode: " + clazz.hashCode());
        System.out.println("class的类加载器名字" +  this.classLoaderName);
        return clazz;
    }

    /**
     * 这个方法时主要实现的方法，根据binaryName就是从磁盘上去加载这个class文件，并把里面的内容转换成byte[]数组加载到内存中。
     * 这个byte[]就是加载到的类信息
     * @param binaryName
     * @return
     */
    private byte[] loadClassData(String binaryName) {
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;

        try {
            //此处将classLoaderName里面的 . 转换成 / (windows要转换成//)
            String filePath = binaryName.replace(".", "/");
//            this.classLoaderName = this.classLoaderName.replace(".", "//");
            System.out.println("进来加载类信息了");
            if(!Strings.isNullOrEmpty(path)) {
                filePath = path + filePath;
            }
            is = new FileInputStream(new File(filePath + this.classLoaderNameSuffix));
            baos = new ByteArrayOutputStream();
            int ch;
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
        //这个 方法这样调用其实走的是系统类加载器，所以没有调用到这个自己实现的类加载器
        //SubClassLoaderBySeeAfterVideo subClassLoaderBySeeAfterVideo = new SubClassLoaderBySeeAfterVideo("load1");
        //test(subClassLoaderBySeeAfterVideo);

        //删掉对应class后，继续加载
        SubClassLoaderBySeeAfterVideo subClassLoader1BySeeAfterVideo = new SubClassLoaderBySeeAfterVideo("load1");
        subClassLoader1BySeeAfterVideo.setPath("/Users/zhuqiuping/test/");
        testByDelteTargetClass(subClassLoader1BySeeAfterVideo);

        ////删掉对应class后，继续加载 (这种情况就不会再继续加载，因为用的父类加载器都是一个）
        //SubClassLoaderBySeeAfterVideo subClassLoader2BySeeAfterVideo = new SubClassLoaderBySeeAfterVideo(subClassLoader1BySeeAfterVideo, "load2");
        //subClassLoader2BySeeAfterVideo.setPath("/Users/zhuqiuping/test/");
        //testByDelteTargetClass(subClassLoader2BySeeAfterVideo);
        //
        ////删掉对应class后，继续加载 (这种情况就不会再继续加载，因为用的父类加载器都是一个）
        //SubClassLoaderBySeeAfterVideo subClassLoader4BySeeAfterVideo = new SubClassLoaderBySeeAfterVideo(subClassLoader2BySeeAfterVideo, "load2");
        //subClassLoader4BySeeAfterVideo.setPath("/Users/zhuqiuping/test/");
        //testByDelteTargetClass(subClassLoader4BySeeAfterVideo);

        //如果写成创建一个 那么类加载器优惠重新加载下这个类，说明这样创建的话，虽然都是用的这个类，但是得到的命名空间是不一样的，很奇怪吧
        //SubClassLoaderBySeeAfterVideo subClassLoader3BySeeAfterVideo = new SubClassLoaderBySeeAfterVideo("load1");
        //subClassLoader3BySeeAfterVideo.setPath("/Users/zhuqiuping/test/");
        //testByDelteTargetClass(subClassLoader3BySeeAfterVideo);

        //此处看下类卸载的情况,在启动配置上加一个jvm参数 -XX:+TraceClassUnLoading，
        //打印的信息中在两个类加载时，有一个[Unloading class main.classloader.AddFinalToParamTest 0x00000007c006c028]
        //如果把这个置空的代码注释掉，此处即使执行gc也不会真的卸载掉该类，因为它下面检测到还有引用的
        //subClassLoader1BySeeAfterVideo = null;
        //System.gc();

        subClassLoader1BySeeAfterVideo = new SubClassLoaderBySeeAfterVideo("load1");
        subClassLoader1BySeeAfterVideo.setPath("/Users/zhuqiuping/test/");
        testByDelteTargetClass(subClassLoader1BySeeAfterVideo);
        //还有一种情况就是在这个对象不再引用的时候，给显示gc一下，因为它下面检测不到有东西在引用这个对象了，但是注掉这个gc就不会有类卸载了。
        //System.gc();
    }

    public static void test(ClassLoader classLoader) throws Exception {
        //用了父类的loadClass方法
        Class<?> clazz = classLoader.loadClass("main.classloader.AddFinalToParamTest");

        Object obj = clazz.newInstance();
        System.out.println("class's hashcode: " + clazz.hashCode());
        System.out.println(obj);
    }

    public static void testByDelteTargetClass(ClassLoader classLoader) throws Exception {
        String showPath = "main.classloader.AddFinalToParamTest";
        Class<?> clazz = classLoader.loadClass(showPath);
        System.out.println("得到类加载器：" + clazz.getClassLoader());
        clazz.newInstance();
        System.out.println();
    }
}
