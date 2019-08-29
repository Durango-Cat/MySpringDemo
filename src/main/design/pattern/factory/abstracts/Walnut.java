package main.design.pattern.factory.abstracts;

/**
 * 核桃
 * @author Zhuqiuping on 2019/8/8
 */
public class Walnut implements IRawMaterial {
    @Override
    public String material() {
        return "核桃";
    }
}
