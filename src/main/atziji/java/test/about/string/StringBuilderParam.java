package main.atziji.java.test.about.string;

/**
 * 试试StringBuilder中定义固定长度的方法
 * Create by ZhuQiuPing
 * on 2017/10/18
 */
public class StringBuilderParam {

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder(4);
//        sb.append("xxx   ");
//        sb.append(new StringBuilder("xxx   "));
//        sb.append(new CharSequence() {
//            @Override
//            public int length() {
//                return 0;
//            }
//
//            @Override
//            public char charAt(int index) {
//                return 0;
//            }
//
//            @Override
//            public CharSequence subSequence(int start, int end) {
//                return null;
//            }
//        });
//        sb.append("xsxs   ", 3, 4);

//        System.out.println(sb.toString());
//        System.out.println(sb.appendCodePoint(2).toString());
//        System.out.printf("%d %f", 21, 21.6);
        System.out.println();
//        System.out.format("%d %f", 21, 21.6);
        System.out.println(String.format("%d %f", 21, 21.6));
    }
}
