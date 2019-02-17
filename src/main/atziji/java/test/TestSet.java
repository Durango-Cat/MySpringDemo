package main.atziji.java.test;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @author ZhuQiuPing
 *         on 2018/11/15
 */
public class TestSet {

    @Test
    public void testOne() {
        Set<String> strSet = Sets.newLinkedHashSet();
        //strSet.add("123");
        strSet.add("43");
        strSet.add("434");
        strSet.add("rww");
        strSet.add("yfg");

        Set<String> xxSet = Sets.newLinkedHashSet();
        xxSet.add("cdfv");
        xxSet.add("123");
        xxSet.add("0987");
        //xxSet.add("43");
        xxSet.add("rww");
        xxSet.add("yfg");
        xxSet.add("434");
        xxSet.add("xsa");
        xxSet.add("8954");

        strSet.retainAll(xxSet);
        System.out.println(strSet.size());
    }

    @Test
    public void testTwo() {
        //2018年12月26日 14：30：0
        long time = 1545805800 * 1000L;
        Date ping = new Date(time);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd MM:hh:ss");
        System.out.println(simpleDateFormat.format(cal.getTime()));
        int sec = 0;
        //if("logger_state".equals(type)){
        //    sec = cal.get(Calendar.SECOND)- SECONED_BEFORE_LOGGER;
        //}else{
        int timeSecond = cal.get(Calendar.SECOND);
        System.out.println(timeSecond);
        sec = timeSecond - 420;
        System.out.println(sec);
        //}
        cal.set(Calendar.SECOND, sec);
        Date d = cal.getTime();

        System.out.println(simpleDateFormat.format(d));
    }
}
