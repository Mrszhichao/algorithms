package com.bean;

/**
 * @description: 栈（手动实现）大小可自动改变
 * @author: Andy
 * @date: 2020/4/6 17:36
 */
public class MyStack<Item> {
    private Item[] array; // 初始化容器
    private int maxSize;
    private int top; // 栈顶元素

    // 构造器
    public MyStack(int size) {
        array = (Item[]) new Object[size];
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

    // 对数组进行扩容
    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    // 向栈添加元素
    public void push(Item item) {
        if (isFull()) {
            maxSize = 2 * maxSize;
            resize(maxSize);
        }
        array[++top] = item;
    }

    // 删除栈顶元素
    public Item pop() {
        if (!isEmpty()) {
            Item item = array[top];
            array[top--] = null;
            // 如果空余的空间太大，将数组大小减半
            if (top == maxSize / 4) {
                maxSize = maxSize / 2;
                resize(maxSize);
            }
            return item;
        } else {
            throw new RuntimeException("栈已经为空");
        }
    }

    public Item peekN(int n) {
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
