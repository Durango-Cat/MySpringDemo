package main.java.jvm.classloader;

/**
 * 类中的静态方法 在类加载时的模式
 *
 * 对于数组实例来说，其类型是由jvm在运行期动态生成的，表示为[Lmain.java.jvm.classloader.MyParent4;
 * 这种形式。动态生成的类型，其父类都是Object。
 *
 * 对于数组来说，Javadoc经常讲构成数组的元素成为Component,实际上就是将数组降低一个维度后的类型。
 * 助记符：
 * anewarray: 表示创建一个引用类型的 （如类、接口、数组）数组 并将其引用值压入栈顶
 * newarray:  表示创建一个指定的基本类型的（int, float, char等）数组，并将其引用值压入栈顶
 * @author zhuqp on 2020/1/1
 */
public class StaticMethodToLoaderMode {

    public static void main(String[] args) {
        //静态代码块只会执行一次
//        MyParent4 myParent4 = new MyParent4();
        //类型数组的使用 不会主动调用。但是这个new 肯定有实例出来，仅仅表示创建了一个数组实例
        MyParent4[] myParent4s = new MyParent4[1];
        //这个调用对象 从属的类型 [L表示生成数组从属的类型，这个类型是jvm在运行期帮我们创建出来的数组类型
        System.out.println(myParent4s.getClass());

//        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        //[[L 表示二维数组
//        System.out.println(myParent4s1.getClass());
//        System.out.println(myParent4s.getClass().getSuperclass());
//        System.out.println(myParent4s1.getClass().getSuperclass());

        //上面的是引用类型的数组，下面创建原生类型的数组
        int[] ints = new int[1];
        //[I  表示Integer
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
        //char类型的就是[C   boolean类型的就是[Z  short类型的就是[S  byte类型的就是[B

    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block!!!");
    }
}
