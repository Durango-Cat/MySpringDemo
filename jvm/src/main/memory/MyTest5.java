package main.memory;

/**
 * 死循环的代码，为了拿到运行时程序的pid  使用jmap等命令行工具
 *
 * 查看进程 ps -ef|grep java 找到这个运行中的类
 *
 * @author Zhuqiuping on 2020/4/2
 */
public class MyTest5 {

    public static void main(String[] args) {
        for(;;) {
            System.out.println("~~~~~~~~~~~~~~~~~");
        }
    }
}
