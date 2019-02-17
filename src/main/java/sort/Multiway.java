package main.java.sort;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 多向归并
 * (觉得这个多向归并还是对数据有要求的，封装的每个输入流中不能有太多重复的元素，这样会影响返回的结果)
 *
 * @author ZhuQiuPing
 *         on 2018/11/28
 */
public class Multiway {
    public static void merge(InputStream[] streams) throws IOException {
        int N = streams.length;
        // 为每个输入流关联一个整数
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);
        // 从每个流中读取一个字符，因为每个流都已经有序，所以其中必然有最小元素
        for (int i = 0; i < N; i++) {
            int ch;
            if ((ch=streams[i].read()) != -1) {
                pq.insert(i, String.valueOf((char)ch));
            }
        }

        while (!pq.isEmpty()) {
            // 不断选出最小元素打印
            System.out.print(pq.min());
            // 关联这个整数的对象被删除，从关联该整数的剩余流中再读取一个字符，并加入到索引优先队列中
            int i = pq.delMin();
            int ch;
            if ((ch=streams[i].read()) != -1) {
                pq.insert(i, String.valueOf((char)ch));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //InputStream stream1 = new ByteArrayInputStream("ACHYZ".getBytes());
        InputStream stream1 = new ByteArrayInputStream("AAAAA".getBytes());
        InputStream stream2 = new ByteArrayInputStream("BCRXY".getBytes());
        InputStream stream3 = new ByteArrayInputStream("ADPQS".getBytes());
        InputStream[] streams = {stream1, stream2 ,stream3};
        try {
            merge(streams); // AABCCDHPQRSXYYZ
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}