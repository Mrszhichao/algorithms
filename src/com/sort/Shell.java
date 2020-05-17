package com.sort;

/**
 * @description: 希尔排序
 * @author: Andy
 * @date: 2020/5/3 16:29
 */
public class Shell extends SortExample {
    // 对元素进行升序排序
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // 将a[i] 插入到a[i-h],a[i-2*h].....
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        //        Integer[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Integer[] a = {1, 2, 3, 4, 5, 9, 8, 7, 6};

        shell.sort(a);
        show(a);
    }
}
