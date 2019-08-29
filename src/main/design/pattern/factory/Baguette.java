package main.design.pattern.factory;

/**
 * 长棍面包
 *
 * @author Zhuqiuping on 2019/8/8
 */
public class Baguette extends Bread {
    /**
     * 用料
     */
    @Override
    public String material() {
        return "面粉";
    }

    /**
     * 类型
     */
    @Override
    public String type() {
        return "长棍";
    }


}
