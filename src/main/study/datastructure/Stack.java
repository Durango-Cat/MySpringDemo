package main.study.datastructure;

import org.junit.Test;

import java.util.Iterator;
import java.util.logging.Logger;

import static java.lang.System.*;

/**
 * 数据类型栈的实现
 * 特点：先进后出，后进先出
 *
 * @author zhuqp on 2019/2/18
 */
public class Stack {

    private static final Logger log = Logger.getLogger("Stack");

    /**
     * 用下压栈（数组）的物理结构方式实现栈
     * 优点：快速遍历 O(1)
     */
     public class StackByArrayImpl {
        /**
         * 暂定简单的Integer类型的数组当做这个栈,如果数组中未存值就将数组默认里面填充null
         */
        private Integer[] items = new Integer[10];
        /**
         * 栈的容量(默认是0)
         */
        private int size = 0;

        /**
         * 修改栈的容量大小，不浪费栈的空间(此操作支持扩容或者减小容量）
         *
         * @param newSize  新的容量大小
         */
        private void resize(int newSize) {
            Integer[] newItems = new Integer[newSize];
            //减小容量时，将新容量直接赋值给sizeTemp
            int sizeTemp = size;
            if (newSize < size) {
                sizeTemp = newSize;
            }
            if (sizeTemp >= 0) {
                System.arraycopy(items, 0, newItems, 0, sizeTemp);
            }
            items = newItems;
        }

        /**
         * 是否为空
         */
        boolean isEmpty() {
            return size == 0;
        }

        /**
         * 向栈中添加元素，支持容量不够扩容
         * @param item  待添加的元素
         */
        public void push(int item) {
            if((size + 1) == items.length) {
                resize(size * 2);
            }

            items[size++] = item;
        }

        /**
         * 删除元素
         */
        Integer pop() {
            if(isEmpty()) {
                log.info("栈为空，不支持删除操作");
                return null;
            }

            Integer delteItem = null;
            if (items[--size] != null) {
                delteItem = items[size];
                items[size] = null;
            }

            if((size) == items.length/4) {
                resize(items.length/2);
            }
            return delteItem;
        }

        /**
         * 遍历栈
         */
        public Iterator<Integer> iterator() {
            return new ReverseArray();
        }
        /**
         * 栈的大小
         */
        public int size() {
            return this.size;
        }

        /**
         * 遍历数组
         */
        public class ReverseArray implements Iterator<Integer> {

            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            /**
             * 这个里面有下标移动的操作
             */
            @Override
            public Integer next() {
                return items[--i];
            }
        }
    }

    /**
     * 以链表的方式来实现栈(线性的逻辑结构和链式的物理结构）
     * 优点：增删快，遍历O（n)
     */
    public class StackByLinkImpl {

        /**
         * 栈顶元素
         */
        private Node first = null;
        /**
         * 元素数量
         */
        private int size = 0;
        /**
         * 链表
         */
        class Node {
            /**
             * 当前元素
             */
            Integer item = null;
            /**
             * 存储下一个元素的
             */
            Node next = null;

            public Node() {
            }

            Node(Integer item) {
                this.item = item;
            }
        }

        /**
         * 向栈顶添加元素
         * @param item 元素值
         */
        public void push(Integer item) {
            Node node = new Node(item);
            //将新加结点的next指向上一个存放的元素
            node.next = first;
            //再将新加结点等于栈顶结点
            this.first = node;
            this.size++;
        }

        /**
         * 删除栈顶的元素
         */
        public Integer pop() {
            if(first == null) {
                log.info("栈为空，无法执行删除操作");
                return null;
            }
            Node secondNode = first.next;
            Integer item = first.item;
            first = secondNode;
            this.size--;
            return item;
        }

        /**
         * 是否为空
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * 遍历栈
         */
        public Iterator<Integer> iterator() {
            return new ReverseStack();
        }

        /**
         * 遍历栈
         */
        public class ReverseStack implements Iterator<Integer> {

            private Node node = first;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Integer next() {
                Integer item = node.item;
                //向下偏移
                node = node.next;
                return item;
            }
        }

        /**
         * 链表里面数值
         */
        public int size() {
            return this.size;
        }
    }

    /**
     * 测试数组方式实现的栈
     */
    @Test
    public void testStackByArrayImpl() {

        //数组的方式实现栈
        StackByArrayImpl stack = new Stack().new StackByArrayImpl();
//        链表的方式实现栈
//        StackByLinkImpl stack = new Stack().new StackByLinkImpl();
        stack.push(3);
        stack.push(45);
        out.println(stack.size());
        Iterator<Integer> items = stack.iterator();
        while(items.hasNext()) {
            out.print(items.next() + "\t");
        }
        out.println();
        stack.pop();
        items = stack.iterator();
        while(items.hasNext()) {
            out.print(items.next() + "\t");
        }
    }
}
