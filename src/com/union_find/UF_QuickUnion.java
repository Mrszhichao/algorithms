package com.union_find;

import com.util.ReadFile;
import edu.princeton.cs.algs4.StdOut;

/**
 * @description:动态连通性算法（quick-union）<br>
 *     解决问题：输入一列整数，每个整数都代表着一个对象，<br>
 *     一对整数p和q可以被理解为“p和q是相连的”。
 * @author: Andy
 * @date: 2020/4/28 23:44
 */
public class UF_QuickUnion {
    private static int[] id; // 分量id（数组的索引是触点）
    private int count; // 分量的数量

    // 以整数表示（0到N-1）初始化N个触点
    public UF_QuickUnion(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // 连通分量的数量
    public int count() {
        return count;
    }

    // 如果p和q存在同一个分量中则返回true
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // p所在分量的标识符
    // 每个触点所对应的元素都是同一个分量中的另一个触点的名字
    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    // 在p和q之间添加一条连接符
    public void union(int p, int q) {
        int pRoot = find(p); // p的根节点
        int qRoot = find(q); // p的根节点
        // 如果p和q已经在相同的分量中，则不采取行动
        if (pRoot == qRoot) return;
        // 如果p和q不在相同的分量中，则添加链接
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        Integer[] integers =
                ReadFile.readTxtByLine("D:\\ideaworkspace\\data\\algs4-data\\tinyUF.txt");
        UF_QuickUnion uf = new UF_QuickUnion(integers[0]);
        for (int i = 1; i < integers.length - 1; i += 2) {
            // 如果两个数已经连通，则忽略
            if (uf.connected(integers[i], integers[i + 1])) continue;
            // 归并两个分量
            uf.union(integers[i], integers[i + 1]);
            for (int j = 0; j < id.length; j++) {
                StdOut.print(id[j] + " ");
            }
            StdOut.println();
            for (int j = 0; j < id.length; j++) {
                int k = j;
                while (id[k] != k) {
                    StdOut.print(k + "--->");
                    k = id[k];
                }
                StdOut.print(id[k] + ",");
            }
            StdOut.println();
        }
        StdOut.print(uf.count);
    }
}
