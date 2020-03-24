package main.bytecode;

/**
 * 方法调用的字节码执行 有5种情况里面的invokestatic
 *
 * @author Zhuqiuping on 2020/3/18
 */
public class MyTest4 {

    public static void test() {
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
