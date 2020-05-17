package com.test;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @description: 寻找已经排序数组中相加等于零元素的个数
 * @author: Andy
 * @date: 2020/5/2 0:14
 */
public class TwoSumFaster {
    // 寻找个数
    public static int count(int[] a) {
        Arrays.sort(a);
        int count = 0;
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            if (a[lo] + a[hi] == 0) {
                count++;
                lo++;
                hi--;
            } else if (a[lo] + a[hi] > 0) hi--;
            else lo++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {-4, -1, 1, 2, 3, 4, 6};
        StdOut.println(count(a));
    }
}
