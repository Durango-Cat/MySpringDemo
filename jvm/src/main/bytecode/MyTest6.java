package main.bytecode;

/**
 * 方法的动态分派
 *
 * 重写  多态都跟这个有关系
 * @author Zhuqiuping on 2020/3/18
 */
public class MyTest6 {
    public static void main(String[] args) {

        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {

    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}
