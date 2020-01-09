package main.classloader;

/**
 * 测试当前类的系统类加载器，以及系统类加载器的父类加载器信息
 *
 * 打印结果：
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * sun.misc.Launcher$ExtClassLoader@452b3a41
 * null
 * @author Zhuqiuping on 2020/1/3
 */
public class ClassLoaderBySystemAndParentsTest {

    public static void main(String[] args) {
        //得到系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while(classLoader != null) {
            //得到系统类加载器的父类加载器
            classLoader = classLoader.getParent();
            //如果是根类加载器 就直接返回null, 可以在ClassLoader类中能找到对应的getParent()
            System.out.println(classLoader);
        }
    }
}

