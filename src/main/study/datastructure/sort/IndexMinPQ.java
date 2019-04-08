package main.study.datastructure.sort;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 关联最小索引的泛型优先队列
 *
 * @author ZhuQiuPing
 *         on 2018/11/28
 */
public class IndexMinPQ<T> {
    /**
     * 数组中存在（有意义）的数的个数
     */
    private int N = 0;

    /**
     * 这个数组是连续存储，有序的队列下标
     * （默认pq数组0下标不会存值，值都从下标为1的位置开始, pq为索引二叉堆,）
     * 可存放的范围是（1，maxN +1)
     */
    private int[] pq;
    /**
     * 针对上面pq数组中，数组的位置，在对应元素的索引位置上写出pq元素的下标值。
     * 可存放的范围是（0，maxN)
     */
    private int[] qp;

    /**
     * 此数组是存储数值的，可能是不间断的，即删掉一个元素该元素的位置即为null
     * 可存放的范围是（0，maxN)
     */
    private String[] keys;

    public IndexMinPQ(int maxN) {
        pq = new int[maxN+1];
        qp = new int[maxN];
        keys = new String[maxN];
        //为啥此处不填充pq, 因为pq的值是只会通过交换或者添加到最后的一个值，不需要知道不确定的索引之外的值是否为-1
        Arrays.fill(qp, -1);
    }

    /**
     * 索引k中是否有值
     *
     * @param k key中的索引
     */
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    /**
     * 返回最小的值
     */
    public String min() {
        if(N == 0) {
            throw new NoSuchElementException("数组为空, 无法返回最小值");
        }

        return keys[pq[1]];
    }

    /**
     * 返回最小值的索引(-1表示没有值，当前数组为空）
     */
    public int minIndex() {
        return N == -1 ? -1 : pq[1];
    }

    /**
     * 数组为空(true为空）
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 数组大小
     */
    public int size() {
        return N;
    }

    /**
     * 将pq中的pqLeft和pqRight索引中的值在key中比较大小
     * 这个是索引最小的在堆顶，所以此处比较的是如果左边的值大于右边的值就返回true
     * @param pqLeft    pq数组中的索引
     * @param pqRight   pq数组中的索引
     * @return  key中两个值的比较结果
     */
    public boolean compare(int pqLeft, int pqRight) {
        //左边大于右边，返回结果>0.左边小于右边<0,左边=右边 =0
        //这块没有错，因为在比较的时候只有左边数值大于右边数值的时候会返回大于的结果。这时候就要进行交换的操作了。左边的数值小于右边的时候，结果是小于0的。不会进行接下来的交换操作。
        int result =  keys[pq[pqLeft]].compareTo(keys[pq[pqRight]]);
        //System.out.println();
        //System.out.println("pq[pqLeft] : " + pq[pqLeft] + " pq[pqRight]: " + pq[pqRight]  + "  key[qp[left]]:" + keys[pq[pqLeft]]
        //         + " keys[pq[pqRight]]: " + keys[pq[pqRight]] + "------" + result);
        return result > 0;
    }

    /**
     * 根据索引交换pq和qp中的值
     *
     * @param pqLeft    左边的索引
     * @param pqRight   右边的索引
     */
    public void swap(int pqLeft, int pqRight) {
        int index = pq[pqLeft];
        //先交换pq中的值
        pq[pqLeft] = pq[pqRight];
        pq[pqRight] = index;

        //再交换qp，qp中的值就是pq索引(此时pq中的值已经交换了，只是索引没交换，现在差的是将交换过的索引的值对应之前的pq的索引
        qp[pq[pqLeft]] = pqLeft;
        qp[pq[pqRight]] = pqRight;
    }

