package main.atziji.java.test;

/**
 * 父类异常在处理的时候放在了子类异常前面，情况测试
 *
 * Create by ZhuQiuPing
 * on 2017/10/15
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class FatherAndChildExceptionTest {

    public static void main(String[] args) {
        try{
            throw new Sneeze();
        } catch (Annoyance e) {
            System.out.println("此处运行Annoyance异常");
        }  //后面这块不能写上比Annoyance异常小的异常，这样编译时都会报错，不符合异常规范
    }
}
