package com.bean;

/**
 * @description: 实现用单向链表实现栈
 * @author: Andy
 * @date: 2020/4/6 20:02
 */
public class MyLinkedStack<Item> {
    // 栈顶元素
    private Node first;
    // 栈的元素数量
    private int N;

    // 节点的内部类
    private class Node {
        Item item; // 数据域
        Node next; // 用于指向下一个节点
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return first == null;
    }

    // 栈的大小
    public int size() {
        return N;
    }

    // 向栈添加元素
    public void push(Item item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }

    // 从栈顶取出元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // 遍历栈，并打印其元素
    public void printStack() {
        for (Node node = first; node != null; node = node.next) {
            System.out.println("Stack(top-->bottom):" + node.item);
        }
    }
}
