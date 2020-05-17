package com.symboltable;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 二分法查找（基于有效数组）
 * @author: Andy
 * @date: 2020/5/7 22:12
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    // 存放value
    private Value[] values;
    // 存放key
    private Key[] keys;
    // 元素个数
    private int N = 0;

    // 构造函数
    public BinarySearchST(int capacity) {
        values = (Value[]) new Comparable[capacity];
        keys = (Key[]) new Comparable[capacity];
    }

    // 对表进行扩容
    private void resize(int capacity) {
        Value[] tempv = (Value[]) new Comparable[capacity];
        Key[] tempk = (Key[]) new Comparable[capacity];
        // 将原数组中的元素复制到临时数组中
        for (int i = 0; i < N; i++) {
            tempv[i] = values[i];
            tempk[i] = keys[i];
        }
        values = tempv;
        keys = tempk;
    }

    // 表中键值对的数量
    public int size() {
        return N;
    }

    // 表是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 小于key的数量
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int temp = key.compareTo(keys[mid]);
            if (temp > 0) lo = mid + 1;
            else if (temp < 0) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    // 获取key所对应的值
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        if (isEmpty()) {
            return null;
        }
        // key应该在表中的位置
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    // 插入指定的键，如果该键已经存在则更新其value，否则新建
    public void put(Key key, Value value) {
        // key应该在表中的位置
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        // 如果超出表的制定容量
        if (N == keys.length) {
            resize(2 * keys.length);
        }
        // 表中不存在键值
        // 将要插入元素后面的元素后移
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    // 根据指定key删除元素
    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        // key应该在表中的位置
        int i = rank(key);
        // 如果key在表中不存在的话
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }
        // 如果制定的键值对存在表中的话，删除元素
        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        N--;
        keys[N] = null;
        values[N] = null;

        // 定容
        if (N > 0 && N == keys.length / 4) resize(keys.length / 2);
    }

    // 获取最小的键
    public Key min() {
        return keys[0];
    }

    // 获取最大的键
    public Key max() {
        return keys[N - 1];
    }

    // 获取排名为k的键
    public Key select(int k) {
        return keys[k];
    }

    // 大于或等于key的最小键
    public Key celling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    // 小于或等于key的最大键
    public Key floor(Key key) {
        int i = rank(key);
        // 如果key存在表中的话
        if (key.compareTo(keys[i]) == 0) {
            return key;
        } else if (i - 1 >= 0) {
            // 如果key不存在表中的话，则返回i的下一个元素
            return keys[i - 1];
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(3);
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        st.put("d", 4);
        StdOut.println(st.size() + "  " + st.get("d"));
        st.delete("d");
        StdOut.println(
                st.size()
                        + "  "
                        + st.get(st.min())
                        + "  "
                        + st.get(st.max())
                        + "  "
                        + st.get(st.celling("a"))
                        + "  "
                        + st.get(st.floor("d")));
    }
}
