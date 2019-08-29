package main.design.pattern.factory.abstracts;

/**
 * 吐司面包
 *
 * @author Zhuqiuping on 2019/8/8
 */
public class ToastBreadFactory implements IBreadFactory {

    @Override
    public String material() {
        return new Wheat().material();
    }

    @Override
    public String type() {
        return new ToastType().type();
    }

    @Override
    public String toString() {
        return "material:" + material() + "    type:" + type();
    }
}
