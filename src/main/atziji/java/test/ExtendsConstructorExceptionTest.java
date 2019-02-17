package main.atziji.java.test;

/**
 * 针对 派生类构造器不能获取基类构造器抛出的异常 测试
 *
 * Create by ZhuQiuPing
 * on 2017/10/14
 */
public class ExtendsConstructorExceptionTest {

    public static void main(String[] args) {
        try {
            Child child = new Child();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Father father = new Father();
    }

}

class Father {
    public Father() throws NullPointerException {
        System.out.println("new father constructor and will throws nullpointerexception");
        throw new NullPointerException();

    }

    public void showException() throws NullPointerException{
        System.out.println("展示父类错误");
    }
}

class Child extends Father {
    public Child() throws Exception {
        //在这里第一行只能写super();要想获取异常信息，最起码要把super()包起来，这样显然就不能实现
        System.out.println("new child constructor");
    }

}