package main.java.test;

import main.java.model.Adapter;
import main.java.java8model.ImplTarget;
import main.java.model.Target;

/**
 * 对适配器的测试
 *
 * Create by zhuqiuping
 * on 2017/3/4
 */
public class TestAdapter {
    public static void main(String[] args) {

        Target adapter = new Adapter();
        adapter.twoHoleSocket();

        Target target = new ImplTarget();
        target.twoHoleSocket();

    }
}
