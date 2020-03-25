package main.bytecode;

/**
 * 栈的指令操作
 *
 * @author Zhuqiuping on 2020/3/24
 */
public class MyTest8 {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 32;

        int d = (a + c) * b;
        System.out.println(d);
    }
}
