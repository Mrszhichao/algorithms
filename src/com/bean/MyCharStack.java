package com.bean;

/**
 * @description:
 * @author: Andy
 * @date: 2020/4/6 10:48
 */
public class MyCharStack {

    private char[] array; // 初始化容器
    private int maxSize;
    private int top; // 栈顶元素

    // 构造器
    public MyCharStack(int size) {
        array = new char[size];
        this.maxSize = size;
        top = -1;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return this.top == -1;
    }

    // 判断栈是否已满
    public boolean isFull() {
        return top >= maxSize - 1;
    }

    // 元素入栈
    public void push(char value) {
        if (!isFull()) {
            array[++top] = value;
        }
    }

    // 取出栈顶元素
    public char pop() {
        if (!isEmpty()) {
            return array[top--];
        } else {
            throw new RuntimeException("栈已经为空");
        }
    }

    // 显示栈顶的元素
    public char peek() {
        return array[top];
    }

    // 取出指定位置的元素
    public char peekN(int n) {
        return array[n];
    }

    // 展示栈的元素
    public void displayStack() {
        System.out.print("Stack(bottom-->top):");
        for (int i = 0; i < top + 1; i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
