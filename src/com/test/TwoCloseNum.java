package com.test;

import java.util.Arrays;

/**
 * @description: 寻找数组中两个数组之差最小的两个数（最接近的一对）
 * @author: Andy
 * @date: 2020/5/2 10:43
 */
public class TwoCloseNum {

    // 寻找值最接近的两个数
    public static void getClosestPair(double[] a) {
        // 记录值接近两个数的位置
        int index1 = 0;
        int index2 = 0;
        double smallestValue = Double.MAX_VALUE; // 任意两个数最小的差值
        // 遍历a，找到之最接近的两个数
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] - a[j] < smallestValue) {
                    index1 = i;
                    index2 = j;
                    smallestValue = a[i] - a[j];
                }
            }
        }
    }

    // 寻找值最接近的两个数改进版
    // 将数组排序，这找出相邻的两个数
    public static void getClosestPair2(double[] a) {
        Arrays.sort(a);
        // 记录值接近两个数的位置
        int index = 0;
        double smallestValue = Double.MAX_VALUE; // 任意两个数最小的差值
        // 遍历a，找到之最接近的两个数
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] < smallestValue) {
                index = i;
                smallestValue = a[i + 1] - a[i];
            }
        }
    }
}
