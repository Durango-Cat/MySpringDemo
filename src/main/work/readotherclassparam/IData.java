package main.work.readotherclassparam;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主机视图几个模块 维度列表返回数据的抽象类
 *
 * @author Zhuqiuping on 2019/12/27
 */
@Data
@NoArgsConstructor
public class IData {
    /**
     * 交易量(没有数据的时候，返回0）
     */
    Long tranCount;
    /**
     * 响应时间(没有数据的时候，返回--)
     */
    String latencyMsec;
    /**
     * 交易成功率(没有数据的时候，返回--)
     */
    String successRate;
    /**
     * 业务成功率(没有数据的时候，返回--)
     */
    String busiSuccessRate;
    /**
     * 响应率(没有数据的时候，返回--)
     */
    String responseRate;

    public IData(Long tranCount, String latencyMsec, String successRate, String busiSuccessRate, String responseRate) {
        this.tranCount = tranCount;
        this.latencyMsec = latencyMsec;
        this.successRate = successRate;
        this.busiSuccessRate = busiSuccessRate;
        this.responseRate = responseRate;
    }
}
