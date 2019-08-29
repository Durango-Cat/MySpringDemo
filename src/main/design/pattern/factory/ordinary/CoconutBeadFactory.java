package main.design.pattern.factory.ordinary;

import main.design.pattern.factory.Bread;
import main.design.pattern.factory.CoconutBread;

/**
 *
 * @author Zhuqiuping on 2019/8/8
 */
public class CoconutBeadFactory extends AbstractTypeFactory {
    @Override
    public Bread createBread() {
        return new CoconutBread();
    }
}
