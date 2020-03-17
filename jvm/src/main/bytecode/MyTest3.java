package main.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *  看下 异常类里面的字节码是怎么处理的
 *
 *      对于Java类中的每一个实例方法（非static方法），其在编译后所生成的字节码当中，方法参数的数量总是会比源代码中方法参数的数量
 *  多一个（this), 它位于方法的第一个参数位置处；这样，我们就可以在Java的实例方法中使用this来去访问当前对象的属性以及其他方法。
 *
 *      这个操作是在编译期间完成的，即由javac 编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问，接下来在运行期间，
 *  由JVM在调用实例方法时，自动向实例方法传入该this参数。所以，在实例方法的局部变量中，至少会有一个指向当前对象的局部变量。
 *
 *  这个方法里面的局部变量表 = 方法参数里面的变量 + 方法里面定义的变量
 *
 * @author Zhuqiuping on 2020/3/17
 */
public class MyTest3 {

    public void test() throws IOException, FileNotFoundException {
        try {
            //Code里面locals是4个，
            // 这四个分别是：this   fis     serverSocket     3个catch块里面最多只能在运行时有一个真正执行到，此catch块里面的e就是第四个变量
            //这个操作数栈stack=3

            FileInputStream fis = new FileInputStream("text.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
