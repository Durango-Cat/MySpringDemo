package main.study.datastructure.sort;

import org.junit.Test;

/**
 * 三向切分的快速排序
 *
 * 这个排序就是针对快速排序中重复元素较多衍生出来的排序算法。这个算法里面基本思想跟快排差不多。就是在针对重复元素时，
 * 切分的指针从原来的low和high两个，变成四个，继续加了两个在重复元素中开始的lt和结束的gt(这两个都是包含的关系）
 *
 * 鉴于内部对待排序区间小的元素执行插入排序，此处继承插入排序的类
 *
 * @author zhuqp on 2019/4/9
 */
public class ThreeWayPartitionQuickSort extends Insection {

    private static Integer THREE = 3;

    private static Double[] a = new Double[] {23.3, 23.1, 14.2, 23.1, 19.3, 19.2, 23.3, 23.1, 23.4, 19.3, 23.1,
            32.1, 23.3, 23.1, 19.2};

    @Test
    public void testThreeWayPartitionQuickSort() {
        int size = a.length;
        System.out.println("排序前: ");
        //将数组填充成随机数
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        System.out.println("排序后：");
        quick(a, 0, size - 1);
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 三向切分的快速排序
     * 这个里面对数组小的时候直接进行插入排序，不再进行每个元素的比较。
     * 就把这个区间定为3
     *
     * @param a         待排序数组
     * @param low       低位元素的索引
     * @param high      高位元素的索引
     */
    public void quick(Double[] a, int low, int high) {

        if(low < 0 || high < 0 || low > high) {
            return;
        }
        if((low + THREE) >= high) {
            Insection.sort(a, low, high);
            return ;
        }

            int lt = low, i=low+1, gt = high;
            Double temp = a[low];
            while(i <= gt){
                //如果待查索引对应的元素比比较的元素小，就将跟待查元素相同索引对应的元素与索引对应的元素进行交换，接下来两个索引累加。
                //累加就是：从左边只要小于待查元素的元素，都不再lt范围内，所以lt会累加。i累加是要变成下一个未排序比较的元素。
                if(a[i] < temp){
                    exch(a, lt++, i++);
                }
                //如果待查索引对应的元素比比较的元素大，就将跟待查元素相同的高位索引与待查索引对应的元素进行交换，接下来只将于待查元素相同的高位索引向下减1
                //交换，是将查出来大的元素放到待查元素相同的右侧位置去；减1，是因为交换过后，该位置已经是大于比较的元素，而非相等，所以索引要往前移
                //
                else if(a[i] > temp){
                    exch(a, i, gt--);
                }else{
                    i++;
                }
            }
            quick(a,low,lt-1);
            quick(a,gt+1,high);
    }
    /**
     * 交换元素
     *
     * @param a     数组
     * @param left  左边的元素
     * @param right 右边的元素
     */
    private static void exch(Double[] a, int left, int right) {
        Double temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

}
