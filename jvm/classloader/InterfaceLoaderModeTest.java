package main.java.jvm.classloader;

/**
 * 接口和父接口初始化和加载 的测试类
 *
 * 当一个接口在初始化时，并不要求其父接口都完成初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量和子类在编译期无法确定的常量时），才会初始化
 *
 * 这个类提供的MyParent5和MyChild5不能很好的反映 子接口调用时不会初始化父接口，因为老师当时说的是MyParent5.class
 * 都删掉了，但是如果build后再运行一次，删掉class 然后
 * @author zhuqp on 2020/1/1
 */
public class InterfaceLoaderModeTest {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    int a = 5;
//    int c = new Random().nextInt(5);
}

interface MyChild5 extends MyParent5 {
    int b = 6;
//这块写一个c 因为这个常量在编译期无法确定，导致在调用的时候必须要MyParent5.class的存在， 如果不用这个就是
    //直接把MyChild5调用的是编译期常量放到了InterfaceLoaderModeTest这个类下的常量池中。
//    int b = new Random().nextInt(2);
}
