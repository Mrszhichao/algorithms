package com.test;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @description: 找出一个数组中四个相加等于0的元素<br>
 * @author: Andy
 * @date: 2020/5/1 18:57
 */
public class FourSum {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (BinarySearch.rank(-a[i] - a[j] - a[k], a) > k) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {-9, -6, 1, 2, 3, 4, 6};
        StdOut.println(count(a));
    }
}
