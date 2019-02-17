package main.atziji.java.test;

/**
 * 在接口中创建内部类
 *
 * Create by ZhuQiuPing
 * on 2017/8/23
 */
public interface InnerClassInInterfaceTest {

    void howhy();

    class Test implements InnerClassInInterfaceTest {
        public void howhy() {
            System.out.println("Test内部类实现了howhy方法");
        }

        public static void main(String[] args) {
            new Test().howhy();
        }
    }
}
