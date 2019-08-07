package main.atziji.java.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * 日期测试
 *
 * @author ZhuQiuPing
 *         on 2018/5/17
 */
public class DateTest {

    @Test
    public void advanceDateTest() {
        Calendar calendar=new GregorianCalendar();
        Long todayTime = calendar.getTimeInMillis();
        Date date = new Date();
        date.setTime(todayTime);
        String startAt = new SimpleDateFormat("yyyy-MM").format(date);
        System.out.println("当时日期是:"+ startAt);
        calendar.add(Calendar.DATE, -30);
        Long lastMonthTime = calendar.getTimeInMillis();
        date.setTime(lastMonthTime);
        String lastStartAt = new SimpleDateFormat("yyyy-MM").format(date);
        System.out.println("30天前是:"+ lastStartAt);
    }

    @Test
    public void stringTest() {
        //String str = "新晋少福晋，前来请安";
        //String subStr = "前来请安bubu";
        //String firstStr = "新";
        String firstStr = "ttttt_2018_04-29";
        //String twoStr = "ttttt_2018_04-24";
        //String threeStr = "ttttt_2018_05-21";
        //String fourStr = "ttttt_2018_04-22";
        //String fiveStr = "ttttt_2018_04-27";
        //String sixStr = "ttttt_2018_04-25";
        //List<String> strList = Lists.newArrayList();
        //strList.add(sixStr);
        //strList.add(fiveStr);
        //strList.add(fourStr);
        //strList.add(threeStr);
        //strList.add(twoStr);
        //strList.add(firstStr);
        //
        //strList.forEach(System.out::println);
        //Collections.sort(strList);
        //strList.forEach(System.out::println);
        //firstStr = "202818_#23";
        //System.out.println(firstStr.indexOf("-"));
        String strs = "xxsxscs2#@#43420239。。。。231=+321212|{网易云！#2#2$%^&*$#@音乐";
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regEx);
        System.out.println(pattern.matcher(strs).replaceAll("").trim());
    }

    @Test
    public void breakTest() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.println(j);
                if(i == 2 && j == 1) {
                    break;
                }
            }
        }
    }

    @Test
    public void yesterdayTest() {
        Long to = System.currentTimeMillis();
        Calendar cale = Calendar.getInstance();
        cale.setTimeInMillis(to);
        //cale.add(Calendar.DATE, -1);
        //cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        //cale.set(Calendar.MILLISECOND, 0);
        Long from = cale.getTimeInMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
        System.out.println(simpleDateFormat.format(new Date(from)));

        to = 1560692760000L;
        cale.setTimeInMillis(to);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        System.out.println(simpleDateFormat.format(cale.getTime()));
    }

    /**
     * 测试时间戳到23点时开始时间还是前一天的23点，时间戳到23点之后开始时间就是今天的23点
     */
    @Test
    public void testElevenClock() {
        //Long to = 1547105040 * 1000L;
        Long to = 1547132700 * 1000L;
        Calendar cale = Calendar.getInstance();
        cale.setTimeInMillis(to);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        //都是小于等于23点时，结束时间看的是昨天的23点
        if("23:00:00".compareTo(simpleDateFormat.format(new Date(to))) >= 0) {
            cale.add(Calendar.DATE, -1);
        }
        cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        Long from = cale.getTimeInMillis();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(from)));
    }

}
