package com.test;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 八皇后问题
 * @author: Andy
 * @date: 2020/5/20 22:16
 */
public class Queen8 {

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8(8);
        queen8.placeQueen(0);
        StdOut.println("共有" + num + "种摆法");
    }

    /**
     * 棋盘的大小
     */
    private int maxszie;

    /**
     * 存放棋子摆放的结果
     */
    int[] array;

    public static int num = 0;

    public Queen8(int size) {
        this.maxszie = size;
        this.array = new int[size];
    }

    /**
     * 摆放棋子
     *
     * @param n 摆放的第n个棋子
     */
    public void placeQueen(int n) {
        // 如果棋子摆放完，责打印棋子
        if (n == maxszie) {
            print();
            num++;
            return;
        }
        // 摆放棋子
        for (int i = 0; i < maxszie; i++) {
            // 将棋子摆放到第i个位置
            array[n] = i;
            if (judge(n)) {
                // 继续摆放下一个棋子
                placeQueen(n + 1);
            }
            // 如果当前位置不合适，则将棋子摆放到下一个位置
        }
    }

    /**
     * 判断当前位置是否满足要求
     *
     * @param n 当前位置
     * @return 位置是否合理
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 如果当前棋子与已经摆放的棋子处于同一列或者同一斜线，则视为不合理
            if (array[i] == array[n] || Math.abs(array[i] - array[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i] + " ");
        }
        StdOut.println();
    }
}
