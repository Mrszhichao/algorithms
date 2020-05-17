package com.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 实现排序的抽象方法
 * @author: Andy
 * @date: 2020/5/3 11:56
 */
public abstract class SortExample {
    // 排序方法
    public abstract void sort(Comparable[] a);

    // 比较两个元素的大小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换两个元素的值
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 展示所有的元素
    public static void show(Comparable[] a) {
        // 打印数组中的所有元素
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + "  ");
        }
        StdOut.println();
    }

    // 查看数组是否已经排序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i])) {
                return false;
            }
        }
        return true;
    }
}
