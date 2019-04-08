package main.atziji.string.test;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author ZhuQiuPing
 *         on 2018/11/5
 */
public class TestString {

    /**
     * 字节数组放到字符串中就会变成字符串
     */
    @Test
    public void testOne() {
        char[] data = new char[]{'a', 'b', 'c'};
        System.out.println(new String(data));
    }

    @Test
    public void testTwo() {
        System.out.println(getTodayTime());
    }

    public String getTodayTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date);
    }

    @Test
    public void testString() {
        List<String> sss = Lists.newArrayList();
        sss.add("xsxss");
        sss.add("zccdcd");
        sss.add("22323");
        //Joiner.on(",")
    }

    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        //sb.append("23");
        //sb.append(",");
        //sb.append("22");
        //sb.append(",");
        //System.out.println(sb.toString());
        sb.delete(0, sb.length());
        sb.append("23--");
        sb.append("23");
        System.out.println(sb.toString());
    }

    @Test
    public void testStringInfo() {
        //Long nowTime = System.currentTimeMillis() / 1000;
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String todayFormat = simpleDateFormat.format(new Date());
        //String indexTime = "2018-11-18";
        //try {
        //    Long to = simpleDateFormat.parse(indexTime).getTime() / 1000;
        //    System.out.println(nowTime % to);
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}

        BigDecimal b1 = new BigDecimal("323");
        BigDecimal b2 = new BigDecimal("4555");
        String netting = b1.subtract(b2).toPlainString();
        System.out.println(netting);
    }

    @Test
    public void testStringOne() throws ParseException {
        String index = "ezsonar_2018-11-18";
        Long nowTime = System.currentTimeMillis() / 1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayFormat = simpleDateFormat.format(new Date());
        String indexTime = index.substring(index.indexOf("_") + 1, index.length());
        Long to = simpleDateFormat.parse(indexTime).getTime() / 1000;
        if(nowTime > to) {
            long interval = (nowTime % to) / 86400;
            System.out.println(interval);
        }
    }

    private boolean less(String itemLeft, String itemRight) {
        return itemLeft.compareTo(itemRight) <= 0;
    }

    @Test
    public void testYouThink() {
        String nullS = null;
        String yours = "";
        //会报空指针异常
        switch (nullS) {
            case "0":
                yours = "0";
                break;
                default:
                    yours = "为空啊";
                    break;
        }

        System.out.println(yours);
    }

    @Test
    public void testTimeStamp() {
        String date1 = "1201235903";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        try {
            System.out.println(simpleDateFormat.parse(date1).getTime());
            date1 = year + date1;
            System.out.println(date1);
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            System.out.println(simpleDateFormat.parse(date1).getTime()/1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testYear() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR) + "");
    }

    @Test
    public void testStringBuffer() {
        String str = "12,23,34,45,56,67,78,89,90";
        System.out.println(str.contains("0"));
    }

    @Test
    public void testYinYONG() {
        List<User> strList = Lists.newArrayList();
        User user = new User("小明");
        strList.add(user);
        user = new User("小黑");
        strList.add(user);

        strList.forEach(System.out::println);
    }

    class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testStrContains() {
        String str = "ATM类";
        System.out.println(str.contains("ATM"));
    }

    @Test
    public void testStrs() {
        String str = "北京分行-西城支行-" + "";
        System.out.println(str.split("-").length);
    }

    @Test
    public void testTime() {
        //long time = System.currentTimeMillis() / 1000;
        //取整
        //time = time - time % 60;

        //    Calendar cal = Calendar.getInstance();
        //    cal.add(Calendar.DATE, -3);
        //cal.set(Calendar.HOUR_OF_DAY,0);
        //cal.set(Calendar.MINUTE,0);
        //cal.set(Calendar.SECOND,0);
        //    //cal.set(Calendar.MILLISECOND, 0);
        //long time = (cal.getTimeInMillis()/1000);

        long time = 1545838245 * 1000L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date(time)));

    }

    @Test
    public void testThree() {
        String xxx = null;
        String show;
        switch (xxx) {
            case "1":
                show = "23213";
                break;
            default:
                show = "你我他";
                break;
        }
        System.out.println(show);
    }

    //@Test
    //public void testFour() {
    //    Float number = 0.2345678F;
    //    String ewweq = number+"";
    //    int index = numberInfo.indexOf(".");
    //    if(index != -1) {
    //        System.out.println(numberInfo.length() - 1 - index);
    //    }
    //}

    @Test
    public void testCompartTo() {
        String a = "Z";
        String b = "C";
        System.out.println(a.compareTo(b));
    }

    /**
     * 测试两个布尔值的判断条件
     */
    @Test
    public void testStringNew() {
        String one = "123";
        String two = "456";

        Boolean flag = !(Strings.isNullOrEmpty(one) && Strings.isNullOrEmpty(two));
        System.out.println("两个字符串都不为空" + flag);

        one = "";
        flag = !(Strings.isNullOrEmpty(one) && Strings.isNullOrEmpty(two));
        System.out.println("一个字符串为空，另一个字符串不为空" + flag);

        one = "123";
        two = "";
        flag = !(Strings.isNullOrEmpty(one) && Strings.isNullOrEmpty(two));
        System.out.println("一个字符串为空，另一个字符串不为空" + flag);

        one = "";
        flag = !(Strings.isNullOrEmpty(one) && Strings.isNullOrEmpty(two));
        System.out.println("两个字符串为空" + flag);
    }

    @Test
    public void testDouble() {
        double bigNum = 2345353453453453445246345634634563463463563563456D;
        double bigNum2 = 23453534534534534452463456346345634634635635634D;
        System.out.println((bigNum - bigNum2) * 100 / bigNum2);
    }

    /**
     * 比较带有字符串的数据是否一致
     */
    @Test
    public void testCompareStrings() {
        String str1 = "成功率 ≥ 100 %";
        String str2 = "成功率 > 90 %";
        Set<String> strSet = Sets.newHashSet();
        strSet.add(str1);
        strSet.add(str2);

        String str3 = "成功率 > 100 %";
        strSet.add(str3);
        System.out.println(strSet.size());
    }

    @Test
    public void testCompareString() {
        Object nullStr = "2344234";
        String one = null;
        String info = one + "-" + nullStr;
        String[] infos = info.split("-");
        System.out.println(infos.length);
        //BigDecimal bigDecimal = new BigDecimal(0);
        //System.out.println(bigDecimal.toPlainString());

        //BigDecimal b1 = new BigDecimal(123);
        //BigDecimal b2 = new BigDecimal(-1);
        //System.out.println(b1.multiply(b2).toPlainString());
    }

    @Test
    public void testList() {
        List<VisualCondition> visualConditionList = Lists.newArrayList();
        getConditionList(1, null, "pie.default", 4, visualConditionList);
        visualConditionList.forEach(System.out::println);
    }

    List<String> metricAndCalculations = Lists.newArrayList("COUNT", "LATENCY_MSEC",
            //"RESPONSE_COUNT", "RESPONSE_FAIL_COUNT", "SUCCESS_COUNT",
            //"FAILED_COUNT", "BUSINESS_SUCCESS_COUNT", "BUSINESS_FAILED_COUNT",
            "RTT", "TRANS_AMOUNT");

    private void getConditionList(int num, Integer index, String visualType, int showSize, List<VisualCondition> visualConditions) {
        while (num-- >= 0) {
            for (int i = 0; i < showSize; i++) {
                if(num ==0 || index == null) {
                    index = i;
                } else {
                    if (index == i) {
                        continue;
                    }
                }
                getConditionLists(visualConditions, i, visualType);
                getConditionList(num, i, visualType, showSize, visualConditions);
                //if(num == 0) {

                //}

            }
        }
    }

    private void getConditionLists(List<VisualCondition> visualConditions, int index, String visualType) {
        String metric = metricAndCalculations.get(index);
        visualConditions.add(getConditionInfo(metric, visualType));
        System.out.println(metric);
    }

    private VisualCondition getConditionInfo(String metricAndCalculation, String visualType) {
        VisualCondition visualCondition = new VisualCondition();
        visualCondition.setMetric(metricAndCalculation);
        visualCondition.setChartType(visualType.split("\\.")[0]);
        return visualCondition;
    }

    private class VisualCondition {
        private String metric;
        private String chartType;

        public String getMetric() {
            return metric;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public String getChartType() {
            return chartType;
        }

        public void setChartType(String chartType) {
            this.chartType = chartType;
        }

        public VisualCondition() {
        }

        @Override
        public String toString() {
            return "VisualCondition{" +
                    "metric='" + metric + '\'' +
                    ", chartType='" + chartType + '\'' +
                    '}';
        }
    }

    /**
     * 测试Number类型数值为null时能存储的情况
     */
    @Test
    public void testNumber() {
        Number[] numbers = new Number[2];
        numbers[0] = null;
        numbers[1] = null;
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
    }

    /**
     * 测试Number类型数值转换成string类型的是会显示值还是显示的是内存
     * 结果：显示的是值，数值大了会是科学计数法的数字类型
     */
    @Test
    public void testNumberParseString() {
        Number number = 131312313123512511F;
        System.out.println(number.toString());
    }
}
