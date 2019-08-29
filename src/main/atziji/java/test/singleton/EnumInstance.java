package main.atziji.java.test.singleton;

/**
 * 枚举类型的实例
 *
 * @author Zhuqiuping on 2019/4/30
 */
public enum EnumInstance {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
