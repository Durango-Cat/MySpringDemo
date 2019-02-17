package main.atziji.java.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Create by ZhuQiuPing
 * on 2017/8/29
 */
public class NullAndEmptyClassTest {

    public static void main(String[] args) {

//        List<String> lists = null;
//
//        if(null == lists || lists.isEmpty()) {
//            System.out.println("sssss");
//        }

//        String str = "asdfasdfasdfasdfa";
//        String[] strArr = str.split(",");
//        System.out.println(strArr.length);
//        System.out.println(strArr[0]);

//        Random random = new Random();
//        int val = random.nextInt(5);

//        System.out.println(val);

//        System.out.println(9 % 2);
        Double[] doubles = {32.0D, 31.0D, 27.0D, 32.0D, 28.0D, 27.0D, 27.5D, 26.4D, 26.8D, 27.3D, 32.4D, 32.1D,
                            31.6D, 30.4D, 32.2D, 26.6D, 27.1D, 28.2D, 23.1D, 33.0D};
        List<List<Object>> resultList = new ArrayList<>();
        for(int i = 0; i < doubles.length; i++) {
            List<Object> objectList = new ArrayList<>();
            objectList.add(new Integer(21312313));
            objectList.add(doubles[i]);
            resultList.add(objectList);
        }


        resultList.sort(new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                Double data1 = (Double)o1.get(1);
                Double data2 = (Double)o2.get(1);
                return data2.compareTo(data1);
            }
        });

        System.out.println(resultList);
    }

}
