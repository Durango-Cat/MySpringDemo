package main.atziji.java.test.about.string;


/**
 * 测试字符串量词中的（贪婪型，勉强型，占有型）
 *
 * Create by ZhuQiuPing
 * on 2017/10/19
 */
public class PatternMatcherTest {

    public static void main(String[] args) {
//        String str = "/s/xs/s.d/d/s/s//rw/e//q/s/s/v/b/h//t//e//w/d/h/u/t/r";
//        Pattern pattern = Pattern.compile("/s.*+w");
//        Matcher m = pattern.matcher(str);
//
//        while (m.find()) {
//            System.out.println(m.group());
//            System.out.println(m.start());
//            System.out.println(m.end());
//        }

        //这是是针对工作中用到的校验
//        String str = "areaIds=5742aca8c1300e6381722f4f" +
//                "&areaIds=5742adacc1300e6381722f51&areaIds=5742b40fc1300e6381722f56" +
//                "&areaIds=5743fe9bc13048e0a42be3ec&areaIds=57562bc9c130de690c648f56" +
//                "&areaIds=57563ef0c1304e986e77e90f&areaIds=575784a3c13014ff751f875b" +
//                "&areaIds=5763aa26c130508838b33000&areaIds=57ff3321e4b066d23b4eb50a" +
//                "&areaIds=58be5eb5e4b032c42b0956ef&areaIds=59127ac7e4b0021afaf0711f" +
//                "&areaIds=59daf0e9e4b035151f2904be";
        String str = "areaIds=0";
//        Pattern pattern = Pattern.compile("areaIds=|&areaIds=");
//        Matcher m = pattern.matcher(str);
//
//        while (m.find()) {
//            System.out.println(m.group());
//        }
        String[] strings = str.split("areaIds=|&areaIds=");
//        for (String stringss : strings) {
//            System.out.println(stringss);
//        }
        System.out.println(strings[1]);  //拿到的第一个值为空
    }
}
