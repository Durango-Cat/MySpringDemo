package main.study.datastructure.sort;

/**
 * 插入排序
 *
 * @author ZhuQiuPing
 *         on 2018/5/14
 */
public class Insection {

    /**
     * 排序整个数组
     *
     * @param a 待排序的数组
     */
    public static void sort(Double[] a) {
        if(a.length <= 0) {
            return;
        }

        for(int i = 0; i < a.length; i++) {
            for(int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
                each(j, j - 1, a);
            }
        }
    }

    /**
     * 指定排序固定范围内的元素
     *
     * @param a         待排序的数组
     * @param low       开始索引
     * @param high      结束索引
     */
    public static void sort(Double[] a, int low, int high) {
        if(a.length <= 0 || low >= high) {
            return ;
        }

        for(int i = low; i < high; i++) {
            for(int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
                each(j, j - 1, a);
            }
        }

    }

    /**
     * 交换元素
     *
     * @param left  左边的元素
     * @param right 右边的元素
     * @param a     数组
     */
    private static void each(int left, int right, Double[] a) {
        Double temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
