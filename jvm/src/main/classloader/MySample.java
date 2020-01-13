package main.classloader;

/**
 *
 *
 * @author Zhuqiuping on 2020/1/10
 */
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());
        //关联了MyCat
        new MyCat();

        System.out.println("from MySample: " + MyCat.class);
    }
}
