package com.bean;

import java.util.Iterator;
import java.util.Random;

/**
 * @description:
 * @author: Andy
 * @date: 2020/4/19 11:37
 */
public class RandomBag<Item> implements Iterable<Item> {

    private Item[] array = null; // 包元素
    int N; // 包中元素个数

    // 构造函数
    public RandomBag() {
        array = (Item[]) new Object[1];
        N = 0;
    }

    // 判断包是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 背包中元素的数量
    public int size() {
        return N;
    }

    // 向背包中添加元素
    public void add(Item item) {
        if (N == array.length) resize(2 * array.length);
        array[N++] = item;
    }

    // 对背包进行扩容
    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    // 迭代器
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    // 是想迭代器的相关方法
    private class RandomBagIterator implements Iterator<Item> {

        private int[] seq = new int[N]; // 用于存储随即数组的索引
        private int index = 0;

        // 迭代器的构造函数
        public RandomBagIterator() {
            // 初始化所引数组
            for (int i = 0; i < N; i++) {
                seq[i] = i;
            }
            shuffle(seq);
        }

        // 是否存在下一个元素
        public boolean hasNext() {
            return index < N;
        }

        // 取下一个元素
        public Item next() {
            return array[seq[index++]];
        }

        // Fisher–Yates shuffle洗牌算法
        private void shuffle(int[] a) {
            int len = a.length - 1; // 交换数组元素，则最后一个元素不需要交换
            Random random = new Random();
            for (int i = len; i > 0; i--) {
                // 生成0~i+1范围内的一个数
                int randN = Math.abs(random.nextInt(i + 1));
                int temp = a[randN];
                a[randN] = a[i];
                a[i] = temp;
            }
        }
    }
}
