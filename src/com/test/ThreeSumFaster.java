package com.test;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @description: 找已经排序数组中三个相加等于零元素的个数
 * @author: Andy
 * @date: 2020/5/2 10:30
 */
public class ThreeSumFaster {

    // 寻找三个数值相加等于零的个数
    public static int count(int[] a) {
        // 保证数组已经排序
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length - 1;
        // 满足条件的个数
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            lo = i + 1;
            while (lo < hi) {
                if (-a[lo] - a[hi] == a[i]) {
                    cnt++;
                    lo++;
                    hi--;
                } else if (-a[lo] - a[hi] > a[i]) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {-4, -2, 0, 2, 3, 4, 6};
        StdOut.println(count(a));
    }
}
