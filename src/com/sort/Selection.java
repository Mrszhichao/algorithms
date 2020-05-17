package com.sort;

/**
 * @description: 选择排序
 * @author: Andy
 * @date: 2020/5/3 12:28
 */
public class Selection extends SortExample {
    // 将元素进行排序
    public void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[i])) min = j;
                exch(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Selection selection = new Selection();
        Integer[] a = {1, 2, 3, 4, 5, 9, 8, 7, 6};
        selection.sort(a);
        show(a);
    }
}
