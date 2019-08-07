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
    public class Node {
        /**
         * 存储字典的键
         */
        private Integer key;
        /**
         * 存储字典的值
         */
        private Object value;
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

        public Node(Integer key, Object value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
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
            int compare = node.key.compareTo(key);
            if(compare < 0) {
                return get(node.left, key);
            } else if(compare > 0) {
                return get(node.right, key);
            } else {
                return node;
            }
        }
    }

    /**
     * 向二叉查找树中插入新节点
     *
     * @param key     用于添加的元素
     * @param value   添加的元素内容
     */
    public void put(Integer key, Object value) {
        if(key == null) {
            System.out.println("没法比较，也没法插入新节点");
            return ;
        }

        if(value == null) {
            System.out.println("尽量别让value为null");
        }
        put(root, key, value);
    }

    /**
     * 从根节点开始遍历，在合适的位置插入新的节点(递归）
     *
     * @param node      根节点
     * @param key       此处的key用于比较，将该节点放在在合适的位置
     * @param value     添加元素的内容
     */
    private Node put(Node node, Integer key, Object value) {
        if(node == null) {
            node = new Node(key, value, 1);
        } else {
            int compare = node.key.compareTo(key);
            //根节点上的key比待添加元素上的key大
            if(compare > 0) {
                node.left = put(node.right, key, value);
            } else if(compare < 0) {
                node.right = put(node.left, key, value);
            } else {
                node.key = key;
                node.value = value;
            }

            node.size = size(node.left) + size(node.right) + 1;
        }

        return node;
    }

    /**
     * 查找index下标所指的键
     *
     * @param index 节点个数
     * @return 节点位置
     */
    public Integer select(int index) {
        if(index <= 0) {
            System.out.println("没法查找index小于等于0个数的节点位置");
            return -1;
        }

        return select(root, index);
    }

    /**
     * 查找index下标所指的键（因为二叉查找树不像数组一样，有精确的下标，根据下标很快就能找到对应的元素。所以二叉查找树会在每个节点
     * 内部放一个size来标识包括该结点的下标。那么根据index下标来找到对应的结点，即找到它的左子节点等于index就表示找到那个元素的键）
     *
     * @param index 节点个数
     * @return 节点位置
     */
    private Integer select(Node root, int index) {
        if(root == null) {
            return -1;
        }

        //查询左节点的长度
        int size = size(root.left);
        //如果左结点大于要查询的index，表示要查询的index在节点的左侧
        if(size > index) {
            return select(root.left, index);
        }
        //如果左结点小于要查询的index，表示要查询的index在节点的右侧（但是查询节点右侧的index时，需要变成右侧长度相关的index数量
        else if(size < index) {
            return select(root.right, index - size -1);
        } else {
            return size;
        }
    }

    public int rank(Integer key) {
        return rank(root, key);
    }

    /**
     * 根据键找到对应index
     *
     * @param key   待查找的键
     * @return  对应index
     */
    private int rank(Node root, Integer key) {
        if(root == null) {
            return -1;
        }

        int compareTo = root.key.compareTo(key);
        if(compareTo < 0) {
            return rank(root.left, key);
        } else if(compareTo > 0) {
            return root.left.size + rank(root.right, key) + 1;
        } else {
            return root.left.size;
        }
    }

    /**
     * 向下取节点的key值，意思就是传进来一个key, 从二叉查找树中找到小于等于此key的键
     *
     * @param key       键值
     */
    public Integer floor(Integer key) {
        if(key == null) {
            System.out.println("向下取节点的key值不能为null");
        }
        return floor(root, key);
    }

    /**
     * 向下取节点的key值，意思就是传进来一个key, 从二叉查找树中找到小于等于此key的键
     *
     * @param key       键值
     */
    private Integer floor(Node root, Integer key) {
        if(root == null) {
            return -1;
        }
        //将key值跟root节点上的键值比较
        int compareTo = key.compareTo(root.key);
        if(compareTo < 0) {
            return floor(root.left, key);
        } else if(compareTo > 0) {
            Integer rightNode = floor(root.right, key);
            if(rightNode == -1) {
                return root.key;
            } else {
                return rightNode;
            }
        } else {
            return root.key;
        }
    }

    /**
     * 向上取节点的key值，就是传进来一个key, 从二叉查找树中找到大于等于此key的键
     *
     * @param key       键值
     */
    public Integer ceiling(Integer key) {
        if(key == null) {
            System.out.println("向上取整的key值不能为null");
        }
        return ceiling(root, key);
    }

    /**
     * 向上取节点的key值，就是传进来一个key, 从二叉查找树中找到大于等于此key的键
     *
     * @param key       键值
     */
    private Integer ceiling(Node root, Integer key) {
        if(root == null) {
            return -1;
        }

        int compare = key.compareTo(root.key);
        if(compare > 0) {
            return ceiling(root.right, key);
        } else if(compare < 0) {
            Integer leftNode = ceiling(root.left, key);
            if(leftNode == -1) {
                return root.key;
            } else {
                return leftNode;
            }
        } else {
            return root.key;
        }
    }

    /**
     * 删除最小节点
     */
    public Node deleteMin() {
        if(root == null) {
            System.out.println("二叉查找树中没有存储任何元素,无法删除最小节点");
            return null;
        }
        return deleteMin(root);
    }

    /**
     * 删除最小的节点
     *
     * @param root  根节点
     * @return 最小的节点
     */
    private Node deleteMin(Node root) {
        Node node = root;
        while(node.left != null && node.left.size > 2) {
            node.size -= 1;
            node = node.left;
        }

        if(node.left == null) {
            //表示只有一个根节点
            if(node.right == null) {
                this.root = null;
            }
            //没有左节点，只有右节点，
            else {
                this.root = node.right;
            }
            return root;
        }
        //表示该节点下面只有一个左节点
        else if(node.left.size == 1) {
            Node newNode = node.left;
            node.left = null;
            node.size -= 1;
            return newNode;
        } else {
            Node newNode = node.left;
            if(newNode.left == null && newNode.right != null) {
                node.left = newNode.right;
            } else {
                node.left.left = null;
                node.left.size = 1;
            }
            node.size -= 1;
            return newNode.left;
        }
    }

    /**
     * 从网上搜到的删除最小元素，递归真的很省代码（不过套路不太一样，返还结果是一直递归结束作为根节点用的）
     *
     * @param node      待判断大小的元素
     * @return          递归作为根节点用的返回值
     */
    private Node deleteMinFromInternet(Node node) {
        if(node.left == null) {
            return node.right;
        }
            node.left = deleteMinFromInternet(node.left);
            node.size = size(node.left) + size(node.right) + 1;
            return node;
    }

    /**
     * 删除最大元素
     */
    public Node deleteMax() {
        if(root == null) {
            System.out.println("二叉查找树为空，不能执行删除操作");
            return null;
        }
        return deleteMax(root);
    }

    /**
     * 从根节点中遍历删除最大元素
     *
     * @param root  根节点
     */
    private Node deleteMax(Node root) {
        Node node = root;

        while(node != null && node.right != null && node.right.size > 2) {
            node.size -= 1;
            node = node.right;
        }

        //节点下面没有子节点了，比如根节点
        if(node.right == null) {
            //表示只有根节点
            if(node.left == null) {
                this.root = null;
            }
            //表示二叉查找树根节点左边有值，根节点右侧没值
            else {
                this.root = node.left;
            }
            return node;
        }
        //表示节点的右侧子节点里面只有一个值，即该值就是最大值
        else if(node.right.size == 1) {
            Node newNode = node.right;
            node.right = null;
            node.size -= 1;
            return newNode;
        }
        //表示节点的右侧子节点里面有两个值，即该值的右子节点或者该值就是最大值
        else {
            Node newNode = node.right;
            //表示该结点只有右子节点有值
            if(node.right.left == null && node.right.right != null) {
                newNode = node.right.right;
                node.right.right = null;
                node.right.size = 1;
            }
            //表示该节点只有左子节点有值，那么删掉该节点让左子节点替代该节点
            else {
                node.right = node.right.left;
                node.size -= 1;
            }

            return newNode;
        }
    }

    /**
     * 删除指定键，并维持二叉查找树的平衡
     * @param key   指定键
     */
    public void delete(Integer key) {
        delete(root, key);
    }

    /**
     * 删除指定键，并维持二叉查找树的平衡
     *
     * 这个方法的主要点是在于查找到元素后，再从元素所在节点的位置的几种情况来维持二叉查找树的平衡
     * ①查找到元素在左子节点上或者在右子节点，那么删除之后就不需要移动其他元素，只需要改下这个节点的父节点指向变为null
     * ②查找到元素下面只有一个子节点，那么删除元素后，要把对应的子节点放到这个节点的位置上。
     * ③查找到元素有两个子节点，分别是左子节点和右子节点。此处需要把左子节点放到这个删除节点的位置上。
     * ④查找到元素子节点下面还有子节点，就需要查找该节点的左子节点下的右节点
     *
     * @param root  根节点
     * @param key   指定键
     * @return  根节点
     */
    private Node delete(Node root, Integer key) {
        return null;
    }
}
