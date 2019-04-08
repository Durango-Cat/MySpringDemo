package main.study.datastructure.sort;

import org.junit.Test;

/**
 * 归并排序(属于稳定排序）
 * 原理：将数组复制一份大小相同的数组，然后每次归并回原来的数组中，
 *      归并过程：从中间分成2组，继续从中间分成2组，知道分到粒度为1（不能再分的时候）进行比较元素，在每次归并的时候，会先进行找中间元素，
 *      找到中间元素后进行左右划分。
 *      调用左右两边的归并方法，归并结束后继续合并元素。
 *
 * @author Zhuqiuping on 2019/3/29
 */
public class MergerSort {

    private static Double[] aux;

    private Double[] a = new Double[]{23.43D, 23232.23D, 34.23D, 1D, 14.2D, 20.343D, 20.34D, 20.3D, 22.32D, 34.23D, 23.23D};

    /**
     * 归并排序的自顶向下排序测试
     */
    @Test
    public void testTopDown() {
        System.out.println("自顶向下排序前：");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        sortTopDown(a);
        System.out.println();
        System.out.println("排序后：");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 归并排序的自底向上排序测试
     */
    @Test
    public void testDownToTop() {
        System.out.println("自底向上排序前：");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        sortDownToTop(a);
        System.out.println();
        System.out.println("排序后：");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 归并排序 自底向上
     */
    public void sortDownToTop(Double[] a) {
        int size = a.length;
        aux = new Double[size];
        System.arraycopy(a, 0, aux, 0, size);
        //记不住排序，就在关键的地方多备注点，这些排序运行前面的排序数值多些，mid不一定真的就是中间的，只要保证分出来mid前后元素都已经排过序了
        //此处的排序增加粒度，是每次2的幂次方，2的0次幂，
        for(int lowSize = 1; lowSize < size; lowSize = lowSize * 2) {
            //此处是每次循环粒度下的，小循环范围
            for(int low = 0; low < size - lowSize; low += lowSize * 2) {
                merge(a, low, low + lowSize - 1, Math.min(low + lowSize * 2 - 1, size - 1));
            }
        }
    }

    /**
     * 归并排序 自顶向下
     */
    public void sortTopDown(Double[] a) {
        aux = new Double[a.length];
        System.arraycopy(a, 0, aux, 0, a.length);
        //这块的数值要做到数组长度-1，如果是数组的长度，后面merge里面
        sortTopDown(a, 0, a.length - 1);
    }

    /**
     * 归并排序 自顶向下
     *
     * @param a         待排序数组
     * @param low       低位
     * @param high      高位
     */
    public void sortTopDown(Double[] a, int low, int high) {
        int mid = low + (high - low) / 2;
        //这里面应该有个截止的条件
        if(high < 0 || low < 0 || high <= low || mid >= high) {
            return;
        }
        //此处也要注意：前面回调方法的结束参数值应该是mid,包含的数值多点，这样能多比较些，可能会出现3个数值时，前面的回调函数比较了前两个数值，
        // 保证了要比较的数组中前面的数值一定是有序的
        sortTopDown(a, low, mid);
        if(mid != low) {
            sortTopDown(a, mid + 1, high);
        }
        merge(a, low, mid, high);
    }

    /**
     * 原地归并
     *
     * @param a             原数组
     * @param low           低位索引
     * @param mid           中间位置
     * @param high          高位索引
     */
    public void merge(Double[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for(int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for(int k = low; k <= high; k++) {
            //左边元素已经合并完了
            if(i > mid) {
                a[k] = aux[j++];
            }
            //右边元素已经合并完了
            else if(j > high) {
               a[k] = aux[i++];
            }
            //左边元素未合并完
            //用未排序的数组来进行数值比较，要将j++这个判断放在前面，因为归并排序是稳定的数组，
            // 要做到稳定就要将数组前面与后面数值相同的时候，将前面的值先填充到数组中
            else if(aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
