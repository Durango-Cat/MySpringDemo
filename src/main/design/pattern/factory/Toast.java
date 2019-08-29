package main.design.pattern.factory;

/**
 * 吐司
 * @author Zhuqiuping on 2019/8/8
 */
public class Toast extends Bread {
    /**
     * 用料
     */
    @Override
    public String material() {
        return "全麦";
    }

    /**
     * 类型
     */
    @Override
    public String type() {
        return "吐司";
    }
}
