package main.java.jvm.classloader;

/**
 * 父子类中的静态变量和静态代码块的加载顺序测试类
 *
 * 我的预期：先打印MyParent6 后打印MyChild6
 * 但真正的结果：只打印了MyParent6
 * 为啥：因为MyChild6 和 MyParent6之间是子父关系，虽然是用子类.父类静态变量的方式或者子类.父类静态方法，
 * 但是终究是主动加载的父类，跟子类没有啥关系，就是没有牵扯到子类的主动加载更不用说初始化了。不看调用方是谁，只看最终调用的类
 * @author zhuqp on 2020/1/2
 */
public class StaticParamInChildAndParentClassLoaderTest {

    public static void main(String[] args) {
        System.out.println(MyChild6.a);
        System.out.println("-----------");
        MyChild6.doSomething();
    }
}

class MyParent6 {
    static int a = 3;

    static {
        System.out.println("MyParent6 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class MyChild6 extends MyParent6 {
    static {
        System.out.println("MyChild6 static block");
    }
}
