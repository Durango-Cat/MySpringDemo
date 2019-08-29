package main.design.pattern.factory.abstracts;

/**
 * 椰香包
 * @author Zhuqiuping on 2019/8/8
 */
public class CoconutBreadFactory implements IBreadFactory {

    @Override
    public String material() {
        return new Coconut().material();
    }

    @Override
    public String type() {
        return new CoconutType().type();
    }

    @Override
    public String toString() {
        return "material:" + material() + "    type:" + type();
    }
}
