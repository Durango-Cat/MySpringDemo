package main.memory;

/**
 * 主要演示：虚拟机栈溢出 StackOverflow
 *
 * 可以在配置文件中配置jvm指令：-Xss160k
 * 可以用jconsole java自带的工具来查看类执行过程中的jvm相关模块信息
 *
 * @author Zhuqiuping on 2020/3/30
 */
public class MyTest2 {

    private int length;

    public int getLength() {
        return length;
    }
    //无限递归的程序
    public void test() {
        this.length++;

        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        try {
           myTest2.test();
        } catch(Throwable ex) {
            System.out.println(myTest2.length);
            ex.printStackTrace();
        }
    }
}
