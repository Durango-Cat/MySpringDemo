package main.design.pattern.factory.abstracts;

/**
 * 全麦
 * @author Zhuqiuping on 2019/8/8
 */
public class WholeWheat implements IRawMaterial {
    @Override
    public String material() {
        return "全麦";
    }
}
