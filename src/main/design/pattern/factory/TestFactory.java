package main.design.pattern.factory;

import main.design.pattern.factory.abstracts.*;
import main.design.pattern.factory.manymethod.ManyMethodFactory;
import main.design.pattern.factory.ordinary.OrdinaryFactory;
import main.design.pattern.factory.simple.SimpleFactory;
import org.junit.Test;

/**
 * 测试四种类型的工厂模式
 *
 * @author Zhuqiuping on 2019/8/9
 */
public class TestFactory {
    //简单工厂的测试
    @Test
    public void testSimpleFactory() {
        SimpleFactory simpleFactory = new SimpleFactory();
        Bread bread = simpleFactory.orderBead(BreadType.TOAST);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = simpleFactory.orderBead(BreadType.BAGUETTE);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = simpleFactory.orderBead(BreadType.COCONUT);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
    }

    //多方法工厂
    @Test
    public void testManyWayFactory() {
        ManyMethodFactory manyMethodFactory = new ManyMethodFactory();
        Bread bread = manyMethodFactory.getBaguette();
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = manyMethodFactory.getBananaBread();
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = manyMethodFactory.getToast();
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
    }

    //普通工厂
    @Test
    public void testOrdinaryFactory() {
        OrdinaryFactory ordinaryFactory = new OrdinaryFactory();
        Bread bread = ordinaryFactory.orderBead(BreadType.COCONUT);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = ordinaryFactory.orderBead(BreadType.BAGUETTE);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = ordinaryFactory.orderBead(BreadType.TOAST);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
        bread = ordinaryFactory.orderBead(BreadType.BANANA);
        System.out.println("material:" + bread.material() + "    type:" + bread.type());
    }

    @Test
    public void testAbstractFactory() {
        IBreadFactory iBreadFactory = new ToastBreadFactory();
        System.out.println(iBreadFactory.toString());
        iBreadFactory = new BananaBreadFactory();
        System.out.println(iBreadFactory.toString());
        iBreadFactory = new BaguetteBreadFactory();
        System.out.println(iBreadFactory.toString());
        iBreadFactory = new CoconutBreadFactory();
        System.out.println(iBreadFactory.toString());
    }
}
