package com.priorityqueue;

import com.util.ReadFile;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 * @description: 优先队列
 * @author: Andy
 * @date: 2020/5/5 21:30
 */
public class MaxPQ<Key extends Comparable<Key>> {

    // 基于堆的完全二叉树
    private Key[] pq;
    // 堆的元素数
    private int N = 0;

    // 堆元素的比较
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 堆元素的交换
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // 堆元素的上浮操作
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    // 为排序专用的上浮操作
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k; // k的子节点
            // j<N是为了保证k有两个子节点
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(j, k);
            k = j;
        }
    }

    // 构造函数
    public MaxPQ(int maxSize) {
        pq = (Key[]) new Comparable[maxSize + 1];
    }

    // 判断是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 判断堆的大小
    public int size() {
        return N;
    }

    // 向队列里插入元素
    public void insert(Key v) {
        // 将元素插入到堆的最后一个位置
        pq[++N] = v;
        // 将插入的值上浮到正确的位置
        swim(N);
    }

    // 删除最大元素
    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public static void main(String[] args) {
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(5 + 1);
        String[] strings =
                ReadFile.readTxtByLineToString(
                        "D:\\ideaworkspace\\data\\algs4-data\\tinyBatch.txt");
        for (String s : strings) {
            pq.insert(new Transaction(s));
            if (pq.size() > 5) {
                pq.delMax();
            }
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMax());
        for (Transaction transaction : stack) StdOut.println(transaction);
    }
}
