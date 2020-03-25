package main.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Zhuqiuping on 2020/3/24
 */
public class Client {

    public static void main(String[] args) {
        //这是一个系统变量  将代理执行时生成的class对象生成文件存到磁盘上
        //这个变量是在Proxy.newProxyInstance方法的 getProxyClass0方法 里面的 ProxyClassFactory.apply方法里面的 ProxyGenerator.generateProxyClass就能找到这个参数了
        //saveGeneratedFiles这个变量控制，
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);

        Class<?> clz = realSubject.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), invocationHandler);

        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
