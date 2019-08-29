package main.design.pattern.factory.abstracts;

/**
 * 香蕉加全麦
 * @author Zhuqiuping on 2019/8/8
 */
public class Banana implements IRawMaterial {
    @Override
    public String material() {
        return "香蕉";
    }
}
