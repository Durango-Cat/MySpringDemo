package main.atziji.java.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author ZhuQiuPing
 *         on 2018/11/12
 */
public class TestList {

    @Test
    public void testOne() {
        List<String> indexList = Lists.newArrayList();
        indexList.add("ezsonar_2018-09");
        indexList.add("ezsonar_2018-12");
        indexList.add("ezsonar_2018-10");
        indexList.add("ezsonar_2018-06");
        indexList.add("ezsonar_2018-10");
        indexList.add("ezsonar_2018-07");
        indexList.add("ezsonar_2018-08");

        indexList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        indexList.forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        //List<String> numberList = Lists.newArrayList();
        //numberList.add("  0011400");
        //numberList.add("  0013900");
        //System.out.println(numberList.("0013900"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Test
    public void testThree() {
        //Double xx = 100D;
        //Double xx2 = 10000_0000D;
        //System.out.println(Math.pow(xx, 0.5));
        //System.out.println(Math.pow(xx2, 0.5));
        BigDecimal bigDecimal = new BigDecimal("0");
        //bigDecimal = ;
        System.out.println(bigDecimal.add(new BigDecimal("123434.5")));
    }

    @Test
    public void testFloat() {
        //Double ss = 34534.23D;
        //Double rr = 0.232342D;
        String rrr = "substringlookme";
        int length = rrr.length();
        String rr = rrr.substring(rrr.length() - 3, length);
        System.out.println(rr);
        //System.out.println(new BigDecimal(rr).divide(new BigDecimal(ss)).toPlainString());
    }
}
