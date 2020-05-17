package com.bean;

/**
 * @description: 双向链表及其操作方法
 * @author: Andy
 * @date: 2020/4/12 20:31
 */
public class MyDoubleLinkedList<Item> {
    public Node first; // 首节点
    public Node last; // 尾节点
    public int N; // 结点个数
    // 节点
    private class Node {
        Item item; // 节点内容
        Node before; // 上一个节点
        Node next; // 下一个节点
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return first == null;
    }

    // 链表中元素的数量
    public int size() {
        return N;
    }

    // 向链表首添加节点
    public void addNodeToHeader(Item item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        first.before = null;
        // 判断是否是第一次向链表中存入元素
        if (last == null) {
            last = first;
        } else {
            // 将第二个节点指向刚刚插入的节点
            first.next.before = first;
        }
        N++;
    }

    // 向链表尾添加节点
    public void addNodeToRear(Item item) {
        Node oldNode = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (first == null) first = last;
        else {
            oldNode.next = last;
            last.before = oldNode;
        }
        N++;
    }

    // 删除尾结点
    public Item deleteRearNode() {
        // 判断链表是否为空
        if (!isEmpty()) {
            // 当链表只有一个节点的时候
            if (first.next == null) {
                Item temp = first.item;
                first = null;
                last = null;
                N--;
                return temp;
            }
            Item temp = last.item;
            last = last.before;
            last.next = null;
            N--;
            return temp;
        } else {
            throw new RuntimeException("链表为空");
        }
    }

    // 删除首结点
    public Item deleteHeaderNode() {
        // 判断链表是否为空
        if (!isEmpty()) {
            if (first.next == null) {
                Item temp = first.item;
                first = null;
                last = null;
                N--;
                return temp;
            }
            Item tempNode = first.item;
            first = first.next;
            first.before = null;
            N--;
            return tempNode;
        } else {
            throw new RuntimeException("链表为空");
        }
    }

    // 删除第k个节点
    public Item delete(int k) {
        Node tempNode = first;
        int curr = 1; // 记录链表的位置
        if (k == 1) {
            return deleteHeaderNode();
        } else if (k == N) {
            return deleteRearNode();
        }
        if (k < N) {
            while (tempNode.next != null) {
                // 寻找第k个节点
                if (k == curr) {
                    tempNode.before.next = tempNode.next;
                    tempNode.next.before = tempNode.before;
                    N--;
                    return tempNode.item;
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

    // 寻找链表中是否存在Key
    public boolean find(Item key) {
        if (!isEmpty()) {
            Node tempNode = first;
            while (tempNode.next != null) {
                if (tempNode.item == key) return true;
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    // 删除链表中所有值为key的元素
    public int remove(Item key) {
        Node tempNode = first;
        int count = 0; // 删除的节点个数
        if (!isEmpty()) {
            while (tempNode.next != null && find(key)) {
                // 如果是第一个结点的话
                if (tempNode.item == key) {
                    deleteHeaderNode();
                    count++;
                    // 更新数据
                    tempNode = first;
                }
                // 如果是最后一个节点
                if (last.item == key) {
                    deleteRearNode();
                    count++;
                }
                // 判断下一个节点是否为要删除的节点
                if (tempNode.next.item == key) {
                    tempNode.next = tempNode.next.next;
                    tempNode.next.next.before = tempNode;
                    count++;
                    N--;
                }
            }
        }
        return count;
    }

    // 打印链表结点的内容
    public void printLinkedList() {
        Node tempNode = first;
        System.out.println("该链表有" + N + "个节点，" + "首节点是：" + first.item + "，尾节点是：" + last.item);
        while (!isEmpty() && tempNode != null) {
            System.out.println(tempNode.item);
            tempNode = tempNode.next;
        }
    }
}
