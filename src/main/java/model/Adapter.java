package main.java.model;

/**
 *适配器（根据接口匹配的适配器）
 *
 * Created by zhuqiuping
 * on 2017/3/4.
 */

public class Adapter extends Adaptee implements Target{

    @Override
    public void twoHoleSocket() {
        this.threeHoleSocket();
    }
}
