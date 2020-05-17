package com.test;

/**
 * @description: 寻找一对两者之差最大的两个数
 * @author: Andy
 * @date: 2020/5/2 11:28
 */
public class TwoFarthestNum {
    // 寻找两者之差最大的两个数，即数组中的最大值和最小值
    public static void getFarthestPair(double[] a) {
        // 记录值远两个数的位置
        int index1 = 0;
        int index2 = 0;
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;

        // 循环遍历数组，寻找数组中的最大值和最小值
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= max) {
                max = a[i];
                index1 = i;
            }
            if (a[i] < min) {
                min = a[i];
                index2 = i;
            }
        }
    }
}
