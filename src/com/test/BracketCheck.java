package com.test;

import com.bean.MyCharStack;

/**
 * @description: 匹配括号是否完整
 * @author: Andy
 * @date: 2020/4/6 22:59
 */
public class BracketCheck {

    public static void main(String[] args) {
        //
        System.out.println(checkBrac("{[()()]()()}()"));
    }

    public static boolean checkBrac(String s) {
        // 初始化栈勇于接受括号
        MyCharStack stack = new MyCharStack(s.length());
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            if (stack.isEmpty() || at == '(' || at == '[' || at == '{') {
                stack.push(at);
            } else if (')' == at && stack.pop() != '(') {
                return false;
            } else if (']' == at && stack.pop() != '[') {
                return false;
            } else if ('}' == at && stack.pop() != '{') {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
