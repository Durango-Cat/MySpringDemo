package main.java.yinlianguoji.config;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import main.java.yinlianguoji.exception.DataNotExistException;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author ZhuQiuPing
 *         on 2018/10/29
 */
public class ReadConfiguration {

    private static final Logger logger = Logger.getLogger("ReadConfiguration");
    /**
     * 读取文件时的编码
     */
    private static final String charset = "UTF-8";

    /**
     * 整个配置文件部分
     */
    private static long configFileLastModify, configFileSize;

    /**
     * 银联国际配置
     */
    private static BusinessSettings businessSettings;

    /**
     * 正向交易码的数据文件部分
     */
    private static long positiveTransCodeFileLastModify, positiveTransCodeFileSize;

    /**
     * 正向交易码数据集合（内部含义正向金额的数据）
     */
    //private static List<PositiveTransCode> positiveTransCodeSync = Lists.newArrayList();

    private static List<String> positiveTransCodeSync = Lists.newArrayList();

    /**
     * 交易代码分类对应表(转换交易代码)的文件部分
     */
    private static long changeTransCodeFileLastModify, changeTransCodeFileSize;
    /**
     * 交易代码数据集合（转换交易代码）的文件部分
     */
    private static Map<String, String> changeTransCodeSync = Maps.newLinkedHashMap();

    /**
     * 初始化银联国际配置文件
     *
     * @throws DataNotExistException 数据不存在
     */
    private synchronized void initConfigFile() throws DataNotExistException {
        // 读取配置文件(yinlianguojiBank_config.xml)
        long[] configFileStat = BusinessSettings.getConfigFileStat();
        if (configFileStat == null) {
            throw new DataNotExistException("Config File Not Exists");
        }
        if (configFileLastModify != configFileStat[0] || configFileSize != configFileStat[1]) {
            try {
                businessSettings = BusinessSettings.getBusinessSettings();
            } catch (Exception e) {
                throw new DataNotExistException("Get config error", e);
            }
            configFileLastModify = configFileStat[0];
            configFileSize = configFileStat[1];
        }
    }

    /**
     * 获取配置信息（yinlianguojiBank_config.xml)
     *
     * @return BusinessSettings
     */
    public BusinessSettings getBusinessSettings() {
        try {
            initConfigFile();
        } catch (DataNotExistException e) {
            logger.info("Get config error");
        }
        return businessSettings;
    }

    /**
     * 初始化内部含有正向金额的文件
     *
     * @throws DataNotExistException 数据文件不存在
     */
    public synchronized void initPositiveAmountDataFile() throws DataNotExistException {
        // 根据配置获取data文件
        BusinessSettings businessSettings = getBusinessSettings();
        //正向交易码数据文件 positive_trans_code.txt
        File positiveAmountFile = new File(businessSettings.getPositiveAmount());
        if (!positiveAmountFile.exists() || !positiveAmountFile.isFile()) {
            throw new DataNotExistException("positive Amount Data file not exist:" + positiveAmountFile.getPath());
        }
        if (positiveTransCodeFileLastModify != positiveAmountFile.lastModified()
                || positiveTransCodeFileSize != positiveAmountFile.length()) {
            try {
                putPositiveAmountData(positiveAmountFile);
                positiveTransCodeFileLastModify = positiveAmountFile.lastModified();
                positiveTransCodeFileSize = positiveAmountFile.length();
            } catch (Exception e) {
                e.printStackTrace();
                //logger.("error:", e);
            }
        }
    }

    /**
     * 初始化交易代码分类对应表的文件
     *
     * @throws DataNotExistException
     */
    public synchronized void initChangeTransCodeDataFile() throws DataNotExistException {
        // 根据配置获取data文件
        BusinessSettings businessSettings = getBusinessSettings();
        //转换交易代码的文件 change_trans_code.txt
        File changeTransCodeFile = new File(businessSettings.getChangeTransCode());
        if (!changeTransCodeFile.exists() || !changeTransCodeFile.isFile()) {
            throw new DataNotExistException("positive Amount Data file not exist:" + changeTransCodeFile.getPath());
        }
        if (positiveTransCodeFileLastModify != changeTransCodeFile.lastModified()
                || positiveTransCodeFileSize != changeTransCodeFile.length()) {
            try {
                putPositiveAmountData(changeTransCodeFile);
                positiveTransCodeFileLastModify = changeTransCodeFile.lastModified();
                positiveTransCodeFileSize = changeTransCodeFile.length();
            } catch (Exception e) {
                e.printStackTrace();
                //logger.error("error:", e);
            }
        }
    }

    /**
     * 读取正向交易码文件（即含有正向金额的文件），得到数据
     *
     * @param positiveAmountFile 正向交易码文件
     */
    private static void putPositiveAmountData(File positiveAmountFile)
            throws FileNotFoundException, UnsupportedEncodingException, IOException {
        FileInputStream fis = null;
        BufferedReader bf;
        try {
            positiveTransCodeSync.clear();

            fis = new FileInputStream(positiveAmountFile);
            bf = new BufferedReader(new InputStreamReader(fis, charset));
            String s;
            while ((s = bf.readLine()) != null) {
                String[] texts = s.split("\\|");
                if (texts.length != 5 || Strings.isNullOrEmpty(texts[1])) {
                    continue;
                }

                String transCode = texts[0];
                if (Strings.isNullOrEmpty(transCode) || transCode.startsWith("#")) {
                    continue;
                }

                positiveTransCodeSync.add(transCode);
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                //logger("error: ", ex);
            }
        }
    }


    public static void main(String[] args) {
        ReadConfiguration readConfiguration = new ReadConfiguration();
        try {
            readConfiguration.initConfigFile();
            readConfiguration.initChangeTransCodeDataFile();

            positiveTransCodeSync.forEach(System.out::println);
        } catch (DataNotExistException e) {
            e.printStackTrace();
        }
    }

}
