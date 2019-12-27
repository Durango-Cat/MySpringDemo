package main.work.readotherclassparam;

/**
 * 应用视图列表数据
 *
 * @author Zhuqiuping on 2019/12/27
 */
public class AppData extends IData {
    /**
     * 应用视图列表第一列指标
     */
    private String appName;
    /**
     * 应用视图列表第二列指标别名
     */
    private String appAliasName;

    public AppData(Long tranCount, String latencyMsec, String successRate, String busiSuccessRate, String responseRate) {
        super(tranCount, latencyMsec, successRate, busiSuccessRate, responseRate);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppAliasName() {
        return appAliasName;
    }

    public void setAppAliasName(String appAliasName) {
        this.appAliasName = appAliasName;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "appName='" + appName + '\'' +
                ", appAliasName='" + appAliasName + '\'' +
                ", tranCount=" + tranCount +
                ", latencyMsec='" + latencyMsec + '\'' +
                ", successRate='" + successRate + '\'' +
                ", busiSuccessRate='" + busiSuccessRate + '\'' +
                ", responseRate='" + responseRate + '\'' +
                '}';
    }
}
