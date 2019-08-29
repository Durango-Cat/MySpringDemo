package main.design.pattern.factory.abstracts;

/**
 * 椰子
 * @author Zhuqiuping on 2019/8/8
 */
public class Coconut implements IRawMaterial {
    @Override
    public String material() {
        return "椰子";
    }
}
