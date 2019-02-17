package main.java.java8model;

/**
 * 测试Lambda用到的接口
 *
 * Create by zhuqiuping
 * on 2017/3/24
 */
@FunctionalInterface
public interface IFunction<T, R> {
    R apply(T t);

    default double sqrt(int a){
        return Math.sqrt(a);
    }

    default void showFunction() {
        System.out.println("wo zhi xiang kankan zhe ge ");
    }

    static void engine() {
        System.out.println("功能的实现引擎");
    }
}
