package com.bean;

/**
 * @description: 用链表实现简单的队列
 * @author: Andy
 * @date: 2020/4/6 20:37
 */
public class MyLinkedQueue<Item> {
    // 最先进入队列的元素
    private Node first;
    // 最近进入队列的元素
    private Node last;
    // 栈的元素数量
    private int N;

    // 节点的内部类
    private class Node {
        Item item; // 数据域
        Node next; // 用于指向下一个节点
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return first == null;
    }

    // 队列的大小
    public int size() {
        return N;
    }

    // 向队列添加元素
    public void enqueue(Item item) {
        Node oldNode = last;
        last = new Node();
        last.item = item;
        last.next = null;
        // 如果队列为空
        if (isEmpty()) first = last;
        else oldNode.next = last;
        N++;
    }

    // 出队列
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        // 如果队列为空
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    // 遍历栈，并打印其元素
    public void printQueue() {
        for (Node node = first; node != null; node = node.next) {
            System.out.println("queue(top-->bottom):" + node.item);
        }
    }
}
