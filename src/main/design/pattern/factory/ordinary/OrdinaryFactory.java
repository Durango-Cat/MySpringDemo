package main.design.pattern.factory.ordinary;

import main.design.pattern.factory.Bread;
import main.design.pattern.factory.BreadType;

/**
 * 普通工厂/工厂方法 （适合于多个工厂 多个产品）
 *
 * @author Zhuqiuping on 2019/8/8
 */
public class OrdinaryFactory {

    public Bread orderBead(BreadType type) {

        AbstractTypeFactory abstractTypeFactory = null;
        switch (type) {
            case TOAST:
                abstractTypeFactory = new ToastFactory();
                break;
            case BAGUETTE:
                abstractTypeFactory = new BaguetteFactory();
                break;
            case BANANA:
                abstractTypeFactory = new BananaBreadFactory();
                break;
            case COCONUT:
                abstractTypeFactory = new CoconutBeadFactory();
                break;
            default:
                break;
        }

        return abstractTypeFactory.createBread();
    }
}
