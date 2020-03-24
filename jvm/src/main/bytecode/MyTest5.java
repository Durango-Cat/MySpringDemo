package main.bytecode;

/**
 * 方法的静态分派
 *
 * Grandpa p1 = new Father();
 * 以上代码，p1的静态类型是Grandpa   而p1的实际类型(真正指向的类型)是Father
 *
 * 我们可以得出这样一个结论；变量的静态类型是不会发生变化的，而实际类型是可以发生变化的（多态的一种体现），实际类型在运行期才能确定。
 *
 *
 * 重载本身是一个静态的
 * 重写本身是一个动态的
 * 这个动态和静态的 体现在静态类型上面，就是区别在编译器是否能确定，比如重载就是编译器完全确定的，无外乎是这个参数传了什么类型的，
 * 但是不论传了什么类型都根据静态类型来决定；重写就不能在编译器确定数据类型。
 * @author Zhuqiuping on 2020/3/18
 */
public class MyTest5 {
    //方法重载，对于jvm来说是一种静态行为，根据参数的静态类型来匹配重载方法  编译器就可以完全确定的。
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa p1 = new Father();
        Grandpa p2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(p1);
        myTest5.test(p2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
