package main.design.pattern.factory;

import lombok.Data;

/**
 * 香蕉包
 * @author Zhuqiuping on 2019/8/8
 */
@Data
public class BananaBread extends Bread {

    /**
     * 用料
     */
    @Override
    public String material() {
        return "香蕉+小麦";
    }

    /**
     * 类型
     */
    @Override
    public String type() {
        return "香蕉包";
    }
}
