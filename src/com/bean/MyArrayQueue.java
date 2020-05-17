package com.bean;

/**
 * @description: 用数组实现可扩展的队列<br>
 *     思路:创建两个数组记载队列头和队列尾，初始值为-1
 * @author: Andy
 * @date: 2020/4/11 12:05
 */
public class MyArrayQueue<Item> {
    private Item[] array; // 队列
    private int maxSize;
    private int first; // 队列头
    private int last; // 指向队列尾最后一个元素的最后一个位置

    // 构造函数
    public MyArrayQueue(int maxSize) {
        array = (Item[]) new Object[maxSize];
        this.maxSize = maxSize;
        first = 0;
        last = 0;
    }

    // 当前队列的元素数
    public int size() {
        return (last - first + maxSize) % maxSize;
    }

    // 队列是否为空
    public boolean isEmpty() {
        return first == last;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (first - 1 + maxSize) % maxSize == last;
    }

    // 入队列
    public void enqueue(Item item) {
        // 如果队列满，将其扩容
        if (isFull()) {
            // 因为last指向的是最后一个元素的后一个位置
            resize(2 * maxSize);
        }

        // 插入元素
        array[last] = item;
        last = (last + 1) % maxSize;
    }

    // 对数组进行扩容
    private void resize(int size) {
        Item[] items = (Item[]) new Object[size];
        for (int i = 0; i < size(); i++) {
            items[i] = array[first % maxSize];
            first++;
        }
        array = items;
        // 更新队列信息
        first = 0;
        last = maxSize - 1;
        // 更新最大容量
        this.maxSize = size;
    }
    // 出队列
    public Item dequeue() {
        if (!isEmpty()) {
            Item temp = array[first];
            array[first++] = null;
            // 如果数组空余空间太大
            if (size() <= maxSize / 4) {
                resize(maxSize / 2);
            }
            return temp;
        } else {
            throw new RuntimeException("队列已经为空");
        }
    }

    // 输出数组元素
    public void printQueue() {
        System.out.print("first---->Button:");
        for (int i = 0; i < size(); i++) {
            System.out.print(array[(first + i) % maxSize] + " ");
        }
        System.out.println();
        System.out.print("size=" + size() + "  maxsize=" + maxSize);
    }
}
