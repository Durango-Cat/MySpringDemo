package main.classloader;

/**
 * 单例类加载的模式
 *
 * @author zhuqp on 2020/1/1
 */
public class SingletonClassLoaderTest {

    public static void main(String[] args) {
        //打印出来的是1 1  为什么 因为int类型默认初始化值为0，在第一次加载静态资源的时候会把默认初始化值
        // 赋上去，等后面调用初始化的时候，才真正的把对应的值从默认值替换掉
//        Singleton1 instance1 = Singleton1.getInstance();
//        System.out.println(Singleton1.count1);
//        System.out.println(Singleton1.count2);

        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(Singleton2.count1);
        System.out.println(Singleton2.count2);
    }
}


class Singleton1 {
    public static int count1;
    public static int count2 = 0;

    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
        count1++;
        count2++;
    }

    public static Singleton1 getInstance() {
        return singleton1;
    }
}

/**
 * 这样写的目的，就是为了更好的体会下 类加载时  连接 和初始化顺序
 * 首先会在连接的准备阶段 把静态变量都赋值成默认值，count1,count2为0，singleton2为null,
 * 等到外面主动调用时，会执行初始化，此时将从getInstance方法中执行，singleton2就会从null变成新创建
 * 的Singleton2, 重点就在构造器里。这时就会执行构造器，count1++就是从0到1了，count2也是从0到1。但是执行完
 * 这个之后还会继续执行下count2=0的这个操作（因为初始化就是为静态变量附上正确的初始值） 构造器里面的操作
 * 只是赋值过程中的变化，并不是最终结果。
 */
class Singleton2 {
    public static int count1;

    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
        count1++;
        count2++;

        System.out.println(count1);
        System.out.println(count2);
    }
    public static int count2 = 0;
    public static Singleton2 getInstance() {
        return singleton2;
    }
}

