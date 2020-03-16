package main.atziji.string;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 测试字符串的一些用法
 *
 * @author ZhuQiuPing
 *         on 2018/2/9
 */
public class StringTest {

    @Test
    public void testOne() {
        //String str;
        //str += "23";

        //String change = "ezsonar_2019-09-29-01";
        //System.out.println(change.substring(0, change.lastIndexOf("-")));
        //int size = 5;
        //size = (size + size) >> 1;
        //System.out.println(size);

        //String[] str = {};
        //System.out.println(str.length);
        //String str = " 232  32323     ";
        //System.out.println(str.trim());
        //List<String> list = Lists.newArrayList("WEDQWED", "2121", "434323", "121454", "ewwdea", "adWED ");

        //List<String> otherList = Lists.newArrayList("2121", "21fefsf", "dwewweg", "121454", "errffkadv", "dqwdeqe");
        //if(list.retainAll(otherList)){
        //    System.out.println(list);
        //}
        //otherList.retainAll(list);
        //List<String> subList = list.subList(0, 0);
        //System.out.println(otherList);

        //String jump = new String("60");
        //int index = jump.indexOf(".");
        //System.out.println(Integer.parseInt(jump.substring(0,index)));

        //Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.DATE, -3);
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String beforeThreeDaysTime = simpleDateFormat.format(new Date(cal.getTimeInMillis())) + " 23:00:00";
        ////三天前23点的时间戳
        //try {
        //    Long time = simpleDateFormat.parse(beforeThreeDaysTime).getTime();
        //    System.out.println(time);
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}

        //System.out.println(DataType.ALL_INFO.toString());

