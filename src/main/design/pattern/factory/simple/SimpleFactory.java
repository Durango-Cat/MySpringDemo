package main.design.pattern.factory.simple;

import main.design.pattern.factory.*;

/**
 * 简单工厂(只有一个工厂，多个产品的场景）
 * @author Zhuqiuping on 2019/8/8
 */
public class SimpleFactory {
    /**
     * 根据类型不同定做面包
     *
     * @param type 类型
     */
    public Bread orderBead(BreadType type) {
        Bread bread = null;
        switch (type) {
            case BANANA:
                bread = new BananaBread();
                break;
            case TOAST:
                bread = new Toast();
                break;
            case COCONUT:
                bread = new CoconutBread();
                break;
            case BAGUETTE:
                bread = new BananaBread();
                break;
            default:
                break;
        }
        return bread;
    }
}
