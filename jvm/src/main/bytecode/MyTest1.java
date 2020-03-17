package main.bytecode;

/**
 * 简单一个例子，主要看编译后的class文件里的内容
 *
 * 可以在下面的Terminal里面 定位到MyTest1.class在的文件夹下，
 * 输入 javap MyTest1  可以查看编译后的内容，这个内容不能完全表示出编译前的代码内容
 * 为了看到更详细的可以输入 javap -c MyTest1 这个命令会更详细的把每行代码都做什么了解释下
 * -verbose 是冗余的意思，就是能打出更多的信息
 * @author zhuqp on 2020/3/5
 */
public class MyTest1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {

    }
}
