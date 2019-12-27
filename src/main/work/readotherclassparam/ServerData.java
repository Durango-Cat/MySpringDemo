package main.work.readotherclassparam;

/**
 * 服务码视图维度列表数据对象
 *
 * @author Zhuqiuping on 2019/12/27
 */

public class ServerData extends IData {
    /**
     * 服务码视图列表第一列指标
     */
    private String serverName;
    /**
     * 服务码视图列表第二列指标别名
     */
    private String serverAliasName;

    public ServerData(Long tranCount, String latencyMsec, String successRate, String busiSuccessRate, String responseRate) {
        super(tranCount, latencyMsec, successRate, busiSuccessRate, responseRate);
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerAliasName() {
        return serverAliasName;
    }

    public void setServerAliasName(String serverAliasName) {
        this.serverAliasName = serverAliasName;
    }

    @Override
    public String toString() {
        return "ServerData{" +
                "serverName='" + serverName + '\'' +
                ", tranCount=" + tranCount +
                ", serverAliasName='" + serverAliasName + '\'' +
                ", latencyMsec='" + latencyMsec + '\'' +
                ", successRate='" + successRate + '\'' +
                ", busiSuccessRate='" + busiSuccessRate + '\'' +
                ", responseRate='" + responseRate + '\'' +
                '}';
    }
}
