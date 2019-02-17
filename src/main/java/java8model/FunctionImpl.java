package main.java.java8model;

/**
 * Create by zhuqiuping
 * on 2017/3/26
 */
public class FunctionImpl implements IFunction {

    @Override
    public Object apply(Object o) {
        if(o instanceof Student) {
            return new Person("花花", 18);
        }
        return null;
    }
}
