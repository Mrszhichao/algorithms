package com.test;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 二分法查找指定的元素
 * @author: chenzhichao
 * @date: 2020/4/4 22:40
 */
public class BinarySearch {

    public static void main(String[] args) {
        //
        int[] a = {1, 2, 5, 10, 10, 10, 10, 30, 100, 800, 1000};
        StdOut.println(rank(10, a));
        StdOut.println(rankAndFindMinIndex(10, a));
    }

    /**
     * 二分法查找有序数组
     *
     * @param key 指定数字
     * @param a 指定的有序数组
     * @return 序列号
     */
    public static int rank(int key, int[] a) {

        // 数组必须有序
        // 起始位置
        int lo = 0;
        // 数组的终了位置
        int hi = a.length - 1;

        // 查找指定数字在数组中的位置
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > key) hi = mid - 1;
            else if (a[mid] < key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 二分法查找有序数组,返回相匹配索引最小的元素
     *
     * @param key 指定数字
     * @param a 指定的有序数组
     * @return 序列号
     */
    public static int rankAndFindMinIndex(int key, int[] a) {

        // 数组必须有序
        // 起始位置
        int lo = 0;
        // 数组的终了位置
        int hi = a.length - 1;
        // 记录最小索引号
        int minIndex = -1;

        // 查找指定数字在数组中的位置
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > key) hi = mid - 1;
            else if (a[mid] < key) lo = mid + 1;
            else if (mid > 0 && a[mid] == a[mid - 1]) {
                minIndex = mid;
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return minIndex;
    }
}
