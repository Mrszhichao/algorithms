package com.bean;

/**
 * @description: JosePhus问题(用数组实现)
 * @author: Andy
 * @date: 2020/4/19 17:40
 */
public class JosePhusByLinkedList<Item> {
    public Node first; // 首节点
    public Node last; // 尾节点
    private int N; // 结点个数

    // 节点
    private class Node {
        Item item; // 节点内容
        Node next; // 下一个节点
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return first == null;
    }

    // 链表元素数
    public int size() {
        return N;
    }

    // 向链表尾添加节点,构造环形链表
    public void addNode(Item item) {
        Node oldNode = last;
        last = new Node();
        last.item = item;
        if (first == null) first = last;
        else oldNode.next = last;
        last.next = first;
        N++;
    }

    // 删除从首节开始的第n个节点，并重新定位初始节点和末尾节点
    public Item delete(int k) {
        Node tempNode = first;
        Item deleteNode;
        int curr = 1; // 记录链表的位置
        if (k == 1) {
            deleteNode = first.item;
            first = first.next;
            last.next = first;
            N--;
            return deleteNode;
        }
        if (k <= N) {
            while (tempNode.next != null) {
                // 寻找第k-1个节点
                if (k == curr + 1) {
                    first = tempNode.next = tempNode.next.next;
                    last = tempNode;
                    N--;
                    return tempNode.next.item;
                } else {
                    // 指向下一个节点
                    tempNode = tempNode.next;
                    curr++;
                }
            }
            System.out.println("找不到指定节点");
            return null;
        } else {
            System.out.println("找不到指定节点");
            return null;
        }
    }

    // 接受n总共元素数，和m要删除的第m个元素
    public Item deleteM(int m) {
        while (size() > 1) {
            int rel = m % size();
            if (rel == 0) delete(size());
            else delete(rel);
        }
        return first.item;
    }
}
