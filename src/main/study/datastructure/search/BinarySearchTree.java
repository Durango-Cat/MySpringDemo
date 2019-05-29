package main.study.datastructure.search;

import lombok.Data;

/**
 * 二叉查找树（本质是一颗二叉树，在此查找树中支持rank()  select()方法，分别是根据排名来找到对应排名上的元素， 根据元素找到对应的元素上的排名）
 * 这个排名看select方法里面比较的排名是左节点上的大小，并不是这个元素本身的size.我猜测是因为元素本身的size是比从0开始的索引多了1个）
 * 注：看了好几个博客，都在说Node里面的size是为了支持select()和rank()用的，如果二叉查找树本身没实现这两个方法的话，就直接将size写在二叉查找树外面了
 *
 * @author Zhuqiuping on 2019/5/27
 */
public class BinarySearchTree {

    /**
     * 根节点
     */
    private Node root;
    /**
     * 每个树节点
     */
    @Data
    private class Node {
        /**
         * 节点里面存储的元素
         */
        private Integer key;
        /**
         * 每个节点的大小
         */
        private int size;
        /**
         * 左节点
         */
        private Node left;
        /**
         * 右节点
         */
        private Node right;
    }

    /**
     * 二叉树大小
     */
    public int size() {
        return size(root);
    }

    /**
     * 查找大小
     * @param root  根节点
     */
    private int size(Node root) {
        return root != null ? root.size : 0;
    }

    /**
     * 判断二叉查找树是否为空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 判断某个元素是否包含
     * @param key
     * @return
     */
    public boolean contains(Integer key) {
        if (key == null) {
            System.out.println("查询的内容为空");
            return false;
        }
        Node node = get(key);
        return node != null;
    }

    /**
     * 从二叉查找树中查找元素（递归）
     *
     * @param key   待查找的元素
     */
    public Node get(Integer key) {
        return get(root, key);
    }

    /**
     * 从二叉查找树中查找元素（递归）
     *
     * @param node  节点
     * @param key   待查找的元素
     */
    private Node get(Node node, Integer key) {
        if(node == null) {
            return null;
        } else {
            int compare = node.getKey().compareTo(key);
            if(compare < 0) {
                return get(node.left, key);
            } else if(compare > 0) {
                return get(node.right, key);
            } else {
                return node;
            }
        }
    }
}
