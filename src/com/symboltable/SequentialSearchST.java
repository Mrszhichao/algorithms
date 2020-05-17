package com.symboltable;

/**
 * @description: 顺序查找（基于无序链表）
 * @author: Andy
 * @date: 2020/5/6 22:24
 */
public class SequentialSearchST<Key, Value> {
    // 首节点
    private Node first;
    // 链表的节点类
    private class Node {
        Key key;
        Value value;
        Node next;
        // 构造方法
        public Node(Key key, Value value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }
    }
    // 获取key的value
    public Value get(Key key) {
        // 查找指定的键值
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }
    // 将指定的键赋值
    public void put(Key key, Value value) {
        // 查找指定的键值，若命中则更新它的值
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
            // 若没有命中，插入新的节点，更新首节点的位置
            first = new Node(key, value, first);
        }
    }
}
