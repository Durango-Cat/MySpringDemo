package main.java.localtimemodel;


import com.google.common.collect.Lists;
import main.java.utils.TimesUtils;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Create by zhuqiuping
 * on 2017/3/27
 */
public class TimeTest {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//
//        localDate = LocalDate.ofYearDay(2017, 181);
//        System.out.println(localDate);
//
//        Clock clock = Clock.systemDefaultZone();  //获取系统默认时区
//        long missis = clock.millis();
//        System.out.println(missis);

//        HashMap hashMap = new HashMap();
//        hashMap.put("1", "23");
////        String key,value;
//        hashMap.forEach((key ,value) -> {
//            System.out.println(hashMap.get(key));
//        });

        long millis = System.currentTimeMillis();
        System.out.println(getStartTime(millis));
        System.out.println("endTime : " + getEndTime(millis));
        //System.out.println(zeroTime(System.currentTimeMillis()));
    }

    private static Long zeroTime(Long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time * 1000L));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime().getTime() / 1000;
    }

    private static int getStartTime(long millis) {
        Calendar start = Calendar.getInstance();
        start.setTimeInMillis(millis);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        start.add(Calendar.DATE, -1);
        Double from = TimesUtils.getUTCTimestampWithMilliseconds(start.getTime().getTime());
        return from.intValue();
    }

    /**
     * 根据当前世界获取同步Mapping最晚的时间
     * 默认查询现在至头一天00:00的Mapping
     *
     * @param millis millis
     * @return (s)
     */
    private static int getEndTime(long millis) {
        Calendar start = Calendar.getInstance();
        start.setTimeInMillis(millis);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Double from = TimesUtils.getUTCTimestampWithMilliseconds(start.getTime().getTime());
        return from.intValue();
    }

    @Test
    public void test() {
        //String 类型转localDate
        //LocalDate beginDateTime = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern(“yyyy-MM-dd”));
        //
        ////date类型转localDate
        //Date dates = new SimpleDateFormat(“yyyyMM”).parse(cycle);
        //Instant instant = dates.toInstant();
        //ZoneId zoneId = ZoneId.systemDefault();
        //LocalDate localDate = instant.atZone(zoneId).toLocalDate();

        LocalDate localDate = Instant.ofEpochSecond(System.currentTimeMillis() / 1000L).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        long lastMonthTime = getLastMonthTimeTest();
        System.out.println(lastMonthTime);
        LocalDate lastMonthTimeLocalDate = Instant.ofEpochSecond(lastMonthTime).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        //long between1 = ChronoUnit.DAYS.between(localDate, lastMonthTimeLocalDate);
        //System.out.println(between1);
        //System.out.println(lastMonthTimeLocalDate.until(localDate).getDays());
        System.out.println(lastMonthTimeLocalDate.until(localDate, ChronoUnit.DAYS));
    }

    @Test
    public void test1() {
        Long from = getLastMonthTimeTest()*1000L;
        System.out.println(from/1000L);
        Long to = System.currentTimeMillis();
        LocalDate fromLocalDate = Instant.ofEpochMilli(from).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        LocalDate toLocalDate = Instant.ofEpochMilli(to).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        long day = fromLocalDate.until(toLocalDate, ChronoUnit.DAYS);
        List<List<Long>> fromAndToList = Lists.newArrayList();
        if(day == 0) {
            fromAndToList.add(Lists.newArrayList(from/1000, to/1000 - 1));
        } else {
            long endZeroTime = tomorrowZeroTime(from);
            for(int i = 0; i < day+1; i++) {
                if(endZeroTime > to || i == day) {
                    fromAndToList.add(Lists.newArrayList(endZeroTime - 86400L, to/1000 - 1));
                } else if(endZeroTime <= to) {
                    if (i == 0) {
                        fromAndToList.add(Lists.newArrayList(from/1000, endZeroTime - 1));
                    } else {
                        fromAndToList.add(Lists.newArrayList(endZeroTime - 86400L, endZeroTime - 1));
                    }
                }
                endZeroTime += 86400;
            }
        }
        System.out.println(fromAndToList);
    }

    /**
     * 获取明天的凌晨零点的时间戳
     *
     * @param timeMillis 毫秒时间级别
     */
    private Long tomorrowZeroTime(Long timeMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeMillis);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis() / 1000L;
    }

    private long getLastMonthTimeTest() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.HOUR, -1);
        cal.set(Calendar.DATE, 28);
        return cal.getTime().getTime() / 1000;
    }
}
