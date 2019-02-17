package main.java.CollectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by zhuqiuping
 * on 2017/5/1
 */
public class ContainsFromArrayListTest {


    public static int toInteger(byte[] b) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            if (b[i] > 0)
                s = s + b[i];
            else {
                s = s + 256 + b[i];
                s = s * 256;
            }
        }
        if (b[3] > 0)
            s = s + b[3];
        else
            s = s + 256 + b[3];
        return s;
    }

    public static byte[] toByteArray(int number){
        int temp = number;
        byte[] b = new byte[4];
        for (int i = b.length - 1; i > -1; i--) {
            b[i] = new Integer(temp & 0xff).byteValue();
            temp = temp >> 8;
        }
        return b;
    }

    public static void main(String[] args) {
        byte[] b = new byte[]{87, 65, 78, 57};

//        System.out.println(toInteger(b));
//        byte[] b1 = toByteArray(287);
//        for(byte i = 0; i < b1.length; i++) {
//            System.out.println(b1[i]);
//        }
        System.out.println();
//         int[] is = new int[]{1, 2, 3};
//         System.out.println(is.toString());

//        Object  i = 12313;
//        System.out.println((String) i);
//        List<Integer> uniquekeyList = new ArrayList<>(60000);
//        for (int i = 0; i < 60000; i++) {
//            uniquekeyList.add(i);
//        }
//
//        Long start1 = System.nanoTime();
//        if (uniquekeyList.contains(50000)) {
//            System.out.println("不知道黄花菜等凉了没");
//        }
//        Long end1 = System.nanoTime();
//        System.out.println(end1 - start1);
//
//        Set uniqueKeySet = new HashSet<>(uniquekeyList);
//        Long start2 = System.nanoTime();
//        if (uniqueKeySet.contains(50000)) {
//            System.out.println("这盘黄花菜还热着呢");
//        }
//        Long end2 = System.nanoTime();
//        System.out.println(end2 - start2);
    }
}
