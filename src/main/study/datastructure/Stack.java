package main.study.datastructure;

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
     public class StackByStackImpl {
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
        public void add(int item) {
            if((size + 1) == items.length) {
                resize(size * 2);
            }

            items[size++] = item;
        }

        /**
         * 删除元素
         */
        Integer delete() {
            if(isEmpty()) {
                log.info("栈为空，不支持删除操作");
                return null;
            }

            if((size - 1) == items.length/4) {
                resize(items.length/2);
            }

            Integer delteItem = null;
            if (items[size - 1] != null) {
                delteItem = items[size - 1];
                items[size - 1] = null;
                this.size--;
            }

            return delteItem;
        }

        /**
         * 查找items集合中某个元素
         *
         * @param index  待查找元素的索引位置
         */
        public Integer findItem(int index) {
            if(isEmpty()) {
                log.info("栈为空，该值不存在");
                return null;
            }

            return items[index];
        }

        /**
         * 遍历栈
         */
        Integer[] ergodic() {
            if(isEmpty()) {
                log.info("栈为空，该值不存在");
                return null;
            }

            Integer[] newItems = new Integer[size];
            arraycopy(items, 0, newItems, 0, size - 1 + 1);
           return newItems;
        }
        /**
         * 栈的大小
         */
        public int size() {
            return this.size;
        }
    }

    /**
     * 以链表的方式来实现栈(线性的逻辑结构和链式的物理结构）
     * 优点：增删快，遍历O（n)
     */
    public class StackByLinkImpl {

        /**
         * 第一个链表元素
         */
        private StackByLink first = null;
        /**
         * 元素数量
         */
        private int size = 0;
        /**
         * 链表
         */
        class StackByLink {
            /**
             * 当前元素
             */
            Integer item = null;
            /**
             * 存储下一个元素的
             */
            StackByLink next = null;

            public StackByLink() {
            }

            StackByLink(Integer item) {
                this.item = item;
            }
        }

        /**
         * 添加元素
         * @param item 元素值
         */
        public void add(Integer item) {
            if(item == null) {
                return ;
            }
            if (first == null) {
                first = new StackByLink(item);
            } else {
                StackByLink next = first;
                while(next.next != null) {
                    next = next.next;
                }

                StackByLink newItem = new StackByLink(item);
                next.next = newItem;
            }
            this.size++;
        }

        /**
         * 删除链表的最后一个元素，即最后一次添加进来的元素
         * 即将最后一个元素前面元素的next置为null
         */
        public Integer delete() {
            if(first == null) {
                log.info("该栈为空，无法执行删除操作");
                return null;
            }

            StackByLink next = first;
            StackByLink lastNext = null;
            while (next.next != null) {
                lastNext = next;
                next = next.next;
            }

            Integer item = next.item;
            if(item != null && lastNext != null) {
                next.item = null;
                lastNext.next = null;
                next = null;
            }
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
        Integer[] ergodic() {
            Integer[] stacks = null;
            if(size > 0) {
                stacks = new Integer[size];
               int i = size - 1;
               StackByLink link = first;
               while(link != null && i >= 0) {
                       stacks[i] = link.item;
                       link = link.next;
                       i--;
               }
            }
            return stacks;
        }

        /**
         * 链表里面数值
         */
        public int size() {
            return this.size;
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        //数组的方式实现栈
        Stack stack = new Stack();
//        StackByStackImpl stackByStack = stack.new StackByStackImpl();
//        stackByStack.add(3);
//        stackByStack.add(45);
//        out.println(stackByStack.size());
//        Integer[] items = stackByStack.ergodic();
//        if(items != null) {
//            for(int size = items.length - 1, i = size; i >= 0; i--) {
//                out.print(items[i] + "\t");
//            }
//        }
//        out.println();
//        stackByStack.delete();
//        items = stackByStack.ergodic();
//        if(items != null) {
//            for(int size = items.length - 1, i = size; i >= 0; i--) {
//                out.print(items[i] + "\t");
//            }
//        }

        //链表的方式实现栈
        StackByLinkImpl stackByLink = stack.new StackByLinkImpl();
        stackByLink.add(3);
        stackByLink.add(45);
        out.println(stackByLink.size());
        Integer[] links = stackByLink.ergodic();
        if(links != null) {
            for(int size = links.length - 1, i = size; i >= 0; i--) {
                out.print(links[i] + "\t");
            }
        }
        out.println();
        stackByLink.delete();
        links = stackByLink.ergodic();
        if(links != null) {
            for(int size = links.length - 1, i = size; i >= 0; i--) {
                out.print(links[i] + "\t");
            }
        }
    }
}
