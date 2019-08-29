package main.design.pattern.factory.ordinary;

import main.design.pattern.factory.BananaBread;
import main.design.pattern.factory.Bread;

/**
 * 香蕉包工厂
 * @author Zhuqiuping on 2019/8/8
 */
public class BananaBreadFactory extends AbstractTypeFactory {
    @Override
    public Bread createBread() {
        return new BananaBread();
    }
}
