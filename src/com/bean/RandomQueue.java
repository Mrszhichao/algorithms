package com.bean;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @description: 1.3.35 随机队列
 * @author: Andy
 * @date: 2020/4/19 16:44
 */
public class RandomQueue<Item> implements Iterable<Item> {

    private Item[] array = null; // 队列元素
    private int N; // 包中元素个数

    // 构造函数，初始化
    public RandomQueue() {
        array = (Item[]) new Object[1];
        N = 0;
    }

    // 判断包是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 元素入队
    public void enqueue(Item item) {
        if (N == array.length) resize(2 * array.length);
        array[N++] = item;
    }

    // 对数组进行扩容
    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    // 删除并随机返回一个元素
    public Item dequeue() {
        if (isEmpty()) return null;
        // 数组占用空间很小的情况下
        if (N == array.length / 4) resize(array.length / 2);
        // 随机生成一个随机数，在0~N之间
        int uniform = StdRandom.uniform(N);
        Item temp = array[uniform];
        array[uniform] = array[N];
        array[N--] = null;
        return temp;
    }

    // 随即返回一个元素但不删除它
    public Item sample() {
        if (isEmpty()) return null;
        return array[StdRandom.uniform(N)];
    }

    // 迭代器
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    // 实现迭代器的内部类
    private class RandomQueueIterator<Item> implements Iterator<Item> {

        private int[] seq = new int[N]; // 用于存储随即数组的索引
        private int index = 0;

        // 构造函数，生成随机序的数组
        public RandomQueueIterator() {
            // 初始化索引数组
            for (int i = 0; i < N; i++) {
                seq[i] = i;
            }
            StdRandom.shuffle(seq);
        }

        // 判断是否有下一个元素
        public boolean hasNext() {
            return index > N;
        }

        // 取出元素
        public Item next() {
            return (Item) array[seq[index++]];
        }
    }
}
