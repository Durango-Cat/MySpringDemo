package main.atziji.java.test;

/**
 * 类中初始化顺序的重新记忆
 *
 * Create by ZhuQiuPing
 * on 2017/8/6
 */
public class InitializationOrderTest extends Insect {

    private int k = printInit("initializationOrderTest.k initialized");
    static {
        System.out.println("静态子类代码块执行。。。");
    }
    {
        System.out.println("子类代码块执行。。。");
    }

    public InitializationOrderTest() {
        System.out.println("k:" + k);
        System.out.println("j:" + j);
    }

    private static int j = printInit("static initializationTest.j initialized");

    public static void main(String[] args) {
        System.out.println("InitializationTest constructor");
        InitializationOrderTest b = new InitializationOrderTest();
    }


}

class Insect {
    private int i = 9;
    protected int j;

    static {
        System.out.println("静态代码块执行。。。");
    }

    {
        System.out.println("代码块执行。。。。");
    }


    public Insect() {
        System.out.println("i:" + i + ",j:" + j);
        j = 29;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String init) {
        System.out.println(init);
        return 49;
    }
}
