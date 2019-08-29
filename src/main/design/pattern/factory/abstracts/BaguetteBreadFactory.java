package main.design.pattern.factory.abstracts;

/**
 * 长棍面包
 * @author Zhuqiuping on 2019/8/8
 */
public class BaguetteBreadFactory implements IBreadFactory {

    @Override
    public String material() {
        return new Walnut().material() + "+" + new Wheat().material();
    }

    @Override
    public String type() {
        return new BaguetteType().type();
    }

    @Override
    public String toString() {
        return "material:" + material() + "    type:" + type();
    }
}
