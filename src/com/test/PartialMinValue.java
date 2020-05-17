package com.test;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 数组局部的最小元素
 * @author: Andy
 * @date: 2020/5/2 12:00
 */
public class PartialMinValue {
    public static int getMinItem(int[] a) {
        // 如果数组为空
        if (a == null || a.length == 0) {
            return -1;
        }
        // 如果数组的元素只有一个
        if (a.length == 1 || a[0] < a[1]) {
            return 0;
        }
        // 如果最后的元素为局部最小元素
        if (a[a.length - 1] < a[a.length - 1]) {
            return a.length;
        }
        int mid = 0;
        int lo = 1; // 起始位置
        int hi = a.length - 2; // 终了位置
        while (lo < hi) {
            mid = (hi + lo) / 2;
            if (a[mid - 1] < a[mid]) {
                hi = mid - 1;
            } else if (a[mid + 1] < a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 11, 14, 8, 25};
        StdOut.println(getMinItem(a));
    }
}
