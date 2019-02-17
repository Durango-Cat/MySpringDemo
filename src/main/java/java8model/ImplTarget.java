package main.java.java8model;

import main.java.model.Target;

/**
 * 实现了需要适配器接口的类
 *
 * Create by zhuqiuping
 * on 2017/3/4
 */
public class ImplTarget implements Target {
    @Override
    public void twoHoleSocket() {
        System.out.println("本宝宝是两项插孔");
    }
}
