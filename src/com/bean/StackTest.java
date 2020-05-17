package com.bean;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description:
 * @author: Andy
 * @date: 2020/4/6 11:19
 */
public class StackTest {
    public static void main(String[] args) {

        JosePhusByLinkedList<Integer> linkedList = new JosePhusByLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        Integer integer = linkedList.deleteM(6);
        StdOut.println(integer);
    }
}
