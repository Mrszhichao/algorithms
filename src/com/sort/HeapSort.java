package com.sort;

/**
 * @description: 堆排序
 * @author: Andy
 * @date: 2020/5/5 23:28
 */
public class HeapSort extends SortExample {

    // 堆元素的上浮操作
    private void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k; // k的子节点
            // j<N是为了保证k有两个子节点
            if (j < N && less(a[j - 1], a[j])) j++;
            if (!less(a[k - 1], a[j - 1])) break;
            exch(a, j - 1, k - 1);
            k = j;
        }
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // 将数组够造成堆
        for (int i = N / 2; i >= 1; i--) {
            sink(a, i, N);
        }
        while (N > 1) {
            exch(a, 0, --N);
            sink(a, 1, N);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Integer[] a = {0, 6, 7, 8, 1, 2, 3, 4, 12, 15, 10, 9};
        heapSort.sort(a);
        show(a);
    }
}
