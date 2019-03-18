package main.study.datastructure;

import lombok.Data;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * 队列（此处会用数组、链表两种方式实现）
 *  特点：先进先出，后进后出
 *
 * @author zhuqp on 2019/3/6
 */
public class Link {
    private static final Logger log = Logger.getLogger("Link");

    /**
     * 用数组的方式实现队列，数组一边是进数，另一边是出数的
     */
    public class LinkByArrayImpl implements Structure<String> {
        /**
         * 队列的数组
         */
        private String[] datas;
        /**
         * 队列的长度
         */
        private int size;

        public LinkByArrayImpl() {
            datas = new String[10];
            size = 0;
        }

        /**
         * 修改数组的大小
         *
         * @param newSize 数组新的大小
         */
        private String[] resize(int newSize) {
            if(newSize <= 0 || newSize < size) {
                log.info("修改数组容量时，新的数组大小不能小于等于0 或者新扩容的大小不能小于现在数组里面的元素");
                return null;
            }

            String[] newDatas = new String[newSize];
            System.arraycopy(datas, 0, newDatas, 0, size);

            return newDatas;
        }

        /**
         * 添加元素（向数组尾部添加元素）
         *
         * @param data 待添加的元素
         */
        @Override
        public void push(String data) {
            if((size + 1) > datas.length) {
                resize(size * 2);
            }

            datas[size++] = data;
        }

        /**
         * 删除元素 (数组头部删除元素）
         */
        @Override
        public String pop() {
            if(size == 0) {
                log.info("该队列中没有元素，无法执行删除操作");
                return null;
            }
            if((size - 1) < (datas.length / 2)) {
                resize(datas.length / 2);
            }

            String data = datas[0];
            System.arraycopy(datas, 1, datas, 0, size -1);
            //移完数据后，将最后一个数值变为null,不在引用，由gc来处理掉
            datas[size--] = null;
            return data;
        }

        /**
         * 是否为空
         */
        @Override
        public boolean empty() {
            return size == 0;
        }

        /**
         * 存储元素的个数
         */
        @Override
        public int size() {
            return size;
        }

        /**
         * 访问队首的元素
         */
        public String front() {
            return size > 0 ? datas[0] : null;
        }

        /**
         * 访问队尾的元素
         */
        public String back() {
            return size > 0 ? datas[size - 1] : null;
        }
    }

    /**
     * 带头的单链表
     */
    public class LinkedBySingleLinkImpl implements Structure<String> {
        /**
         * 头节点
         */
        private SingleNode header;
        /**
         * 链表存储的元素数量
         */
        private int size;

        /**
         * 添加元素
         * @param data  节点数据
         */
        @Override
        public void push(String data) {
            SingleNode node = new SingleNode(data);
            //头节点中未填值
            if(header == null) {
                header = node;
            } else {
                SingleNode nextNode = header;
                while (nextNode.next != null) {
                    nextNode = nextNode.next;
                }

                nextNode.next = node;
            }
            size++;
        }

        /**
         * 删除元素  队首
         * @return  删除的元素
         */
        @Override
        public String pop() {
            if (size <= 0) {
                log.info("该队列中没有元素，无法执行删除操作");
                return null;
            }
            size--;
            String data = header.data;
            header = header.next;
            return data;
        }

        @Override
        public boolean empty() {
            return size == 0;
        }

        @Override
        public int size() {
            return size;
        }

        /**
         * 访问队首的元素
         */
        public String front() {
            return size > 0 ? header.data : null;
        }

        /**
         * 访问队尾的元素
         */
        public String back() {
            if(size <= 0) {
                return null;
            }

            SingleNode node = header;
            if(node == null) {
                return null;
            }
            while(node.next != null) {
                node = node.next;
            }

            return node.data;
        }
    }

    /**
     * 单链表里面的节点
     */
    @Data
    class SingleNode {
        /**
         * 数据
         */
        private String data;
        /**
         * 下一个元素的索引
         */
        private SingleNode next;

        public SingleNode(String data) {
            this.data = data;
        }
    }

    /**
     * 测试用数组的数据结构实现队列
     */
    @Test
    public void testLinkByArrayImpl() {
        Link link = new Link();
        LinkByArrayImpl linkByArray = link.new LinkByArrayImpl();
        linkByArray.push("添");
        linkByArray.push("加");
        linkByArray.push("小");
        linkByArray.push("兔");
        linkByArray.push("崽");
        linkByArray.push("子");

        System.out.println(linkByArray.size);

        System.out.println(linkByArray.pop());
        System.out.println(linkByArray.pop());
        System.out.println(linkByArray.pop());
        System.out.println(linkByArray.pop());
        System.out.println(linkByArray.pop());
        System.out.println(linkByArray.pop());
        System.out.println(linkByArray.pop());
    }

    /**
     * 测试用单链表的数据结构实现队列
     */
    @Test
    public void testLinkedBySingleLinkImpl() {
        Link link = new Link();
        LinkedBySingleLinkImpl linkedBySingleLink = link.new LinkedBySingleLinkImpl();
        linkedBySingleLink.push("添");
        linkedBySingleLink.push("加");
        linkedBySingleLink.push("小");
        linkedBySingleLink.push("兔");
        linkedBySingleLink.push("崽");
        linkedBySingleLink.push("子");
        linkedBySingleLink.push("了");

        System.out.println(linkedBySingleLink.size);

        System.out.println("队首元素：" + linkedBySingleLink.front());
        System.out.println("队尾元素：" + linkedBySingleLink.back());

        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());
        System.out.println(linkedBySingleLink.pop());

    }
}
