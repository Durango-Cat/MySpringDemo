package main.atziji.java.test;

/**
 * 其他外部类对非静态内部类继承的应用
 *
 * Create by ZhuQiuPing
 * on 2017/8/28
 */
public class InnerClassExtendsTest extends Outer.Inner {
    InnerClassExtendsTest(Outer outer) {
        outer.super();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        InnerClassExtendsTest innerClassExtendsTest = new InnerClassExtendsTest(outer);
        innerClassExtendsTest.show();
    }

}

class Outer {
    public Outer() {
        System.out.println("我是包含内部类的外部类的构造函数");
    }

    public class Inner {
        public Inner() {
            System.out.println("我是非静态内部类的构造函数");
        }

        public void show() {
            System.out.println("我只是展示下内部类的某一个方法");
        }
    }
}
