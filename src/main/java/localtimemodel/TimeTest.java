package main.java.localtimemodel;


import java.util.HashMap;

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

        HashMap hashMap = new HashMap();
        hashMap.put("1", "23");
//        String key,value;
        hashMap.forEach((key ,value) -> {
            System.out.println(hashMap.get(key));
        });
    }
}
