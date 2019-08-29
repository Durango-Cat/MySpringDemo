package main.design.pattern.factory;

/**
 * 椰香包
 * @author Zhuqiuping on 2019/8/8
 */
public class CoconutBread extends Bread {
    /**
     * 用料
     */
    @Override
    public String material() {
        return "椰子+小麦";
    }

    /**
     * 类型
     */
    @Override
    public String type() {
        return "椰香包";
    }
}
