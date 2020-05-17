package com.sort;

/**
 * @description: 归并排序
 * @author: Andy
 * @date: 2020/5/3 16:52
 */
public class Merge extends SortExample {
    // 归并所需要的数组
    private static Comparable[] aux;

    // 对元素进行排序
    public void sort(Comparable[] a) {
        // 初始化数组
        aux = new Comparable[a.length];
        //        sortByTopTOBottom(a, 0, a.length - 1);
        sortByBottomTOTop(a);
    }

    // 将两个有序数组进行归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 将数组元素复制到aux中
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 对元素进行归并
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // 自顶向下的归并排序
    private static void sortByTopTOBottom(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (hi + lo) / 2;
        sortByTopTOBottom(a, lo, mid); // 将数组左半部分进行排序
        sortByTopTOBottom(a, mid + 1, hi); // 将数组右半部分进行排序
        merge(a, lo, mid, hi); // 归并结果
    }

    // 自底向上的归并排序
    private static void sortByBottomTOTop(Comparable[] a) {
        int N = a.length;
        // sz是子数组的大小
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        Integer[] a = {5, 6, 7, 8, 1, 2, 3, 4};
        merge.sort(a);
        show(a);
    }
}
