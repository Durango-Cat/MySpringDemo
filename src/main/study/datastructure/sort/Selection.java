package main.study.datastructure.sort;

/**
 * 选择排序
 *
 * @author ZhuQiuPing
 *         on 2018/5/14
 */
public class Selection {
    //这次按照升序排列
    public static void sort(Double[] a) {
        if(a.length > 0) {
            int size = a.length;
            for(int i = 0; i < size; i++) {
                for(int j = i+1; j < size; j++) {
                    if(a[i].compareTo(a[j]) > 0) {
                        double temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                    //("查看a数组的参考" + a);
                }
            }
        }
    }

    public static void main(String[] args) {
        Double[] a = new Double[]{0.8, 0.1, 0.04, 0.6, 0.04, 0.65};
        for(double aArr : a) {
            System.out.print(aArr+"\t");
        }
        System.out.println();
        sort(a);
        for(double aArr : a) {
            System.out.print(aArr+"\t");
        }
    }
}
