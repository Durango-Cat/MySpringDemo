package main.study.datastructure.sort;

import org.junit.Test;

/**
 * 快速排序测试
 * @author Zhuqiuping on 2019/4/3
 */
public class QuickSort {

    private Double[] a = new Double[]{11.43, 12.33, 2.43, 3.43, 5.54, 7.89, 10.32, 12.32, 2.32, 11.38, 11.98, 12.54, 2.18};

    @Test
    public void testQuickSort() {
        int size = 13;
        a = new Double[size];
        System.out.println("排序前: ");
        //将数组填充成随机数
        for(int i = 0; i < size; i++) {
            //a[i] = Double.parseDouble(String.format("%.2f", Math.random() * 13D));
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        System.out.println("排序后：");
        quick(a, 0, a.length);
        for(int i = 0; i < size; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 快排
     * 原理：拿第一个元素先找出这个元素该存放的索引（在找出的过程中，将大于第一个元素都会放到该索引的右侧，小于该数值都会放到该索引左侧），
     * 然后递归的二分数组，进行第一个元素排序。
     *
     * @param a 待排序数组
     * @return 排完序的数组
     */
    public void quick(Double[] a, int low, int high) {
        if(a.length <= low || low >= high) {
            return ;
        }
        int middleIndex = partition(a, low, high);

        quick(a, low, middleIndex - 1);
        quick(a, middleIndex + 1, high);
    }

    /**
     * 找出元素第一个位置
     *
     * @param a        待排序的数组
     * @param low      低位元素索引
     * @param high     高位元素索引
     */
    private int partition(Double[] a, int low, int high) {
        double lowData = a[low];
        int numberIndex = low;
        //永真循环
        while(true) {
            if(a[++low] < lowData) {
                continue;
            } else if(a[--high] > lowData) {
                if(a[low] > lowData) {
                    low--;
                }
                continue;
            } else if(a[high] < lowData && a[low] < lowData) {
                high++;
                continue;
            }

            if(low >= high) {
                break;
            }

            if(a[low] > lowData && a[high] < lowData) {
                exchange(a, low, high);
            }

        }

        exchange(a, numberIndex, high);

        return high;
    }

    /**
     * 交换元素
     *
     * @param a         待交换元素的数组
     * @param left      左边元素
     * @param right     右边元素
     */
    private void exchange(Double[] a, int left, int right) {
        double temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
