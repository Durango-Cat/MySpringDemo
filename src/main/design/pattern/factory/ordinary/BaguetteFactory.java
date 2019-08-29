package main.design.pattern.factory.ordinary;

import main.design.pattern.factory.Baguette;
import main.design.pattern.factory.Bread;

/**
 * 长棍面包工厂
 * @author Zhuqiuping on 2019/8/8
 */
public class BaguetteFactory extends AbstractTypeFactory {
    @Override
    public Bread createBread() {
        return new Baguette();
    }
}