    /**
     * k索引上浮
     * @param k 此处的k表示pq中的索引
     */
    public void swim(int k) {
        //比较下左边的数值，如果左边比右边小就从左边开始比较
        if(k > 1 && compare(k, k - 1)) {
            k = k - 1;
        }
        while (k / 2 >= 1 && compare(k / 2, k)) {
            //如果k/2大于k的值，就让这个k /= 2;
            //交换pq中的值
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * k索引下沉
     * @param k pq数组的索引
     */
    public void sink(int k) {
        while(k * 2 < N) {
            int j = k * 2;
            if(compare(j, j+1)) {
                j++;
            }
            //只要出现一个有序的，就立刻停止遍历
            if(!compare(k, j)) {
               break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 在指定索引处添加元素
     * @param k     keys数组中的索引处
     * @param key   添加的元素
     */
    public void insert(int k, String key) {
        if (k >= keys.length) {
            N *= 2;

            int[] pqTemp = pq;
            int[] qpTemp = qp;
            String[] itemTemp = keys;

            pq = new int[N];
            qp = new int[N];
            keys = new String[N];

            for(int i = 0, size = itemTemp.length; i < size; i++) {
                pq[i] = pqTemp[i];
                qp[i] = qpTemp[i];
                keys[i] = itemTemp[i];
            }
        }

        int pqIndex = qp[k];
        //将新的值填充到数组中
        if(keys[k] == null) {
            N++;
            pq[N] = k;
            qp[k] = N;
            pqIndex = N;
        }
        keys[k] = key;
        //新加的元素还是要排序的，只跟pq和qp有关（新添加的元素就要执行上浮的操作）（此处的元素索引是pq数组的）
        swim(pqIndex);
    }

    /**
     * 将索引k上的值改为key
     *
     * @param k     索引k（指的是keys数组的索引，也等于qp数组的索引）
     * @param key   要修改的值
     */
    public void change(int k, String key) {
        if (k > keys.length) {
            return;
        }

        keys[k] = key;
        //此处的排序是要上浮和下沉都判断下，就是等于两个方向都要走下。不确定这个新添加的值是要上浮还是下沉才能保证堆平衡
        int pqIndex = qp[k];
        //上浮
        swim(pqIndex);
        //下沉
        sink(pqIndex);
    }

    /**
     * 删除索引k上的值
     * @param k 索引k(指的是keys数组的索引，也等于qp数组的索引）
     */
    public void delete(int k) {
        if(!contains(k)) {
           throw new NoSuchElementException("没有元素与" + k + "关联！");
        }
       //删除的步骤是，先将最后一个值跟堆顶的值交换
       //将N的值-1，然后排序pqIndex中在堆中的顺序
       //最后去掉qp数组中的关联，keys中的内容置空（如果提早置空keys了，就会导致compare中报空指针异常，也就是在排序的时候遍历会出错）
       //此处提示：不去掉pq数组的关联，因为不会直接访问到pq，而且有N来确定pq数组的长度

        //将最后一个pq值跟堆的最后一个pq值交换
        int pqIndex = qp[k];
        swap(pqIndex, N--);

        //排序下
        swim(pqIndex);
        sink(pqIndex);

        //去掉qp的关联
        qp[k] = -1;
        //删掉keys中的值
        keys[k] = null;
    }

    /**
     * 删除最小的元素（即堆顶元素）
     * @return 堆顶所在keys中索引
     */
    public int delMin() {
        if(isEmpty()) {
            throw new NoSuchElementException("没有元素 无法删除");
        }
        //堆顶和最后一个元素交换(这块的交换仅仅只是交换了pq和qp中的数值，
        // 然后要删除元素所在的下标不会变。即qp中要删除的元素下标不会变，
        // 只是变的是qp里面的值是这个要删除元素最后被放置的位置)
        int qpIndex = pq[1];
        swap(1, N--);

        //排序下(下沉）
        sink(1);
        //删掉keys中的值
        keys[qpIndex] = null;
        //去掉qp的关联
        qp[qpIndex] = -1;
        return qpIndex;
    }

    public static void main(String[] args) {
        IndexMinPQ<String> indexMinPQ = new IndexMinPQ<>(20);
        indexMinPQ.insert(5, "E");
        indexMinPQ.insert(7, "G");
        indexMinPQ.insert(2, "B");
        indexMinPQ.insert(1, "A");
        if (indexMinPQ.contains(7)) {
            indexMinPQ.change(7, "Z");
        }

        System.out.println(indexMinPQ.min()); // A
        System.out.println(indexMinPQ.delMin()); // 1
        System.out.println(indexMinPQ.delMin());// 2
        System.out.println(indexMinPQ.minIndex()); // 5
        //System.out.println(indexMinPQ.keyOf(7)); // Z
        indexMinPQ.delete(7);

    }
}
