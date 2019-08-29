package main.design.pattern.factory.ordinary;

import main.design.pattern.factory.Bread;

/**
 * 抽象的类型工厂，根据不同的类型来生产不同的面包
 *
 * @author Zhuqiuping on 2019/8/8
 */
public abstract class AbstractTypeFactory {
    /**
     * 根据类型来生成面包
     */
    public abstract Bread createBread();
}
