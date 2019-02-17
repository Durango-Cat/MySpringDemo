package main.atziji.java.test.about.string;

/**
 * 测试下split分成数组后可能,号后面为空
 *
 * Create by ZhuQiuPing
 * on 2017/11/12
 */
public class SplitTest {
    public static void main(String[] args) {

        String str = "a,v,b,,,,";
        String[] strArr = str.split(",");
        System.out.println(strArr.length);
//        for (String item : strArr) {
//            System.out.println(item);
//        }
    }
}
