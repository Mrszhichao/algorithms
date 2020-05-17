package com.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @description: 快速排序
 * @author: Andy
 * @date: 2020/5/4 17:46
 */
public class Quick extends SortExample {
    // 快速排序法
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 将数组打乱顺序
        sort(a, 0, a.length - 1);
    }

    // 实现快速切分
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        // 得到切分元素
        int j = partition(a, lo, hi);
        // 将数组的左半部分排序，不包括切分元素
        sort(a, lo, j - 1);
        // 将数组的右半部分排序，不包括切分元素
        sort(a, j + 1, hi);
    }

    // 快速排序的切分
    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分成a[io...i-1],a[i],a[i+1,hi]
        int i = lo, j = hi + 1; // 左右扫描元素的指针
        Comparable v = a[lo]; // 切分元素
        // 开始切分元素
        while (true) {
            // 将数组的右半部分与切分元素比较
            while (less(v, a[--j])) {
                // 代码是多余的，因为当--j = lo的时候
                // less(v, a[--j]) <> true
                // 内循环一直进不来
                // if (j == lo) break;
            }
            // 将数组的左半部分与切分元素比较
            while (less(a[++i], v)) if (i == hi) break;
            if (i >= j) break;
            // 交换元素
            exch(a, i, j);
        }
        // 将切分元素换到中间位置
        exch(a, j, lo);
        // 返回切分元素当前的位置
        return j;
    }

    public static void main(String[] args) {
        Quick quick = new Quick();
        Integer[] a = {5, 6, 7, 8, 1, 2, 3, 4};
        quick.sort(a);
        show(a);
    }
}
