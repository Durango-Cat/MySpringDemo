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

    private static Double[] a = new Double[] {23.3, 23.1, 14.2, 23.1, 19.3, 19.2, 23.3, 23.1, 23.4, 19.3, 23.1, 32.1, 23.3, 23.1, 19.2};

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
        quick(a, 0, size);
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

        if((low + THREE) >= high) {
            Insection.sort(a, low, high);
            return ;
        }

            int lt = low,i=low+1,gt = high;
            Double temp = a[low];
            while(i <= gt){
                if(a[i] < temp){
                    exch(a,lt++,i++);
                }else if(a[i] > temp){
                    exch(a,i,gt--);
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
