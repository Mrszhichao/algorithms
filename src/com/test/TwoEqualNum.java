package com.test;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 寻找两个有序数组中所有公共元素
 * @author: Andy
 * @date: 2020/5/1 17:57
 */
public class TwoEqualNum {

    // 寻找两个数组中相同的元素，并打印
    public static void printSameItem(int[] a, int[] b) {
        int length1 = a.length;
        int length2 = b.length;
        for (int i = 0, j = 0; i < length1; ) {
            if (a[i] > b[j]) j++;
            else if (a[i] < b[j]) i++;
            else {
                StdOut.println(a[i]);
                j++;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 9, 12};
        int[] b = {4, 6, 7, 9, 12, 13};
        printSameItem(a, b);
    }
}
