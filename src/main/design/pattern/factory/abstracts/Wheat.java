package main.design.pattern.factory.abstracts;

/**
 * 小麦
 * @author Zhuqiuping on 2019/8/8
 */
public class Wheat implements IRawMaterial{

    @Override
    public String material() {
        return "小麦";
    }
}
