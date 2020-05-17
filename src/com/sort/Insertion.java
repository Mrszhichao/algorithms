package com.sort;

/**
 * @description: 插入排序
 * @author: Andy
 * @date: 2020/5/3 13:34
 */
public class Insertion extends SortExample {
    // 对元素进行排序
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        Insertion selection = new Insertion();
        //        Integer[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Integer[] a = {1, 2, 3, 4, 5, 9, 8, 7, 6};

        selection.sort(a);
        show(a);
    }
}
