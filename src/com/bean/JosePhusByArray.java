package com.bean;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 数组实现约瑟夫问题
 * @author: Andy
 * @date: 2020/4/19 19:37
 */
public class JosePhusByArray {
    Integer[] array = null; // 用于存放每个元素

    // 初始化n个元素
    public JosePhusByArray(int n) {
        array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    // 解决约瑟夫问题
    public void solution(int m) {
        int len = array.length;
        int index = 0; // 每次删掉一个元素之后，第一开始元素的位置
        int deleteN = 0; // 删掉元素的数量
        int deleteNo = 0;

        // 处理数据
        while (array.length - deleteN > 1) {
            deleteNo = (m + deleteNo - 1) % len;
            deleteN++;
            int deleteItem = array[deleteNo];
            // 将要删除的元素后面的元素向前移动
            for (int i = deleteNo; i + 1 < len; i++) {
                array[i] = array[i + 1];
            }
            len--;
            array[len] = null;

            StdOut.print(deleteItem);
        }
    }

    public static void main(String[] args) {
        JosePhusByArray josePhusByArray = new JosePhusByArray(7);
        josePhusByArray.solution(2);
    }
}
