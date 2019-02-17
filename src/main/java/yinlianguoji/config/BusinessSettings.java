package main.java.yinlianguoji.config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @author ZhuQiuPing
 *         on 2018/10/29
 */
public class BusinessSettings {

    private static final String CONFIG_FILE_NAME = "yinlianguojiBank_config.xml";

    /**
     * 后台时间查询粒度（单位按分钟计算）
     */
    private Integer interval;

    /**
     * 内部含有正向金额的文件
     */
    private String positiveAmount;

    /**
     * 转换交易代码的文件
     */
    private String changeTransCode;

    /**
     * 地区对应表文件
     */
    private String areaCorrespondenceTable;

    /**
     * 汇率表文件
     */
    private String tableOnExchangeRates;

    //读取mysql配置文件
    /**
     * 驱动类名
     */
    private String driverName;

    /**
     * 数据库地址
     */
    private String url;

    /**
     * 用户名
     */
    private String user;

    /**
     * 密码
     */
    private String password;

    public BusinessSettings() {
    }

    public BusinessSettings(Integer interval, String positiveAmount, String changeTransCode,
                            String areaCorrespondenceTable, String tableOnExchangeRates,
                            String driverName, String url, String user, String password) {
        this.interval = interval;
        this.positiveAmount = positiveAmount;
        this.changeTransCode = changeTransCode;
        this.areaCorrespondenceTable = areaCorrespondenceTable;
        this.tableOnExchangeRates = tableOnExchangeRates;
        this.driverName = driverName;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * 得到配置文件内容
     *
     * @return  BusinessSettings
     * @throws Exception Exception
     */
    public static BusinessSettings getBusinessSettings() throws Exception {
        String path = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar";
        BusinessSettings businessSettings = new BusinessSettings();
        try {
            SAXReader sr = new SAXReader();
            sr.setEncoding("utf-8");
            Document doc = sr.read(new File(path, CONFIG_FILE_NAME));
            Element root = doc.getRootElement();
            businessSettings.interval = Integer.parseInt(root.element("interval").getStringValue());
            businessSettings.positiveAmount = root.element("positiveAmount").getStringValue();
            businessSettings.changeTransCode = root.element("changeTransCode").getStringValue();
            businessSettings.areaCorrespondenceTable = root.element("areaCorrespondenceTable").getStringValue();
            businessSettings.tableOnExchangeRates = root.element("tableOnExchangeRates").getStringValue();
            businessSettings.driverName = root.element("driverName").getStringValue();
            businessSettings.url = root.element("url").getStringValue();
            businessSettings.user = root.element("user").getStringValue();
            businessSettings.password = root.element("password").getStringValue();

            return businessSettings;
        }
        catch(Exception ex) {
            throw new Exception("YinLianGuoJiBank's getBusinessSettings", ex);
        }
    }

    public Integer getInterval() {
        return interval;
    }

    public String getPositiveAmount() {
        return positiveAmount;
    }

    public String getChangeTransCode() {
        return changeTransCode;
    }

    public String getAreaCorrespondenceTable() {
        return areaCorrespondenceTable;
    }

    public String getTableOnExchangeRates() {
        return tableOnExchangeRates;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public static long[] getConfigFileStat() {
        String path = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar";
        File config = new File(path, CONFIG_FILE_NAME);
        if (config.exists() && config.isFile()) {
            return new long[]{config.lastModified(), config.length()};
        }
        return null;
    }
}
