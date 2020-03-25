package main.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Zhuqiuping on 2020/3/24
 */
public class DynamicSubject implements InvocationHandler {

    private Object obj;

    public DynamicSubject(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call invoke function ~~~~~~");
        method.invoke(obj, args);
        System.out.println("after call invoke function ~~~~~~~~");
        return null;
    }
}
