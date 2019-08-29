package main.design.pattern.factory.abstracts;

/**
 * 吐司
 * @author Zhuqiuping on 2019/8/8
 */
public class ToastType implements IType {
    @Override
    public String type() {
        return "吐司";
    }
}
