package main.study.datastructure;

/**
 * 结构 里面还有通用的方法
 */
public interface Structure<T> {
    /**
     * 添加元素
     * @param data 待添加的元素
     */
    void push(T data);

    /**
     * 删除元素
     */
    T pop();

    /**
     * 结构是否为空
     */
    boolean empty();

    /**
     * 结构包含的元素个数
     */
    int size();
}
