package main.design.pattern.factory.abstracts;

/**
 * 香蕉包
 * @author Zhuqiuping on 2019/8/8
 */
public class BananaBreadFactory implements IBreadFactory {

    @Override
    public String material() {
        return new Banana().material() + "+" + new WholeWheat().material();
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
