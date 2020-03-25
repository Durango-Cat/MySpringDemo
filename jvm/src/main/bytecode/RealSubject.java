package main.bytecode;

/**
 * 动态代理中的Subject实现类
 *
 * @author Zhuqiuping on 2020/3/24
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("call real subject's request function!");
    }
}
