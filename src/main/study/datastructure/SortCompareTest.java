package main.study.datastructure;

import java.util.Random;

/**
 * 插入排序、选择排序、希尔排序的比较
 *
 * @author ZhuQiuPing
 *         on 2018/5/14
 */
public class SortCompareTest {

    private static String selectionSort = "Selection sort", insertionSort = "insertion sort", shellSort = "shell sort";
    public static Long time(String alg, Double[] a) {
        if(alg == null || alg.isEmpty()) {
            return 0L;
        }

        int size = a.length;
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        Long startTime = System.currentTimeMillis();
        if(selectionSort.equals(alg)) {
            a = selection(a);
        } else if(insertionSort.equals(alg)) {
            a = insertion(a);
        } else if(shellSort.equals(alg)) {
            a = shell(a);
        }
        Long endTime = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + "\t");
        }
        return endTime - startTime;
    }

    /**
     * 选择排序（从小到大）
     * 思路：从第一个元素开始遍历集合，找到最小的值，把索引跟第一个索引下的值换下
     *      接下来从第二个元素开始继续遍历，找到剩下值里的最小值，将索引跟第二个索引下的值换下
     *
     * @param a 待排序的集合
     * @return 已经排好序的集合
     */
    public static Double[] selection(Double[] a) {

        int size = a.length;

        for(int i = 0; i < size; i++) {
            //最小元素的索引
            int min = i;
            for(int j = i+1; j < size; j++) {
                if(a[min] > a[j]) {
                    min = j;
                }
            }
            //找到最小值
            if(i != min) {
                double temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }

        return a;
    }

    /**
     * 插入排序（从小到大）
     * 思路：从第二个元素开始向左遍历元素，比较左边元素跟当前元素大小，如果大于当前元素，就交换。
     * 本来插入排序的规则是：从左到右开始，遍历的左边元素都是有序的，如果该元素小于左边元素，就找到合适的位置让该位置的元素一直到都向右移一位。
     *
     * @param a 待排序的集合
     * @return 已经排好序的集合
     */
    public static Double[] insertion(Double[] a) {
        int size = a.length;
        for(int i = 1; i < size; i++) {
            for(int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
                each(j, j - 1, a);
            }
        }
        return a;
    }

    /**
     * 希尔排序（从小到大）
     *
     * 思路：按照数组长度除以3+1之后的值，即（1、4、7...)的宽度，按照这个宽度比较这个宽度内的数值
     * 比如9位长的，第一次是从4的索引上比较索引4前4个的元素大小，如果小于就互换。如果不小于，就继续比较索引为5的
     *
     * @param a 待排序的集合
     * @return 已经排好序的集合
     */
    public static Double[] shell(Double[] a) {
        int size = a.length;
        int h = 1;
        while(h < size / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    each(j - h, j, a);
                }
            }
            h *= 3;
        }
        return a;
    }

    /**
     * 随机数组并统计出来每个排序花费的时间
     *
     * @param alg
     * @param N
     * @param T
     * @return
     */
    public static Long[] timeRandomInput(String alg, int N, int T) {
        Long[] total = new Long[T];
        Double[] a = new Double[N];
        Random random = new Random();

        for(int t = 0; t < T; t++) {
            //每一次循环都会对该数组进行一次赋值和排序
            for(int i = 0; i < N; i++) {
                a[i] = random.nextDouble() * N;
            }
            total[t] = time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        Long[] insertSortTime = timeRandomInput(insertionSort, 16, 5);
        Long[] selectionSortTime = timeRandomInput(selectionSort, 16, 5);
        Long[] shellSortTime = timeRandomInput(shellSort, 16, 5);

        for(int i = 0; i < 5; i++) {
            System.out.println(insertSortTime[i] + "插入排序的第" +(i+1) +"个花费的时间");
            System.out.println(selectionSortTime[i] + "选择排序的第" +(i+1) +"个花费的时间");
            System.out.println(shellSortTime[i] + "希尔排序的第" +(i+1) +"个花费的时间");
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
