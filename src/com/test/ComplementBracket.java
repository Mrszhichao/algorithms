package com.test;

import com.bean.MyLinkedStack;

/**
 * @description: 补全运算表达式的左括号<br>
 *     例如：1+2)*3-4)*5-6))) → ((1+2)*((3-4)*(5-6)))
 * @author: Andy
 * @date: 2020/4/9 22:57
 */
public class ComplementBracket {

    public static void main(String[] args) {
        //
        System.out.println(complBracket("1+2)*3-4)*5-6)))"));
    }

    // 为输入字符串补全括号
    public static String complBracket(String input) {
        MyLinkedStack<String> operation = new MyLinkedStack<>(); // 操作符
        MyLinkedStack<String> operand = new MyLinkedStack<>(); // 操作数
        // 处理运算符和操作数
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            if (s == '+' || s == '-' || s == '*' || s == '/') {
                // 将操作符放入操作符栈
                operation.push("" + s);
            } else if (s == ')') {
                // 取到的是左括号时，取出两个操作数和操作符组合
                // 此处是")"和"("而不是，因为后续要倒序输出处理结果
                String op = ")" + operand.pop() + operation.pop() + operand.pop() + "(";
                operand.push(op);
            } else {
                operand.push("" + s);
            }
        }

        // 将结果出栈并反转
        String operateResult = operand.pop();
        String result = "";
        for (int i = operateResult.length() - 1; i >= 0; i--) {
            result += operateResult.charAt(i);
        }
        return result;
    }
}
