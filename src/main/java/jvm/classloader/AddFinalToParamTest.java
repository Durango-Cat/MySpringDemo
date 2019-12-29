package main.java.jvm.classloader;

/**
 * 测试类中加final的常量，类启动时的情况
 *
 * 解释：常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 *       本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * 注意：这里指的是常量存放到了AddFinalToPararmTest的常量池中，之后AddFinalToPararmTest与
 * MyFinalParent2就没有任何关系了。甚至，可以将MyFinalParent2的class文件删除
 * 删除方法：此项目编译完后 会把class文件都放到了out文件夹下面
 *   在out文件夹下找到java.jvm.jvmparam文件夹下的MyFinalParent2.class删除掉程序还是可以正常执行
 *
 * 助记符：
 * ldc表示将int, float或是String类型的常量值从常量池中推送至栈顶（就是马上要用到的）
 * bipush 表示将单字节(-128 ~ 127)的常量值推送到栈顶
 * sipush 表示将一个短整型的常量值（-32768~32767）推送至栈顶  短整型如果在-128~127范围内就是bipush超过了就是sipush
 * iconst_1 将int型的1推送到栈顶   也会有iconst_2 ~ iconst_5  最多就到5
 *
 * @author zhuqp on 2019/12/29
 */
public class AddFinalToParamTest {

    public static void main(String[] args) {
        //此处执行先打印了静态代码块，后打印了str内容
//        System.out.println(MyParent2.str);
//        System.out.println();
        //println此处执行只打印了str内容
//        System.out.println(MyFinalParent2.str);
//        System.out.println(MyFinalParent2.s);
//        System.out.println(MyFinalParent2.i);
//        System.out.println(MyFinalParent2.l);
        System.out.println(MyFinalParent2.i1);
    }
}

class MyParent2 {
    public static String str = "hello world!";

    static {
        System.out.println("MyParent2 static block!");
    }
}

class MyFinalParent2 {
    public static final String str = "hello final world!";

    public static final short s = 7;
    public static final int i = 128;
    public static final int l = 180;
    public static final int i1 = 1;

    static {
        System.out.println("MyParent2 static block!");
    }
}
