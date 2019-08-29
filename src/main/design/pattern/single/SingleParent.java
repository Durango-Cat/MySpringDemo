package main.design.pattern.single;

/**
 * 有同步的双重判断单例模式
 *
 * @author Zhuqiuping on 2019/8/13
 */
public class SingleParent {

    private static volatile SingleParent singleParent;

    private SingleParent() {

    }

    public static SingleParent getInstance() {
        if(singleParent == null) {
            synchronized (SingleParent.class) {
                if(singleParent == null) {
                    singleParent = new SingleParent();
                }
            }
        }
        return singleParent;
    }
}
