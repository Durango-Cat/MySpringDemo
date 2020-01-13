package main.classloader;

/**
 * @author Zhuqiuping on 2020/1/9
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
        //打印MySample类的class对象
        //System.out.println("from MyCat: " + MySample.class);
    }
}
