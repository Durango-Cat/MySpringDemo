package main.java.yinlianguoji.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhuQiuPing
 *         on 2018/10/30
 */
public class TestFile {
    /**
     * 读取文件时的编码
     */
    private static final String charset = "gb2312";

    @Test
    public void testOne() {
        String path = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar/yinlianguojiBank_data/change_trans_code.txt";
        File file = new File(path);

        System.out.println(file.isFile());

        System.out.println(file.exists());
    }

    @Test
    public void testTwo() {
        //Object to = (int)1540954847;
        String path = "/Users/zhuqiuping";
        File file = new File(path);
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();
        for(File fileTemp : files) {
            System.out.println(fileTemp.getPath());
            //System.out.println(fileTemp.getName());
        }
        //System.out.println((long) to);
    }

    @Test
    public void testThree() {
        String path = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar/yinlianguojiBank_data/IFO18100801RAT";
        File file = new File(path);

        FileInputStream fis = null;
        BufferedReader bf;
        try {

            fis = new FileInputStream(file);
            bf = new BufferedReader(new InputStreamReader(fis, charset));
            String s;

            Date date = new Date();
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            String dateInfo = "";
            //sdf.format(date);
            //System.out.print(dateInfo);
            dateInfo =  "20181008156";
            List<String> textList;
            while ((s = bf.readLine()) != null) {
                s = s.replace(" ", "|");
                if(s.indexOf("H") != 0 || s.indexOf("T") != 0) {
                    Iterable<String> texts = Splitter.on("|").omitEmptyStrings().split(s);
                    textList = Lists.newArrayList(texts);

                    String firstIndexStr = textList.get(0);
                    Integer index = firstIndexStr.indexOf(dateInfo);
                    if(index != -1) {
                        String code = firstIndexStr.substring(dateInfo.length(), firstIndexStr.length());
                        System.out.println(code + "---币种");
                        System.out.println(textList.get(3) + "---汇率");
                    }
                }

                //System.out.println(texts[0].indexOf("#"));
                //System.out.println(texts[0].toString());
                //System.out.println(!Strings.isNullOrEmpty(texts[0]));


                //Integer index = texts[0].indexOf(dateInfo);
                //if(texts[0].indexOf("H") != 0 && index != -1 && texts[0].indexOf("T") != 0) {
                //    String code = texts[0].substring(dateInfo.length(), texts[0].length());
                //    System.out.print(code + "----code\t");
                //    System.out.println(texts[3] + "对应的汇率");
                //    //System.out.println(texts[1]);
                //    //String xx = texts[1].substring(texts[1].indexOf("[") + 1, texts[1].indexOf("]"));
                //    //String[] xxStr = xx.split(",");
                //    //System.out.println(Float.parseFloat(xxStr[0].toString()));
                //    //System.out.println(Float.parseFloat(xxStr[1].toString()));
                //    //System.out.println((texts[1));
                //}
                //System.out.println(texts.length);

            }

        } catch (IOException e) {

        }
    }

    @Test
    public void testFour() {
        String dealedExchangeRates = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar/yinlianguojiBank_data/dealedExchangeRates.txt";

        String tableOnExchangeRates = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar/yinlianguojiBank_data/IFO18100801RAT";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            File dealedExchangeRatesFile = new File(dealedExchangeRates);
            if (dealedExchangeRatesFile.exists() && dealedExchangeRatesFile.isFile()) {
                dealedExchangeRatesFile.delete();
            }
            dealedExchangeRatesFile.createNewFile();

            File exchangeRatesTableFile = new File(tableOnExchangeRates);

            fis = new FileInputStream(exchangeRatesTableFile);
            bufferedReader = new BufferedReader(new InputStreamReader(fis, charset));
            String s;

            //Date date = new Date();
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateInfo = "";
            //sdf.format(date);
            dateInfo = "20181008156";
            //每行的数据封装的集合
            List<String> rowDataList;
            byte[] b;
            StringBuffer sb;
            bufferedWriter = new BufferedWriter(new FileWriter(dealedExchangeRates));
            while ((s = bufferedReader.readLine()) != null) {
                s = s.replace(" ", "|");
                //表示除去第一行和最后一行的行数据
                if (s.indexOf("H") != 0 || s.indexOf("T") != 0) {
                    Iterable<String> texts = Splitter.on("|").omitEmptyStrings().split(s);
                    rowDataList = Lists.newArrayList(texts);

                    String firstIndexStr = rowDataList.get(0);
                    Boolean contains = firstIndexStr.contains(dateInfo);
                    if (!contains || rowDataList.size() != 4) {
                        continue;
                    }
                    String code = firstIndexStr.substring(dateInfo.length(), firstIndexStr.length());
                    String exchangeRate = rowDataList.get(3);

                    if (!Strings.isNullOrEmpty(code) && !Strings.isNullOrEmpty(exchangeRate)) {
                        sb = new StringBuffer();
                        sb.append(code).append("|").append(exchangeRate);
                        bufferedWriter.write(sb.toString());
                        bufferedWriter.newLine();
                    }
                }
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                //LOGGER.info("银联国际定时获取汇率表 读入文件异常: ", e);
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                //LOGGER.info("银联国际定时获取汇率表 写出文件异常: ", e);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        //创建一个字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar/yinlianguojiBank_data/dealedExchangeRates.txt"));


        //写数据
        bw.write("hello");
        bw.write("world");

        //刷新流
        bw.flush();

        //关闭资源
        bw.close();
    }


    @Test
    public void testFile() {
        String fileName = "conf.properties.json";
        String filePath = "/Users/zhuqiuping/java/IdeaWorkSpace/branches/" +
                "huangHeNongShangHang/dev/src/main/webapp/screensLauncher/" +
                "realTimeTransaction/conf/conf.properties.json";

        File file = new File(filePath);
        if(!file.exists()) {
            System.out.println("读取文件失败了");
        }
        String json = readFile(filePath);
        JSONObject data = JSON.parseObject(json);

    }

    private static String readFile(String path) {
        StringBuilder stb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(path), StandardCharsets.UTF_8.name())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stb.toString();
    }
}
