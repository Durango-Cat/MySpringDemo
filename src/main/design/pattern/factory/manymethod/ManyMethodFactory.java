package main.design.pattern.factory.manymethod;

import main.design.pattern.factory.*;

/**
 * 多方法的工厂（适合于一个工厂，多个产品的情况，属于对简单工厂->工厂方法的过渡）
 *
 * @author Zhuqiuping on 2019/8/8
 */
public class ManyMethodFactory {

    /**
     * 香蕉包
     */
    public Bread getBananaBread() {
        return new BananaBread();
    }

    /**
     * 吐司
     */
    public Bread getToast() {
        return new Toast();
    }

    /**
     * 椰香包
     */
    public Bread getCoconutBread() {
        return new CoconutBread();
    }

    /**
     * 长棍
     */
    public Bread getBaguette() {
        return new Baguette();
    }
}
