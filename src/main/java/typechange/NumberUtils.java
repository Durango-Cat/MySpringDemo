package main.java.typechange;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * number类型的数值转换
 *
 * @author ZhuQiuPing
 *         on 2018/10/24
 */
public class NumberUtils {


    private static final NumberFormat formatter;
    //星期描述
    private static final String[] WEEK_CHINA = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    static {
        formatter = NumberFormat.getNumberInstance();
        formatter.setGroupingUsed(false);
        formatter.setRoundingMode(RoundingMode.HALF_UP);
    }

    /**
     * Float类型的入参会被自动转换成double类型。
     * 2.3F -> 2.299999952316284D，再经过格式化后，原来是直接向下取舍的话，就变成2.29啦。
     * @param o 格式化的值
     */
    public static String format(Float o) {
        if (o == null) {
            return null;
        }
        formatter.setMaximumFractionDigits(2);
        BigDecimal bigDecimal = new BigDecimal(o + "");
        return formatter.format(bigDecimal);
    }

    public static String format(Double o) {
        if (o == null) {
            return null;
        }
        formatter.setMaximumFractionDigits(2);
        BigDecimal bigDecimal = new BigDecimal(o + "");
        return formatter.format(bigDecimal);
    }

    public static String format(Float o, int digits) {
        if (o == null) {
            return null;
        }
        formatter.setMaximumFractionDigits(digits);
        BigDecimal bigDecimal = new BigDecimal(o + "");
        return formatter.format(bigDecimal);
    }

    public static String format(Double o, int digits) {
        if (o == null) {
            return null;
        }
        formatter.setMaximumFractionDigits(digits);
        return formatter.format(o);
    }

    public static Double getDoubleValue(Object obj) {
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception e) {
            throw new NumberFormatException(obj + " is not number");
        }
    }

    public static String number_with_delimiter(long count) {
        String temp = "" + count;
        String parts[] = temp.split("\\.");
        String countStr = "";
        for (int i = 0; i < parts[0].toCharArray().length; i++) {
            countStr = parts[0].toCharArray()[parts[0].toCharArray().length - i - 1] + countStr;
            if (i != parts[0].toCharArray().length - 1 && (i + 1) % 3 == 0)
                countStr = "," + countStr;
        }
        return countStr;
    }

    /**
     * 计算成功率或响应率
     * @param countList
     * @return
     */
    public static List<List<Object>> getRateFromList(List<List<Object>> countList){
        List<List<Object>> retList = Lists.newArrayList();
        for (List<Object> countItem : countList) {
            Long timestamp = (Long) countItem.get(0);
            Double memberCount = (Double)countItem.get(1), totalCount = (Double) countItem.get(2);

            List<Object> memberRateItem = new ArrayList<Object>(2);
            memberRateItem.add(timestamp);
            if(totalCount > 0){
                memberRateItem.add(Double.parseDouble(format(memberCount * 100f / totalCount)));
            }else{
                memberRateItem.add(null);
            }
            retList.add(memberRateItem);
        }
        return retList;
    }

    /**
     * 数字转大写描述，支持1-10
     *
     * @param num num
     * @return 大写描述结果
     */
    public static String numberUppercase(int num) {

        if (num < 1 || num > 10) {
            throw new NumberFormatException("数字转大写描述错误，num =" + num);
        }
        switch (num) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            default:
                throw new NumberFormatException("数字转大写描述错误，num =" + num);
        }
    }

    /**
     * 数字转大写描述，支持1-10
     *
     * @param prefix 描述前缀
     * @param num    num
     * @return 描述结果
     */
    public static String numberUppercase(String prefix, int num) {

        return prefix + numberUppercase(num);
    }

    /**
     * 数字转大写描述，支持1-10
     *
     * @param prefix 描述前缀
     * @param num    num
     * @param suffix 描述后缀
     * @return 描述结果
     */
    public static String numberUppercase(String prefix, int num, String suffix) {

        return prefix + numberUppercase(num) + suffix;
    }

    /**
     * 数字转大写描述，支持1-10
     *
     * @param num    num
     * @param suffix 描述后缀
     * @return 描述结果
     */
    public static String numberUppercase(int num, String suffix) {

        return numberUppercase(num) + suffix;
    }

    /**
     * 数字转星期描述
     *
     * @param num 1-7
     * @return 星期[一/二/..../日] 描述
     */
    public static String numberWeekChinal(int num) {
        if (num < 1 || num > 7) {
            throw new NumberFormatException("星期数字为[1-7]，num =" + num);
        }
        return WEEK_CHINA[num - 1];
    }
}
