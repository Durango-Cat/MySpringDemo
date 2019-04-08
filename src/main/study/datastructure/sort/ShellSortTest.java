package main.study.datastructure.sort;

/**
 * 希尔排序
 *
 * @author ZhuQiuPing
 *         on 2018/5/13
 */
public class ShellSortTest {
    public static void main(String[] args) {
        Character[] a = new Character[]{'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A',
                'M', 'P', 'L', 'E'};
        sort(a);
        System.out.println("---------------------");
        for(Character chars : a) {
            System.out.print(chars + "\t");
        }
    }

    public static boolean less(Character a, Character k) {
        //升序就会让此处变为-1
        return a.compareTo(k) < 0;
    }

    public static void sort(Character[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) { h = h*3 + 1; }
        while(h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    Character temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
                for(Character chars : a) {
                    System.out.print(chars + "\t");
                }
                System.out.println("-----------------");
            }
            h /= 3;
        }
    }

}