        String str = "null,454545";
        String[] xsxs = str.split(",");
        String xx = xsxs[0];
        System.out.println(xx);
    }

    @Test
    public void testTwo() {
        List<Integer> streamIdList = Lists.newArrayList();
        streamIdList.add(1);
        streamIdList.add(2);
        streamIdList.add(3);
        streamIdList.add(4);
        streamIdList.add(5);
        streamIdList.add(6);
        streamIdList.add(7);

        Iterator<Integer> iterator = streamIdList.iterator();
        while(iterator.hasNext()) {
            Integer number = iterator.next();
            if(number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println(streamIdList.size());
    }

    @Test
    public void testThree() {
        String[] metric = new String[]{"is_sys_success_fail_count", "count", "customized", "latency_msec"};
        System.out.println(Arrays.asList(metric).contains("count"));

    }

    @Test
    public void testFour() {
        //Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -15);
        //calendar.add(Calendar.YEAR, -1);
        Long lastPreserved = calendar.getTimeInMillis();
        System.out.println(lastPreserved);
        Date date = calendar.getTime();
        String lastPreservedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(lastPreservedTime);
    }

    @Test
    public void testFive() {
        String[] dateStr = new String[]{"bbb20171012", "bbb20170221", "bbb20180211", "bbb20180101", "bbb20190918"};
        List<String> dateList = Arrays.asList(dateStr);
        Collections.sort(dateList);
        //dateList.forEach(System.out::println);

        for(String date : dateList) {
            String temp = date.substring(3, date.length());
            System.out.println(temp);
            //表示小于2017-04-11的数值
            if("20170411".compareTo(temp) > -1) {

                System.out.println("略略略");
            } else {
                System.out.println(date);
            }
        }
    }

    @Test
    public void testSix() {
        String path = "/Users/zhuqiuping/java/test";
        File directory = new File(path);
        if(directory.exists()) {
            if(directory.isDirectory()) {
                String[] files = directory.list();
                if(files != null && files.length > 0) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                    String todayTime = simpleDateFormat.format(new Date());

                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DATE, -6);
                    String timeBeforeSixDay = simpleDateFormat.format(calendar.getTime());
                    System.out.println(timeBeforeSixDay + "-----6天前的日期");
                    List<String> fileList = Arrays.asList(files);
                    //Collections.sort(fileList);
                    //Iterator<String> iterator = fileList.iterator();
                    for (String file : fileList) {
                        String fileTemp = file.substring(0, 8);
                        System.out.println(file);
                        //表示小于之前那个数值或者大于等于今天的数值都会删掉
                        if(todayTime.compareTo(fileTemp) <= 0 || timeBeforeSixDay.compareTo(fileTemp) > 0) {
                            System.out.println(path+file);
                            File deleteFile = new File(path+ "/"+ file);
                            deleteFile.delete();
                            //iterator.remove();
                        }
                    }
                }
            }
        } else {
            directory.mkdirs();
        }
    }

    @Test
    public void testSeven() {
        String[] test = new String[]{"xsxs", "abcd", "edfg", "hijk", "banana", "blance"};
        List<String> testList = Lists.newArrayList(Arrays.asList(test));
        System.out.println(testList.remove("apple"));
        System.out.println(testList.remove("blance"));
        testList.forEach(System.out::println);
    }

    @Test
    public void testIntegerMax() {
        Integer int123 = new Integer(123);
        int er3 = 123;

        System.out.println(er3 == int123);

        Integer int128 = new Integer(128);
        Integer er8 = new Integer(128);
        System.out.println(er8 == int128);
        System.out.println(int128.equals(er8));
    }

    @Test
    public void testEight() {
        long timeLength = (1573660740L - 1573401600) / 86400L;
        System.out.println(timeLength);
        System.out.println(timeLength * 3370);

        //System.out.println(10<<<3);
        //Number ss = new Double(234243.23);
        //System.out.println(ss.toString());
        //String test = "xsxsxs";
        //String xx = null;
        //if(xx.equals(test)) {
        //    System.out.println("xx is null");
        //}
        //else

          //equals后面的比较的为空时，查询的结果用为false
        //    if(test.equals(xx)) {
        //    System.out.println("test is not null");
        //}
    }

    @Test
    public void testNine() {
        String[] xxx = new String[10];
        for(int i = 0; i < 10; i++) {
            if(i == 5) {
                xxx[i] = "5";
                System.out.println(xxx[i] + "~~~~~~");
                continue;
            }

            if(Strings.isNullOrEmpty(xxx[i])) {
                System.out.println(xxx[i]);
            }
        }
        System.out.println();

        for(int i = 0; i < 10; i++) {
            System.out.println(xxx[i] + "\t");
        }
    }

    @Test
    public void testExport() {
        List<String> lists = Lists.newArrayListWithExpectedSize(10);
        lists.add(3, "222");
        lists.forEach(System.out::println);
    }


    @Test
    public void testDateSimpleDate() {
        Long time = System.currentTimeMillis();
        Date date = new Date();
        Long yesterdayTime = time / 1000 - 86400;
        //date.setTime(time);
        date.setTime(yesterdayTime * 1000);
        String startAt = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(startAt);
    }

    private Long initDateByDay(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    @Test
    public void testTime() {
        Long time = System.currentTimeMillis()/1000;
        System.out.println(time);
        Date date = new Date();
        date.setTime(time * 1000);
        String startAt = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(startAt);
        time -= 86400;
        Long yesterdayTime = initDateByDay(time * 1000);
        date.setTime(yesterdayTime);
        startAt = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(startAt);
    }


    @Test
    public void testStringSort() {
        List<String> sss = Lists.newArrayList();
        sss.add("djf");
        sss.add("xsd.swfw");
        sss.add("aaa");
        sss.add("abc");
        sss.add("wew");
        sss.add("fdf");
        sss.add("dcdc");
        sss.add("gfg");
        sss.add("asx");
        sss.add("wev");
        sss.add("cssc");
        sss.add("zdf");

        Collections.sort(sss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //表示倒叙
                return o1.compareTo(o2) >= 0 ? -1 : 1;
                //if(o1.compareTo(o2) >= 0) {
                //
                //}
            }
        });

        sss.forEach(System.out::println);
    }


    @Test
    public void testDouble() {
        //BigDecimal b2 = new BigDecimal("100");
        //BigDecimal b3 = new BigDecimal("1.333");
        //System.out.println(b3.subtract(b2).doubleValue());
        //System.out.println(b3.multiply(b2).doubleValue());

        //Double d = 1.333D;
        //System.out.println(d * 100);
        Double xx = 152711299515232D;
        System.out.println(xx.longValue());
        System.out.println(xx);
    }

    /**
     * 强制保留3位小数
     */
    @Test
    public void testFloat() {
        Long count1 = 3234234234L;
        Long count2 = 10032L;
        //Double f = count2 * 100D / count1;
        Double f = 100D;
        System.out.println(f);
        BigDecimal obj = new BigDecimal(f).setScale(3, BigDecimal.ROUND_HALF_DOWN);
        DecimalFormat df = new DecimalFormat( "#0.000");
        if(obj.compareTo(BigDecimal.ZERO)==0 || obj.toPlainString().equals("0.000")) {
            System.out.println(0);
        } else if(obj.compareTo(new BigDecimal(100)) >= 0) {
            System.out.println(100);
        }else {
            System.out.println(Float.parseFloat(df.format(obj).toString()));
        }
        //String value = df.format(f);
        //System.out.println(Float.parseFloat(value));
    }

    @Test
    public void testStringss() {
        //int tokenIdIndex = url.indexOf("tokenId=") + 8;
        //String firstUrl = url.substring(0, tokenIdIndex);
        //System.out.println((tokenIdIndex + needReplace.length()) +  "  " + url.length());
        //String endUrl = url.substring(tokenIdIndex + needReplace.length(), url.length());
        //System.out.println(firstUrl + needReplace + endUrl);
        //String url = "http://192.168.100.224:8085/ezsonar/apm/apps?tokenId=6c95d62e-e45f-4598-b0d6-12ccdcacc662";
        String url = "apps?tokenId=6c95d62e-e45f-4598-b0d6-12ccdcacc662";
        String needReplace = "6c99ws2e-j41f-tg98-c3d6-xc34dcaccbgt";


    }

    @Test
    public void testString() {
        //String RET_CODE_METRIC = "_ret_code.";
        //String metric = "_ret_code.RC";
        //System.out.println(metric.contains(RET_CODE_METRIC));

        //String baseline = "23.233434345E+12";
        //BigDecimal bd1 = new BigDecimal(baseline);
        //System.out.println(bd1.toPlainString());
        String str = "234234/234234234234";
        System.out.println(str);
        str = str.replace("/", "-");
        System.out.println(str);
    }

    /**
     * 测测jvm是否是原子性
     */
    @Test
    public void testJVMIsVolatile() {
        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch + "-bits");
    }

    @Test
    public void testStringOne() {
        List<String> strList = Lists.newArrayList();
        strList.add("33.46%");
        strList.add("100%");
        strList.add("57.12%");
        strList.add("98.23%");
        strList.add("33.46%");
        strList.add("44.34%");
        strList.add("--");
        strList.add("--");

        Collections.sort(strList);

        strList.forEach(System.out::println);
    }

    @Test
    public void testStringSubString() {
        String summaryIndex = "analyzier_2018";
    }

    private String sss() throws RuntimeException {
        throw new RuntimeException("我只是想看看");
    }

    public String throwExceptionInfo() throws RuntimeException {
        String str = "likeme";
        if(!Strings.isNullOrEmpty(str)) {
            //return str;
            sss();
            //throw new RuntimeException("我只是想看看你");
        }
        return str;
    }

    @Test
    public void testException() {
        //try {
        //    List<String> strList = Lists.newArrayList();
        //    strList.add("3232");
        //    for(int i = 0; i < 10; i++) {
        //        try {
        //            strList.add(throwExceptionInfo());
        //        } catch (RuntimeException e) {
        //            System.out.println("piapiapia");
        //        }
        //        //System.out.println(strList.size());
        //    }
        //    strList.forEach(System.out::println);
        //} catch (Exception e) {
        //    System.out.println("dwwdwe");
        //}
        //String xx1 = "2342";
        //String xx2 = "33434";
        //compareXX(xx1, xx2);
        //System.out.println(xx1);

        String[] str1 = new String[]{"231", "3434", "ewe", "23212", "dsde"};
        Set<String> set1 = Sets.newHashSet();
        set1.add("xe");
        set1.add("231");
        set1.add("2313");
        set1.add("3434");

        System.out.println(set1.size());
        Collections.addAll(set1, str1);
        System.out.println("size : " + set1.size());
    }

    public void compareXX(String xx1, String xx2) {
        xx1 = "";
        xx2 = xx1;
        if(xx1.equals(xx2)) {
            System.out.println("一样");
        }
    }

    @Test
    public void testFours() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Long zeroTime = c.getTimeInMillis()/1000;
        Long time = System.currentTimeMillis() / 1000;
        //取整
        time = time - time % 60L;

        if((time - zeroTime) % 120L < 120L) {
            time = zeroTime + ((time - zeroTime) / 120L) * 120L;
        }

        System.out.println(time);
    }

    @Test
    public void testSixs() {
        FileInputStream fis = null;
        BufferedReader bf = null;
        try {
            String maxCountFile = "/Users/zhuqiuping/java/apache-tomcat-7.0.62/conf/ezsonar/yinlianguojiBank_data/maxCountCountry.txt";
            Map<String, String> maxCountSync = Maps.newLinkedHashMap();
                fis = new FileInputStream(maxCountFile);
            //里面有中文，所以编码就不是utf-8了
            try {
                bf = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String s;

            while ((s = bf.readLine()) != null) {
                //分隔出来的第一个数值为国家名或者渠道交易量里面的几种类别，第二个为对应的峰值
                String[] texts = s.split("\\|");

                if (!Strings.isNullOrEmpty(texts[0]) && !Strings.isNullOrEmpty(texts[1])) {
                    String name = texts[0].trim();
                    String countAndTime = texts[1].trim();
                    maxCountSync.put(name, countAndTime);
                }
            }

            for(Map.Entry<String, String> entry : maxCountSync.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (FileNotFoundException e) {

        } catch (UnsupportedEncodingException e) {

        } catch (IOException e) {

        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    @Test
    public void testSwithCase() {
        String type = null;
        switch (type) {
            case "123":
                System.out.println("嘿嘿");
                break;
                default:
                    System.out.println("哈哈");
                    break;
        }

    }

    @Test
    public void testZhengze() {
        String xx = "^(?![a-z]+$)(?![A-Z]+$)(?!\\d+$)(?![~!#^&*()+$@%_]+$)";

    }

    @Test
    public void test() {
        String indexPrefixAndSuffix = "2020-01-06-18";
        SimpleDateFormat hourDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        String todayHour = hourDateFormat.format(new Date());
        System.out.println(todayHour);
        int xxx = (indexPrefixAndSuffix.compareTo(todayHour));
        System.out.println(xxx);
        System.out.println(xxx <= 0);
    }

}
