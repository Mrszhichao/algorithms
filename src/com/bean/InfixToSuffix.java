package com.bean;

/**
 * @description: 中缀表达式转换成后缀表达式<br>
 *     a*(b+c)+d/(e-f) → abc*+def-/+ <br>
 *     转换思路 <br>
 *     1.初始化两个栈：s1用于存数运算符，s2用于存储处理结果<br>
 *     2.从左到右读取字符串<br>
 *     3.遇到操作数将其压入到s2<br>
 *     4.遇到运算符时，比较其与s1的栈顶元素<br>
 *     1) 若s1的栈顶为空或者为(，则直接将其压入到s1中<br>
 *     2) 若比栈顶的运算符的优先级高，则将其压入到s1的栈顶<br>
 *     3) 否则将s1栈顶的元素弹出压入到s2中，再次转到 1）步骤<br>
 *     5.若遇到括号时，若是（则直接压入到s1，若是）依次弹出s1中的元素到s2中，直到遇到（停止并将（）丢弃<br>
 *     6.重复2~5直到读完所有的字符，将s1中剩余的运算符弹出放到s2中。<br>
 *     7.s2中从栈到栈顶为处理的结果
 * @author: Andy
 * @date: 2020/4/6 11:31
 */
public class InfixToSuffix {
    private MyCharStack s1; // 定义运算符栈
    private MyCharStack s2; // 定义结果栈
    private String input;

    // 构造函数，用于初始换栈
    public InfixToSuffix(String input) {
        this.input = input;
        s1 = new MyCharStack(input.length());
        s2 = new MyCharStack(input.length());
    }

    // 根据得到的后缀表达式求出计算结果
    public int calculate(String s) {
        MyLinkedStack<Integer> intStack = new MyLinkedStack<Integer>();
        int firstN;
        int SecondN;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '/':
                    firstN = intStack.pop();
                    SecondN = intStack.pop();
                    intStack.push(SecondN / firstN);
                    break;
                case '+':
                    intStack.push(intStack.pop() + intStack.pop());
                    break;
                case '-':
                    firstN = intStack.pop();
                    SecondN = intStack.pop();
                    intStack.push(SecondN - firstN);
                    break;
                case '*':
                    intStack.push(intStack.pop() * intStack.pop());
                    break;
                default:
                    intStack.push(Integer.parseInt("" + ch));
                    break;
            }
        }
        return intStack.pop();
    }

    // 将算式转化成后缀表达式
    public MyCharStack doTrans() {
        for (int i = 0; i < input.length(); i++) {
            System.out.print("s1栈的元素：");
            s1.displayStack();
            System.out.print("s2栈的元素：");
            s2.displayStack();
            char ch = input.charAt(i);
            System.out.println("当前的字符为" + ch);
            // 对输入的字符串进行处理
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    s1.push(ch);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    s2.push(ch);
                    break;
            }
        }
        // 处理完之后，将s1中剩余的操作符压入到s2中
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2;
    }

    /**
     * 对输入的操作符号进行处理
     *
     * @param ch 输入的操作符
     * @param prec1 输入的操作符的优先级 1：+ - 2：/ *
     */
    private void gotOper(char ch, int prec1) {
        while (!s1.isEmpty()) {
            char chTop = s1.pop();
            if (chTop == '(') {
                s1.push(chTop);
                break;
            } else {
                int prec2 = 2;
                if (chTop == '+' || chTop == '-') {
                    prec2 = 1;
                }
                if (prec1 > prec2) {
                    s1.push(chTop);
                    break;
                } else {
                    s2.push(chTop);
                }
            }
        }
        s1.push(ch);
    }

    private void gotParen() {
        while (!s1.isEmpty()) {
            char chout = s1.pop();
            if (chout != '(') {
                s2.push(chout);
            } else {
                break;
            }
        }
    }
}
