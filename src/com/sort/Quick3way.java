package com.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @description: 三向切分的快速排序
 * @author: Andy
 * @date: 2020/5/4 19:52
 */
public class Quick3way extends SortExample {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 将数组打乱顺序
        sort(a, 0, a.length - 1);
    }

    // 实现三项切分排序
    // a[lo...lt-1]的元素都小于切分元素，a[lt...i-1]都等于切分元素，a[gt+1....hi]都大于切分元素
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo <= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        // 切分元素
        Comparable v = a[lo];
        // 将数组处理为a[lo...lt-1]<v = a[lt...i-1]<a[gt+1....hi]
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp > 0) exch(a, i, gt--);
            else if (cmp < 0) exch(a, i++, lt++);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        Quick3way quick3way = new Quick3way();
        Integer[] a = {5, 6, 7, 8, 1, 2, 3, 4};
        quick3way.sort(a);
        show(a);
    }
}
